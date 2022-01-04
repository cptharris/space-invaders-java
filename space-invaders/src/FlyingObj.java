import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class FlyingObj {
	protected Image img;
	protected AffineTransform tx;

	protected int x, y;
	protected double scaleSize;

	public FlyingObj() {
		img = getImage("/imgs/xwing.png");
		tx = AffineTransform.getTranslateInstance(x, y);
		init(x, y);
	}

	public void changePicture(int type) {
		img = getImage("/imgs/alien" + type + ".png");
		init(x, y);
	}

	public void paint(Graphics g) {
		move();
		// these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
		update();
	}

	public void move() {
	}

	// update the picture variable location
	protected void update() {
		tx.setToTranslation(x, y);
		tx.scale(scaleSize, scaleSize);
	}

	protected void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(scaleSize, scaleSize);
	}

	protected Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Alien.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}
