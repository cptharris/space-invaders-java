
public class Reward extends FlyingObj {

	public Reward(String filename, double scaleSize) {
		super(-50, (int) (Math.random() * 401 + 100), filename + ".png", scaleSize);
	}

	public void move() {
		x += 10;
	}

}

class Heart extends Reward {

	public Heart() {
		super("heart", 0.05);
	}
}

class Ammo extends Reward {

	public Ammo() {
		super("ammo", 0.1);
	}
}
