import java.awt.geom.AffineTransform;

public class Alien extends FlyingObj {
	private int direction;

	public Alien(int x, int y, int type) {
		super(x, y, "alien" + type + ".png", 0.05);
		direction = 1;
	}

	public void move() {
		if (Math.abs(x - oX) > range) {
			direction *= -1;
			y += 20;
		}
		x += 5 * direction;
	}

}

/*
 * if (type == 0) { g.fillRect(x - 30, y - 15, 60, 30); // body g.fillRect(x -
 * 35, y - 20, 20, 20); // left ear g.fillRect(x + 15, y - 20, 20, 20); // right
 * ear g.fillRect(x - 25, y + 10, 10, 15); // left foot g.fillRect(x + 15, y +
 * 10, 10, 15); // right foot } else if (type == 1) { g.fillRect(x - 20, y - 10,
 * 40, 20); g.fillRect(x - 30, y - 25, 10, 20); g.fillRect(x + 20, y - 25, 10,
 * 20); g.fillRect(x - 5, y - 20, 10, 20); g.fillRect(x - 15, y + 10, 5, 10);
 * g.fillRect(x + 10, y + 10, 5, 10); }
 */
