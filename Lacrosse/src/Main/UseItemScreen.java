package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UseItemScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UseItemScreen window = new UseItemScreen();
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
	public UseItemScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 298);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblChooseAReserve = new JLabel("Choose a reserve to use the Item on");
		lblChooseAReserve.setBounds(43, 12, 323, 15);
		frame.getContentPane().add(lblChooseAReserve);
		
		JList listReserves = new JList();
		listReserves.setBounds(53, 39, 233, 210);
		frame.getContentPane().add(listReserves);
		
		JButton btnConfirm = new JButton("Confirm");     //ENABLE EXIT AFTER SELECTION IS MADE (CHANGE LABEL TO DISPLAY CHANGED STATS FIRST)
		btnConfirm.setBounds(387, 167, 117, 25);
		frame.getContentPane().add(btnConfirm);
		
		JLabel lblStatChange = new JLabel("STAT");
		lblStatChange.setBounds(334, 99, 233, 15);
		frame.getContentPane().add(lblStatChange);
		
		JButton btnDone = new JButton("Done");
		btnDone.setEnabled(false);
		btnDone.setBounds(471, 233, 117, 25);
		frame.getContentPane().add(btnDone);
		
		btnConfirm.addActionListener(new ActionListener() {  //Done button select action
			public void actionPerformed(ActionEvent e) {
				btnDone.setEnabled(true);
			}
		});
	}

}
