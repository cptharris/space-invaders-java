
public class Bomb extends FlyingObj {

	public Bomb(String fileName, double scaleSize) {
		super(-50, (int) (Math.random() * 401 + 100), fileName, scaleSize);
	}

	public void move() {
		x += 10;
	}

}
