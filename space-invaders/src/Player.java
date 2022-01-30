public class Player extends FlyingObj {
	protected int vx;
	protected int hits;
	protected boolean shooting;
	protected int[] cooldown = { 0, 50 };
	protected int kills;
	protected int lives;
	protected int shotsFired;

	public Player(int x, int y) {
		super(x, y, "xwing.png", 0.2);
		vx = 0;
		hits = 0;
		shooting = false;

		range += 50;

		kills = 0;
		lives = 5;
		shotsFired = 0;
	}

	public void move() {
		if (x - oX > range) { // left side
			x = oX + range;
		} else if (x - oX < -range) { // right side
			x = oX - range;
		}

		x += vx * 25;

		if (hits > 0) {
			changePicture("xwing-d" + (hits % 6) + ".png");
		}

		if (cooldown[0] > 0) {
			cooldown[0]--;
		}
	}

	/*
	 * -1: left, 0: stop 1: right
	 */
	public void motion(int key) {
		vx = key;
	}

	public void hit() {
		hits++;
		lives--;
	}

	public boolean checkShot() {
		if (shooting && cooldown[0] == 0) {
			cooldown[0] = cooldown[1];
			return true;
		}
		return false;
	}

	public void decreaseCooldown() {
		if (cooldown[1] > 1) {
			cooldown[1] /= 2;
		}
	}

	public void setShooting(boolean shooting) {
		this.shooting = shooting;
	}

	public int[] getCooldown() {
		return cooldown;
	}

	public int getKills() {
		return kills;
	}

	public void incKills() {
		kills++;
	}

	public int lives() {
		return lives;
	}

	public void lives(int updown) {
		this.lives += 1 * updown;
	}

	public int getShotsFired() {
		return shotsFired;
	}

	public void incShotsFired() {
		shotsFired += 2;
	}

	public int vx() {
		return vx;
	}

}
