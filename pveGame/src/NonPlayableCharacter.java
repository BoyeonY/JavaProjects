
public class NonPlayableCharacter  extends Characters {
	
	public NonPlayableCharacter(int health_point) {
		super(health_point, 0, 0, 0, 0, "Enemy");
		
	}
	@Override
	public int att() {
			
		return (int)(Math.random()*15 +20) ;
	}
	
	@Override
	public int def() {
		
		return (int)(Math.random()*15 +10) ;
	}
}
