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
	Alien[][] aliens;
	Player player;
	ArrayList<Blast> blasts, aBlasts;
	ArrayList<Reward> rewards;
	ArrayList<Explosion> explosions;
	ArrayList<Message> messages;
	ArrayList<Boss> bosses;
	ArrayList<Star> stars;

	Audio explosionSound;

	int rewardTimer;
	boolean playing, gameOver;
	boolean bossFight;

	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, screenW, screenH);
		// END SCREEN
		if (player.lives() <= 0 || gameOver) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("Dialog", Font.PLAIN, 50));
			g.drawString("Game Over", screenW / 2 - 150, screenH / 2);
			g.setFont(new Font("Dialog", Font.PLAIN, 25));
			g.drawString("Press ESC to restart.", screenW / 2 - 140, screenH / 2 + 150);
			return;
		}

		if (!playing) {
			return;
		}

		bossFight = true;
		try {
			bosses.get(0);
		} catch (Exception e) {
			bossFight = false;
		}

		g.setFont(new Font("Dialog", Font.PLAIN, 20));

		rewardTimer++;
		if (rewardTimer / 400 == 1) {
			rewardTimer = 0;
			if (Math.random() > 0.5) {
				rewards.add(new Ammo());
			} else {
				if (player.lives() < 10) {
					rewards.add(new Heart());
				}
			}
		}

		removals();

		paints(g);

		comparisons();

		// cooldown bar
		g.setColor(new Color(130, 130, 130));
		g.fillRect(50 - 1, screenH - 100 - 1, player.getCooldown()[1] * (200 / player.getCooldown()[1]) + 2, 10 + 2);
		g.setColor(Color.BLUE);
		g.fillRect(50, screenH - 100,
				(player.getCooldown()[1] - player.getCooldown()[0]) * (200 / player.getCooldown()[1]), 10);

		// kill bar
		g.setColor(Color.GREEN);
		g.drawString(player.getKills() + "", 1610, 990);

		g.setColor(Color.RED);
		for (int i = 0; i < player.lives(); i++) {
			g.drawOval(1700 + 20 * i, 980, 10, 10);
		}
	}

	private void removals() {

		// removes expired explosions
		for (int i = 0; i < messages.size(); i++) {
			if (messages.get(i).time() <= 0) {
				messages.remove(i);
				i--;
			}
		}

		// removes expired explosions
		for (int i = 0; i < explosions.size(); i++) {
			if (explosions.get(i).time() <= 0) {
				explosions.remove(i);
				i--;
			}
		}

		// removes blasts outside of screen
		for (int i = 0; i < blasts.size(); i++) {
			if (blasts.get(i).y() < -50) {
				blasts.remove(i);
				i--;
			}
		}
		for (int i = 0; i < aBlasts.size(); i++) {
			if (aBlasts.get(i).y() > screenH + 50) {
				aBlasts.remove(i);
				i--;
			}
		}

		// removes rewards outside of screen
		for (int i = 0; i < rewards.size(); i++) {
			if (rewards.get(i).x() > screenW + 50) {
				rewards.remove(i);
				i--;
			}
		}
	}

	private void paints(Graphics g) {
		for (Star s : stars) {
			s.paint(g);
		}

		for (Boss b : bosses) {
			b.paint(g);
		}

		if (!bossFight) {
			// paint messages
			g.setColor(Color.WHITE);
			for (int i = 0; i < messages.size(); i++) {
				g.setColor(messages.get(i).color());
				g.drawString(messages.get(i).message(), 10, 20 + 20 * i);
				messages.get(i).incTime();
			}

			// paint explosions
			for (Explosion e : explosions) {
				e.paint(g);
			}

			// paint rewards
			for (Reward r : rewards) {
				r.paint(g);
			}

			// paint aliens
			for (Alien[] a1 : aliens) {
				for (Alien a : a1) {
					if (a.y() > screenH + 10) {
						explosionSound.play();
						explosionSound.play();
						gameOver = true;
					}
					if (a.shoot()) {
						aBlasts.add(new Blast(a.x() + 40, a.y() + 55, 1)); // alien center is +40,+55
					}
					a.paint(g);
				}
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

		if (player.checkShot()) {
			blasts.add(new Blast(player.x() + 11, player.y() + 60, 0));
			blasts.add(new Blast(player.x() + 115, player.y() + 60, 0));
			player.incShotsFired();
		}

		player.paint(g);
	}

	private void comparisons() {
		// compare every alien with every player blast
		for (int r = 0; r < aliens.length; r++) {
			for (int c = 0; c < aliens[r].length; c++) {
				Alien a = aliens[r][c];
				for (int i = 0; i < blasts.size(); i++) {
					Blast b = blasts.get(i);
					if (b.hit(a)) {
						explosions.add(new Explosion(b));
						explosionSound.play();
						blasts.remove(i);
						a.respawn();
						player.incKills();

						messages.add(new Message("Alien destroyed", Color.BLUE));
						i--;
					}
				}
			}
		}

		// compare every reward with every blast
		for (int i = 0; i < blasts.size(); i++) {
			Blast b = blasts.get(i);
			for (int x = 0; x < rewards.size(); x++) {
				if (b.hit(rewards.get(x))) {
					if (rewards.get(x).isType("ammo")) {
						player.decreaseCooldown();
						messages.add(new Message("Reload decreased to " + player.getCooldown()[1], Color.GREEN));
					} else if (rewards.get(x).isType("heart")) {
						player.lives(1);
						messages.add(new Message("Health increased", Color.GREEN));
					}
					blasts.remove(i);
					rewards.remove(x);
					x--;
					i--;
				}
			}
		}

		// compare player with every blast
		for (int i = 0; i < aBlasts.size(); i++) {
			Blast b = aBlasts.get(i);
			if (b.hit(player)) {
				explosions.add(new Explosion(b));
				explosionSound.play();
				aBlasts.remove(i);
				player.hit();
				messages.add(new Message("Player hit", Color.RED));
				i--;
			}
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

		generate();

		frame.setVisible(true);
	}

	public void generate() {
		aliens = new Alien[6][4];

		// populate aliens array
		for (int r = 0; r < aliens.length; r++) {
			for (int c = 0; c < aliens[r].length; c++) {
				aliens[r][c] = new Alien(100 * r + 650, 100 * c - 150, c % 2);
			}
		}

		player = new Player(screenW / 2, screenH - 280);
		blasts = new ArrayList<Blast>();
		aBlasts = new ArrayList<Blast>();
		rewards = new ArrayList<Reward>();
		explosions = new ArrayList<Explosion>();
		messages = new ArrayList<Message>();
		bosses = new ArrayList<Boss>();
		stars = new ArrayList<Star>();

		while (stars.size() < 200) {
			stars.add(new Star());
		}

		explosionSound = new Audio("explosion.wav", false);

		rewardTimer = 0;
		playing = true;
		gameOver = false;
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
			player.setShooting(true);
			break;
		case 27: // ESC
			generate();
			break;
		default:
//			 System.out.println("Unrecognized, key code: " + arg0.getKeyCode());
			break;
		}
	}

	public void keyReleased(KeyEvent arg0) {
		switch (arg0.getKeyCode()) {
		case 37: // left
			if (player.vx() == -1) {
				player.motion(0);
			}
			break;
		case 39: // right
			if (player.vx() == 1) {
				player.motion(0);
			}
			break;
		case 32: // space
			player.setShooting(false);
			break;
		default:
			break;
		}
	}

	public void keyTyped(KeyEvent arg0) {

	}

	public void mouseClicked(MouseEvent arg0) {
		System.out.println(arg0);
	}

	public void mouseEntered(MouseEvent arg0) {
		playing = true;
	}

	public void mouseExited(MouseEvent arg0) {
		playing = false;
	}

	public void mousePressed(MouseEvent arg0) {

	}

	public void mouseReleased(MouseEvent arg0) {

	}

}
