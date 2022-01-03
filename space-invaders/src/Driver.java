import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Driver extends JPanel implements ActionListener, KeyListener {
	public int screenW = 800, screenH = 600;

	Alien alien1 = new Alien(100, 100);

	public void paint(Graphics g) {
		g.fillRect(0, 0, screenW, screenH);
		alien1.paint(g);
		
		
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
