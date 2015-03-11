package managegui;

import fight.Fight;
import game.AI;
import game.Direction;
import game.GameControl;
import map.Fleisch;
import map.Fruechte;
import map.Gebirge;
import map.Getreide;
import map.Map;
import map.Meer;
import map.Fisch;
import map.Savanne;
import map.Strand;
import map.Sumpf;
import map.Wald;
import map.Wiese;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import players.Enemy;
import players.Player;
import players.Species;

public class GuiControl extends BasicGame {

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
	
	private Map map;
	
	private Player player;
	private Enemy enemy;
	
	private GameControl gamecontrol;
	private AI ai;
	
	private Fight fight;
	
	public GuiControl(String title) {
		super(title);
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		//map.zeichnen();
		
		if (!gamecontrol.isFight()) {
			map.zeichnen();
		} else {
			//map.zeichnenFight();
			fight.zeichnenFight();
		}
		
		player.render(g);
		enemy.render(g);
		
		g.drawString("Lebenspunkte", 50, 420);
		g.drawString(Integer.toString(player.getLebenspunkte()), 180, 420);
		
		g.drawString("Züge", 50, 460);
		g.drawString(Float.toString(player.getStepsCount()), 180, 460);
		
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		meer = new Meer();
		savanne = new Savanne();
		sumpf = new Sumpf();
		wiese = new Wiese();
		
		gebirge = new Gebirge();
		strand = new Strand();
		wald = new Wald();
		
		fisch = new Fisch();
		fleisch = new Fleisch();
		fruechte = new Fruechte();
		getreide = new Getreide();
		ai = new AI();
		fight = new Fight();
		
		map = new Map(meer, savanne, sumpf, wiese, gebirge, strand, wald, fisch, fleisch, fruechte, getreide);
		player = new Player(0, 0, 3, true, 40, 20, 20, 20, 20, Species.LITUS);
		enemy = new Enemy(0, 300, 3, true, 40, 20, 20, 20, 20, Species.AQUA ,Direction.EAST);
		player.init(container);
		enemy.init(container);
		gamecontrol = new GameControl(ai, player, enemy, meer, savanne, sumpf, wiese, gebirge, strand, wald, fisch, fleisch, fruechte, getreide);
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		
		
		if (!gamecontrol.isFight()) {
		
			Input input = container.getInput();
			if (input.isKeyPressed(Input.KEY_UP)) {
				player.setSprite(Direction.NORTH);
				if (ai.moveTry(player.getPosX(), player.getPosY() - 20, player.getSpecies())) {
					gamecontrol.movePlayer(0, -20);
				}
			} else if (input.isKeyPressed(Input.KEY_DOWN)) {
				player.setSprite(Direction.SOUTH);
				if (ai.moveTry(player.getPosX(), player.getPosY() + 20, player.getSpecies())) {
					gamecontrol.movePlayer(0, 20);
				}
			} else if (input.isKeyPressed(Input.KEY_LEFT)) {
				player.setSprite(Direction.WEST);
				if (ai.moveTry(player.getPosX() - 20, player.getPosY(), player.getSpecies())) {
					gamecontrol.movePlayer(-20, 0);
				}
			} else if (input.isKeyPressed(Input.KEY_RIGHT)) {
				player.setSprite(Direction.EAST);
				if (ai.moveTry(player.getPosX() + 20, player.getPosY(), player.getSpecies())) {
					gamecontrol.movePlayer(20, 0);
				}
			}
		
		}
		
	}
	
}
