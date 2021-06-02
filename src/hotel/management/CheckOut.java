
package hotel.management;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.sql.*;//Resultset sathi
import java.awt.event.ActionListener;
import java.awt.event.*;

/**
 *
 * @author Shivani
 */
public class CheckOut extends JFrame implements ActionListener{
     Choice c1;
   
    JTextField t1;
    JButton b1,b2,b3;
    CheckOut()
    {
        
        JLabel l1 = new JLabel("Check-Out");
        l1.setForeground(Color.BLUE);
    l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
    l1.setBounds(30,20, 100, 30);
    add(l1);
    
    b3=new JButton("search");
    b3.setBackground(Color.BLACK);
    b3.setForeground(Color.WHITE);
    b3.setBounds(30,200,100,30);
    b3.addActionListener(this);
    
    add(b3);
    
    
JLabel l2 = new JLabel("Customer Id");
    l2.setFont(new Font("Tahoma", Font.PLAIN, 20));
    l2.setBounds(30,80, 140, 30);
    add(l2);

    c1 = new Choice();
                try{
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery("select * from customer");
                    while(rs.next()){
                        c1.add(rs.getString("number"));    
                    }
                }catch(Exception e){ }
                c1.setBounds(170, 82, 200, 26);
		add(c1);
                
                t1=new JTextField();
                t1.setBounds(170,122 , 200, 26);
                add(t1);
                
    b1=new JButton("Check Out");
    b1.setBackground(Color.BLACK);
    b1.setForeground(Color.WHITE);
    b1.setBounds(280,200,100,30);
    b1.addActionListener(this);
    
    add(b1);
    
    b2=new JButton("Update");
    b2.setBackground(Color.BLACK);
    b2.setForeground(Color.WHITE);
    b2.setBounds(150,200,100,30);
    b2.addActionListener(this);
    add(b2);
    
                
    JLabel l3 = new JLabel("Room No");
    l3.setFont(new Font("Tahoma", Font.PLAIN, 20));
    l3.setBounds(30,120, 200, 30);
    add(l3);

        setLayout(null);
         setBounds(530, 200, 800, 294);  
        setVisible(true);
    
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
               String id = c1.getSelectedItem();
                                String room = t1.getText();
				String str = "delete from customer where number = '"+id+"'";
                                String str2 = "update room set available = 'Available' where room = '"+room+"'";
                                
                                
				conn c = new conn();

	    		try{
	    			
	    			
	    			c.s.executeUpdate(str);
	    			c.s.executeUpdate(str2);
	    			JOptionPane.showMessageDialog(null, "Check Out Successful");
	    			new Reception().setVisible(true);
                                setVisible(false);
	    		}catch(SQLException e1){
	    			System.out.println(e1.getMessage());
	    		}
			
        }
        else if(ae.getSource()==b2)
        {
            new Reception().setVisible(true);
            this.setVisible(false);
            
        }
        else if(ae.getSource()==b3)
        {
         conn c=new conn();
         String id = c1.getSelectedItem();
         try
         {
         ResultSet rs = c.s.executeQuery("select * from customer where number = '"+id+"'");
         while(rs.next())
         {
             t1.setText(rs.getString("room"));
             
         }
         }
         catch(Exception e){}
        }
        
    }
    public static void main(String args[])
    {
        new CheckOut().setVisible(true);
    }
}
