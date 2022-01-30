
public class Boss extends Alien {

	public Boss() {
		super(1920 / 2 - 300, 0, 0);
		scaleSize = 0.5;
		update();
		vx = 5;
	}

	public void move() {
		if (true) {
			return;
		}
		// change direction and go down when reaches edge of range
		if (Math.abs(x - oX) > range) {
			direction *= -1;
			y += 20;
		}
		// go left/right
		x += vx * direction;
	}

	public int[] shoot(int key) {
		// alien @ x=660 y = 0
		// foot 1 @ x=+66,+123 y=+495
		// foot 2 @ x=+530,+588 y=+495
		return new int[2];
	}
}
