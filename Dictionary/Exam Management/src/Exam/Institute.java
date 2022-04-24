package Exam;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.sql.*;

public class Institute 
{
    public static void main(String args[])
	{
    	@SuppressWarnings("unused")
		i institute = new i();
	}
}

@SuppressWarnings("serial")
class i extends JFrame
{
	 JLabel l1,l2,l3,l4,l5,l6;
	 JTextField t1,t2,t3,t4,t5,t6;
	i()
	{
		
        setVisible(true);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(250,50,900,630);

		//Font
		
           Font f = new Font("Times New Roman",Font.BOLD|Font.ITALIC,24);
		
       //Label
			
            l1 = new JLabel("Enter Your Name :");
            l2 = new JLabel("Institute Code :");
            l3 = new JLabel("Institute Address :");
            l4 = new JLabel("Institute Phone Number :");
            l5 = new JLabel("Principal Name :");
            l6 = new JLabel("Contact Number :");
        
		 // Text area for input
		 
           t1 = new JTextField();
           t2 = new JTextField();
           t3 = new JTextField();
           t4 = new JTextField();
           t5 = new JTextField();
           t6 = new JTextField(); 
        
        // Buttons For Action
           
           JButton b1 = new JButton("Next");
           JButton b2 = new JButton("Cancel");
           
           
		 //input objects
           
		    l1.setBounds(100,40,200,30);
			l1.setFont(f);
			add(l1);
			t1.setBounds(450,40,300,30);
			t1.setFont(f);
			add(t1);
			t1.addKeyListener(new KeyAdapter(){
				public void keyPressed(KeyEvent ke)
				{
					char c = ke.getKeyChar();
					if(Character.isLetter(c)||Character.isWhitespace(c)||Character.isISOControl(c)||ke.getKeyChar()==KeyEvent.VK_PERIOD)
					{
						t1.setEditable(true);
					}
					else
					{
						t1.setEditable(false);
					}
				}
			});
			l2.setBounds(100,110,200,30);
			l2.setFont(f);
            add(l2);
			t2.setBounds(450,110,300,30);
			t2.setFont(f);
			add(t2);
			t2.setText("0012");
			t2.setEditable(false);
			
            l3.setBounds(100,180,200,30);
            l3.setFont(f);
            add(l3);
            t3.setBounds(450,180,300,30);
            t3.setFont(f);
			add(t3);
            
			l4.setBounds(100,250,300,30);
            l4.setFont(f);
            add(l4);
            t4.setBounds(450,250,300,30);
            t4.setFont(f);
            add(t4);
            t4.setText("1234567890");
			t4.setEditable(false);
            
            l5.setBounds(100,320,200,30);
            l5.setFont(f);
            add(l5);
            t5.setBounds(450,320,300,30);
            t5.setFont(f);
            add(t5);
            t5.addKeyListener(new KeyAdapter(){
				public void keyPressed(KeyEvent ke)
				{
					char c = ke.getKeyChar();
					if(Character.isLetter(c)||Character.isWhitespace(c)||Character.isISOControl(c)||ke.getKeyChar()==KeyEvent.VK_PERIOD)
					{
						t5.setEditable(true);
					}
					else
					{
						t5.setEditable(false);
					}
				}
			});
            
            l6.setBounds(100,390,200,30);
            l6.setFont(f);
            add(l6);
            t6.setBounds(450,390,300,30);
            t6.setFont(f);
            add(t6);
            t6.addKeyListener(new KeyAdapter(){
				public void keyPressed(KeyEvent ke)
				{
					String  pn = t6.getText();
					int length = pn.length();
					
					if(ke.getKeyChar()>='0' && ke.getKeyChar()<='9')
					{
						if(length<10)
						{
							t6.setEditable(true);
						}
						else
						{
							t6.setEditable(false);
						}
					}
					else
					{
						if(ke.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || ke.getExtendedKeyCode()==KeyEvent.VK_DELETE)
						{
							t6.setEditable(true);
						}
						else
						{
							t6.setEditable(false);
						}
					}
				}
			});
            
            b1.setBounds(200,500,150,40);
            b1.setFont(f);
            b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
            add(b1);
            b2.setBounds(480,500,150,40);
            b2.setFont(f);
            b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
            add(b2);
            
            b1.addActionListener(new ActionListener(){
            	public void actionPerformed(ActionEvent ae)
            	{
            		String save = "insert into institute (eyn,inc,ina,ipn,pn,cn) values(?,?,?,?,?,?)", delete="truncate institute";
            		
            		try
            		{
            			Class.forName("com.mysql.jdbc.Driver");
            			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","vapking","aa");
            			Statement st = con.createStatement();
            			ResultSet rs = st.executeQuery("select * from institute");
            			
            			if(rs.next())
            			{
            				PreparedStatement del = con.prepareStatement(delete);
            				int count = del.executeUpdate();
            				
            	 			PreparedStatement sa = con.prepareStatement(save);
            	 			
	            			sa.setString(1,t1.getText());
	            			sa.setString(2,t2.getText());
	            			sa.setString(3,t3.getText());
	            			sa.setString(4,t4.getText());
	            			sa.setString(5,t5.getText());
	            			sa.setString(6,t6.getText());
	            			
	            			count = sa.executeUpdate();
	            			
	            			if(count > 0 )
	            			{
	            				String imsg = "New Row Is Added !";
	            				JOptionPane.showMessageDialog(null,imsg,null,JOptionPane.INFORMATION_MESSAGE);
	            				st.close();
	            				con.close();
	            				new Office();
	            				dispose();
	            			}
	            			else
	            			{
	            				String emsg = "Row Is Not Added !";
	            				JOptionPane.showMessageDialog(null,emsg,null,JOptionPane.ERROR_MESSAGE);
	            				new i();
	            				dispose();
	            			}
	            		}
            			else
            			{
            				PreparedStatement sa = con.prepareStatement(save);
            	 			
	            			sa.setString(1,t1.getText());
	            			sa.setString(2,t2.getText());
	            			sa.setString(3,t3.getText());
	            			sa.setString(4,t4.getText());
	            			sa.setString(5,t5.getText());
	            			sa.setString(6,t6.getText());
	            			
	            			int count = sa.executeUpdate();
	            			
	            			if(count > 0 )
	            			{
	            				String imsg = "New Row Is Added !";
	            				JOptionPane.showMessageDialog(null,imsg,null,JOptionPane.INFORMATION_MESSAGE);
	            				st.close();
	            				con.close();
	            				new Office();
	            				dispose();
	            			}
	            			else
	            			{
	            				String emsg = "Row Is Not Added !";
	            				JOptionPane.showMessageDialog(null,emsg,null,JOptionPane.ERROR_MESSAGE);
	            				new i();
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
