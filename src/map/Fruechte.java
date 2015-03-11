package map;

import org.newdawn.slick.Image;

import players.Species;

public class Fruechte extends Feld {

	public Fruechte() {
		super(Habitat.FRUECHTE, "data/Fruits.png");
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
			nahrung = 10;
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
