package players;

import game.Direction;
import map.Habitat;
import map.Map;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SpriteSheet;

public class Kreatur {

	protected int posX, posY;
	protected float stepsCount;
	protected boolean isAlive;
	protected int lebenspunkte;
	protected int konstitution;
	protected int staerke;
	protected int tempo;
	protected int geschick;
	protected Species species;
	
	//protected int nahrung;
	
	protected Animation sprite, up, down, left, right;
	protected SpriteSheet movmentUp, movmentDown, movmentLeft, movmentRight;
	
	protected Map map;
	
	public Kreatur(int posX, int posY, float steps, boolean isAlive, int lp, int konst, int staerke, int tempo, int gesch, Species species) {
		this.posX = posX;
		this.posY = posY;
		this.stepsCount = steps;
		this.isAlive = isAlive;
		this.lebenspunkte = lp;
		this.konstitution = konst;
		this.staerke = staerke;
		this.tempo = tempo;
		this.geschick = gesch;
		this.species = species;
		this.map = new Map();
	}
	
	public Habitat move(int dx, int dy) {
		//this.stepsCount -= 1;
		this.posX += dx;
		this.posY += dy;
		return map.getHabitat(posX, posY);
	}
	
	public void setSprite(Direction dir) {
		if (dir == Direction.NORTH) {
			sprite = up;
		} else if (dir == Direction.SOUTH) {
			sprite = down;
		} else if (dir == Direction.WEST) {
			sprite = left;
		} else if (dir == Direction.EAST) {
			sprite = right;
		}
	}
	
	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
	
	public float getStepsCount() {
		return stepsCount;
	}
	
	public void setStepsCount(float stepsCount) {
		this.stepsCount -= stepsCount;
	}
	
	public void setSteps(float steps) {
		this.stepsCount = steps;
	}
	
	public boolean isAlive() {
		return isAlive;
	}
	
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	public Species getSpecies() {
		return species;
	}
	
	public void setSpecies(Species species) {
		this.species = species;
	}
	
	/*public int getNahrung() {
		return nahrung;
	}
	
	public void setNahrung(int nahrung) {
		this.nahrung += nahrung;
	}*/
	
	public int getLebenspunkte() {
		return lebenspunkte;
	}
	
	public void setLebenspunkte(int lebenspunkte) {
		this.lebenspunkte += lebenspunkte;
	}
	
}
