package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class MarketSelectScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MarketSelectScreen window = new MarketSelectScreen();
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
	public MarketSelectScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 440, 246);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSelectAMarket = new JLabel("Select A Market:");
		lblSelectAMarket.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectAMarket.setBounds(158, 12, 131, 15);
		frame.getContentPane().add(lblSelectAMarket);
		
		JButton btnDraftAthlete = new JButton("Draft Athlete");
		btnDraftAthlete.setBounds(256, 50, 141, 46);
		frame.getContentPane().add(btnDraftAthlete);
		
		JButton btnBuyAthlete = new JButton("Buy Athlete");
		btnBuyAthlete.setBounds(54, 50, 141, 46);
		frame.getContentPane().add(btnBuyAthlete);
		
		JButton btnBuyItem = new JButton("Buy Item");
		btnBuyItem.setBounds(54, 122, 141, 46);
		frame.getContentPane().add(btnBuyItem);
		
		JButton btnDraftItem = new JButton("Draft Item");
		btnDraftItem.setBounds(256, 122, 141, 46);
		frame.getContentPane().add(btnDraftItem);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setBounds(311, 181, 117, 25);
		frame.getContentPane().add(btnGoBack);
	}

}
