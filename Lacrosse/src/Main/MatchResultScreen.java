package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class MatchResultScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MatchResultScreen window = new MatchResultScreen();
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
	public MatchResultScreen() {
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
		
		JLabel lblMatchresult = new JLabel("MatchResult");
		lblMatchresult.setFont(new Font("Dialog", Font.BOLD, 50));
		lblMatchresult.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatchresult.setBounds(43, 12, 502, 104);
		frame.getContentPane().add(lblMatchresult);
		
		JLabel lblPointsWon = new JLabel("Points Won:");
		lblPointsWon.setHorizontalAlignment(SwingConstants.CENTER);
		lblPointsWon.setBounds(181, 150, 213, 15);
		frame.getContentPane().add(lblPointsWon);
		
		JLabel lblMoneyWon = new JLabel("Money Won:");
		lblMoneyWon.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoneyWon.setBounds(181, 184, 213, 15);
		frame.getContentPane().add(lblMoneyWon);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.setBounds(223, 211, 137, 44);
		frame.getContentPane().add(btnContinue);
	}

}
