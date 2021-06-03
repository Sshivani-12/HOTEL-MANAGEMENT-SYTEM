
package hotel.management;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;


public class Admin extends JFrame implements ActionListener{
    JLabel l1,l2;//to access outside constructor
    JTextField t1;
    JButton b1,b2;
    JPasswordField t2; 
	JFrame j;
    Admin()
    {
       
        l1=new JLabel("Username");
        l1.setBounds(60,60,100,30);
        add(l1);
        setLayout(null);
        
        l1=new JLabel("Password");
        l1.setBounds(60,120,100,30);//(x ditance,y distance,width,ht)
        add(l1);
        setLayout(null);
        
        
      t1=new JTextField();
      t1.setBounds(180,60,150,30);
      add(t1);
     
      t2=new JPasswordField();
      t2.setBounds(180,120,150,30);
      add(t2);
     
	 ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/icons/login.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(500,50,150,150);
        add(l3);
        
        
        
      b1=new JButton("Login");
      b1.setBackground(Color.BLACK);
      b1.setForeground(Color.WHITE) ;
      b1.setBounds(40,200,110,30);
      b1.addActionListener(this);
      add(b1);
      
      b2=new JButton("Cancel");
      b2.setBackground(Color.BLACK);
      b2.setForeground(Color.WHITE) ;
      b2.setBounds(270,200,110,30);
      b2.addActionListener(this);
      add(b2);
      
     //setContentPane().setBackground(Color.WHITE);
       setVisible(true);
        setSize(840,300);
        setLocation(300,150);

          
     setVisible(true);
    }
 
public void actionPerformed(ActionEvent ae)//to go to next page
 {

    if(ae.getSource()==b1)
    {
       String username= t1.getText();
       String password= t2.getText();
	   
       conn c =new conn();
        
       String str="select * from admin where username= '"+username+"' and password='"+password+"'";
       try
       {
       ResultSet rs=c.s.executeQuery(str); 
       if(rs.next())
       {
           
        new AdminPage().setVisible(true);
        this.setVisible(false);
       }
       else
       {
       JOptionPane.showMessageDialog(null,"Please enter correct username and password");
       this.setVisible(false);
       
       }
       }
       
       catch(Exception e)
       {
           
       }
    }
    else if(ae.getSource()==b2)
    {
    System.exit(0);
    }
 }
 
    public static void main(String args[])
    {
        new Admin();
    }
}
