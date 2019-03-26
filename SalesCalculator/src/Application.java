import javax.swing.JOptionPane;

import java.util.ArrayList;

public class Application {
		public void start() {
		
			SalesCalculator();
		}
		private void SalesCalculator() {
			
			String Item=null;
			boolean loop=true;
			int num=0;
		
			ArrayList<SalesPerson> salesPeople = new ArrayList<>();
			String begin = JOptionPane.showInputDialog("Enter to start or type 'exit' to quit the program: ");
			String[] itemName = {"ITEM1", "ITEM2", "ITEM3", "ITEM4"};
			
			while (!begin.equalsIgnoreCase("exit")) 
			{
				SalesPerson myPerson = new SalesPerson();
				String name = JOptionPane.showInputDialog("Enter a name of the sales person: ");
				myPerson.setName(name);
				/*each salesperson*/
				// validation test if item is integer value or not
				// each item's sales amount
				// total amount
				// amount of commission
				
				for(int i = 0; i< itemName.length; i++)	{
					do {
						Item = JOptionPane.showInputDialog("Enter the number of "+ itemName[i] +" sold: ");
						if(validate(Item)) 
					 	{
					 		num = Integer.parseInt(Item);
					 		loop = false;
					 	}
					 	else 
					 	{
					 		JOptionPane.showMessageDialog(null,"Please enter a valid integer");
					 		loop = true;
					 	}
					}while(loop);
					
					if(i == 0)
						myPerson.setNumItem1sold(num);
					else if(i ==1 )
						myPerson.setNumItem2sold(num);
					else if(i ==2 )
						myPerson.setNumItem3sold(num);
					else if(i ==3 )
						myPerson.setNumItem4sold(num);
				}
				double weeklyPay = myPerson.getWeekWage();
				JOptionPane.showMessageDialog(null, myPerson.getName()+String.format(", Your weekly wage: $%.2f", weeklyPay));
					// evaluate weekly wage
					// display weekly wage
			salesPeople.add(myPerson);
			begin = JOptionPane.showInputDialog("Enter to process another person or type 'exit' to quit the program: ");
			}
			
			
			// display sales activity report
			double allTotalSales =0.0;
			int allNumItem1 = 0;
			int allNumItem2 = 0;
			int allNumItem3 = 0;
			int allNumItem4 = 0;
			int allNumItemSold = 0;
			
			
			for(SalesPerson p : salesPeople) {
				allTotalSales += p.getTotalSales();
				allNumItem1 += p.getNumItem1sold();
				allNumItem2 += p.getNumItem2sold();
				allNumItem3 += p.getNumItem3sold();
				allNumItem4 += p.getNumItem4sold();
			}
			allNumItemSold = allNumItem1+allNumItem2+allNumItem3+allNumItem4;
			/*average sales*/
			double avrSalesAmount = 0.0;
			if(allNumItemSold!=0) {
				avrSalesAmount=allTotalSales/allNumItemSold;
			}
			
			int[] allNumItems = {allNumItem1,allNumItem2,allNumItem3,allNumItem4};
			/*evaluate most sold item*/
			/*maxValue, maxIndex*/
			int maxValue = allNumItems[0];
			int maxIndex = 0;
			for(int i=0; i<allNumItems.length-1;i++) {
				if(maxValue<=allNumItems[i+1]) {
					maxValue = allNumItems[i+1];
					maxIndex = i+1;
				}		
			}
			String mostSoldItem = "item"+String.valueOf(maxIndex+1);
			/*evaluate best sales man*/
			double topSalesAmount = 0.0;
			String bestSalesPerson = "";
			for(SalesPerson p : salesPeople) {
				if(topSalesAmount<=p.getTotalSales()) {
					topSalesAmount = p.getTotalSales();
					bestSalesPerson = p.getName();
				}
			}
			
			
			// allTotalSales avrSalesAmount mostSoldItem bestSalesPerson
			String result = String.format("1. Sum of all sales : $%.2f \n", allTotalSales)+
			String.format("2. Average value of a sale  : $%.2f \n",avrSalesAmount) +
			String.format("3. The name of the product most sold  : "+mostSoldItem+"\n") +
			String.format("4. The name of the top sales person : "+bestSalesPerson+"\n");
			
			JOptionPane.showMessageDialog(null, result);
		}
		
		private boolean validate(String Item) {
			boolean valid =true;
			int i = 0;
			
			if(Item.length()==0) //set valid to 'false' if empty string
			   valid = false;
			
			while(valid && i<Item.length())//set valid to  'false' if a character is not a digit
			{	  
				if(!Character.isDigit(Item.charAt(i)))//if the character in the array at loc I is not a digit set valid =false
				{
				  valid = false;
				}
				i++;
			}
			return valid;
		}

}
