import java.awt.BorderLayout;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Cursor;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import javax.swing.UIManager;


import java.io.FileReader;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
public class GamePages extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField_name;
	private JTextField textField_stren;
	private JTextField textField_intell;
	private JTextField textField_dex;
	private JLabel lblNewLabel_validation;
	private JLabel lbl_CH_Images;
	private User_setting user = new User_setting();
	private JTextArea taBattleReport;
	private JTextArea lbl_CH_desc;
	private JLabel label_gold;
	private Battle myBattle;
	private String[][] itemList;
	private JLabel lblUserHp;
	private JLabel lblEnemyHp;
	private JLabel label_Setdefault_userImg;
	private JLabel label_noGold;
	
	private Timer timer;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Battle battle = new Battle();
					GamePages frame = new GamePages();
					frame.setMyBattle(battle);
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
	public GamePages() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		// Main page
		JPanel panel_1st = new JPanel();
		contentPane.add(panel_1st, "name_259779542511836");
		panel_1st.setLayout(null);
			//Main page- start button
		JButton START_Button = new JButton("");
	
		START_Button.setIcon(new ImageIcon(GamePages.class.getResource("/images/play.png")));
		START_Button.setBounds(153, 271, 125, 30);
		panel_1st.add(START_Button);
			//Main page- exit button
		JButton EXIT_Button = new JButton("");
		EXIT_Button.setIcon(new ImageIcon(GamePages.class.getResource("/images/exit.png")));
		EXIT_Button.setBounds(442, 271, 125, 30);
		panel_1st.add(EXIT_Button);
		EXIT_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		JLabel lblName = new JLabel("name:");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(212, 227, 54, 30);
		panel_1st.add(lblName);
		//Main page - user inputs name
		textField_name = new JTextField();
		textField_name.setBounds(265, 226, 185, 35);
		panel_1st.add(textField_name);
		textField_name.setColumns(10);
		lblNewLabel_validation = new JLabel("");
		lblNewLabel_validation.setForeground(Color.RED);
		lblNewLabel_validation.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_validation.setBounds(276, 175, 220, 41);
		panel_1st.add(lblNewLabel_validation);
		//Main page - background image
		JLabel lblNewLabel_BG = new JLabel("");
		lblNewLabel_BG.setIcon(new ImageIcon(GamePages.class.getResource("/images/background.png")));
		lblNewLabel_BG.setBounds(0, 10, 680, 350);
		panel_1st.add(lblNewLabel_BG);
		// //Characters page
		JPanel panel_CH = new JPanel();
		contentPane.add(panel_CH, "name_259779568880647");
		panel_CH.setLayout(null);
		// characters radio buttons -monster
		JRadioButton rdbtn_Monster = new JRadioButton("Monster");
		rdbtn_Monster.setSelected(true); // set monster as a default 
		
		
		buttonGroup.add(rdbtn_Monster);
		rdbtn_Monster.setBounds(19, 37, 103, 21);
		panel_CH.add(rdbtn_Monster);
		// Knight
		JRadioButton rdbtn_Kinght = new JRadioButton("Knight");
		
		
		buttonGroup.add(rdbtn_Kinght);
		rdbtn_Kinght.setBounds(19, 70, 103, 21);
		panel_CH.add(rdbtn_Kinght);
		//Wizard
		JRadioButton rdbtn_Wizard = new JRadioButton("Wizard");
		
		buttonGroup.add(rdbtn_Wizard);
		rdbtn_Wizard.setBounds(19, 108, 103, 21);
		panel_CH.add(rdbtn_Wizard);
	
		//set a monster image as a default
		lbl_CH_Images = new JLabel("");
		lbl_CH_Images.setIcon(new ImageIcon(GamePages.class.getResource("/images/monster.png")));
		lbl_CH_Images.setBounds(408, 56, 230, 183);
		panel_CH.add(lbl_CH_Images);
		//set the user's name
		JLabel lbl_name_pg2 = new JLabel("");
		lbl_name_pg2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_name_pg2.setBounds(535, 17, 103, 26);
		panel_CH.add(lbl_name_pg2);
		
		JLabel lbl_name = new JLabel("NAME: ");
		lbl_name.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_name.setBounds(467, 20, 66, 21);
		panel_CH.add(lbl_name);
		// botton for random numbers
		JButton btn_statRoll = new JButton("STAT ROLL");
		
		btn_statRoll.setBounds(170, 237, 108, 90);
		panel_CH.add(btn_statRoll);
		// create user's character and go to the next page
		JButton btn_CH_CREATE = new JButton("CREATE");
	
		btn_CH_CREATE.setBounds(528, 249, 119, 78);
		panel_CH.add(btn_CH_CREATE);
		
		// character descriptions 
		lbl_CH_desc = new JTextArea("Monster possesses immense strength.\r\nMonster's weapon is a hammer.\r\nAttack point = strength");
		lbl_CH_desc.setBackground(Color.WHITE);
		lbl_CH_desc.setEditable(false);
		lbl_CH_desc.setBounds(133, 37, 265, 190);
		panel_CH.add(lbl_CH_desc);
		// set random numbers (str, int, dex)
		textField_stren = new JTextField();
		textField_stren.setEditable(false);
		textField_stren.setBounds(81, 238, 66, 19);
		panel_CH.add(textField_stren);
		textField_stren.setColumns(10);
		
		textField_intell = new JTextField();
		textField_intell.setEditable(false);
		textField_intell.setBounds(81, 274, 66, 19);
		panel_CH.add(textField_intell);
		textField_intell.setColumns(10);
		
		textField_dex = new JTextField();
		textField_dex.setEditable(false);
		textField_dex.setBounds(81, 308, 66, 19);
		panel_CH.add(textField_dex);
		textField_dex.setColumns(10);
		
		JLabel lbl_Str = new JLabel("Str");
		lbl_Str.setBounds(10, 237, 61, 20);
		panel_CH.add(lbl_Str);
		
		JLabel lblInt = new JLabel("Int");
		lblInt.setBounds(10, 276, 61, 20);
		panel_CH.add(lblInt);
		
		JLabel lblDex = new JLabel("Dex");
		lblDex.setBounds(10, 311, 61, 20);
		panel_CH.add(lblDex);
		
		// background image
		JLabel lbl_background_pg2 = new JLabel("");
		lbl_background_pg2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_background_pg2.setIcon(new ImageIcon(GamePages.class.getResource("/images/2.png")));
		lbl_background_pg2.setBounds(0, 0, 686, 362);
		panel_CH.add(lbl_background_pg2);
		
		// store page
	
		JPanel panel_STORE = new JPanel();
		contentPane.add(panel_STORE, "name_259779623914764");
		panel_STORE.setLayout(null);
		
		JLabel lbl_store = new JLabel("STORE");
		lbl_store.setFont(new Font("Tahoma", Font.BOLD, 19));
		lbl_store.setBounds(23, 10, 154, 39);
		panel_STORE.add(lbl_store);
		
		// item images and descriptions
		JLabel lbl_ITEM1 = new JLabel("ITEM1");
		lbl_ITEM1.setIcon(new ImageIcon(GamePages.class.getResource("/images/hammer.jpg")));
		lbl_ITEM1.setBounds(10, 128, 113, 87);
		panel_STORE.add(lbl_ITEM1);
		
		JLabel lbl_Item2 = new JLabel("ITEM2");
		lbl_Item2.setIcon(new ImageIcon(GamePages.class.getResource("/images/wand2.png")));
		lbl_Item2.setBounds(10, 248, 113, 87);
		panel_STORE.add(lbl_Item2);
		
		JLabel lbl_ITEM3 = new JLabel("ITEM3");
		lbl_ITEM3.setIcon(new ImageIcon(GamePages.class.getResource("/images/download.jpg")));
		lbl_ITEM3.setBounds(327, 128, 113, 87);
		panel_STORE.add(lbl_ITEM3);
		
		//go to the next page
		JButton btnNext = new JButton("Next");
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		btnNext.setBounds(573, 10, 91, 83);
		panel_STORE.add(btnNext);
		
		//button for buying items
		JButton btn_BUY1 = new JButton("BUY");
		
		btn_BUY1.setBounds(133, 108, 85, 21);
		panel_STORE.add(btn_BUY1);
		
		JButton btn_BUY2 = new JButton("BUY");
		
		btn_BUY2.setBounds(133, 235, 85, 21);
		panel_STORE.add(btn_BUY2);
		
		JButton btn_BUY3 = new JButton("BUY");
		
		btn_BUY3.setBounds(460, 108, 85, 21);
		panel_STORE.add(btn_BUY3);
		
		JButton btn_BUY4 = new JButton("BUY");
		
		btn_BUY4.setBounds(460, 240, 85, 21);
		panel_STORE.add(btn_BUY4);
		
		JTextArea item1_desc = new JTextArea();
		item1_desc.setFont(new Font("Monospaced", Font.PLAIN, 12));
		item1_desc.setText("- Hammer \r\n- Strength + 10\r\n- Recommended for Monster \r\nCOST: 600");
		item1_desc.setBounds(133, 143, 184, 72);
		panel_STORE.add(item1_desc);
		
		JTextArea item2_desc = new JTextArea();
		item2_desc.setFont(new Font("Monospaced", Font.PLAIN, 12));
		item2_desc.setText("- Armor\r\n- Defense + 10\r\n- Recommended for any character\r\nCOST: 300");
		item2_desc.setBounds(450, 139, 214, 74);
		panel_STORE.add(item2_desc);
		
		JTextArea item3_desc = new JTextArea();
		item3_desc.setFont(new Font("Monospaced", Font.PLAIN, 12));
		item3_desc.setText("- Magic staff \r\n- Intelligence + 10\r\n- Recommended for Wizard \r\nCOST: 600");
		item3_desc.setBounds(133, 266, 184, 69);
		panel_STORE.add(item3_desc);
		
		JTextArea item4_desc = new JTextArea();
		item4_desc.setFont(new Font("Monospaced", Font.PLAIN, 12));
		item4_desc.setText("- Polearm\r\n- Dex + 10\r\n- Recommended for Knight \r\nCOST: 600");
		item4_desc.setBounds(450, 265, 214, 70);
		panel_STORE.add(item4_desc);
		
		label_noGold = new JLabel("");
		label_noGold.setForeground(Color.RED);
		label_noGold.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_noGold.setBounds(383, 53, 148, 24);
		panel_STORE.add(label_noGold);
		
		JLabel lbl_ITEM4 = new JLabel("ITEM3");
		lbl_ITEM4.setIcon(new ImageIcon(GamePages.class.getResource("/images/518-Halberd-of-the-Sharpstar.png")));
		lbl_ITEM4.setBounds(327, 242, 113, 98);
		panel_STORE.add(lbl_ITEM4);
		
		
		JLabel lblGold = new JLabel("GOLD : ");
		lblGold.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGold.setBounds(383, 12, 60, 39);
		panel_STORE.add(lblGold);
		// set gold 
		label_gold = new JLabel("");
		label_gold.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_gold.setBounds(460, 19, 67, 30);
		panel_STORE.add(label_gold);
		
		//background image
		JLabel lblNewLabel_BACK = new JLabel("");
		lblNewLabel_BACK.setIcon(new ImageIcon(GamePages.class.getResource("/images/2.png")));
		lblNewLabel_BACK.setBackground(UIManager.getColor("Button.disabledShadow"));
		lblNewLabel_BACK.setBounds(0, 0, 686, 365);
		panel_STORE.add(lblNewLabel_BACK);
		
		// battle page
		JPanel panel_BATTLE = new JPanel();
		panel_BATTLE.setBackground(Color.WHITE);
		contentPane.add(panel_BATTLE, "name_259779600392375");
		panel_BATTLE.setLayout(null);
		
		// start battle
		JButton btn_battle_start = new JButton("Battle Start");
		btn_battle_start.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btn_battle_start.setBounds(212, 10, 121, 31);
		panel_BATTLE.add(btn_battle_start);
		
		// go to the main page
		JButton btnExit = new JButton("EXIT");
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 13));
	
		btnExit.setBounds(573, 10, 74, 31);
		panel_BATTLE.add(btnExit);
		
		label_Setdefault_userImg = new JLabel(""); // label for user's character image
		label_Setdefault_userImg.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		label_Setdefault_userImg.setBorder(new LineBorder(Color.BLACK));
		label_Setdefault_userImg.setIcon(new ImageIcon(GamePages.class.getResource("/images/monster.png"))); // set user's character image
		label_Setdefault_userImg.setBackground(Color.WHITE);
		label_Setdefault_userImg.setBounds(10, 62, 205, 190);
		panel_BATTLE.add(label_Setdefault_userImg);
		
		JLabel label_SetEnemyImg = new JLabel("");
		label_SetEnemyImg.setIcon(new ImageIcon(GamePages.class.getResource("/images/images.jpg"))); // set the enemy image
		label_SetEnemyImg.setBorder(new LineBorder(Color.BLUE));
		label_SetEnemyImg.setBounds(468, 62, 196, 190);
		panel_BATTLE.add(label_SetEnemyImg);
		//display hp
		lblUserHp = new JLabel("");
		lblUserHp.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblUserHp.setBounds(76, 292, 51, 38);
		panel_BATTLE.add(lblUserHp);
		
		lblEnemyHp = new JLabel("");
		lblEnemyHp.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblEnemyHp.setBounds(534, 283, 57, 38);
		panel_BATTLE.add(lblEnemyHp);
		// set a full of health point
		JLabel label_HP200_User = new JLabel("/200");
		label_HP200_User.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		label_HP200_User.setBounds(573, 287, 57, 31);
		panel_BATTLE.add(label_HP200_User);
		
		JLabel label_HP200 = new JLabel("/200");
		label_HP200.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		label_HP200.setBounds(115, 296, 57, 31);
		panel_BATTLE.add(label_HP200);
		
		JLabel lblHp = new JLabel("HP :");
		lblHp.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblHp.setBounds(10, 305, 45, 13);
		panel_BATTLE.add(lblHp);
		
		JLabel label_HP = new JLabel("HP :");
		label_HP.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		label_HP.setBounds(480, 298, 45, 13);
		panel_BATTLE.add(label_HP);
		
		JLabel lbl_setUserName = new JLabel("");
		lbl_setUserName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_setUserName.setBounds(106, 271, 84, 25);
		panel_BATTLE.add(lbl_setUserName);
		
		JLabel lblNewLabel_5 = new JLabel("Enemy");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(573, 262, 74, 23);
		panel_BATTLE.add(lblNewLabel_5);
		
		// re battle button
		JButton btnBattleAgain = new JButton("Battle again");
	
		btnBattleAgain.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBattleAgain.setBounds(343, 9, 128, 31);
		panel_BATTLE.add(btnBattleAgain);
		
		JButton btn_storeback = new JButton("STORE");
		btn_storeback.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btn_storeback.setBounds(21, 10, 89, 29);
		panel_BATTLE.add(btn_storeback);
		// text for a battle
		taBattleReport = new JTextArea();
		taBattleReport.setBounds(210, 130, 190, 200);
		
		JScrollPane scrollPane = new JScrollPane(taBattleReport);
		scrollPane.setBounds(225, 62, 233, 268);
		panel_BATTLE.add(scrollPane);
		//background image
		JLabel lbl_background_pg4 = new JLabel("");
		lbl_background_pg4.setIcon(new ImageIcon(GamePages.class.getResource("/images/2.png")));
		lbl_background_pg4.setBounds(0, 0, 674, 351);
		panel_BATTLE.add(lbl_background_pg4);
				
	//-------------------------------------------------------------------------------//
		// action methods
		
		btn_BUY1.addActionListener(new ActionListener() { //Hammer
			public void actionPerformed(ActionEvent arg0) {
				setItem(0);
			}
		});
		
		btn_BUY3.addActionListener(new ActionListener() { //Armor
			public void actionPerformed(ActionEvent arg0) {
				setItem(1);
			}
		});
		
		btn_BUY2.addActionListener(new ActionListener() { //Magic Staff
			public void actionPerformed(ActionEvent arg0) {
				setItem(2);
			}
		});
		
		btn_BUY4.addActionListener(new ActionListener() {		//Spear
			public void actionPerformed(ActionEvent arg0) {
				setItem(3);
			}
		});
		
		rdbtn_Wizard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtn_Wizard.isSelected()) {
					user.setCharacter("Wizard"); // save data to User_Setting
					lbl_CH_Images.setIcon(new ImageIcon(GamePages.class.getResource("/images/wizard.jpg")));
					// read character descriptions from a txt file - wizard 
					String FILENAME = GamePages.class.getResource("/txt/wizard_des.txt").toString().substring(6).replaceAll("%20", " ");
					BufferedReader br=null;
					FileReader fr = null;
					try {
						fr = new FileReader(FILENAME);
						br = new BufferedReader(fr);
						String line;
						String text="";
						while((line = br.readLine()) != null) {
							text += line+"\n";
						}
						lbl_CH_desc.setText(text);
					}catch(Exception e) {lbl_CH_desc.setText("error");}
					set_ran();
				}
					
			}	
		});
		rdbtn_Kinght.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtn_Kinght.isSelected()) {
					user.setCharacter("Knight");
					lbl_CH_Images.setIcon(new ImageIcon(GamePages.class.getResource("/images/knight.jpg")));
					// read a txt file - Knight
					String FILENAME = GamePages.class.getResource("/txt/knight_des.txt").toString().substring(6).replaceAll("%20", " ");
					BufferedReader br=null;
					FileReader fr = null;
					try {
						fr = new FileReader(FILENAME);
						br = new BufferedReader(fr);
						String line;
						String text="";
						while((line = br.readLine()) != null) {
							text += line+"\n";
						}
						lbl_CH_desc.setText(text);
					}catch(Exception e) {lbl_CH_desc.setText("error");}
					set_ran();
				}
			}
		 });
		
		rdbtn_Monster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtn_Monster.isSelected()) {
					user.setCharacter("Monster"); // save data 
					lbl_CH_Images.setIcon(new ImageIcon(GamePages.class.getResource("/images/monster.png"))); // set monster image
					String FILENAME = GamePages.class.getResource("/txt/monster_des.txt").toString().substring(6).replaceAll("%20", " ");
					// // read a txt file - monster
					BufferedReader br=null;
					FileReader fr = null;
					try {
						fr = new FileReader(FILENAME);
						br = new BufferedReader(fr);
						String line;
						String text="";
						while((line = br.readLine()) != null) {
							text += line+"\n";
						}
						lbl_CH_desc.setText(text);
					}catch(Exception e) {lbl_CH_desc.setText("error");}
					set_ran();
				}
			}
		});
		
		// main page - start button: 
		START_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Nameinput()) {
					set_ran();
					load_battleData();
					panel_1st.setVisible(false);
					panel_CH.setVisible(true);
					user.setUserName(textField_name.getText()); //save user's name to User_setting
					lbl_name_pg2.setText(textField_name.getText()); // "
					label_gold.setText(String.valueOf(user.getCurrent_gold())); // set gold
				}	
			}
			
		});
		btn_statRoll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				set_ran();	
			}
		});
		btn_CH_CREATE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setCharacterInfo();
				panel_CH.setVisible(false);
				panel_STORE.setVisible(true);
			}
		});
		
		btnNext.addActionListener(new ActionListener() { // store button
			public void actionPerformed(ActionEvent arg0) {
				initBattle();
				setBattleScreen();
				if(user.getCharacter()=="Knight") {
					label_Setdefault_userImg.setIcon(new ImageIcon(GamePages.class.getResource("/images/knight.jpg")));
				}else if (user.getCharacter()=="Wizard") {
					label_Setdefault_userImg.setIcon(new ImageIcon(GamePages.class.getResource("/images/wizard.jpg")));
				}
				panel_STORE.setVisible(false);
				panel_BATTLE.setVisible(true);
				
			}
		});
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetBattle();
				user = new User_setting();
				panel_BATTLE.setVisible(false);
				panel_1st.setVisible(true);
			}
		});
		
		btn_battle_start.addActionListener(new ActionListener() { //run battle
			public void actionPerformed(ActionEvent arg0) {
				runBattle();
			}
		});
		
		btn_storeback.addActionListener(new ActionListener() { //store button
			public void actionPerformed(ActionEvent arg0) {
				reBattle();
				label_gold.setText(String.valueOf(user.getCurrent_gold()));
				System.out.println(user.getCurrent_gold() + user.getReward());
				panel_BATTLE.setVisible(false);
				panel_STORE.setVisible(true);
			}
		});
		
		btnBattleAgain.addActionListener(new ActionListener() { // battle again
			public void actionPerformed(ActionEvent arg0) {
				taBattleReport.setText("");
				reBattle();
				loadBattleData();
				setBattleScreen();
				runBattle();
			}
		});
	}
		
