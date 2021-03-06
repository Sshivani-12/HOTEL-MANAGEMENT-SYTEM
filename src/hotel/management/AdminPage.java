package hotel.management;

import javax.swing.*;

import java.sql.*;	
import java.awt.event.*;
import java.awt.*;

public class AdminPage extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		new AdminPage();
	}
	
	public AdminPage(){
		
                setBounds(430, 170, 900, 600);
                
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
               ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/icons/fourth.jpg"));
                Image i3 = i1.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(250,30,580,470);
                add(l1);
		
		
		JButton btnNewCustomerForm = new JButton("Add Employee");
		btnNewCustomerForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
			new AddEmployee().setVisible(true);
                                setVisible(false);
                                
			}catch(Exception e1){
				e1.printStackTrace();
			}
			}
		});
		btnNewCustomerForm.setBounds(10, 60, 200, 30);
                btnNewCustomerForm.setBackground(Color.BLACK);
                btnNewCustomerForm.setForeground(Color.WHITE);
		contentPane.add(btnNewCustomerForm);
		
		
                JButton btnNewButton_2 = new JButton("All Employee Info");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				
					Employee em = new Employee();
					em.setVisible(true);
					setVisible(false);
					
				}
				catch (Exception e1){
					e1.printStackTrace();
				}
			
			}
		});
		btnNewButton_2.setBounds(10, 140, 200, 30);                
                btnNewButton_2.setBackground(Color.BLACK);
                btnNewButton_2.setForeground(Color.WHITE);

		contentPane.add(btnNewButton_2);
		
                
		JButton btnNewButton_3 = new JButton("AddRoom");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				
					AddRoom em = new AddRoom();
					em.setVisible(true);
					setVisible(false);
					
				}
				catch (Exception e1){
					e1.printStackTrace();
				}
			
			}
		});
		btnNewButton_3.setBounds(10, 230, 200, 30);                
                btnNewButton_3.setBackground(Color.BLACK);
                btnNewButton_3.setForeground(Color.WHITE);

		contentPane.add(btnNewButton_3);
		
		
		JButton btnNewButton = new JButton("Room");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				Room room = new Room();
				room.setVisible(true);
                                setVisible(false);
				}
				catch(Exception e){
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(10, 320, 200, 30);
                btnNewButton.setBackground(Color.BLACK);
                btnNewButton.setForeground(Color.WHITE);

                
		contentPane.add(btnNewButton);
		
	
                
                
                
                
                JButton btnManagerInfo = new JButton("AddDriver");
		btnManagerInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				AddDriver mana = new AddDriver();
				mana.setVisible(true);
                                setVisible(false);
				}
				catch (Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnManagerInfo.setBounds(10, 410, 200, 30);
                btnManagerInfo.setBackground(Color.BLACK);
                btnManagerInfo.setForeground(Color.WHITE);

		contentPane.add(btnManagerInfo);
                
                
                JButton btnNewButton_4 = new JButton("Customer Info");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					//error ---------------------
					CustomerInfo customer = new CustomerInfo();
					customer.setVisible(true);				
					setVisible(false);
				}
				catch (Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_4.setBounds(10, 500, 200, 30);
                btnNewButton_4.setBackground(Color.BLACK);
                btnNewButton_4.setForeground(Color.WHITE);

		contentPane.add(btnNewButton_4);
		
		
		
		        setVisible(true);
	}
}