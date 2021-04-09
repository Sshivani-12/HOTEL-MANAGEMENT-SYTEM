package hotel.management;

import java.awt.BorderLayout;
import java.awt.*;

import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchRoom extends JFrame implements ActionListener {

        JComboBox c1;
        JCheckBox c2;
        JButton b1,b2;
	JTable t1;
        SearchRoom(){
        t1=new JTable();
        
        JLabel l1=new JLabel ("Search for room");
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        l1.setBounds(400,30,200,30);
        add(l1);
        
        JLabel l2=new JLabel ("Room Bed Type");
        l2.setBounds(50,100,100,20);
        add(l2);
        
        c1=new JComboBox(new String[]{"Single Bed","Double Bed"});
        c1.setBounds(200,100,150,25);
        c1.setBackground(Color.WHITE);
        add(c1);
        
        c2=new JCheckBox("Only display Available");
        c2.setBounds(600,100,150,25);
        add(c2);
        
        t1=new JTable();
        t1.setBounds(0,200,1000,300);
        add(t1);
        
          b1=new JButton("Submit");
                b1.setBackground(Color.BLACK);
                b1.setForeground(Color.WHITE);
                b1.setBounds(350,520,120,30);
                b1.addActionListener(this);
                add(b1);
                
                  b2=new JButton("Back");
                b2.setBackground(Color.BLACK);
                b2.setForeground(Color.WHITE);
                b2.setBounds(500,520,120,30);
                b2.addActionListener(this);
                add(b2);
                
                JLabel lblSearchForRoom = new JLabel("Search For Room");
		lblSearchForRoom.setBounds(45, 160, 100, 20);
		add(lblSearchForRoom);
		
		JLabel lblRoomAvailable = new JLabel("Cleaning Ststus");
		lblRoomAvailable.setBounds(485, 160, 100, 20);
		add(lblRoomAvailable);
		
		
		JLabel lblRoomAvailable_1 = new JLabel("Availability");
		lblRoomAvailable_1.setBounds(265, 162, 100, 20);
		add(lblRoomAvailable_1);
		
		JLabel lblPrice_1 = new JLabel("Price");
		lblPrice_1.setBounds(695, 162, 100, 20);
		add(lblPrice_1);
                
                JLabel l11 = new JLabel("Bed Type");
		l11.setBounds(895, 162, 100, 20);
		add(l11);
                
                
                
        setLayout(null);
        setBounds(500,200,1000,650);
        setVisible(true);
        }
        
        public void actionPerformed(ActionEvent ae)
        {
        if(ae.getSource()==b1){
        try{
            String str = "select * from room where bed_type = '"+c1.getSelectedItem()+"'";
            String str2 = "select * from room where available = 'Available' AND bed_type = '"+c1.getSelectedItem()+"'";
            conn c=new conn();
            ResultSet rs = c.s.executeQuery(str);
            t1.setModel(DbUtils.resultSetToTableModel(rs));
            
            if(c2.isSelected())
				{	
					rs = c.s.executeQuery(str2);
					t1.setModel(DbUtils.resultSetToTableModel(rs));
				}
            else
            {
            	rs = c.s.executeQuery(str);
		t1.setModel(DbUtils.resultSetToTableModel(rs));
		
            }
        }
        catch(Exception e){}
            
        }
        else if(ae.getSource()==b2)
        {
        new Reception().setVisible(true);
        this.setVisible(false);
        }
        }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
        new SearchRoom().setVisible(true);
        }

}