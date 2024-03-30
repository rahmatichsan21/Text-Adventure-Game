import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {
	
	JFrame window;
	Container con;
	JPanel titleGamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
	JLabel titleGameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
	Font titleFont = new Font("Algerian", Font.PLAIN, 90);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 25);
	JButton startButton, choice1, choice2, choice3, choice4;
	JTextArea mainTextArea;
	
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler cHandler = new ChoiceHandler();
	
	int playerHP;
	String weapon, position;
	
	public static void main(String[] args) {
		new Game();
	}
	
	public Game() {
		
		window = new JFrame();
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		con = window.getContentPane();
		
		titleGamePanel = new JPanel();
		titleGamePanel.setBounds(100, 100, 600, 150);
		titleGamePanel.setBackground(Color.black);
		
		titleGameLabel = new JLabel("GABUT");
		titleGameLabel.setForeground(Color.white);
		titleGameLabel.setFont(titleFont);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 150, 50); //Ubah tinggi menjadi 50 agar lebih sesuai dengan teks di dalamnya
		startButtonPanel.setBackground(Color.black);
		
		startButton = new JButton("Start");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.addActionListener(tsHandler);
		startButton.setBorder(BorderFactory.createLineBorder(Color.white)); //Tambahkan border putih
		startButton.setFocusPainted(false); //Hilangkan focus border saat tombol aktif
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setBackground(Color.gray); //Ubah warna background saat mouse hover
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setBackground(Color.black); //Kembalikan warna background saat mouse keluar
			}
		});
		
		startButtonPanel.add(startButton);
		titleGamePanel.add(titleGameLabel);
		
		con.add(titleGamePanel);
		con.add(startButtonPanel);
		window.setVisible(true);
	}
	
	public void createGameScreen() {
		
		titleGamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);
		
		mainTextArea = new JTextArea("This is the Main text game");
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.WHITE);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 350, 300, 150);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4,1));
		con.add(choiceButtonPanel);
		
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(cHandler);
		choice1.setActionCommand("C1");
		choiceButtonPanel.add(choice1);
		
		
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(cHandler);
		choice2.setActionCommand("C2");
		choiceButtonPanel.add(choice2);
		
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(cHandler);
		choice3.setActionCommand("C3");
		choiceButtonPanel.add(choice3);
		
		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(cHandler);
		choice4.setActionCommand("C4");
		choiceButtonPanel.add(choice4);
		
		playerPanel = new JPanel();
		playerPanel.setBounds(100, 15, 600, 50);
		playerPanel.setBackground(Color.black);
		playerPanel.setForeground(Color.white);
		playerPanel.setLayout(new GridLayout(1,4));
		con.add(playerPanel);
		hpLabel = new JLabel("HP: ");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.WHITE);
		playerPanel.add(hpLabel);
		hpLabelNumber = new JLabel();
		hpLabelNumber.setFont(normalFont);
		hpLabelNumber.setForeground(Color.white);
		playerPanel.add(hpLabelNumber);
		weaponLabel = new JLabel("Weapon: ");
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.white);
		playerPanel.add(weaponLabel);
		weaponLabelName = new JLabel();
		weaponLabelName.setFont(normalFont);
		weaponLabelName.setForeground(Color.white);
		playerPanel.add(weaponLabelName);
		
		playerSetUp();
	}
	
	public void playerSetUp() {
		playerHP = 20;
		weapon = "Knife";
		weaponLabelName.setText(weapon);
		hpLabelNumber.setText(""+ playerHP);
		
		townGate();
	}
	
	public void townGate() {
		position = "townGate";
		mainTextArea.setText("Your are at the gate of the town. \nA guard is standing in front of you\n\nWhat do you do?");
		choice1.setText("Talk to the Guard");
		choice2.setText("Attack the Guard");
		choice3.setText("Leave");
		choice4.setText("");
	}
	
	public void talkGuard() {
		position = "talkGuard";
		mainTextArea.setText("You are not from this town aren't you\nYou shall not enter!");
		choice1.setText("Return");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void attackGuard() {
		position = "attackGuard";
		mainTextArea.setText("Arhg....\nYou ... FOOL\nTake This!!\nThe Guard hit you\n(you took 3 Damage)");
		playerHP = playerHP -3;
		hpLabelNumber.setText(""+playerHP);
		choice1.setText("Return");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void crossRoad() {
		position = "crossRoad";
		mainTextArea.setText("You are at a crossroad.\nIf you go south you'll go back to the town gate");
		choice1.setText("Go South");
		choice2.setText("Go North");
		choice3.setText("Go East");
		choice4.setText("Go West");
		
	}
	
	public void north() {
		position = "north";
		mainTextArea.setText("You found a river. You drank some water and the water heals you\n(You gained 2 HP)");
		playerHP = playerHP +2;
		hpLabelNumber.setText(""+playerHP);
		choice1.setText("return");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void east() {
		position = "east";
		mainTextArea.setText("You found a new weapon\nWhat will you do?");
		choice1.setText("Pick it up");
		choice2.setText("Return");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void pickupSword() {
		position = "pickupSword";
		mainTextArea.setText("You picked up a Great Sword of the Angels");
		weaponLabelName.setText("Great Sword");
		choice1.setText("return");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void west() {
		position = "west";
		mainTextArea.setText("You are at a crossroad.\nIf you go south you'll go back to the town gate");
		choice1.setText("Go South");
		choice2.setText("Go North");
		choice3.setText("Go East");
		choice4.setText("Go West");
	}
	
	public class TitleScreenHandler implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			createGameScreen();
		}
	}
	
	public class ChoiceHandler implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			String yourChoice = event.getActionCommand();
			
			switch(position) {
			case "townGate":
				switch(yourChoice) {
				case "C1": talkGuard(); break;
				case "C2" : attackGuard(); break;
				case "C3" : crossRoad(); break;
				}
				break;
			case "talkGuard":
				switch(yourChoice) {
				case "C1" : townGate(); break;
				}
			case "attackGuard":
				switch(yourChoice) {
				case "C1": townGate(); break;
				}
			case "crossRoad":
				switch(yourChoice) {
				case "C1": townGate(); break;
				case "C2": north(); break;
				case "C3": east(); break;
				case "C4": 
				}
			case "north":
				switch (yourChoice) {
				case "C1": crossRoad(); break;
				}
			case "east":
				switch(yourChoice){
				case "C1": pickupSword(); break;
				case "C2": crossRoad(); break;
				}
			case "pickupSword":
				switch(yourChoice) {
				case "C1" : east(); break;
				}
			}
		}
		
	}
}
