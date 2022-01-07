public class Blast extends FlyingObj {
	private int type;

	public Blast(int x, int y, int type) {
		super(x - 10, y - 30, "blast" + type + ".png", 0.05);
		this.type = type;
	}

	public void move() {
		if (type == 0) {
			y -= 10;
		} else if (type == 1) {
			y += 10;
		}
	}

	public boolean hit(FlyingObj obj) {
		if (!obj.visible || !visible) {
			return false;
		}

		int objX = obj.x;
		int objY = obj.y;
		double objW = obj.width;
		double objH = obj.height;

		if (objX < this.x) {
			if (objY < this.y) {
				if (objX + objW > this.x) {
					if (objY + objH > this.y) {
						return true;
					}
				}
			}
		}

		return false;
	}
}
