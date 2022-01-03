import java.awt.Graphics;
import java.awt.Color;

public class Alien {
	private int x;
	private int y;
	private int type;
	private Color c;

	public Alien() {
		x = 0;
		y = 0;
		type = 1;
		c = Color.white;
	}

	public Alien(int x, int y) {
		this();
		this.x = x;
		this.y = y;
	}

	public void paint(Graphics g) {
		g.setColor(c);
		if (type == 0) {
			g.fillOval(x - 30, y - 15, 60, 30);
			g.fillRect(x - 5 - 30, y - 5 - 15, 20, 20);
			g.fillRect(x + 60 - 15 - 30, y - 5 - 15, 20, 20);
			g.fillRect(x + 15 - 30, y + 25 - 15, 10, 10);
			g.fillRect(x + 35 - 30, y + 25 - 15, 10, 10);
		} else if (type == 1) {
			g.fillRect(x - 20, y - 10, 40, 20);
			g.fillRect(x - 30, y - 25, 10, 20);
			g.fillRect(x + 20, y - 25, 10, 20);
			g.fillRect(x - 5, y - 20, 10, 20);
			g.fillRect(x - 15, y + 10, 5, 10);
			g.fillRect(x + 10, y + 10, 5, 10);
		}
	}
}
