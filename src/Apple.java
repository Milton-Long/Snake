import java.awt.Color;
import java.awt.Graphics;

public class Apple {

	int x;
	int y;
	int width;
	int height;
	
	public Apple(int AppleX, int AppleY, int Apple_width, int Apple_height) {
		x = AppleX;
		y = AppleY;
		width = Apple_width;
		height = Apple_height;
	}
	
	public void move(int newX, int newY) {
		x = newX;
		y = newY;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(x, y, width, height);
	}
}
