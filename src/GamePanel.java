import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.Timer;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable,  ActionListener  {

	static final int PANEL_WIDTH = 500;
	static final int PANEL_HEIGHT = 500;
	static final int UNIT_SIZE = 20;
	static final int GAME_UNITS = (PANEL_WIDTH * PANEL_HEIGHT) / UNIT_SIZE;
	static final int MAXIMUM_DELAY = 16; // 60 frames per second

	final int[] x = new int[GAME_UNITS];
	final int[] y = new int[GAME_UNITS];

	public static final int UP = KeyEvent.VK_UP;
	public static final int DN = KeyEvent.VK_DOWN;
	public static final int LT = KeyEvent.VK_LEFT;
	public static final int RT = KeyEvent.VK_RIGHT;
	public static final int SPACE = KeyEvent.VK_SPACE;

	public static final int _W = KeyEvent.VK_W;
	public static final int _A = KeyEvent.VK_A;
	public static final int _S = KeyEvent.VK_S;
	public static final int _D = KeyEvent.VK_D;

	public boolean[] pressed = new boolean[1024];

	private static Thread thread;

	boolean running = false;
	Random rng = new Random();
	Apple apple;

	Player player;

	public GamePanel() {
		this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		this.setBackground(Color.BLACK);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter()); //<-- Reimplement this for key adapter

		apple = new Apple(rng.nextInt(PANEL_WIDTH / UNIT_SIZE) * UNIT_SIZE, rng.nextInt(PANEL_HEIGHT / UNIT_SIZE) * UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);
		player = new Player((140 / UNIT_SIZE) * UNIT_SIZE, (250 / UNIT_SIZE) * UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);  // 140, 250

		start();
	}

	public void start() {

		thread = new Thread(this);
		thread.start();

		running = true;

	}

	@Override
	public void run() {
		while (running) {

			// System.out.println("astroid" + " .... " + "player x: "+player.body.x +"
			// player y: " + player.body.y);
			// apple.move(rng.nextInt(PANEL_WIDTH/UNIT_SIZE)*UNIT_SIZE,
			// rng.nextInt(PANEL_HEIGHT/UNIT_SIZE)*UNIT_SIZE);

			if (pressed[UP]) {
				System.out.println("Up button is pressed");
			}
			if (pressed[DN]) {
				System.out.println("Down button is pressed");
			}
			if (pressed[LT]) {
				System.out.println("Left button is pressed");
			}
			if (pressed[RT]) {
				System.out.println("Right button is pressed");
			}

			repaint();
			try {
				Thread.sleep(MAXIMUM_DELAY); // puts my thread to sleep
			} catch (Exception x) {

			}
		}

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (int i = 0; i < PANEL_HEIGHT / UNIT_SIZE; i++) {
			// Draw vertical lines
			g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, PANEL_HEIGHT);

			// Draw horizontal lines
			g.drawLine(0, i * UNIT_SIZE, PANEL_WIDTH, i * UNIT_SIZE);
		}

		apple.draw(g);
		player.draw(g);
	}

	
	public class MyKeyAdapter extends KeyAdapter{
	  
	  
		@Override 
		public void keyPressed(KeyEvent e) { 
			
			int keyCode = e.getKeyCode();
			
			if(keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_W) {
				System.out.println("Up button is pressed");
			}
			if(keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_S) {
				System.out.println("Down button is pressed");
			}
			if(keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_A) {
				System.out.println("Left button is pressed");
			}
			if(keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_D) {
				System.out.println("Right button is pressed");
			}
		}
	  
		@Override 
		public void keyReleased(KeyEvent e) {  
			
			int keyCode = e.getKeyCode();
			
			if(keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_W) {
				System.out.println("Up button is released");
			}
			if(keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_S) {
				System.out.println("Down button is released");
			}
			if(keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_A) {
				System.out.println("Left button is released");
			}
			if(keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_D) {
				System.out.println("Right button is released");
			}
			
		}
	  
	  }
	  
	  @Override 
	  public void actionPerformed(ActionEvent arg0) { 
	  // TODO Auto-generated method stub
	  
	  }
	 

}
