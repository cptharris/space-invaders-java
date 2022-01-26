
public class Explosion extends FlyingObj {
	private int time = 35;

	public Explosion(FlyingObj obj) {
		super(obj.x, obj.y, "explosion.gif", 0.75);
	}

	public Explosion(int x, int y, double scaleSize) {
		super(x, y, "explosion.gif", scaleSize);
	}

	public void move() {
		time--;
	}

	public int time() {
		return time;
	}

}
