package players;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Player extends Kreatur {

	public Player(int posX, int posY, float steps, boolean isAlive, int lp, int konst, int staerke, int tempo, int gesch, Species species) {
		super(posX, posY, steps, isAlive, lp, konst, staerke, tempo, gesch, species);
	}
	
	public void render(Graphics g) {
		sprite.draw(this.getPosX(), this.getPosY(), 20, 20);
	}
	
	public void init(GameContainer container) throws SlickException {
		
		movmentUp = new SpriteSheet("data/Up.png", 25, 25);
		movmentDown = new SpriteSheet("data/Down.png", 25, 25);
		movmentLeft = new SpriteSheet("data/Left.png", 25, 25);
		movmentRight = new SpriteSheet("data/Right.png", 25, 25);
		
		up = new Animation(movmentUp, 200);
		down = new Animation(movmentDown, 200);
		left = new Animation(movmentLeft, 200);
		right = new Animation(movmentRight, 200);
		
		sprite = right;
	}
	
	
}
