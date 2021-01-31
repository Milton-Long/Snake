import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player {

	int x;
	int y;
	int width;
	int height;
	
	Rectangle body;
	
	public Player(int player_x, int player_y, int player_width, int player_height) {
		x = player_x;
		y = player_y;
		width = player_width;
		height = player_height;
		
		createRectangle();
	}
	
	public void createRectangle() {
		body = new Rectangle(x, y, width, height);
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x, y, width, height);
		//g.drawRect(x, y, width, height);
		
	}
}
