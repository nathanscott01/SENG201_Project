package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;

public class InventoryScreen {

	private JFrame frame;
	private JTextField txtBoxItemDescription;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventoryScreen window = new InventoryScreen();
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
	public InventoryScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Inventory");
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 42));
		lblTitle.setBounds(22, 12, 275, 62);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblItems = new JLabel("Items:");
		lblItems.setFont(new Font("Dialog", Font.BOLD, 20));
		lblItems.setBounds(22, 97, 140, 24);
		frame.getContentPane().add(lblItems);
		
		JList list = new JList();
		list.setBounds(32, 133, 233, 210);
		frame.getContentPane().add(list);
		
		txtBoxItemDescription = new JTextField();
		txtBoxItemDescription.setEditable(false);
		txtBoxItemDescription.setColumns(10);
		txtBoxItemDescription.setBackground(Color.WHITE);
		txtBoxItemDescription.setBounds(390, 102, 294, 248);
		frame.getContentPane().add(txtBoxItemDescription);
		
		JLabel lblItemDesc = new JLabel("Item Description:");
		lblItemDesc.setFont(new Font("Dialog", Font.BOLD, 24));
		lblItemDesc.setBounds(390, 59, 283, 34);
		frame.getContentPane().add(lblItemDesc);
		
		JButton btnUseItem = new JButton("Use Item");
		btnUseItem.setBounds(22, 403, 117, 25);
		frame.getContentPane().add(btnUseItem);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setBounds(603, 403, 117, 25);
		frame.getContentPane().add(btnGoBack);
	}
}
