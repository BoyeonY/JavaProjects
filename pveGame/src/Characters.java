

public abstract class Characters {
	
	//Properties
	
	private int health_point;
	private int intell;
	private int dex;
	private int strength;
	private double gold;	
	private String ch_name; 
	private Item item;
	
	

	
	public Characters(int health_point, int intell, int dex, int strength, double gold, String ch_name ) {

		this.health_point = health_point;
		this.intell = intell;
		this.dex = dex;
		this.strength = strength;
		this.gold = gold;
		this.ch_name = ch_name;
		
	}
	
	public abstract int att();
	public abstract int def();
	
	//GET AND SET
	public String getCh_name() {
		return ch_name;
	}
	public void setCh_name(String ch_name) {
		this.ch_name = ch_name;
	}
	public int getHealth_point() {
		return health_point;
	}
	public void setDamaged(int damage) {
		this.health_point -= damage;
	}
	public int getIntell() {
		return intell;
	}
	public void setIntell(int intell) {
		this.intell = intell;
	}
	public int getDex() {
		return dex;
	}
	public void setDex(int dex) {
		this.dex = dex;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public double getGold() {
		return gold;
	}
	public void setGold(double gold) {
		this.gold = gold;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public void setHealth_point(int health_point) {
		this.health_point = health_point;
	}
	
		


}
