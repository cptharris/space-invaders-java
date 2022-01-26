public class Player extends FlyingObj {
	protected int vx;
	protected int hits;
	protected boolean shooting;
	protected int[] cooldown = { 0, 50 };

	public Player(int x, int y) {
		super(x, y, "xwing.png", 0.2);
		range += 50;
		hits = 0;
		shooting = false;
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

		if (cooldown[0] > 0) {
			cooldown[0]--;
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

	public boolean shoot() {
		boolean temp = shooting && cooldown[0] == 0;
		cooldown[0] = cooldown[1];
		return temp;
	}

	public void decreaseCooldown() {
		if (cooldown[1] > 5) {
			cooldown[1] /= 2;
		}
	}

	public void setShooting(boolean shooting) {
		this.shooting = shooting;
	}

	public int[] getCooldown() {
		return cooldown;
	}

}
