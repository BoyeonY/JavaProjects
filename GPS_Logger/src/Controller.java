import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.io.BufferedReader;
import java.io.BufferedWriter;
public class Controller {
	
	private String file = "src\\Report.txt";
	private String species;
	private String sex;
	private double weight;
	private double bloodPressure;
	private int numOfSpot;
	private String dentalHealth;
	private Animal animal;
	private String gpsData;
	

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

	public double getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(double bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public int getNumOfSpot() {
		return numOfSpot;
	}

	public void setNumOfSpot(int numOfSpot) {
		this.numOfSpot = numOfSpot;
	}

	public String getDentalHealth() {
		return dentalHealth;
	}

	public void setDentalHealth(String dentalHealth) {
		this.dentalHealth = dentalHealth;
	}
	public void setgpsData(String gpsData) {
		this.gpsData = gpsData;
	}
	
	
	//////////////////////////////////////////////////////////////////////////
	public String ReportData() { 
		String report="";
		ArrayList<String> GPSline = Reading();
		for(String line:GPSline) {
			report+=line+"\n";
		}
		return report;
	}
	private ArrayList<String> Reading() { // Read the file
		
		ArrayList<String> lines=new ArrayList<String>();
		try
		{
			BufferedReader Reader = new BufferedReader(new FileReader(file));
			String sCurrentLine;
			while((sCurrentLine=Reader.readLine())!=null)//while stuff to read
			{
				lines.add(sCurrentLine);
			}
			Reader.close();
		}
		catch(IOException e)
		{
			JOptionPane.showMessageDialog(null,"Failed to read a file");
			System.out.println(e.getMessage());//explain error to user
			e.printStackTrace();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Failed to read a file");
			System.out.println(e.getMessage());//explain error to user
			e.printStackTrace();
		}
		return lines;
	}
	public boolean entry() {
		boolean valid = true;
		
		return valid;
		
		
	}
	private boolean writing(String data) { // writing data to Report.txt
		boolean valid = true;
		BufferedWriter bw = null;
		FileWriter fw = null;
		
		try {
			bw = new BufferedWriter(new FileWriter(file, true));
			bw.write(data);
			bw.newLine();
			bw.flush();
		}catch(IOException e) {
			e.printStackTrace();
			valid = false;
		}finally {			
			try {
				if(bw !=null)
					bw.close();
				if(fw != null)
					fw.close();
			} catch(IOException ex) {
				valid = false;
				ex.printStackTrace();
			}
		}
		return valid;
	}
	public boolean saveAnimal() { 
		boolean isSuccess = true;
		//create Animal
		this.animal = getAnimal();
		//get toString message
		String line = animal.stringdata();
		//save to file
		if(!writing(line)) isSuccess = false;
		//return result
		return isSuccess;
	}
	private Animal getAnimal() { // generate animal from input
		if(this.species.equals("Penguins")) {
			return new Penguins(this.species, this.sex, this.weight, this.bloodPressure, getGPS());
		}else if(this.species.equals("Sea lion")) {
			return new Sealions(this.species, this.sex, this.weight, this.numOfSpot, getGPS());
		}else {
			return new Walrus(this.species, this.sex, this.weight, this.dentalHealth, getGPS());
		}
	}
	private GPS getGPS() { // split gpsdata each line
		String[] gpsSet = gpsData.split("\n");
		ArrayList<String> gps = new ArrayList<String>(); //save splited gps data in to the array
		
		for(String tmp: gpsSet) {
			gps.add(tmp);
		}
		return new GPS(gps);
	}
	
	public void reset() {// reset entry before going to first panel.		
		species="";
		sex="";
		weight=0;
		bloodPressure=0;
		numOfSpot=0;
		dentalHealth="";
		animal=null;
		gpsData="";
	}
}


