package hotel.management;


import java.awt.EventQueue;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class AddEmployee extends JFrame{ //Third Frame

    
	JTextField t1,t2,t3,t4,t5,t6;
        JComboBox c1;

        public AddEmployee(){
            getContentPane().setForeground(Color.BLUE);
            getContentPane().setBackground(Color.WHITE);
            setTitle("ADD EMPLOYEE DETAILS");
		 
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setSize(778,486);
            getContentPane().setLayout(null);
			
            JLabel Passportno = new JLabel("NAME");
            Passportno.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Passportno.setBounds(60, 30, 150, 27);
            add(Passportno);
            
            t1 = new JTextField();
            t1.setBounds(200, 30, 150, 27);
            add(t1);
			
            JButton Next = new JButton("SAVE");
            Next.setBounds(200, 420, 150, 30);
            Next.setBackground(Color.BLACK);
            Next.setForeground(Color.WHITE);
            add(Next);
			
            JLabel Pnrno = new JLabel("AGE");
            Pnrno.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Pnrno.setBounds(60, 80, 150, 27);
            add(Pnrno);
			
            t2 = new JTextField();
            t2.setBounds(200, 80, 150, 27);
            add(t2);
            
            JLabel Gender = new JLabel("GENDER");
            Gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Gender.setBounds(60, 120, 150, 27);
            add(Gender);
		
            JRadioButton NewRadioButton = new JRadioButton("MALE");
            NewRadioButton.setBackground(Color.WHITE);
            NewRadioButton.setBounds(200, 120, 90, 27);
            add(NewRadioButton);
	
            JRadioButton Female = new JRadioButton("FEMALE");
            Female.setBackground(Color.WHITE);
            Female.setBounds(290, 120, 90, 27);
            add(Female);
            
            
            JLabel Address = new JLabel("JOB");
            Address.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Address.setBounds(60, 170, 150, 27);
            add(Address);
			
            String course[] = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
            c1 = new JComboBox(course);
            c1.setBackground(Color.WHITE);
            c1.setBounds(200,170,150,30);
            add(c1);
            		
            JLabel Nationality = new JLabel("SALARY");
            Nationality.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Nationality.setBounds(60, 220, 150, 27);
            add(Nationality);
			
            t3 = new JTextField();
            t3.setBounds(200, 220, 150, 27);
            add(t3);
	
            JLabel Name = new JLabel("PHONE");
            Name.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Name.setBounds(60, 270, 150, 27);
            add(Name);
	
            t4 = new JTextField();
            t4.setBounds(200, 270, 150, 27);
            add(t4);
	
            JLabel aadhar = new JLabel("AADHAR");
            aadhar.setFont(new Font("Tahoma", Font.PLAIN, 17));
            aadhar.setBounds(60, 320, 150, 27);
            add(aadhar);
			
            t5 = new JTextField();
            t5.setBounds(200, 320, 150, 27);
            add(t5);
	
            
            JLabel email = new JLabel("EMAIL");
            email.setFont(new Font("Tahoma", Font.PLAIN, 17));
            email.setBounds(60, 370, 150, 27);
            add(email);
			
            t6 = new JTextField();
            t6.setBounds(200, 370, 150, 27);
            add(t6);
	
            setVisible(true);
	
            JLabel Add = new JLabel("ADD EMPLOYEE DETAILS");
            Add.setForeground(Color.BLUE);
            Add.setFont(new Font("Tahoma", Font.PLAIN, 31));
            Add.setBounds(450, 24, 442, 35);
            add(Add);
			
     
           
             ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/icons/tenth.jpg"));
            Image i3 = i1.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT);
            ImageIcon i2 = new ImageIcon(i3);
            JLabel image = new JLabel(i2);
            image.setBounds(410,80,480,410);
            add(image);

            Next.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    String name = t1.getText();
                    String age = t2.getText();
                    String salary = t3.getText();
                    String phone = t4.getText();
                    String aadhar = t5.getText();
                    String email = t6.getText();
                   
				    String gender = null;
                    
                    if(NewRadioButton.isSelected()){
                        gender = "male";
                    
                    }else if(Female.isSelected()){
                        gender = "female";
                    }

                            
                    String s6 = (String)c1.getSelectedItem();
                    
                    try {
						
				if(t4.getText().length()!=10)
                                {
                                    JOptionPane.showMessageDialog(null, "Oops!Phone no should be of 10 digit");
                                }
                                
                                if(t5.getText().length()!=12)
                                {
                                    JOptionPane.showMessageDialog(null, "Oops!Phone no should be of 12 digit");
                                }
                                
                                
				if(t1.getText().length() == 0 || t2.getText().length() == 0 ||t3.getText().length() == 0 || t4.getText().length() == 0|| t5.getText().length() == 0 || t6.getText().length() == 0 )
			  {
            //notify user that mandatory field is empty.
				
				JOptionPane.showMessageDialog(null, "Oops!Add details of Employee");
				}
               else
			   {
                        conn c = new conn();
                        String str = "INSERT INTO employee values( '"+name+"', '"+age+"', '"+gender+"','"+s6+"', '"+salary+"', '"+phone+"','"+aadhar+"', '"+email+"')";
                        
                        c.s.executeUpdate(str);
                        JOptionPane.showMessageDialog(null,"Employee Added");
                        setVisible(false);
			   }
                    } catch (Exception e) {
                        e.printStackTrace();
        	    }
		}
            });
			
            setSize(900,600);
            setVisible(true);
            setLocation(430,170);
			
	}
        
    public static void main(String[] args){
        new AddEmployee();
    }   
}