public class Explosion extends FlyingObj {
	private int time = 35;

	public Explosion(int x, int y) {
		super(x, y, "explosion.gif", 0.75);
	}

	public Explosion(FlyingObj obj) {
		this(obj.x, obj.y);
	}

	public void move() {
		time--;
	}

	public int time() {
		return time;
	}

}
