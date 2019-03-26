
public class Sealions extends Animal {

	private int numOfSpots;

	public Sealions(String species, String sex, double weight,int numOfSpots,GPS gps) {
		super(species, sex, weight,gps);
		this.numOfSpots = numOfSpots;
	}
	
	public int getNumOfSpots() {
		return numOfSpots;
	}
	public void setNumOfSpots(int numOfSpots) {
		this.numOfSpots = numOfSpots;
	}

	@Override
	public String stringdata() {
		return "Species: "+getSpecies()+" Sex: "+getSex()+" Weight: "+getWeight()+" Number of Spots: "+getNumOfSpots()+"\n"
				+ "GPS:\n"+ getGps().getGpsList();
	}
}
