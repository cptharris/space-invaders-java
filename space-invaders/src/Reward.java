
public class Reward extends FlyingObj {
	String type;

	public Reward(String filename, double scaleSize) {
		super(-50, (int) (Math.random() * 401 + 100), filename + ".png", scaleSize);
		type = filename;
	}

	public void move() {
		x += 10;
	}

	public boolean isType(String checkType) {
		return type.equals(checkType);
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
