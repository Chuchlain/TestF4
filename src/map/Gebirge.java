package map;

import org.newdawn.slick.Image;

import players.Species;

public class Gebirge extends Feld {

	public Gebirge() {
		super(Habitat.GEBIRGE, "data/Gebirge.png");
	}
	
	public Image getBild() {
		return bild;
	}
	
	public int habitatLP(Species species) {
		
		switch (species) {
		case AQUA:
			nahrung = -1;
			break;
		case HERBA:
			nahrung = 0;
			break;
		case LITUS:
			nahrung = -2;
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
			steps = 0f;
			break;
		case LITUS:
			steps = 1f;
			break;
		default:
			steps = 0f;
			break;
		}
		return steps;
	}

}
