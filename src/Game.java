import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game {
	
	JFrame window;
	Container con;
	JPanel titleGamePanel, startButtonPanel;
	JLabel titleGameLabel;
	Font titleFont = new Font("Algerian", Font.PLAIN, 90);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
	JButton startButton;
	
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
}
