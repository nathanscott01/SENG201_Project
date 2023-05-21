package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JButton;

public class SetupScreen {

	private JFrame frame;
	private JTextField txtLetters;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetupScreen window = new SetupScreen();
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
	public SetupScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 670, 410);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblInitialSetup = new JLabel("Initial Setup:");
		lblInitialSetup.setHorizontalAlignment(SwingConstants.CENTER);
		lblInitialSetup.setFont(new Font("Dialog", Font.BOLD, 29));
		lblInitialSetup.setBounds(209, 12, 230, 34);
		frame.getContentPane().add(lblInitialSetup);
		
		JLabel lblSetDifficulty = new JLabel("Set Difficulty");
		lblSetDifficulty.setBounds(44, 65, 113, 27);
		frame.getContentPane().add(lblSetDifficulty);
		
		JRadioButton rdbtnEasy = new JRadioButton("Easy");
		rdbtnEasy.setBounds(44, 100, 149, 23);
		frame.getContentPane().add(rdbtnEasy);
		
		JRadioButton rdbtnNormal = new JRadioButton("Normal");
		rdbtnNormal.setBounds(44, 127, 149, 23);
		frame.getContentPane().add(rdbtnNormal);
		
		JRadioButton rdbtnHard = new JRadioButton("Hard");
		rdbtnHard.setBounds(44, 154, 149, 23);
		frame.getContentPane().add(rdbtnHard);
		
		JLabel lblSetClubName = new JLabel("Set Club Name (3-15 lettes)");
		lblSetClubName.setBounds(293, 71, 253, 15);
		frame.getContentPane().add(lblSetClubName);
		
		txtLetters = new JTextField();
		txtLetters.setBounds(303, 88, 114, 19);
		frame.getContentPane().add(txtLetters);
		txtLetters.setColumns(10);
		
		JSlider slider = new JSlider();
		slider.setMaximum(15);
		slider.setMinimum(5);
		slider.setBounds(289, 205, 257, 16);
		frame.getContentPane().add(slider);
		
		JLabel lblSetSeasonLength = new JLabel("Set Season length (5-15)");
		lblSetSeasonLength.setBounds(304, 176, 195, 15);
		frame.getContentPane().add(lblSetSeasonLength);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(273, 300, 117, 25);
		frame.getContentPane().add(btnConfirm);
	}
}
