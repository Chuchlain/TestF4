package game;

import map.Fleisch;
import map.Fruechte;
import map.Gebirge;
import map.Getreide;
import map.Habitat;
import map.Meer;
import map.Fisch;
import map.Savanne;
import map.Strand;
import map.Sumpf;
import map.Wald;
import map.Wiese;
import players.Enemy;
import players.Kreatur;
import players.Player;

public class GameControl {

	private Player player;
	private Enemy enemy;
	
	private Meer meer;
	private Savanne savanne;
	private Sumpf sumpf;
	private Wiese wiese;
	
	private Gebirge gebirge;
	private Strand strand;
	private Wald wald;
	
	private Fisch fisch;
	private Fleisch fleisch;
	private Fruechte fruechte;
	private Getreide getreide;
	
	private AI ai;
	private Direction dirAI;
	
	private boolean fight = false;
	
	public GameControl(AI ai, Player player, Enemy enemy, Meer meer, Savanne savanne, Sumpf sumpf, Wiese wiese, Gebirge gebirge, Strand strand, Wald wald, Fisch fisch, Fleisch fleisch, Fruechte fruechte, Getreide getreide) {
		this.ai = ai;
		this.player = player;
		this.enemy = enemy;
		
		this.meer = meer;
		this.savanne = savanne;
		this.sumpf = sumpf;
		this.wiese = wiese;
		
		this.gebirge = gebirge;
		this.strand = strand;
		this.wald = wald;
		
		this.fisch = fisch;
		this.fleisch = fleisch;
		this.fruechte = fruechte;
		this.getreide = getreide;
	}

	public void getFromHabitat(Habitat h, Kreatur k) {
		int n = 0;
		float d = 0f;
		
		switch (h) {
		case MEER:
			n = meer.habitatLP(k.getSpecies());
			d = meer.getBewegung(k.getSpecies());
			break;
		case SAVANNE:
			n = savanne.habitatLP(k.getSpecies());
			d = savanne.getBewegung(k.getSpecies());
			break;
		case SUMPF:
			n = sumpf.habitatLP(k.getSpecies());
			d = sumpf.getBewegung(k.getSpecies());
			break;
		case WIESE:
			n = wiese.habitatLP(k.getSpecies());
			d = wiese.getBewegung(k.getSpecies());
			break;
		case GEBIRGE:
			n = gebirge.habitatLP(k.getSpecies());
			d = gebirge.getBewegung(k.getSpecies());
			break;
		case STRAND:
			n = strand.habitatLP(k.getSpecies());
			d = strand.getBewegung(k.getSpecies());
			break;
		case WALD:
			n = wald.habitatLP(k.getSpecies());
			d = wald.getBewegung(k.getSpecies());
			break;
		case FISCH:
			n = fisch.habitatLP(k.getSpecies());
			d = fisch.getBewegung(k.getSpecies());
			break;
		case FLEISCH:
			n = fleisch.habitatLP(k.getSpecies());
			d = fleisch.getBewegung(k.getSpecies());
			break;
		case FRUECHTE:
			n = fruechte.habitatLP(k.getSpecies());
			d = fruechte.getBewegung(k.getSpecies());
			break;
		case GETREIDE:
			n = getreide.habitatLP(k.getSpecies());
			d = getreide.getBewegung(k.getSpecies());
			break;
		default:
			break;
		}
		//k.setNahrung(n);
		k.setLebenspunkte(n);
		k.setStepsCount(d);
	}
	
	public void fightCheck() {
		if ((player.getPosX() == enemy.getPosX()) && (player.getPosY() == enemy.getPosY())) {
			System.out.println("fight");
			setFight(true);
			
		} else {
			//setFight(false);
		}
	}
	
	public void gameControl() {
		
		while (enemy.getStepsCount() > 0.0) {
			dirAI = ai.randomMove(enemy.getPosX(), enemy.getPosY(), enemy.getSpecies());
			
			switch (dirAI) {
			case NORTH:
				getFromHabitat(enemy.move(0, -20), enemy);
				fightCheck();
				break;
			case EAST:
				getFromHabitat(enemy.move(20, 0), enemy);
				fightCheck();
				break;
			case SOUTH:
				getFromHabitat(enemy.move(0, 20), enemy);
				fightCheck();
				break;
			case WEST:
				getFromHabitat(enemy.move(-20, 0), enemy);
				fightCheck();
				break;
			default:
				getFromHabitat(enemy.move(0, 0), enemy);
				fightCheck();
				break;
			}
			
		}
		enemy.setSteps(3);
		//System.out.println("Update:" + enemy.getSpecies() + " " + enemy.getStepsCount());
		player.setSteps(3);
		//System.out.println("Update:" + player.getSpecies() + " " + player.getStepsCount());
	}
	
	public void movePlayer(int px, int py) {
		getFromHabitat(player.move(px, py), player);
		fightCheck();
		if (player.getStepsCount() < 1) {
			gameControl();
		}
	}

	public boolean isFight() {
		return fight;
	}

	public void setFight(boolean fight) {
		this.fight = fight;
	}
	
}
