
public class Star extends FlyingObj {
	private int vx, vy;

	public Star() {
		super(genX(), genY(), "star.png", Math.random() * (0.1 - 0.05) + 0.05);
		vx = (int) (Math.random() * 11 + 1);
		vy = (int) (Math.random() * 6 + 1);
	}

	public void move() {
		x += vx;
		y += vy;

		if (y > 1080 + 10) {
			y = genY();
		}
		if (x > 1920 + 10) {
			x = genX();
		}
	}

	private static int genX() {
		return -1 * (int) (Math.random() * 50 + 20);
	}

	private static int genY() {
		return (int) (Math.random() * (1080 * 2) - 1080);
	}

}
