package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class StadiumScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StadiumScreen window = new StadiumScreen();
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
	public StadiumScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 620, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblStadium = new JLabel("Stadium");
		lblStadium.setFont(new Font("Dialog", Font.BOLD, 40));
		lblStadium.setBounds(12, 12, 232, 48);
		frame.getContentPane().add(lblStadium);
		
		JLabel lblMatches = new JLabel("Matches:");
		lblMatches.setFont(new Font("Dialog", Font.BOLD, 18));
		lblMatches.setBounds(22, 72, 99, 25);
		frame.getContentPane().add(lblMatches);
		
		JList listMatches = new JList();
		listMatches.setBounds(32, 98, 548, 206);
		frame.getContentPane().add(listMatches);
		
		JButton btnBattleClub = new JButton("Battle Club");
		btnBattleClub.setBounds(32, 316, 162, 50);
		frame.getContentPane().add(btnBattleClub);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setBounds(418, 316, 162, 50);
		frame.getContentPane().add(btnGoBack);
		
		JLabel lblNotenoughplayers = new JLabel("NotEnoughPlayers");
		lblNotenoughplayers.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotenoughplayers.setBounds(212, 334, 188, 15);
		frame.getContentPane().add(lblNotenoughplayers);
	}
}
