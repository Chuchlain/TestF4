package game;

import java.util.ArrayList;
import java.util.Collections;

import map.Habitat;
import map.Map;
import players.Species;

public class AI {

	private ArrayList<Direction> randomDir;
	private Direction dir;
	private Map map;
	
	public AI() {
		this.map = new Map();
	}
	
	public boolean moveTry(int px, int py, Species s) {
		
		if ((px < 0 || px > 620) || (py < 0 || py > 380)) {
			return false;
		}
		
		switch (s) {
		case AQUA:
			if ((map.getHabitat(px, py) == Habitat.MEER) || (map.getHabitat(px, py) == Habitat.FISCH)) {
				return true;
			} else {
				return false;
			}
		case HERBA:
			if ((map.getHabitat(px, py) == Habitat.SAVANNE) || (map.getHabitat(px, py) == Habitat.WIESE) || (map.getHabitat(px, py) == Habitat.FLEISCH) || (map.getHabitat(px, py) == Habitat.FRUECHTE) || (map.getHabitat(px, py) == Habitat.GETREIDE)) {
				return true;
			} else {
				return false;
			}
		case LITUS:
			if ((map.getHabitat(px, py) == Habitat.MEER) || (map.getHabitat(px, py) == Habitat.SUMPF) || (map.getHabitat(px, py) == Habitat.WIESE) || (map.getHabitat(px, py) == Habitat.FISCH) || (map.getHabitat(px, py) == Habitat.FLEISCH) || (map.getHabitat(px, py) == Habitat.FRUECHTE) || (map.getHabitat(px, py) == Habitat.GETREIDE)) {
				return true;
			} else {
				return false;
			}
		default:
			return false;
		}
	}
	
	
	
	public Direction randomMove(int px, int py, Species species) {
		randomDir = new ArrayList<Direction>();
		
		//nord
		if (moveTry(px, py - 20, species)) {
			randomDir.add(Direction.NORTH);
		}
		
		//ost
		if (moveTry(px + 20, py, species)) {
			randomDir.add(Direction.EAST);
		}
		
		//süd
		if (moveTry(px, py + 20, species)) {
			randomDir.add(Direction.SOUTH);
		}
		
		//west
		if (moveTry(px - 20, py, species)) {
			randomDir.add(Direction.WEST);
		}
		
		/*for (Direction d: randomDir) {
			System.out.println(d);
		}
		System.out.println("neu");*/
		
		Collections.shuffle(randomDir);
		dir = randomDir.get(0);
		
		return dir;
	}
	
}
