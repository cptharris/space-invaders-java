
public class Blast extends FlyingObj {
	public Blast(int x, int y) {
		super(x - 10, y - 30, "blast.png", 0.05);
	}
	
	public void move() {
		y -= 20;
	}
}
