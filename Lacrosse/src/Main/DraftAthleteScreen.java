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

public class DraftAthleteScreen {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DraftAthleteScreen window = new DraftAthleteScreen();
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
	public DraftAthleteScreen() {
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
		
		JLabel lblTitle = new JLabel("Draft Athlete");
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
		
		JLabel lblAthletes = new JLabel("Reserve Athletes:");
		lblAthletes.setBounds(22, 58, 181, 15);
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
		
		JButton btnDraft = new JButton("Draft");
		btnDraft.setEnabled(false);
		btnDraft.setBounds(22, 328, 233, 56);
		frame.getContentPane().add(btnDraft);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setBounds(467, 359, 117, 25);
		frame.getContentPane().add(btnGoBack);
	}

}
