import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Driver extends JPanel implements ActionListener, KeyListener, MouseListener {
	public int screenW = 1920, screenH = 1080;
	Alien[][] aliens = new Alien[6][4];
	Player player = new Player(screenW / 2, screenH - 280);
	ArrayList<Blast> blasts = new ArrayList<Blast>();
	ArrayList<Blast> aBlasts = new ArrayList<Blast>();

	int[] cooldown = { 0, 50 };

	int kills = 0;
	int lives = 3;

	public void paint(Graphics g) {
		if (lives <= 0) {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, screenW, screenH);

			g.setColor(Color.WHITE);
			g.setFont(new Font("Dialog", Font.PLAIN, 50));
			g.drawString("Game Over", screenW / 2 - 150, screenH / 2);
			return;
		}
		g.fillRect(0, 0, screenW, screenH);

		// removes blasts outside of screen
		for (int i = 0; i < blasts.size(); i++) {
			if (blasts.get(i).getY() < -50) {
				blasts.remove(i);
				i--;
			}
		}

		for (int i = 0; i < aBlasts.size(); i++) {
			if (aBlasts.get(i).getY() > screenH + 50) {
				aBlasts.remove(i);
				i--;
			}
		}

		// paint aliens
		for (Alien[] a1 : aliens) {
			for (Alien a : a1) {
				if (a.shoot()) {
					aBlasts.add(new Blast(a.getX() + 40, a.getY() + 55, 1)); // alien center is +40,+55
				}
				a.paint(g);
			}
		}

		// paint player blasts
		for (Blast b : blasts) {
			b.paint(g);
		}

		// paint alien blasts
		for (Blast b : aBlasts) {
			b.paint(g);
		}

		player.paint(g);

		// compare every alien with every blast
		for (int r = 0; r < aliens.length; r++) {
			for (int c = 0; c < aliens[r].length; c++) {
				Alien a = aliens[r][c];
				for (int i = 0; i < blasts.size(); i++) {
					Blast b = blasts.get(i);
					if (b.hit(a)) {
						blasts.remove(i);
//						a.setVisible(false);
						a.setY(-500);
						kills++;
						i--;
					}
				}
			}
		}

		// compare player with every blast
		for (int i = 0; i < aBlasts.size(); i++) {
			Blast b = aBlasts.get(i);
			if (b.hit(player)) {
				aBlasts.remove(i);
				// remove hearts/end game
				lives--;
				i--;
			}
		}

		if (cooldown[0] > 0) {
			cooldown[0]--;
		}

		// cooldown bar
		g.setColor(new Color(130, 130, 130));
		g.fillRect(50 - 1, screenH - 100 - 1, cooldown[1] * (200 / cooldown[1]) + 2, 10 + 2);
		g.setColor(Color.RED);
		g.fillRect(50, screenH - 100, (cooldown[1] - cooldown[0]) * (200 / cooldown[1]), 10);

		// kill bar
		for (int i = 0; i < kills; i++) {
			StillAlien temp = new StillAlien(280 + 10 * (i % 20), 980, 1);
			temp.paint(g);
		}

		g.setColor(Color.BLUE);
		for (int i = 0; i < lives; i++) {
			g.drawOval(1700 + 20 * i, 980, 10, 10);
		}
	}

	public static void main(String[] arg) {
		Driver d = new Driver();
	}

	public Driver() {
		JFrame frame = new JFrame("Space Invaders");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(FlyingObj.class.getResource("/imgs/alien00.png")));
		frame.setSize(screenW, screenH);
		frame.add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(this);
		frame.addMouseListener(this);
		t.start();

		// generate aliens
		for (int r = 0; r < aliens.length; r++) {
			for (int c = 0; c < aliens[r].length; c++) {
				aliens[r][c] = new Alien(100 * r + 650, 100 * c - 150, c % 2);
			}
		}

		frame.setVisible(true);
	}

	Timer t = new Timer(16, this);

	public void actionPerformed(ActionEvent m) {
		repaint();
	}

	public void keyPressed(KeyEvent arg0) {
		switch (arg0.getKeyCode()) {
		case 37: // left
			player.motion(-1);
			break;
		case 39: // right
			player.motion(1);
			break;
		case 32: // space
			// was 68, not 60
			if (cooldown[0] == 0) {
				blasts.add(new Blast(player.getX() + 11, player.getY() + 60, 0));
				blasts.add(new Blast(player.getX() + 115, player.getY() + 60, 0));
				cooldown[0] = cooldown[1];
			}

			break;
		default:
//			System.out.println("Unrecognized, key code: " + arg0.getKeyCode());
			break;
		}
	}

	public void keyReleased(KeyEvent arg0) {
		if (arg0.getKeyCode() == 37 || arg0.getKeyCode() == 39) {
			player.motion(0);
		}
	}

	public void keyTyped(KeyEvent arg0) {

	}

	public void mouseClicked(MouseEvent arg0) {
//		System.out.println(player);
		System.out.println(arg0);
	}

	public void mouseEntered(MouseEvent arg0) {

	}

	public void mouseExited(MouseEvent arg0) {

	}

	public void mousePressed(MouseEvent arg0) {

	}

	public void mouseReleased(MouseEvent arg0) {

	}

}
