import javax.swing.JOptionPane;

public class Application {
	private boolean[][] seatTable = new boolean[4][4]; //default initialization -> false
	
	public void start() {
		airlineBooker();
	}
	private void airlineBooker() {
		String name = null;
		String classType = null;
		String seatType = null;
		
		//get user choice( book or quit) from main dialog
		//loop booking until user want to quit
		while(mainDialog()==0) {
			// is there any available seat? in any class in any seat type?
			boolean isFull = true;
			
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					if(isFull&&!seatTable[i][j]) {
						isFull=false;
					}
				}
			}
			
			if(isFull) {
				JOptionPane.showMessageDialog(null, "Sorry, there is no available seat, Next flight leaves in 3 hours");
				continue;
			}
			
			
			
			BoardingPass ticket = new BoardingPass();
			// get passenger's name from user
			name=getName();
			// get preferred class from user
			classType=getClassType();
			if(classType.equals("Cancled")) {
				JOptionPane.showMessageDialog(null, "Sorry, there is no available seat, Next flight leaves in 3 hours");
				continue;
			}
			// get preferred seat type from user
			seatType=getSeatType(classType);
			
			if(seatType.equals("Cancled")) {
				JOptionPane.showMessageDialog(null, "Sorry, there is no available seat, Next flight leaves in 3 hours");
				continue;
			}
			// initiate BoardingPass object
			ticket.setPassenger(name);
			ticket.setClassType(classType);
			ticket.setSeatType(seatType);
			// book seat !!
			bookSeat(ticket);
			// print Boarding Pass
			printBoardingPass(ticket);
		}
	}
	
	private int mainDialog() {
		int userChoice = 0;
		Object[] options = {"Book Your seat", "Quit Program"};
		
		//draw table
		String strTable = buildHTMLTable();
		
		//display table
		userChoice=JOptionPane.showOptionDialog(null,
				strTable,"Airline SeatBooker", JOptionPane.YES_NO_OPTION, 
				JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		//set dialog
		
		return userChoice;
	}
	private String buildHTMLTable() {
		String rows = "ABCD";
		String cols = "1234";
		
		String strTable = "<html><head><style>"
				+ "table, td {border: 1px solid black;	}"
				+ "td{width: 60px;height: 60px;	text-align: center;	background-color: #f1f133;}"
				+ "	td.aisle{width: 40px;background-color: #f1f1f1;	}"
				+ "td.booked{background-color: #f12222;	}</style></head>"
				+ "<body><table>";
		for(int i=0; i<4; i++) {
			strTable += "<tr>";
			for(int j=0; j<2; j++) {
				if(seatTable[i][j]) {
					strTable+="<td class=\"booked\">"+rows.charAt(i)+cols.charAt(j) +"</td>";
				}else {
					strTable+="<td>"+rows.charAt(i)+cols.charAt(j) +"</td>";
				}
			}
			//aisle td
			strTable += "<td class=\"aisle\"></td>";
			for(int j=2; j<4; j++) {
				if(seatTable[i][j]) {
					strTable+="<td class=\"booked\">"+rows.charAt(i)+cols.charAt(j) +"</td>";
				}else {
					strTable+="<td>"+rows.charAt(i)+cols.charAt(j) +"</td>";
				}
			}
			strTable += "</tr>";
		}
		strTable += "</table></body></html>";
		return strTable;
	}
	private String getName() {
		String inName = null;
		boolean loop =true;
		// get name from user
		// validation check
		do {
			inName = JOptionPane.showInputDialog("Please enter passenger name.");
			if(validate(inName))
			{
				loop = false;
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Please enter only letters");
		 		loop = true;	
			}
		}while(loop);
		
		return inName;
	}
	private boolean validate(String nametest) {
		String validChars = "abcdefghijklmnopqrstuvwxyz ";	
		char testChar;
		if(nametest.length()==0)
			return false;
		
		nametest = nametest.toLowerCase();
		for(int i = 0 ; i <nametest.length(); i++)
		{
			testChar = nametest.charAt(i);
			if(validChars.indexOf(testChar) <0)
				return false;
		}
		return true;
	}
	private String getClassType() {
		String inClassType = null;
		int userInput = 0;
		Object[] classOptions = {"First Class","Economic Class"};
		Object[] yesnoOptions = {"Yes","No"};
		boolean isFull = true;
		// get preferred class from user
		userInput = JOptionPane.showOptionDialog(null,"Please select your prefered class","Airline SeatBooker", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,classOptions , classOptions[0]);
		
		// check available seat
		if(userInput == JOptionPane.YES_OPTION) {
			//first class
			for(int i= 0; i<2; i++) {
				for(int j=0 ; j<4; j++) {
					if(isFull&&!seatTable[i][j]) {
						isFull = false;
					}
				}
			}
			if(isFull) {
				//there is no seat
				JOptionPane.showMessageDialog(null,"Sorry, there is no available seat, Next flight leaves in 3 hours");
			}
		}else {
			//economy class
			for(int i= 2; i<4; i++) {
				for(int j=0 ; j<4; j++) {
					if(isFull&&!seatTable[i][j]) {
						isFull = false;
					}
				}
			}
			if(isFull) {
				//there is no seat
				JOptionPane.showMessageDialog(null,"Sorry, there is no available seat, Next flight leaves in 3 hours");
			}
		}
		if(isFull) {
			//ask user change class
			int input = JOptionPane.showOptionDialog(null,"Would you like to change the class type?","Airline SeatBooker", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,yesnoOptions , yesnoOptions[0]);
			if(input == JOptionPane.YES_OPTION) {
				if(userInput == JOptionPane.YES_OPTION)
					userInput = JOptionPane.NO_OPTION;
				else
					userInput = JOptionPane.YES_OPTION;
			}else {
				userInput = -1; //cancel
			}
		}
		
		if(userInput == JOptionPane.YES_OPTION) {
			inClassType="FirstClass";
		}else if(userInput == JOptionPane.NO_OPTION) {
			inClassType="EconomyClass";
		}else {
			inClassType="Cancled";
		}
		return inClassType;
	}
	
	private String getSeatType(String classType) {
		// get preferred seat type from user
		String inSeatType = null;
		int userInput = 0;
		Object[] seatOptions = {"Window side","Aisle side"};
		Object[] yesnoOptions = {"Yes","No"};
		boolean isFull = true;
		// get preferred class from user
		userInput = JOptionPane.showOptionDialog(null,"Please select your prefered seat type","Airline SeatBooker", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, seatOptions , seatOptions[0]);
		
		// check available seat
		if(userInput == JOptionPane.YES_OPTION) { 
			//window side 0 3
			if(classType.equals("FirstClass")) {
				for(int i= 0; i<2; i++) {
					for(int j=0 ; j<4; j++) {
						if(j==0 || j==3) {
							if(isFull&&!seatTable[i][j]) {
								isFull = false;
							}
						}
					}
				}
			}else {
				for(int i= 2; i<4; i++) {
					for(int j=0 ; j<4; j++) {
						if(j==0 || j==3) {
							if(isFull&&!seatTable[i][j]) {
								isFull = false;
							}
						}
					}
				}
			}
			
			if(isFull) {
				//there is no seat
				JOptionPane.showMessageDialog(null,"Sorry, there is no available seat, Next flight leaves in 3 hours");
			}
		}else {
			//aisle side 1 2
			if(classType.equals("FirstClass")) {
				for(int i= 0; i<2; i++) {
					for(int j=0 ; j<4; j++) {
						if(j==1 || j==2) {
							if(isFull&&!seatTable[i][j]) {
								isFull = false;
							}
						}
					}
				}
			}else {
				for(int i= 2; i<4; i++) {
					for(int j=0 ; j<4; j++) {
						if(j==1 || j==2) {
							if(isFull&&!seatTable[i][j]) {
								isFull = false;
							}
						}
					}
				}
			}
			
			if(isFull) {
				//there is no seat
				JOptionPane.showMessageDialog(null,"Sorry, there is no available seat, Next flight leaves in 3 hours");
			}
		}
		if(isFull) {
			//ask user change class
			int input = JOptionPane.showOptionDialog(null,"Would you like to change the seat type?","Airline SeatBooker", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,yesnoOptions , yesnoOptions[0]);
			if(input == JOptionPane.YES_OPTION) { //change!!
				if(userInput == JOptionPane.YES_OPTION)
					userInput = JOptionPane.NO_OPTION;
				else
					userInput = JOptionPane.YES_OPTION;
			}else { //not change
				userInput = -1; //cancel
			}
		}
		
		if(userInput == JOptionPane.YES_OPTION) {
			inSeatType="WindowSide";
		}else if(userInput == JOptionPane.NO_OPTION) {
			inSeatType="AisleSide";
		}else {
			inSeatType="Cancled";
		}
		
		
		return inSeatType;
	}
	
	private void bookSeat(BoardingPass ticket) {
		//FirstClass EconomyClass 
		//WindowSide AisleSide
		int row = 0;
		int col = 0;
		boolean isBooked = false;
		//read class type and seat type from ticket
		if(ticket.getClassType().equals("FirstClass") && ticket.getSeatType().equals("WindowSide")) {
			for(int i =0; i<2; i++) {
				for(int j=0; j<4; j++) {
					if(j==0 || j==3) {
						if(!isBooked && !seatTable[i][j]) {
							row = i;
							col = j;
							isBooked = true;
						}
					}
				}
			}
		}else if(ticket.getClassType().equals("FirstClass") && ticket.getSeatType().equals("AisleSide")) {
			for(int i =0; i<2; i++) {
				for(int j=0; j<4; j++) {
					if(j==1 || j==2) {
						if(!isBooked && !seatTable[i][j]) {
							row = i;
							col = j;
							isBooked = true;
						}
					}
				}
			}
		}else if(ticket.getClassType().equals("EconomyClass") && ticket.getSeatType().equals("WindowSide")) {
			for(int i =2; i<4; i++) {
				for(int j=0; j<4; j++) {
					if(j==0 || j==3) {
						if(!isBooked && !seatTable[i][j]) {
							row = i;
							col = j;
							isBooked = true;
						}
					}
				}
			}
		}else {
			for(int i =2; i<4; i++) {
				for(int j=0; j<4; j++) {
					if(j==1 || j==2) {
						if(!isBooked && !seatTable[i][j]) {
							row = i;
							col = j;
							isBooked = true;
						}
					}
				}
			}
		}
		
		// update seat table array
		seatTable[row][col] = true;
		
		// make seat name (ex A1, D1)
		String rows = "ABCD";
		String cols = "1234";
		
		String seatNum = ""+rows.charAt(row)+cols.charAt(col);
		ticket.setSeatNumber(seatNum);
	}
	private void printBoardingPass(BoardingPass ticket) {
		// display passenger's name and seat number
		String strTicket = "name : "+ticket.getPassenger() +"\n"
				+ "seat number: "+ ticket.getSeatNumber();
		JOptionPane.showMessageDialog(null,strTicket);
	}
}

