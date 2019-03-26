
public class Penguins extends Animal {
	
	private double bloodPressure;
	public Penguins(String species, String sex, double weight, double bloodPressure,GPS gps) {
		super(species, sex, weight,gps);
		this.bloodPressure = bloodPressure;
	
	}

	public double getBloodPressure() {
		return bloodPressure;
	}
	public void setBloodPressure(double bloodPressure) {
		this.bloodPressure = bloodPressure;
	}


	@Override
	public String stringdata() {
		return "Species: "+getSpecies()+" Sex: "+getSex()+" Weight: "+getWeight()+" Blood Pressure: "+getBloodPressure()+"\n"
				+ "GPS:\n"+ getGps().getGpsList();
	}
}
