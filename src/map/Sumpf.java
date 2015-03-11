package map;

import org.newdawn.slick.Image;

import players.Species;

public class Sumpf extends Feld {

	public Sumpf() {
		super(Habitat.SUMPF, "data/Sumpf.png");
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
			nahrung = -1;
			break;
			
		case LITUS:
			nahrung = 1;
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
			steps = 0f;
			break;
		case HERBA:
			steps = 0f;
			break;
		case LITUS:
			steps = 0.5f;
			break;
		default:
			steps = 0f;
			break;
		}
		return steps;
	}
	
}
