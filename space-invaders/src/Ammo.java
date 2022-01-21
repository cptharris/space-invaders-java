
public class Ammo extends FlyingObj {

	public Ammo() {
		super(-50, (int) (Math.random() * 401 + 100), "ammo.png", 0.1);
	}

	public void move() {
		x += 10;
	}

}
