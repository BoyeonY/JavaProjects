
public abstract class Animal {

	private String species;
	private String sex;
	private double weight;
	private GPS gps;
	//Constructor
	public Animal(String species, String sex, double weight, GPS gps) {
		this.species = species;
		this.sex = sex;
		this.weight = weight;
		this.gps =gps;
	}
	
	// getting  and setting
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}

	public GPS getGps() {
		return gps;
	}

	public void setGps(GPS gps) {
		this.gps = gps;
	}
	// abstract method
	public abstract String stringdata();
}
