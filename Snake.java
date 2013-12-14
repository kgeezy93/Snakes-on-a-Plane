import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Random;

/**
 * class for the snake
 * @author kevinguh
 *
 */
public class Snake implements KeyListener{
	LinkedList<SnakeNode> snake;
	Random rand = new Random();
	protected int snakeLength;
	protected int xPosition;
	protected int xVelocity;
	protected int yPosition;
	protected int yVelocity;
	protected final int X_INIT_VELOCITY;
	protected final int Y_INIT_VELOCITY;
	
	/**
	 * constructor method for the snake
	 * @param game the main game
	 */
	public Snake(SnakeMain game){
		xPosition = generateRandXPosition(rand, game);
		yPosition = generateRandYPosition(rand, game);
		xVelocity = generateRandVelocity(rand);
		yVelocity = generateRandVelocity(rand);
		snake = new LinkedList<SnakeNode>();
		snake.add(new SnakeNode(this));
		snakeLength = snake.size();
		X_INIT_VELOCITY = xVelocity;
		Y_INIT_VELOCITY = yVelocity;
	}
	
	/**
	 * method to generate random velocity
	 * @param random Random object
	 * @return velocity randomly generated velocity
	 */
	public int generateRandVelocity(Random random){
		int velocity = random.nextInt(10);
		boolean velocityFlip = random.nextBoolean();
		if(velocityFlip)
			velocity = -velocity;
		return velocity;
	}
	
	/**
	 * method for generating random x positions
	 * @param random Random object
	 * @param main the main game
	 */
	public int generateRandXPosition(Random random, SnakeMain main){
		int position = random.nextInt(main.getWidth());
		return position;
	}
	
	/**
	 * method for generating random y positions
	 * @param random Random object
	 * @param main the main game
	 */
	public int generateRandYPosition(Random random, SnakeMain main){
		int position = random.nextInt(main.getHeight());
		return position;
	}
	/**
	 * method that lengthens the snake when it eats an object
	 */
	public void addNode(int xPosition, int yPosition, int xVelocity, int yVelocity){
		snake.add(new SnakeNode(this));
		snakeLength = snake.size();
	}

	/**
	 * method to move the snake in the x-direction
	 * @param deltaX how much the snake should move in the x-direction
	 */
	public void moveSnakeX(int deltaX){
		xPosition += deltaX;
	}
	
	/**
	 * method to move the snake in the y-direction
	 * @param deltaY how much the snake should move in the y-direction
	 */
	public void moveSnakeY(int deltaY){
		yPosition += deltaY;
	}
	
	/**
	 * getter method for xPosition variable
	 * @return xPosition
	 */
	public int getXPosition(){
		return xPosition;
	}
	
	/**
	 * getter method for yPosition variable
	 * @return yPosition
	 */
	public int getYPosition(){
		return yPosition;
	}
	
	/**
	 * getter method for xVelocity variable
	 * @return xVelocity
	 */
	public int getXVelocity(){
		return xVelocity;
	}
	
	/**
	 * getter method for yVelocity variable
	 * @return yVelocity
	 */
	public int getYVelocity(){
		return yVelocity;
	}
	
	/**
	 * instructions for how the game will respond to key presses
	 */
	public void keyPressed(KeyEvent k) {
		int keyValue = k.getKeyCode();
		
		// only change the snake movement when valid
		switch(keyValue) {
			case KeyEvent.VK_UP:
				yVelocity -= 2;
				break;
				
			case KeyEvent.VK_DOWN:
				yVelocity += 2;
				break;
				
			case KeyEvent.VK_LEFT:
				xVelocity -= 2;
				break;
					
			case KeyEvent.VK_RIGHT:
				xVelocity += 2;
				break;
		}
			
	}

	public void keyReleased(KeyEvent k) { }
	public void keyTyped(KeyEvent k) { }
}
