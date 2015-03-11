package fight;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Fight {

	private Image wasser;
	private Image savanne;
	private Image seaF;
	
	public Fight() {
		try {
			this.wasser = new Image("data/Wasser.png");
			this.savanne = new Image("data/Savanne.png");
			this.seaF = new Image("data/SeaF.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	private int[][] fightMap = {
			{0, 0, 0, 0, 0, 0},
			{1, 1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1, 1}
	};
	
	public void test() {
		
	}
	
	public void zeichnenFight() {
		int y = 0;
		for(int[] i : fightMap){
			int x = 0; 
			for(int a : i){	
				switch(a){
				case 0:
					wasser.draw(x, y, 40, 40);
					break;
				case 1:
					savanne.draw(x, y, 40, 40);
					break;
				
				}
				x += 40;
			}
			y += 40;
		}
	}
	
}
