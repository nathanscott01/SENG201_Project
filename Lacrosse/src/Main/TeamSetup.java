package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class TeamSetup {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeamSetup window = new TeamSetup();
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
	public TeamSetup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 682, 440);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTeamSetUp = new JLabel("Team Set Up");
		lblTeamSetUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeamSetUp.setFont(new Font("Dialog", Font.BOLD, 35));
		lblTeamSetUp.setBounds(142, 0, 400, 78);
		frame.getContentPane().add(lblTeamSetUp);
		
		JLabel lblCurrentAthlete = new JLabel("Current Athlete:");
		lblCurrentAthlete.setBounds(73, 147, 122, 15);
		frame.getContentPane().add(lblCurrentAthlete);
		
		JLabel lblAthleteinfo = new JLabel("AthleteInfo");
		lblAthleteinfo.setBounds(207, 141, 440, 26);
		frame.getContentPane().add(lblAthleteinfo);
		
		JLabel lblChoooseposition = new JLabel("Chooose Position:");
		lblChoooseposition.setBounds(62, 205, 149, 15);
		frame.getContentPane().add(lblChoooseposition);
		
		JRadioButton rdbtnForward = new JRadioButton("Forward");
		rdbtnForward.setBounds(225, 201, 95, 23);
		frame.getContentPane().add(rdbtnForward);
		
		JRadioButton rdbtnMid = new JRadioButton("Mid");
		rdbtnMid.setBounds(359, 201, 62, 23);
		frame.getContentPane().add(rdbtnMid);
		
		JRadioButton rdbtnDefence = new JRadioButton("Defence");
		rdbtnDefence.setBounds(468, 201, 149, 23);
		frame.getContentPane().add(rdbtnDefence);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(277, 319, 117, 25);
		frame.getContentPane().add(btnConfirm);
		
		JLabel lblErrorMessage = new JLabel("Confirm Placement");
		lblErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorMessage.setBounds(127, 275, 415, 15);
		frame.getContentPane().add(lblErrorMessage);
	}
}
