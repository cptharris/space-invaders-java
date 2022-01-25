
public class Explosion extends FlyingObj {
	private int time;

	public Explosion(FlyingObj obj) {
		super(obj.x, obj.y, "explosion.gif", 0.75);
		time = 35;
	}

	public void move() {
		time--;
	}

	public int time() {
		return time;
	}

}
