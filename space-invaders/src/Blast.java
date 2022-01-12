public class Blast extends FlyingObj {
	private int type;

	public Blast(int x, int y, int type) {
		super(x - 10, y - 30, "blast" + type + ".png", 0.05);
		this.type = type;
	}

	public void move() {
		int v = 20;
		if (type == 0) {
			y -= v;
		} else if (type == 1) {
			y += v;
		}
	}

	public boolean hit(FlyingObj obj) {
		if (!obj.visible || !visible || obj.y < -10) {
			return false;
		}

		int objX = obj.x;
		int objY = obj.y;
		double objW = obj.width;
		double objH = obj.height;

		if (objX - 5 < this.x) {
			if (objY - 5 < this.y) {
				if (objX + objW + 5 > this.x) {
					if (objY + objH + 5 > this.y) {
						return true;
					}
				}
			}
		}

		return false;
	}
}
