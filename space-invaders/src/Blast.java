
public class Blast extends FlyingObj {
	public Blast(int x, int y) {
		super(x - 10, y - 30, "blast.png", 0.05);
	}

	public void move() {
		y -= 1;
	}

	public boolean hit(FlyingObj obj) {
		if (!obj.visible || !visible) {
			return false;
		}

		int objX = obj.x;
		int objY = obj.y;
		int objW = (int) obj.width;
		int objH = (int) obj.height;

		if (objX < x && objY < y && objX + objW > x + width && objY + objH > y + height) {
			System.out.println("blast#" + id + " just hit alien#" + obj.id);
			return true;
		}
		return false;
	}
}
