package Exam;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Year
{
		public static void main(String args[])
		{
				@SuppressWarnings("unused")
				exam e = new exam();
				
		}
}

@SuppressWarnings("serial")
class exam extends JFrame 
{				
	Choice year ;
	JRadioButton r1,r2;
	ButtonGroup bg;
			exam()
			{
				setVisible(true);
				setBounds(450,250,550,250);
				ImageIcon i = new ImageIcon("user.jpg");
				setIconImage(i.getImage());
				setLayout(null);
				setResizable(false);
				setTitle("Year");
				setDefaultCloseOperation(EXIT_ON_CLOSE);
				
				//JLabel
					
					JLabel l1 = new JLabel("Exam Season : ");
					JLabel l2 = new JLabel("Exam Year: ");
				
				//Choice
					
					year = new Choice();
				
				//Button
					
					JButton b1 = new JButton("Next");
					JButton b2 = new JButton("Cancel");
			
				//Font
					
					Font f =new Font("Comic sans ms",Font.BOLD|Font.ITALIC,20);
			
			    //RadioButton
				
					r1 = new JRadioButton("Summer",true);
					r2 = new JRadioButton("Winter",false);
			
				//ButtonGroup
				
					bg = new ButtonGroup();
			
				// Container
					
					Container c = getContentPane();
						
				l1.setBounds(50,40,200,40);
				l1.setFont(f);
				c.add(l1);
				
				l2.setBounds(50,100,200,40);
				l2.setFont(f);
				c.add(l2);
				
				r1.setBounds(250,47,140,30);
				r1.setFont(f);
				c.add(r1);
				
				r2.setBounds(400,47,100,30);
				r2.setFont(f);
				c.add(r2);
				
				bg.add(r1);
				bg.add(r2);
				
				year.add("2018");
				year.add("2019");
				year.setBounds(255,100,100,40);
				year.setFont(f);
				c.add(year);
				
				b1.setBounds(100,170,100,30);
				b1.setFont(f);
				b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
				c.add(b1);
				
				b2.setBounds(300,170,100,30);
				b2.setFont(f);
				b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
				c.add(b2);
				
				b1.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ae)
					{	
						String save = "insert into year(es,ey)values(?,?)",
					    delete="truncate year";
				     
					try
	        		{
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","vapking","aa");
	        			Statement st = con.createStatement();
	        			ResultSet rs = st.executeQuery("select * from year");
	        			
	        			if(rs.next())
	        			{
	        				PreparedStatement del = con.prepareStatement(delete);
	        				int count = del.executeUpdate();
	        				
	        	 			PreparedStatement sa = con.prepareStatement(save);
	        	 			
	    					if(bg.getSelection()==r1)
	    					{
	    						sa.setString(1,r1.getActionCommand());
	    					}
	    					else
	    					{
	    						sa.setString(1,r2.getActionCommand());
	    					}
	    					
	    					sa.setString(2,year.getSelectedItem());
	    	        		
	    					count = sa.executeUpdate();
							
							if(count > 0)
							{ 
								String imsg ="New Row Is Added !";
								JOptionPane.showMessageDialog(null,imsg,null,JOptionPane.INFORMATION_MESSAGE);
								st.close();
								con.close();
								new i();
								dispose();
							}
							else
							{
								String emsg ="Row Is Not Added !";
								JOptionPane.showMessageDialog(null,emsg,null,JOptionPane.ERROR_MESSAGE);
								new exam();
								dispose();
							}
							
						}
	        			else
	        			{	
	        				PreparedStatement sa = con.prepareStatement(save);
	        	 			
	    					if(bg.getSelection()==r1)
	    					{
	    						sa.setString(1,r1.getActionCommand());
	    					}
	    					else
	    					{
	    						sa.setString(1,r2.getActionCommand());
	    					}
	    					
	    					sa.setString(2,year.getSelectedItem());
	    	        		
	    					int count = sa.executeUpdate();
							
							if(count > 0)
							{ 
								String imsg ="New Row Is Added !";
								JOptionPane.showMessageDialog(null,imsg,null,JOptionPane.INFORMATION_MESSAGE);
								st.close();
								con.close();
								new i();
								dispose();
							}
							else
							{
								String emsg ="Row Is Not Added !";
								JOptionPane.showMessageDialog(null,emsg,null,JOptionPane.ERROR_MESSAGE);
								new exam();
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
						dispose();
						new M();
					}
				});
				
			}
}