package hotel.management;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame {
 
    Dashboard()
    {
    JLabel a = new JLabel("THE TAJ GROUP WELCOMES YOU");
	a.setForeground(Color.BLACK);
        a.setFont(new Font("Tahoma", Font.PLAIN, 46));
	a.setBounds(450,300, 1000, 50);
	add(a);
	setLayout(null);
        
        setSize(1950,1090);
	setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        
        JMenuBar menu = new JMenuBar();//create menu
        setJMenuBar(menu);
        
        JMenu hotelmanagement = new JMenu("Hotel Management");
        hotelmanagement.setForeground(Color.blue);
        menu.add(hotelmanagement);
        
        JMenuItem reception=new JMenuItem(" Go  to  Reception");
        hotelmanagement.add(reception);
        
        JMenu Admin = new JMenu("ADMIN");
        Admin.setForeground(Color.RED);
	menu.add(Admin);
        
        JMenuItem Employee = new JMenuItem("ADD EMPLOYEE");
	Admin.add(Employee);
     
        
        JMenuItem Add_Rooms = new JMenuItem("ADD ROOMS");
	Admin.add(Add_Rooms);
        
        JMenuItem Add_Drivers = new JMenuItem("ADD DRIVERS");
	Admin.add(Add_Drivers);
    }
    public static void main(String[] args) {
        new Dashboard().setVisible(true);
    }
}
