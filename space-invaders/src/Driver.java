import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Driver extends JPanel implements ActionListener, KeyListener {
	public int screenW = 1920, screenH = 1080;
	Alien[][] aliens = new Alien[6][4];

	public void paint(Graphics g) {
		g.fillRect(0, 0, screenW, screenH);
		for (Alien[] a1 : aliens) {
			for (Alien a : a1) {
				a.paint(g);
			}
		}

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
		t.start();

		// generate aliens
		for (int r = 0; r < aliens.length; r++) {
			for (int c = 0; c < aliens[r].length; c++) {
				aliens[r][c] = new Alien(100 * r + 650, 100 * c + 10, c % 2);
			}
		}

		frame.setVisible(true);
	}

	Timer t = new Timer(16, this);

	public void actionPerformed(ActionEvent m) {
		repaint();
	}

	public void keyPressed(KeyEvent arg0) {

	}

	public void keyReleased(KeyEvent arg0) {

	}

	public void keyTyped(KeyEvent arg0) {

	}
}
