import java.util.ArrayList;

public class GPS {
	private ArrayList<String> gpsList;
	
	public GPS(ArrayList<String> gpsList) {
		this.gpsList = gpsList;
	}
	public String getGpsList() { 
		String gpsList="";
		for(String tmp: this.gpsList) {
			gpsList += tmp+"\n";
		}
		return gpsList;
	}

}
