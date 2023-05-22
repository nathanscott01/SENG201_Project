package Main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class BuyItemScreen {

	private JFrame frame;
	private JTextField textFieldItemDesc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuyItemScreen window = new BuyItemScreen();
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
	public BuyItemScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 598, 424);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Buy Item");
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTitle.setBounds(22, 12, 151, 24);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblMoney = new JLabel("Money: ");
		lblMoney.setFont(new Font("Dialog", Font.BOLD, 18));
		lblMoney.setBounds(394, 13, 190, 24);
		frame.getContentPane().add(lblMoney);
		
		JList listMarket = new JList();
		listMarket.setBounds(22, 85, 233, 206);
		frame.getContentPane().add(listMarket);
		
		JLabel lblItems = new JLabel("Items:");
		lblItems.setBounds(22, 58, 80, 15);
		frame.getContentPane().add(lblItems);
		
		JLabel lblItemDesc = new JLabel("Item Description:");
		lblItemDesc.setBounds(331, 58, 131, 15);
		frame.getContentPane().add(lblItemDesc);
		
		textFieldItemDesc = new JTextField();
		textFieldItemDesc.setEditable(false);
		textFieldItemDesc.setColumns(10);
		textFieldItemDesc.setBackground(Color.WHITE);
		textFieldItemDesc.setBounds(308, 84, 245, 207);
		frame.getContentPane().add(textFieldItemDesc);
		
		JLabel lblErrorlabel = new JLabel("errorlabel");
		lblErrorlabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorlabel.setBounds(308, 332, 245, 15);
		frame.getContentPane().add(lblErrorlabel);
		
		JButton btnPurchase = new JButton("Purchase");
		btnPurchase.setBounds(32, 329, 223, 55);
		frame.getContentPane().add(btnPurchase);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setBounds(467, 359, 117, 25);
		frame.getContentPane().add(btnGoBack);
	}

}
