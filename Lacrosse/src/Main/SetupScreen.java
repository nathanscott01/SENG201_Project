package Main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SetupScreen {

	private JFrame frame;
	private JTextField txtLetters;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private GameEnvironment manager;

	public SetupScreen(GameEnvironment game) {
		manager = game;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeFrame() {
		frame.dispose();
	}
	
	public void finishedFrame() {
		manager.closeSetupScreen(this);
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
		buttonGroup.add(rdbtnEasy);
		rdbtnEasy.setBounds(44, 100, 149, 23);
		frame.getContentPane().add(rdbtnEasy);
		
		JRadioButton rdbtnNormal = new JRadioButton("Normal");
		buttonGroup.add(rdbtnNormal);
		rdbtnNormal.setBounds(44, 127, 149, 23);
		frame.getContentPane().add(rdbtnNormal);
		
		JRadioButton rdbtnHard = new JRadioButton("Hard");
		buttonGroup.add(rdbtnHard);
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
		slider.setBounds(289, 203, 257, 16);
		frame.getContentPane().add(slider);
		
		JLabel lblSetSeasonLength = new JLabel("Set Season length (5-15)");
		lblSetSeasonLength.setBounds(304, 176, 195, 15);
		frame.getContentPane().add(lblSetSeasonLength);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnConfirm.setEnabled(false);
		btnConfirm.setBounds(496, 305, 117, 25);
		frame.getContentPane().add(btnConfirm);
		
		JLabel errorLabel = new JLabel("Error displayed here:");
		errorLabel.setBounds(56, 305, 170, 15);
		frame.getContentPane().add(errorLabel);
		
		JLabel lblCurrentNum = new JLabel("");
		lblCurrentNum.setBounds(554, 203, 70, 15);
		frame.getContentPane().add(lblCurrentNum);
		
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lblCurrentNum.setText(String.valueOf(slider.getValue()));
				btnConfirm.setEnabled(true);
			}
		});
	}
}
