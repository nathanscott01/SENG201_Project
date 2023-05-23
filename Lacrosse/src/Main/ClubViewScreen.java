package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JList;

public class ClubViewScreen {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClubViewScreen window = new ClubViewScreen();
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
	public ClubViewScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblClubname = new JLabel("ClubName");
		lblClubname.setFont(new Font("Dialog", Font.BOLD, 38));
		lblClubname.setBounds(28, 12, 470, 64);
		frame.getContentPane().add(lblClubname);
		
		JLabel lblPlayerStats = new JLabel("Player Stats:");
		lblPlayerStats.setFont(new Font("Dialog", Font.BOLD, 24));
		lblPlayerStats.setBounds(511, 47, 211, 34);
		frame.getContentPane().add(lblPlayerStats);
		
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setEditable(false);
		textField.setBounds(511, 93, 242, 248);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblReserve = new JLabel("Reserve");
		lblReserve.setHorizontalAlignment(SwingConstants.CENTER);
		lblReserve.setFont(new Font("Dialog", Font.BOLD, 20));
		lblReserve.setBounds(288, 86, 134, 32);
		frame.getContentPane().add(lblReserve);
		
		JList listReserve = new JList();
		listReserve.setBounds(265, 125, 196, 208);
		frame.getContentPane().add(listReserve);
		
		JLabel lblTeam = new JLabel("Team");
		lblTeam.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeam.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTeam.setBounds(61, 86, 134, 32);
		frame.getContentPane().add(lblTeam);
		
		JList listTeam = new JList();
		listTeam.setBounds(35, 125, 196, 208);
		frame.getContentPane().add(listTeam);
		
		JButton btnViewInventory = new JButton("View Inventory");
		btnViewInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnViewInventory.setBounds(61, 389, 170, 25);
		frame.getContentPane().add(btnViewInventory);
		
		JButton btnSwapAthlete = new JButton("Substitute Team Member");
		btnSwapAthlete.setBounds(61, 426, 225, 25);
		frame.getContentPane().add(btnSwapAthlete);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setBounds(636, 443, 117, 25);
		frame.getContentPane().add(btnGoBack);
		
		JLabel lblErorlabel = new JLabel("ErorLabel");
		lblErorlabel.setBounds(390, 389, 330, 15);
		frame.getContentPane().add(lblErorlabel);
	}
}
