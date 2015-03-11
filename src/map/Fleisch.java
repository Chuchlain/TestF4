package map;

import org.newdawn.slick.Image;

import players.Species;

public class Fleisch extends Feld {

	public Fleisch() {
		super(Habitat.FLEISCH, "data/Fleisch.png");
	}

	public Image getBild() {
		return bild;
	}
	
	public int habitatLP(Species species) {
		
		switch (species) {
		case AQUA:
			nahrung = 0;
			break;
		case HERBA:
			nahrung = 0;
			break;
		case LITUS:
			nahrung = 10;
			break;
		default:
			nahrung = 10;
			break;
		}
		return nahrung;
	}
	
	public float getBewegung(Species species) {
		
		switch (species) {
		case AQUA:
			steps = 1f;
			break;
		case HERBA:
			steps = 1f;
			break;
		case LITUS:
			steps = 1f;
			break;
		default:
			steps = 1f;
			break;
		}
		return steps;
	}
	
}
