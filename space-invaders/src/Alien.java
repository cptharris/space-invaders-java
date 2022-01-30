public class Alien extends FlyingObj {
	protected int direction;
	private int version;
	private int type;
	protected int vx;
	private int shotChance = 400;

	public Alien() {
		this(100, 100, 0);
	}

	public Alien(int x, int y, int type) {
		super(x, y, "alien" + type + "0.png", 0.05);
		this.type = type;
		direction = 1;
		version = 0;
		vx = 20;
	}

	public void move() {
		// change direction and go down when reaches edge of range
		if (Math.abs(x - oX) > range) {
			direction *= -1;
			y += 20;
		}
		// go left/right
		x += vx * direction;

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
		vx++;
		shotChance -= 50;
	}

	public boolean shoot() {
		if (y < -10) {
			return false;
		}
		return (int) (Math.random() * (shotChance) + 1) > shotChance - 1;
	}

}
