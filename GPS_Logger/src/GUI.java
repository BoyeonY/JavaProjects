import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JScrollPane;
import java.awt.Font;


public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField_weight;
	private JTextField textField_GPS;
	private JTextField textField;
	private JLabel label_change;
	private JComboBox comboBox_speices;
	private JComboBox comboBox_dental;
	private JComboBox comboBox_sex;
	private JButton btnNewButton_generate;
	private JButton btnAdd;
	private JButton btnNewButton_save;
	private JTextArea textArea_report;
	private JButton btnHome;
	private JPanel panel_1;
	private JTextArea text_fReport;
	
	Controller control;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
 {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Controller con = new Controller();
					GUI frame = new GUI();
					frame.setControl(con);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "name_243171928397545");
		panel.setLayout(null);
		
		JLabel label_animal = new JLabel("Choose animal");
		label_animal.setBounds(14, 24, 74, 22);
		panel.add(label_animal);
		
		comboBox_speices = new JComboBox();
		comboBox_speices.setModel(new DefaultComboBoxModel(new String[] {"<Select>", "Penguins", "Sea lions", "Walrus"}));
		comboBox_speices.setBounds(98, 25, 92, 21);
		panel.add(comboBox_speices);

		comboBox_sex = new JComboBox();
		comboBox_sex.setModel(new DefaultComboBoxModel(new String[] {"<Select>", "Female", "Male"}));
		comboBox_sex.setBounds(98, 56, 92, 22);
		panel.add(comboBox_sex);
		
		
		JLabel lblSex = new JLabel("Sex");
		lblSex.setBounds(24, 61, 45, 13);
		panel.add(lblSex);
		
		JLabel labael_weight = new JLabel("Weight");
		labael_weight.setBounds(24, 101, 45, 13);
		panel.add(labael_weight);
		
		textField_weight = new JTextField();
		textField_weight.setBounds(97, 98, 93, 19);
		panel.add(textField_weight);
		textField_weight.setColumns(10);
		
		textField_GPS = new JTextField();
		textField_GPS.setBounds(227, 188, 189, 22);
		panel.add(textField_GPS);
		textField_GPS.setColumns(10);
		
		btnAdd = new JButton("Add");
		
		btnAdd.setBounds(288, 220, 85, 21);
		panel.add(btnAdd);
		
		textArea_report = new JTextArea();
		textArea_report.setBounds(227, 42, 189, 140);
		panel.add(textArea_report);
		
		JLabel lblNewLabel_2 = new JLabel("GPS coordinates");
		lblNewLabel_2.setBounds(230, 10, 160, 22);
		panel.add(lblNewLabel_2);
		
		btnNewButton_save = new JButton("Save Entry");
		
		btnNewButton_save.setBounds(10, 220, 85, 21);
		panel.add(btnNewButton_save);
		
		btnNewButton_generate = new JButton("Generate Report");
	
		btnNewButton_generate.setBounds(105, 220, 107, 21);
		panel.add(btnNewButton_generate);
		
		label_change = new JLabel("");
		label_change.setBounds(10, 127, 78, 22);
		panel.add(label_change);
		
		textField = new JTextField();
		textField.setBounds(96, 127, 94, 22);
		panel.add(textField);
		textField.setColumns(10);
		textField.setVisible(false);
		
		
		comboBox_dental = new JComboBox();
		comboBox_dental.setModel(new DefaultComboBoxModel(new String[] {"<Select>", "Good", "Average", "Poor"}));
		comboBox_dental.setBounds(98, 127, 92, 21);
		panel.add(comboBox_dental);
		
		JLabel label_error = new JLabel("");
		label_error.setBounds(81, 169, 45, 13);
		panel.add(label_error);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, "name_785954432013934");
		panel_1.setLayout(null);
		
		text_fReport = new JTextArea();
		text_fReport.setBounds(72, 32, 283, 163);
		//panel_1.add(text_fReport);
		text_fReport.setColumns(10);
		JScrollPane scrollPane = new JScrollPane(text_fReport);
		scrollPane.setBounds(72, 41, 279, 163);
		panel_1.add(scrollPane);
		
		
		
		btnHome = new JButton("HOME");
	
		btnHome.setBounds(168, 220, 85, 21);
		panel_1.add(btnHome);
		
		JLabel lblReport = new JLabel("Report");
		lblReport.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblReport.setBounds(21, 10, 85, 21);
		panel_1.add(lblReport);
		comboBox_dental.setVisible(false);
		
		
		//////////////////action/////////////////////////////////////////////
		
		comboBox_speices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changeSpecies();
			}
		});
		
		// save button
		btnNewButton_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				savingcheck();
		
			}
		});
		
		// generate report button
		btnNewButton_generate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				report();
				panel.setVisible(false);
				panel_1.setVisible(true);
				
			}
		});
		
		// gps add button
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//validation GPS
				gpsInput();
				//save at array
				//set GPS in the textArea_report
				
			}
		});
		
		// home button ( go to first page)
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
				panel_1.setVisible(false);
				panel.setVisible(true);
			}
		});
	}
		
	public void setControl(Controller control) {
		this.control = control;
	}

	// To change a display on the panel from textfield(penuins, sealions) to combo box (walrus)
	public void changeSpecies() {
		if (comboBox_speices.getSelectedIndex() == 1) 
		{
		control.setSpecies("Penguins");
		textField.setVisible(true);
		comboBox_dental.setVisible(false);
		label_change.setText("Blood pressure");
		
		}
	else if(comboBox_speices.getSelectedIndex() == 2) 
		{
		control.setSpecies("Sea lion");
		textField.setVisible(true);
		comboBox_dental.setVisible(false);
		label_change.setText("Number of spots");
		}
	else {
		control.setSpecies("Walrus");
		textField.setVisible(false);
		comboBox_dental.setVisible(true);
		label_change.setText("Dental health");
		}
		
	}
	//save sexInput to the controller
	public void changeSex() {
		if (comboBox_sex.getSelectedIndex() == 1)
			control.setSex("Female");
		else control.setSex("Male");
	}


	// Validaton (weight,blood pressure, number of spots)
	private boolean validate(String weight,String bloodorSpots,String dentalInfo) {
		boolean valid =true;
		if(comboBox_speices.getSelectedIndex()==0) {
			valid = false;
			//message
			JOptionPane.showMessageDialog(this,"Please select a animal");
			return valid;
		}
		if(weight.length()>0 ) {//if input is empty or not
			if(comboBox_speices.getSelectedIndex() == 1 && bloodorSpots.length()>0) { //penguins
				if(weight.matches("^[+]?\\d+(\\.\\d+)?$")&&bloodorSpots.matches("^[+]?\\d+(\\.\\d+)?$")) //weight: double or int// blood: double or int 
					valid =true;
				else 
					valid = false;
			}
			else if(comboBox_speices.getSelectedIndex() == 2 && bloodorSpots.length()>0) {///sealion
				 //set valid to 'false' if empty string
				if((weight.matches("^[+]?\\d+(\\.\\d+)?$")&&bloodorSpots.matches("^[+]?[1-9]\\d*$"))) //number of spots: only int
					 valid = true;
				else
					valid =false;
			}else if(comboBox_speices.getSelectedIndex() == 3){
				if(comboBox_dental.getSelectedIndex()==0) valid = false;
			}
		}else valid = false;			
	
	return valid;

	}
	
	public boolean weightInput() {
		
		String inWeight = textField_weight.getText(); // weight input
		String inbloodorSpots = textField.getText(); // blood pressure or number of spots input
		String inDentalInfo = (String)comboBox_dental.getSelectedItem(); // dental health selected
		if(validate(inWeight,inbloodorSpots,inDentalInfo))	{ // if validate is true
	 		control.setWeight(Double.valueOf(inWeight)); // save input to controller class
	 		if(comboBox_speices.getSelectedIndex()==1)  // if it is a penguin
	 			control.setBloodPressure((Double.valueOf(inbloodorSpots))); 
	 		else if(comboBox_speices.getSelectedIndex()==2)// if it is a sea lion
	 			control.setNumOfSpot((Integer.valueOf(inbloodorSpots)));	
	 		else
	 			control.setDentalHealth(inDentalInfo); // if it is a walrus
	 		return true;
	 	}
	 	else {
	 		JOptionPane.showMessageDialog(null,"Please enter valid numbers"); // if input is not valid 
	 		return false;
	 	}
	}
	
	//GPS validation 
	public boolean validateGPS(String gps) {
		String regex ="^(\\-?\\d+(\\.\\d{7})?),\\s*(\\-?\\d+(\\.\\d{7})?)$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(gps);
		if(m.find())
			return true;
		else 
			return false;
	}

	public boolean gpsInput() {
		String gps = textField_GPS.getText();
		if(validateGPS(gps)) { // gps validation
			String gps_data = gps+"\n"; 
			this.textArea_report.append(gps_data); // diplay gps at the screen
			return true;
		}else { 
			JOptionPane.showMessageDialog(null,"Not valid GPS entry"+"\n"+"Entry format: ddd.ddddddd,ddd.ddddddd");// if it is not valid
			return false;
		}
	}
		
	public void savingcheck() { // when user click a save button, check before saving
		
		if (weightInput()) { // 1. weight validation
			changeSex(); // save selected sex and species to the controller class 
			changeSpecies();
			control.setgpsData(textArea_report.getText()); //save gps data from screen to controller class
			//call save to file method
			if(control.saveAnimal()) {//success
				//reset
				reset();//GUI fields reset
				control.reset();//Controller fields reset
				//message
				JOptionPane.showMessageDialog(this,"Record saved");
			}else {//fail
				//message
				JOptionPane.showMessageDialog(null,"Failed to save");
			}	
		}

	}
	public void reset() { // after saving the entry, reset input boxes to get new entry
		textField_GPS.setText("");
		textArea_report.setText("");
		textField.setText("");
		textField_weight.setText("");
	}
	
	public void report() { // generate report 
		String A_report = control.ReportData();
		System.out.print(A_report);
		text_fReport.setText(A_report);
	}
}
