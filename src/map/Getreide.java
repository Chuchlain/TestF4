package map;

import org.newdawn.slick.Image;

import players.Species;

public class Getreide extends Feld {

	public Getreide() {
		super(Habitat.GETREIDE, "data/Getreide.png");
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
			nahrung = 10;
			break;
		case LITUS:
			nahrung = 0;
			break;
		default:
			nahrung = 0;
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
