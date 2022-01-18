
public class Reward extends FlyingObj {

	public Reward(String fileName, double scaleSize) {
		super((int) (Math.random() * 401 + 100), -50, fileName, scaleSize);
	}

	public void move() {
		x += 10;
	}

}
