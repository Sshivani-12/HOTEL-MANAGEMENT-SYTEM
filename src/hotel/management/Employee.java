package hotel.management;

import java.awt.BorderLayout;
import java.awt.*;//to change color

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;//to extract data from mysql//rs2.jar file import keli

import javax.swing.JTable;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.*;


public class Employee extends JFrame {
	Connection conn = null;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JLabel lblJob;
	private JLabel lblName;
	private JLabel lblDepartment;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee frame = new Employee();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void close()
	{
		this.dispose();
	}
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Employee() throws SQLException {
		//conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setSize(1100,600);
            setLocation(350,170);
          
          
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(0, 34, 1000, 450);
		contentPane.add(table);
		
		JButton btnLoadData = new JButton("Load Data");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
                                    conn c = new conn();
				String displayCustomersql = "select * from Employee";
				ResultSet rs = c.s.executeQuery(displayCustomersql);
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				
			}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
			
		});
		btnLoadData.setBounds(350, 500, 120, 30);
                btnLoadData.setBackground(Color.BLACK);
                btnLoadData.setForeground(Color.WHITE);
		contentPane.add(btnLoadData);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminPage().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(510, 500, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
                
                
                JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                           /* DefaultTableModel m=(DefaultTableModel) table.getModel();
                            
                            if(table.getSelectedRowCount()==1)
                            {
                               m.removeRow(table.getSelectedRow());
               JOptionPane.showMessageDialog(null, "Selected row deleted successfully");         
                                       
                                
                            }
                            else
                            {
                                if(table.getSelectedRowCount()==0)
                                {
                                    JOptionPane.showMessageDialog(null, "tableempty");
                                }
                                else
                                {
                                        JOptionPane.showMessageDialog(null, "plesase select");
                                
                                }


                           
                            }*/
                           
                            	
                            /*	try{
                                     int row=table.getSelectedRow();
                            String cell=table.getModel().getValueAt(row,0).toString();
                           
                                conn c = new conn();
				String sql = "delete * from Employee where lblNewLabel="+cell;
				ResultSet rs = c.s.executeQuery(sql);
				
                            
                            
			
                                                                      
                                     JOptionPane.showMessageDialog(null, "deleted successfully");         
                                }catch(Exception ee)
                                {
                                    JOptionPane.showMessageDialog(null, ee);         
                                    
                                }
                                
                            */
                            
                            int row = table.getSelectedRow();
DefaultTableModel model= (DefaultTableModel)table.getModel();

String selected = model.getValueAt(row, 0).toString();

            if (row >= 0) {

                model.removeRow(row);

                try {
                  
           Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3350/hrm","root","root");
                    PreparedStatement ps = conn.prepareStatement("delete from employee where Name='"+selected+"' ");
                    ps.executeUpdate();
                }
                catch (Exception w) {
                    JOptionPane.showMessageDialog(null, "Connection Error!");
                }           
            }
			}
		});
		btnDelete.setBounds(790, 500, 120, 30);
                btnDelete.setBackground(Color.BLACK);
                btnDelete.setForeground(Color.WHITE);
		contentPane.add(btnDelete);
		
		lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(41, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblJob = new JLabel("Age");
		lblJob.setBounds(159, 11, 46, 14);
		contentPane.add(lblJob);
		
		lblName = new JLabel("Gender");
		lblName.setBounds(273, 11, 46, 14);
		contentPane.add(lblName);
		
		lblDepartment = new JLabel("Job");
		lblDepartment.setBounds(416, 11, 86, 14);
		contentPane.add(lblDepartment);
                
                JLabel l1 = new JLabel("Salary");
		l1.setBounds(536, 11, 86, 14);
		contentPane.add(l1);
                
                JLabel l2 = new JLabel("Phone");
		l2.setBounds(656, 11, 86, 14);
		contentPane.add(l2);
                
                JLabel l3 = new JLabel("Aadhar");
		l3.setBounds(786, 11, 86, 14);
		contentPane.add(l3);
                
                JLabel l4 = new JLabel("Gmail");
		l4.setBounds(896, 11, 86, 14);
		contentPane.add(l4);
                
                getContentPane().setBackground(Color.WHITE);
	}
}