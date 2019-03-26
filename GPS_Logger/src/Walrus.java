
public class Walrus extends Animal {

	private String dentalHealth;
	public Walrus(String species, String sex, double weight, String dentalHealth,GPS gps) {
		super(species, sex, weight,gps);
		this.dentalHealth =  dentalHealth;

	}

	public String getDentalHealth() {
		return dentalHealth;
	}
	public void setDentalHealth(String dentalHealth) {
		this.dentalHealth = dentalHealth;
	}

	
	@Override
	public String stringdata() {
		return "Species: "+getSpecies()+" Sex: "+getSex()+" Weight: "+getWeight()+" Dental Health: "+getDentalHealth()+"\n"
				+ "GPS:\n"+ getGps().getGpsList();
	}
}
