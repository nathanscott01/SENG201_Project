package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameOverScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameOverScreen window = new GameOverScreen();
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
	public GameOverScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblGameOver = new JLabel("Game Over");
		lblGameOver.setFont(new Font("Dialog", Font.BOLD, 62));
		lblGameOver.setBounds(12, 12, 416, 88);
		frame.getContentPane().add(lblGameOver);
		
		JLabel lblYouScored = new JLabel("You Scored:");
		lblYouScored.setHorizontalAlignment(SwingConstants.CENTER);
		lblYouScored.setBounds(12, 134, 416, 15);
		frame.getContentPane().add(lblYouScored);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnClose.setBounds(161, 206, 117, 25);
		frame.getContentPane().add(btnClose);
	}

}
