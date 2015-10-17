package application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import java.util.List;


import model.V1.DateInt;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;


public class Frame1 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JDateChooser dp = new JDateChooser();
	private JComboBox unitsAvailable = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
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
	public Frame1() {
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
		
		JLabel lblReservationBungalows = new JLabel("Reservation bungalows");
		lblReservationBungalows.setBounds(0, 0, 434, 14);
		frame.getContentPane().add(lblReservationBungalows);
		
		JLabel lblFromDate = new JLabel("From date : ");
		lblFromDate.setBounds(24, 30, 76, 14);
		frame.getContentPane().add(lblFromDate);
		
		JLabel lblNumberOfNights = new JLabel("Number of nights :");
		lblNumberOfNights.setBounds(24, 55, 95, 14);
		frame.getContentPane().add(lblNumberOfNights);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int numbernights = Integer.parseInt(textField_2.getText());
					model.Date date = (model.Date) dp.getDate();
					
					ReservationService rs = new ReservationService();
						List<House> houselist = rs.getAvailableHouses(date, numbernights);
						for(House h : houselist){
							unitsAvailable.addItem(h.toString());
						}
						}
						
					
					
					
							
				 catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					// exception met delegate in ander scherm
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setBounds(297, 67, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblUnitsAvailable = new JLabel("Units Available");
		lblUnitsAvailable.setBounds(26, 92, 93, 14);
		frame.getContentPane().add(lblUnitsAvailable);
		
		unitsAvailable = new JComboBox();
		unitsAvailable.setBounds(140, 89, 125, 20);
		frame.getContentPane().add(unitsAvailable);
		
		JLabel lblLastNa = new JLabel("Last Name Tennant");
		lblLastNa.setBounds(24, 137, 110, 14);
		frame.getContentPane().add(lblLastNa);
		
		textField = new JTextField();
		textField.setBounds(140, 134, 142, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("First name tennant");
		lblNewLabel.setBounds(24, 172, 95, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(140, 169, 142, 20);
		frame.getContentPane().add(textField_1);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.setBounds(297, 209, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(138, 52, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		dp = new JDateChooser();
		dp.setBounds(140, 21, 125, 23);
		frame.getContentPane().add(dp);
	}
}
