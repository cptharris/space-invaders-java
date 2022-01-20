public class Alien extends FlyingObj {
	private int direction;
	private int version;
	private int type;

	public Alien() {
		this(100, 100, 0);
	}

	public Alien(int x, int y, int type) {
		super(x, y, "alien" + type + "0.png", 0.05);
		this.type = type;
		direction = 1;
		version = 0;
	}

	public void move() {
		if (Math.abs(x - oX) > range) {
			direction *= -1;
			y += 20;
		}
		x += 20 * direction;
		version++;
		if (version > 3) {
			version = 0;
		}
		changePicture("alien" + type + version + ".png");
	}

	public void respawn() {
		// max = 750, min = 250
		y = -1 * ((int) (Math.random() * 501) + 250);
	}

	public boolean shoot() {
		if (y < -10) {
			return false;
		}
		int i = 400;
		return (int) (Math.random() * (i) + 1) > i - 1;
	}

	public boolean overlaping(Alien a) {
		if (x - 5 < a.x) {
			if (x - 5 < a.y) {
				if (x + width + 5 > a.x) {
					if (x + height + 5 > a.y) {
						return true;
					}
				}
			}
		}

		return false;
	}

}

class StillAlien extends Alien {

	public StillAlien(int x, int y, int type) {
		super(x, y, type);
		scaleSize = 0.01;
		init(x, y);
	}

	public void move() {
	}

	public boolean shoot() {
		return false;
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
