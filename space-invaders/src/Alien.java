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
		// change direction and go down when reaches edge of range
		if (Math.abs(x - oX) > range) {
			direction *= -1;
			y += 20;
		}
		// go left/right
		x += 20 * direction;

		// toggle through versions of alien type
		version++;
		if (version > 3) {
			version = 0;
		}
		// update picture
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

}
