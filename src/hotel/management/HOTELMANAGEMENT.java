/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management;
import javax.swing.*;

/**
 *
 * @author Shivani
 */
public class HOTELMANAGEMENT extends JFrame {
 HOTELMANAGEMENT(){
        setBounds(300,200,1366,565);//combination of setvisibility and location
    //setSize(400,400);
    //setLocation(300,300);
    
   ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/home.jpg")); 
//ImageIcon to take image
    
    JLabel l1=new JLabel(i1);//image la label madhe takaycha
    
    l1.setBounds(0,0,1366,565); //y axis,x axis,size
    add(l1);

 }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
  new HOTELMANAGEMENT();
    }
    
}
