public class Player extends FlyingObj {

	public Player(int x, int y) {
		super(x, y, "xwing.png", 0.2);
		range += 50;
	}

	public void motion(int key) {
		/*
		 * 0: left 1: right
		 */

		if (key == 0) {
			this.x -= 10;
		} else if (key == 1) {
			this.x += 10;
		}

		if (x - oX > range) { // left side
			this.x = oX + range;
		} else if (x - oX < -range) { // right side
			this.x = oX - range;
		}

	}
}

/*
 * if (type == 0) { g.fillRect(x - 30, y - 15, 60, 30); // body g.fillRect(x -
 * 35, y - 20, 20, 20); // left ear g.fillRect(x + 15, y - 20, 20, 20); // right
 * ear g.fillRect(x - 25, y + 10, 10, 15); // left foot g.fillRect(x + 15, y +
 * 10, 10, 15); // right foot } else if (type == 1) { g.fillRect(x - 20, y - 10,
 * 40, 20); g.fillRect(x - 30, y - 25, 10, 20); g.fillRect(x + 20, y - 25, 10,
 * 20); g.fillRect(x - 5, y - 20, 10, 20); g.fillRect(x - 15, y + 10, 5, 10);
 * g.fillRect(x + 10, y + 10, 5, 10); }
 */
