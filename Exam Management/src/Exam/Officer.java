package Exam;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Officer 
{
	public static void main(String args[]) throws Exception
	{
		@SuppressWarnings("unused")
		Office o = new Office();
	}
}

@SuppressWarnings("serial")
class Office extends JFrame 
{
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JTextField t6,t7;
	JComboBox cb1,cb2,cb3,cb4,cb5;
	@SuppressWarnings("unchecked")
	Office()
	{
			setVisible(true);
			setBounds(250,25,900,720);
			setResizable(false);
			setLayout(null);
			setBackground(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container c = getContentPane();
			Border bd = BorderFactory.createLineBorder(Color.BLACK);
			Font f = new Font("Times New Roman",Font.BOLD|Font.ITALIC,20);
			
			// Labels for TextField
			 l1 = new JLabel("Name of Inchrge : ");
			 l2 = new JLabel("Contact No. : ");
			 l3 = new JLabel("Name of sealing supervisor : ");
			 l4 = new JLabel("Contact No. : ");
			 l5 = new JLabel("Name of Controller : ");
			 l6 = new JLabel("Institute Name : ");
			 l7 = new JLabel("Institute Code : ");
					
			 
			 cb1 = new JComboBox();
			 cb2 = new JComboBox();
			 cb3 = new JComboBox();
			 cb4 = new JComboBox();
			 cb5 = new JComboBox();
			 
			//TextField to Enter Data
			 t6 = new JTextField();
			 t7 = new JTextField();
			
			 
			 try 
				{	
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","vapking","aa");
					PreparedStatement sa = con.prepareStatement("select * from staff");
					ResultSet rs = sa.executeQuery();
					
					while(rs.next())
					{
						cb1.addItem(rs.getString("name"));
						cb2.addItem(rs.getString("contactno"));
						cb3.addItem(rs.getString("name"));
						cb4.addItem(rs.getString("contactno"));
						cb5.addItem(rs.getString("name"));
					}
					
				} 
				catch (ClassNotFoundException e) 
				{
					e.printStackTrace();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
	
			//Buttons To Perform Action
			JButton b1 = new JButton("Save");
			JButton b2 = new JButton("Cancle");
		
							
			//Panel to add Component
			JPanel jp1 ,jp2 ,jp3;
			jp1 = new JPanel(null);
			jp1.setBorder(bd);
			jp2 = new JPanel(null);
			jp2.setBorder(bd);
			jp3 = new JPanel(null);
			jp3.setBorder(bd);
			                                
			jp1.setBounds(50,20,800,160);
			c.add(jp1);
			                                
			jp2.setBounds(50,200,800,160);
			c.add(jp2);
			                                
			jp3.setBounds(50,380,800,230);
			c.add(jp3);
					
			l1.setBounds(100,30,200,30);
			l1.setFont(f);
			jp1.add(l1);
		
			cb1.setBounds(400,30,300,30);
			cb1.setFont(f);
			jp1.add(cb1);
		
			l2.setBounds(100,100,200,30);
			l2.setFont(f);
			jp1.add(l2);
		
			cb2.setBounds(400,100,300,30);
			cb2.setFont(f);
			jp1.add(cb2);
			
			l3.setBounds(100,30,250,30);
			l3.setFont(f);
			jp2.add(l3);
		
			cb3.setBounds(400,30,300,30);
			cb3.setFont(f);
			jp2.add(cb3);
					
			l4.setBounds(100,100,200,30);
			l4.setFont(f);
			jp2.add(l4);
		
			cb4.setBounds(400,100,300,30);
			cb4.setFont(f);
			jp2.add(cb4);
			
			l5.setBounds(100,30,200,30);
			l5.setFont(f);
			jp3.add(l5);
		
			cb5.setBounds(400,30,300,30);
			cb5.setFont(f);
			jp3.add(cb5);
			
			l6.setBounds(100,100,200,30);
			l6.setFont(f);
			jp3.add(l6);
		
			t6.setBounds(400,100,300,30);
			t6.setFont(f);
			jp3.add(t6);
			
			t6.setText("Institute of Civil and Rural Engineering Collage");
			t6.setEditable(false);
			
			l7.setBounds(100,170,200,30);
			l7.setFont(f);
			jp3.add(l7);
		
			t7.setBounds(400,170,300,30);
			t7.setFont(f);
			jp3.add(t7);
		
			t7.setText("0012");
			t7.setEditable(false);
			
			b1.setBounds(200,630,100,40);
			b1.setFont(f);
			b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
			c.add(b1);
					
			b2.setBounds(600,630,100,40);
			b2.setFont(f);
			b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
			c.add(b2);				
			
				b1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae)
				{
					String save = "insert into office (noi,coi,noss,cnss,noc,ina,ic) values(?,?,?,?,?,?,?)", delete="truncate office";
            		try
					{	
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","vapking","aa");
						Statement st = con.createStatement();
            			ResultSet rs = st.executeQuery("select * from office");
						if(rs.next())
            			{
            				PreparedStatement del = con.prepareStatement(delete);
            				int count = del.executeUpdate();
            				
            	 			PreparedStatement sa = con.prepareStatement(save);
				
							sa.setString(1,(String) cb1.getSelectedItem());
							sa.setString(2,(String) cb2.getSelectedItem());
							sa.setString(3,(String) cb3.getSelectedItem());
							sa.setString(4,(String) cb4.getSelectedItem());
							sa.setString(5,(String) cb5.getSelectedItem());
							sa.setString(6,t6.getText());
							sa.setString(7,t7.getText());
							
							count = sa.executeUpdate();
							
							if(count > 0)
							{ 
								String imsg ="New Row Is Added !";
								JOptionPane.showMessageDialog(null,imsg,null,JOptionPane.INFORMATION_MESSAGE);
								st.close();
								con.close();
								new M();
								dispose();
							}
							else
							{
								String emsg ="Row Is Not Added !";
								JOptionPane.showMessageDialog(null,emsg,null,JOptionPane.ERROR_MESSAGE);
								new Office();
								dispose();
							}
						
					}
					else
					{
						
        	 			PreparedStatement sa = con.prepareStatement(save);
			
        	 			sa.setString(1,(String) cb1.getSelectedItem());
						sa.setString(2,(String) cb2.getSelectedItem());
						sa.setString(3,(String) cb3.getSelectedItem());
						sa.setString(4,(String) cb4.getSelectedItem());
						sa.setString(5,(String) cb5.getSelectedItem());
						sa.setString(6,t6.getText());
						sa.setString(7,t7.getText());
						
						int count = sa.executeUpdate();
						
						if(count > 0)
						{ 
							String imsg ="New Row Is Added !";
							JOptionPane.showMessageDialog(null,imsg,null,JOptionPane.INFORMATION_MESSAGE);
							st.close();
							con.close();
							new M();
							dispose();
						}
						else
						{
							String emsg ="Row Is Not Added !";
							JOptionPane.showMessageDialog(null,emsg,null,JOptionPane.ERROR_MESSAGE);
							new Office();
							dispose();
						}
					}
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		});
		b2.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent ae)
	       {

	          new M();
	          dispose();
	       }
	    });
	}
}