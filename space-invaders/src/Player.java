public class Player extends FlyingObj {
	private int vx;
	private int hits;

	public Player(int x, int y) {
		super(x, y, "xwing.png", 0.2);
		range += 50;
		hits = 0;
	}

	public void move() {
		if (x - oX > range) { // left side
			x = oX + range;
		} else if (x - oX < -range) { // right side
			x = oX - range;
		}

		x += vx * 25;

		if (hits > 0) {
			changePicture("xwing-d" + (hits % 7) + ".png");
		}
	}

	public void motion(int key) {
		/*
		 * -1: left, 0: stop 1: right
		 */

		vx = key;
	}

	public void hit() {
		hits++;
	}
}
