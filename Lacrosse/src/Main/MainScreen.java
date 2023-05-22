package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainScreen {

	private JFrame frame;
	private GameEnvironment manager;
	
	public MainScreen(GameEnvironment game) {
		manager = game;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeFrame() {
		frame.dispose();
	}
	
	public void finishedFrame() {
		manager.closeMainScreen(this);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 680, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLacrosse = new JLabel("Lacrosse");
		lblLacrosse.setHorizontalAlignment(SwingConstants.CENTER);
		lblLacrosse.setFont(new Font("Dialog", Font.BOLD, 80));
		lblLacrosse.setBounds(109, 30, 451, 102);
		frame.getContentPane().add(lblLacrosse);
		
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {       //Implement advance to next page
				manager.advanceWeek();
			}
		});
		btnStartGame.setBounds(269, 270, 117, 25);
		frame.getContentPane().add(btnStartGame);
	}
}