//-------------------------------------------------------------------------------
//	// Random
//		//user_setting user = new user_setting();
		public int[] init_ran() {
			int[] initValue = new int[3];
		
			Random init_point = new Random();
			for(int i=0;i<3;i++)
				initValue[i] = init_point.nextInt(15)+ 10;
			// set random number to user_Setting
			return initValue;
		}
		public void set_ran() {
			int[] randomValues = init_ran();
			if(user.getCharacter().equals("Monster")) {
				randomValues[0] *= 2;
			}else if(user.getCharacter().equals("Wizard")) {
				randomValues[1] *= 2;
			}else {
				randomValues[2] *= 2;
			}
			
			this.textField_stren.setText(String.valueOf(randomValues[0]));
			this.textField_intell.setText(String.valueOf(randomValues[1]));
			this.textField_dex.setText(String.valueOf(randomValues[2]));
			
		}
		
		
		
		// name validation
		public boolean Nameinput() {
			String inName = textField_name.getText();
			
				if(validate(inName))
					return true;
				else{					
					lblNewLabel_validation.setText("Enter letters!!");
					return false;
				}	 		
		}
		private boolean validate(String nametest) {
			String validChars = "abcdefghijklmnopqrstuvwxyz ";	
			char testChar;
			if(nametest.length()==0|| nametest ==" ")
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
		
		private void setCharacterInfo() {
			user.setInit_stren(Integer.parseInt(this.textField_stren.getText()));
			user.setInit_intell(Integer.parseInt(this.textField_intell.getText()));
			user.setInit_dex(Integer.parseInt(this.textField_dex.getText()));
			
		}
		public void setMyBattle(Battle myBattle) {
			this.myBattle = myBattle;
		}
		
		public void load_battleData() {
			this.itemList = this.myBattle.getItemList();
		}
		public void setItem(int itemCode) {
			int userGold = user.getCurrent_gold();
			int itemGold = Integer.valueOf(itemList[itemCode][3]);
			if (userGold - itemGold >= 0) {
				user.setCurrent_gold(userGold - itemGold);
				user.setItem(itemList[itemCode][0]);
				label_gold.setText(String.valueOf(user.getCurrent_gold()));
			}else {
				label_noGold.setText("Not enough Gold !!");
				
			}
		}
		public void reward() {
			int gold = user.getCurrent_gold();
			int reward = 200;
			if (this.myBattle.userWin())
			user.setCurrent_gold(gold+ reward);
		}
		
		public void initBattle() {
			this.myBattle.initBattle(user);
			this.taBattleReport.setText("");
			loadBattleData();
		}
		public void loadBattleData() {
			user.setHealth_point(this.myBattle.getUserHp());
			user.setEnemy_health_point(this.myBattle.getEnemyHp());
			user.setDone(this.myBattle.isDone());
		}
		public void setBattleScreen() {
			if(user.getHealth_point() < 0) {
				this.lblUserHp.setText("0");
				this.lblEnemyHp.setText(String.valueOf(user.getEnemy_health_point()));				
			}else if(user.getEnemy_health_point() < 0) {
				this.lblUserHp.setText(String.valueOf(user.getHealth_point()));
				this.lblEnemyHp.setText("0");				
			}else {
				this.lblUserHp.setText(String.valueOf(user.getHealth_point()));
				this.lblEnemyHp.setText(String.valueOf(user.getEnemy_health_point()));				
			}
			taBattleReport.append(user.getBattleResult());
			user.setBattleResult("");
			
//			int userHp = user.getHealth_point();
//			int enemyHp= user.getEnemy_health_point();
//			
//			this.lblUserHp.setText(String.valueOf(user.getHealth_point()<0?0:user.getHealth_point() ));
//			this.lblEnemyHp.setText(String.valueOf(user.getEnemy_health_point()<0?0:user.getEnemy_health_point() ));	
//			this.lblUserHp.setText(String.valueOf(userHp<0?0:userHp));
//			this.lblEnemyHp.setText(String.valueOf(enemyHp<0?0:enemyHp));
			
		}
		
		public void runBattle() {
			timer = new Timer();
			TimerTask battleRound = new TimerTask() {  // like array
				@Override
				public void run() {
					//every time the timer says so, write a number to console
					
					if (user.isDone()) { 
						reward();
						// stop the timer
						timer.cancel(); // cancel the timer				
						timer.purge(); // clear memory
						return;
					}
					user.setBattleResult(myBattle.getBattle());
					loadBattleData();
					setBattleScreen();
					
				}
			};
			//Assign our timertask to a schedule
			timer.schedule(battleRound, 500, 200 ); //in milliseconds
		}
		
		public void reBattle() {
			user.setBattleResult("");
			this.myBattle.reGame();
		}
		public void resetBattle() {
			user.setBattleResult("");
			this.myBattle.reset();
		}
}

