import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.event.MouseInputListener;

public class Driver extends JPanel implements ActionListener, KeyListener, MouseListener {
	public int screenW = 1920, screenH = 1080;
//	Alien[][] aliens = new Alien[6][4];
	Player player = new Player(screenW / 2, screenH - 280);
//	ArrayList<Blast> blasts = new ArrayList<Blast>();

	Alien test1 = new Alien(200, 100, 0);
	Blast test2 = new Blast(300, 200);

	public void paint(Graphics g) {
		g.fillRect(0, 0, screenW, screenH);

//		for (int i = 0; i < blasts.size(); i++) {
//			if (blasts.get(i).getY() < -50) {
//				blasts.remove(i);
//				i--;
//			}
//		}

		test1.paint(g);
		test2.paint(g);
		if (test2.hit(test1)) {
			System.out.println("hit");
		}

//		for (int r = 0; r < aliens.length; r++) {
//			for (int c = 0; c < aliens[r].length; c++) {
//				Alien a = aliens[r][c];
//				for (int i = 0; i < blasts.size(); i++) { // compare every alien with every blast
//					Blast b = blasts.get(i);
//					if (b.hit(a)) {
//						System.out.println("hit");
////						b.setVisible(false);
////						a.setVisible(false);
//					}
//				}
//			}
//		}

//		for (Alien[] a1 : aliens) {
//			for (Alien a : a1) {
//				a.paint(g);
//			}
//		}

//		for (Blast b : blasts) {
//			b.paint(g);
//		}

		player.paint(g);

	}

	public static void main(String[] arg) {
		Driver d = new Driver();
	}

	public Driver() {
		JFrame frame = new JFrame("Space Invaders");
		frame.setSize(screenW, screenH);
		frame.add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(this);
		frame.addMouseListener(this);
		t.start();

		// generate aliens
//		for (int r = 0; r < aliens.length; r++) {
//			for (int c = 0; c < aliens[r].length; c++) {
//				aliens[r][c] = new Alien(100 * r + 650, 100 * c - 150, c % 2);
//			}
//		}

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
//			blasts.add(new Blast(player.getX() + 11, player.getY() + 60));
//			blasts.add(new Blast(player.getX() + 115, player.getY() + 60));

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
		System.out.println(arg0.getX() + ", " + arg0.getY());
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
