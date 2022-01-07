public class Player extends FlyingObj {
	private int vx;

	public Player(int x, int y) {
		super(x, y, "xwing.png", 0.2);
		range += 50;
	}

	public void move() {
		if (x - oX > range) { // left side
			x = oX + range;
		} else if (x - oX < -range) { // right side
			x = oX - range;
		}

		x += vx;
	}

	public void motion(int key) {
		/*
		 * -1: left, 0: stop 1: right
		 */

		if (key == -1) {
			vx = -10;
		} else if (key == 0) {
			vx = 0;
		} else if (key == 1) {
			vx = 10;
		}

	}
}
