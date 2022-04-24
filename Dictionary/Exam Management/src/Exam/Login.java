package Exam;

import java.awt.Cursor;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login 
{
	public static void main(String args[])
	{
		@SuppressWarnings("unused")
		verify obj = new verify();
	}
}

@SuppressWarnings("serial")
class verify extends JFrame
{
	JLabel user,pass;
	JTextField tuser,tpass;
	JButton log,cancel;
	Font f;
	
	
	public verify()
	{
		setLayout(null);
		setVisible(true);
		setBounds(400,200,480,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		f = new Font("Times New Roman",Font.BOLD|Font.ITALIC,20);
		
		user = new JLabel("UserName :");
		pass = new JLabel("Password :");
		
		tuser = new JTextField();
		tpass = new JTextField();
		
		log = new JButton("Login");
		cancel = new JButton("Cancel");
		
		user.setBounds(50,30,100,30);
		user.setFont(f);
		add(user);
		tuser.setBounds(200,30,200,30);
		tuser.setFont(f);
		add(tuser);
	
		tuser.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent ke)
			{
				char c = ke.getKeyChar();
				if(Character.isAlphabetic(c)||Character.isLetter(c)||Character.isDigit(c)||Character.isISOControl(c)||ke.getKeyCode()==KeyEvent.VK_SHIFT||ke.getKeyCode()==KeyEvent.VK_ASTERISK)
				{
					tuser.setEditable(true);
				}
				else
				{
					tuser.setEditable(false);
				}
			}
		});
		
		pass.setBounds(50,100,100,30);
		pass.setFont(f);
		add(pass);
		tpass.setBounds(200,100,200,30);
		tpass.setFont(f);
		add(tpass);
		
		tpass.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent ke)
			{
				char c = ke.getKeyChar();
				if(Character.isAlphabetic(c)||Character.isLetter(c)||Character.isDigit(c)||Character.isISOControl(c))
				{
					tpass.setEditable(true);
				}
				else
				{
					tpass.setEditable(false);
				}
			}
		});
		
		log.setBounds(100,170,100,30);
		log.setFont(f);
		log.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(log);
		cancel.setBounds(230,170,100,30);
		cancel.setFont(f);
		cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(cancel);
		
		log.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				String query ="select * from login";
				try 
				{
					Class.forName("com.mysql.jdbc.Driver");
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","vapking","aa");
					
					PreparedStatement log = con.prepareStatement(query);
					
					ResultSet rs = log.executeQuery();
					
					rs.next();
					
					String suser = rs.getString("username");
					String spass = rs.getString("password");
					
					
					if(suser.equalsIgnoreCase(tuser.getText()) && spass.equalsIgnoreCase(tpass.getText()))
					{
						new M();
						dispose();
					}
					else
					{
						String msg = "Username or Password is Worng !";
						JOptionPane.showMessageDialog(null,msg,null,JOptionPane.ERROR_MESSAGE);
						tuser.setText("");
						tpass.setText("");
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
			}
		});
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				dispose();
			}
		});
	}
}