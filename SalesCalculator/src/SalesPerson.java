// salesperson class

public class SalesPerson {
	private String name = null;
	private int numItem1sold = 0;
	private int numItem2sold = 0;
	private int numItem3sold = 0;
	private int numItem4sold = 0;
	
	private double totalSales = 0.0;
	private double weekWage = 0.0;
	
	private final double rate =0.09;
	private final double base = 200.0;
	
	private final double valItem1 = 239.99;
	private final double valItem2 = 129.55;
	private final double valItem3 = 99.95;
	private final double valItem4 = 350.89;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getTotalSales() {
		totalSales = numItem1sold*valItem1 + numItem2sold*valItem2 + numItem3sold*valItem3 + numItem4sold*valItem4;
		return totalSales;
	}
	public double getWeekWage() {
		weekWage = getTotalSales() * rate + base;
		return weekWage;
	}
	public void setNumItem1sold(int numItem1sold) {
		this.numItem1sold = numItem1sold;
	}
	public void setNumItem2sold(int numItem2sold) {
		this.numItem2sold = numItem2sold;
	}
	public void setNumItem3sold(int numItem3sold) {
		this.numItem3sold = numItem3sold;
	}
	public void setNumItem4sold(int numItem4sold) {
		this.numItem4sold = numItem4sold;
	}
	public int getNumItem1sold() {
		return numItem1sold;
	}
	public int getNumItem2sold() {
		return numItem2sold;
	}
	public int getNumItem3sold() {
		return numItem3sold;
	}
	public int getNumItem4sold() {
		return numItem4sold;
	}
	
	
}
