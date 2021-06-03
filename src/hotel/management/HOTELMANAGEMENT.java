
package hotel.management;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;//to import package inside awt

/**
 *
 * @author Shivani
 */
public class HOTELMANAGEMENT extends JFrame implements ActionListener{
 HOTELMANAGEMENT(){
 setSize(1950,1090);
	setVisible(true);      

	  // setBounds(40,200,1366,565);//combination of setvisibility and location
    //setSize(400,400);
    //setLocation(300,300);
    

// IMAGE TO BE ADDED
  

 ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950, 1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); 
	JLabel l1=new JLabel(i1);//image la label madhe takaycha
l1.setBounds(0, 0, 2010, 1000);//y axis,x axis,size
add(l1);

    
	
    
    
    
    l1.setBounds(10,10,1526,705); //y axis,x axis,size
    add(l1);
    
    JLabel l2=new JLabel("Hotel Management System");//image la label madhe takaycha
   
    l2.setBounds(120,150,900,90); //y axis,x axis,size
    l2.setForeground(Color.BLACK);//in awt packet
    
	l2.setFont(new Font("serif",Font.PLAIN,70));
    l1.add(l2);
    
    JButton b1=new JButton("Next");
    b1.setBackground(Color.BLACK);
    b1.setForeground(Color.WHITE);
    b1.setBounds(420,320,140,50);
    b1.addActionListener(this);
    
    l1.add(b1);
    
    setLayout(null);
    setVisible(true);
    
    while(true)//for blinking
    {
        l2.setVisible(false);
      
        try{
        
            Thread.sleep(500);
        }
        catch(Exception e){}
		l2.setVisible(true);
       
        try{
        Thread.sleep(500);
        }
        catch(Exception e){}
                
    }
    
    
 }
 public void actionPerformed(ActionEvent ae)//to go to next page
 {
 new Login().setVisible(true);
 }
    public static void main(String[] args) {
        // TODO code application logic here
  new HOTELMANAGEMENT();
    }
    
}
