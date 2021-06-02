package hotel.management;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame {
 
    Dashboard()
    {
        
          
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950, 1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); 
	JLabel NewLabel = new JLabel(i3);
	NewLabel.setBounds(0, 0, 1950, 1000); 
        add(NewLabel);
		
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
        
         reception.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Reception();
            }
	});
        
        JMenu Admin = new JMenu("ADMIN");
        Admin.setForeground(Color.RED);
	menu.add(Admin);
        
        JMenuItem Employee = new JMenuItem("ADD EMPLOYEE");
	//Employee.addActionListener(this);
        Admin.add(Employee);
     
        Employee.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new AddEmployee().setVisible(true);
                }catch(Exception e ){}
            }
	});
        
        JMenuItem Add_Rooms = new JMenuItem("ADD ROOMS");
	//Add_Rooms.addActionListener(this);
        Admin.add(Add_Rooms);
        
         Add_Rooms.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new AddRoom().setVisible(true);
                }catch(Exception e ){}
            }
	});
         
         
         
        JMenuItem Add_Drivers = new JMenuItem("ADD DRIVERS");
	//Add_Drivers.addActionListener(this);
        
        Admin.add(Add_Drivers);
        
         Add_Drivers.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new AddDriver().setVisible(true);
                }catch(Exception e ){}
            }
	});
    }
    
    /*
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("RECEPTION")){
        }
        
        else if(ae.getActionCommand().equals("ADD DRIVER")){//to choose in between menus
        new AddDriver().setVisible(true);
    }
    else if(ae.getActionCommand().equals("ADD EMPLOYEE"))
    {//to open employee page
        new AddEmployee().setVisible(true);
    }
    else if(ae.getActionCommand().equals("ADD ROOM"))
    {//to open employee page
        new AddRoom().setVisible(true);
    }
    }
    */
    
    
    public static void main(String[] args) {
        new Dashboard().setVisible(true);
    }
}
