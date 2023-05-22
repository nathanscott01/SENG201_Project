package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class ByeScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ByeScreen window = new ByeScreen();
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
	public ByeScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 588, 313);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAWeekPasses = new JLabel("A Week Passes");
		lblAWeekPasses.setFont(new Font("Dialog", Font.BOLD, 40));
		lblAWeekPasses.setHorizontalAlignment(SwingConstants.CENTER);
		lblAWeekPasses.setBounds(90, 12, 408, 58);
		frame.getContentPane().add(lblAWeekPasses);
		
		JLabel lblAllAthleteStamina = new JLabel("All Athlete Stamina is back to full. What else happened?");
		lblAllAthleteStamina.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllAthleteStamina.setBounds(90, 99, 408, 15);
		frame.getContentPane().add(lblAllAthleteStamina);
		
		JLabel lblEvent = new JLabel("Event");
		lblEvent.setHorizontalAlignment(SwingConstants.CENTER);
		lblEvent.setBounds(90, 141, 408, 15);
		frame.getContentPane().add(lblEvent);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.setBounds(215, 197, 159, 58);
		frame.getContentPane().add(btnContinue);
	}
}
