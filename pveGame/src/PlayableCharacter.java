
public class PlayableCharacter extends Characters {

	private String characterType;
	
	public PlayableCharacter(int health_point, int intell, int dex, int strength, double gold, String ch_name, String characterType) {
		super(health_point, intell, dex, strength, gold, ch_name);
		this.characterType = characterType;
	}
	
	@Override
	public int att() {
		int attackPoint = 0;
		if(this.characterType.equals("Knight")) {
			attackPoint = super.getDex();
		}else if(this.characterType.equals("Monster")) {
			attackPoint =  super.getStrength();
		}else {
			attackPoint =  super.getIntell();
		}
		attackPoint += super.getItem().getAtk(); 
		
		return attackPoint;
	}
	
	@Override
	public int def() {
		return (int)(Math.random()*15 +10) + super.getItem().getDef();
	}
	

}
