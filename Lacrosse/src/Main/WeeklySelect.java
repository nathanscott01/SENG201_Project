package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class WeeklySelect {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WeeklySelect window = new WeeklySelect();
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
	public WeeklySelect() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 680, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("What would you like to do?");
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 32));
		lblTitle.setBounds(31, 12, 527, 41);
		frame.getContentPane().add(lblTitle);
		
		JButton btnGoToClub = new JButton("Go to Club");
		btnGoToClub.setBounds(31, 95, 267, 91);
		frame.getContentPane().add(btnGoToClub);
		
		JButton btnGoToMarket = new JButton("Go to Market");
		btnGoToMarket.setBounds(331, 95, 267, 91);
		frame.getContentPane().add(btnGoToMarket);
		
		JButton btnGoToStadium = new JButton("Go to Stadium");
		btnGoToStadium.setBounds(31, 215, 267, 91);
		frame.getContentPane().add(btnGoToStadium);
		
		JButton btnTakeBye = new JButton("Take a Bye");
		btnTakeBye.setBounds(331, 215, 267, 91);
		frame.getContentPane().add(btnTakeBye);
		
		JLabel lblCurrentWeek = new JLabel("Current Week: ");
		lblCurrentWeek.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCurrentWeek.setBounds(46, 347, 204, 15);
		frame.getContentPane().add(lblCurrentWeek);
		
		JLabel lblWeeksRemaining = new JLabel("Weeks Remaining: ");
		lblWeeksRemaining.setFont(new Font("Dialog", Font.BOLD, 18));
		lblWeeksRemaining.setBounds(45, 374, 267, 35);
		frame.getContentPane().add(lblWeeksRemaining);
	}

}
