package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class BuyAthleteScreen {

	private JFrame frame;
	private JTextField textField;
	private JTextField textFieldNickname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuyAthleteScreen window = new BuyAthleteScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BuyAthleteScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 598, 424);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Buy Athlete");
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTitle.setBounds(22, 12, 151, 24);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblMoney = new JLabel("Money: ");
		lblMoney.setFont(new Font("Dialog", Font.BOLD, 18));
		lblMoney.setBounds(394, 13, 190, 24);
		frame.getContentPane().add(lblMoney);
		
		JList listMarket = new JList();
		listMarket.setBounds(22, 85, 233, 206);
		frame.getContentPane().add(listMarket);
		
		JLabel lblAthletes = new JLabel("Athletes:");
		lblAthletes.setBounds(22, 58, 80, 15);
		frame.getContentPane().add(lblAthletes);
		
		JLabel lblAthleteStats = new JLabel("Athlete Stats:");
		lblAthleteStats.setBounds(331, 58, 131, 15);
		frame.getContentPane().add(lblAthleteStats);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		textField.setBounds(308, 84, 245, 207);
		frame.getContentPane().add(textField);
		
		JLabel lblErrorlabel = new JLabel("errorlabel");
		lblErrorlabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorlabel.setBounds(184, 302, 245, 15);
		frame.getContentPane().add(lblErrorlabel);
		
		JButton btnPurchase = new JButton("Purchase");
		btnPurchase.setBounds(308, 343, 117, 25);
		frame.getContentPane().add(btnPurchase);
		
		JLabel lblNickname = new JLabel("Nickname:");
		lblNickname.setBounds(22, 348, 80, 15);
		frame.getContentPane().add(lblNickname);
		
		textFieldNickname = new JTextField();
		textFieldNickname.setBounds(116, 346, 139, 19);
		frame.getContentPane().add(textFieldNickname);
		textFieldNickname.setColumns(10);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setBounds(467, 359, 117, 25);
		frame.getContentPane().add(btnGoBack);
	}

}
