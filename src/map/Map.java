package map;

public class Map {

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
	
	private int x, y, nr;
	private Habitat habitat;
	
	public Map() {
		
	}
	
	public Map(Meer meer, Savanne savanne, Sumpf sumpf, Wiese wiese, Gebirge gebirge, Strand strand, Wald wald, Fisch fisch, Fleisch fleisch, Fruechte fruechte, Getreide getreide) {
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

	// Array definiert Weltkarte
	private int[][] positionMap = {
			{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
			{10, 12, 11, 11, 11, 11, 11, 22, 10, 10, 10, 22, 11, 11, 10, 10, 11, 11, 11, 11, 11, 11, 10, 10, 10, 10, 11, 11, 12, 12, 10, 10},
			{10, 12, 12, 11, 11, 11, 11, 22, 22, 22, 22, 22, 11, 11, 10, 10, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 12, 12, 12, 10},
			{10, 12, 12, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 10, 10, 11, 11, 11, 13, 13, 11, 11, 11, 11, 11, 11, 11, 12, 12, 10},
			{10, 10, 12, 12, 11, 11, 11, 13, 13, 11, 11, 11, 11, 11, 11, 11, 10, 11, 11, 11, 13, 13, 13, 11, 11, 11, 11, 11, 11, 11, 12, 10},
			{10, 10, 12, 12, 13, 11, 13, 13, 13, 13, 13, 11, 11, 11, 11, 11, 10, 11, 11, 11, 11, 13, 13, 13, 11, 11, 13, 13, 11, 54, 12, 10},
			{10, 10, 12, 11, 13, 13, 13, 13, 13, 13, 13, 11, 11, 11, 11, 10, 10, 11, 11, 11, 11, 11, 13, 13, 13, 13, 13, 13, 11, 11, 12, 10},
			{10, 12, 12, 11, 13, 13, 13, 13, 13, 13, 11, 11, 11, 11, 10, 10, 11, 11, 11, 11, 11, 13, 13, 13, 13, 13, 13, 13, 11, 11, 11, 10},
			{10, 12, 11, 11, 11, 13, 13, 13, 13, 13, 11, 11, 11, 11, 10, 10, 11, 11, 11, 11, 11, 13, 13, 13, 13, 13, 11, 11, 11, 11, 11, 10},
			{10, 12, 11, 11, 11, 13, 13, 13, 13, 11, 11, 11, 11, 11, 12, 10, 10, 10, 11, 11, 11, 13, 13, 13, 13, 13, 13, 13, 11, 11, 11, 10},
			{10, 12, 11, 11, 11, 23, 13, 13, 13, 11, 11, 11, 11, 11, 12, 12, 12, 10, 10, 11, 11, 13, 13, 21, 21, 13, 53, 13, 13, 11, 11, 10},
			{10, 12, 11, 11, 13, 23, 23, 13, 13, 13, 13, 11, 11, 11, 12, 12, 12, 10, 10, 11, 11, 13, 13, 13, 21, 13, 13, 11, 11, 11, 11, 10},
			{10, 12, 11, 11, 11, 13, 52, 13, 13, 13, 13, 11, 11, 11, 11, 12, 12, 10, 12, 11, 11, 13, 13, 13, 13, 13, 13, 11, 11, 11, 11, 10},
			{10, 12, 11, 11, 13, 13, 13, 13, 11, 13, 13, 13, 11, 11, 11, 11, 12, 10, 12, 12, 11, 11, 13, 13, 13, 13, 13, 11, 11, 11, 11, 10},
			{10, 12, 12, 11, 13, 13, 13, 11, 11, 11, 13, 13, 13, 11, 11, 11, 12, 10, 12, 12, 11, 11, 11, 13, 13, 13, 11, 11, 11, 11, 11, 10},
			{10, 12, 12, 12, 13, 13, 11, 11, 11, 11, 11, 13, 13, 13, 11, 11, 11, 10, 10, 12, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 10},
			{10, 12, 12, 12, 13, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 10, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 10, 10},
			{10, 10, 12, 12, 12, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 10, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 10, 10, 10},
			{51, 10, 10, 12, 12, 12, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 10, 10, 10, 11, 11, 11, 11, 11, 11, 11, 11, 11, 10, 10, 10},
			{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}
	};
	
	public Habitat getHabitat(int px, int py) {
		
		y = px / 20;
		x = py / 20;
		nr = positionMap[x][y];
		
		switch (nr) {
		case 10:
			habitat = Habitat.MEER;
			break;
		case 11:
			habitat = Habitat.SAVANNE;
			break;
		case 12:
			habitat = Habitat.SUMPF;
			break;
		case 13:
			habitat = Habitat.WIESE;
			break;
		case 21:
			habitat = Habitat.GEBIRGE;
			break;
		case 22:
			habitat = Habitat.STRAND;
			break;
		case 23:
			habitat = Habitat.WALD;
			break;
		case 51:
			habitat = Habitat.FISCH;
			break;
		case 52:
			habitat = Habitat.FLEISCH;
			break;
		case 53:
			habitat = Habitat.FRUECHTE;
			break;
		case 54:
			habitat = Habitat.GETREIDE;
			break;
		default:
			
			break;
		}
		
		return habitat;
	}
	
	// zeichnet Weltkarte
	public void zeichnen() {
		int y = 0;
		for(int[] i : positionMap){
			int x = 0; 
			for(int a : i){	
				switch(a){
				case 10:
					meer.getBild().draw(x, y, 20, 20);
					break;
				case 11:
					savanne.getBild().draw(x, y, 20, 20);
					break;
				case 12:
					sumpf.getBild().draw(x, y, 20, 20);
					break;
				case 13:
					wiese.getBild().draw(x, y, 20, 20);
					break;
				case 21:
					gebirge.getBild().draw(x, y, 20, 20);
					break;
				case 22:
					strand.getBild().draw(x, y, 20, 20);
					break;
				case 23:
					wald.getBild().draw(x, y, 20, 20);
					break;
				case 51:
					fisch.getBild().draw(x, y, 20, 20);
					break;
				case 52:
					fleisch.getBild().draw(x, y, 20, 20);
					break;
				case 53:
					fruechte.getBild().draw(x, y, 20, 20);
					break;
				case 54:
					getreide.getBild().draw(x, y, 20, 20);
					break;
					
				}
				x += 20;
			}
			y += 20;
		}
	}
	
}
