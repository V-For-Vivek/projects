package Exam;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Examinee 
{
	public static void main(String args[])
	{
		@SuppressWarnings("unused")
		examin obj = new examin();
	}
}

@SuppressWarnings("serial")
class examin extends JFrame
{
	JTable jt;
	JLabel name,enroll,seat,course;
	JTextField tname,tseat;
	@SuppressWarnings("rawtypes")
	JComboBox cbenroll,cbcourse;
	JButton edit,save,back;
	DefaultTableModel model;
	Font f;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public examin()
	{
		setLayout(null);
		setBounds(0,0,1000,700);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		f = new Font("Times New Roman",Font.BOLD|Font.ITALIC,20);
		
		jt =new JTable();
		show_student();
		jt.setModel(model);
		jt.setFont(f);
		jt.setEnabled(false);
		int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		JScrollPane jsp = new JScrollPane(jt,v,h);
		jsp.setBounds(0,0,990,250);
		add(jsp);
		
		name = new JLabel("Name :");
		enroll = new JLabel("Select EnrollMent No.to Edit :");
		seat = new JLabel("Seat No. :");
		course = new JLabel("Course");
		
		String cou[]={"CO","CR","EJ","EE","IT","ME"};
		cbcourse = new JComboBox(cou);
		cbenroll = new JComboBox();
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","vapking","aa");
			PreparedStatement sa = con.prepareStatement("select * from student");
			ResultSet rs = sa.executeQuery();
			
			while(rs.next())
			{
				cbenroll.addItem(rs.getString("enrollno"));
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
		
		tname = new JTextField();
		tseat = new JTextField();
		
		edit = new JButton("Edit");
		save = new JButton("Save");
		back = new JButton("Back");
		
		enroll.setBounds(100,300,300,30);
		enroll.setFont(f);
		add(enroll);	
		cbenroll.setBounds(500,300,200,30);
		cbenroll.setFont(f);
		add(cbenroll);
		
		name.setBounds(100,360,200,30);
		name.setFont(f);
		add(name);
		tname.setBounds(500,360,200,30);
		tname.setFont(f);
		add(tname);
		
		seat.setBounds(100,420,100,30);
		seat.setFont(f);
		add(seat);
		tseat.setBounds(500,420,200,30);
		tseat.setFont(f);
		add(tseat);
		
		course.setBounds(100,480,100,30);
		course.setFont(f);
		add(course);
		cbcourse.setBounds(500,480,100,30);
		cbcourse.setFont(f);
		add(cbcourse);

		tname.setEditable(false);
		tseat.setEditable(false);
		cbcourse.setEnabled(false);
		cbenroll.setEnabled(false);
		
		edit.setBounds(200,540,100,30);
		edit.setFont(f);
		edit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(edit);
		save.setBounds(400,540,100,30);
		save.setFont(f);
		save.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(save);
		back.setBounds(600,540,100,30);
		back.setFont(f);
		back.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(back);
		
		edit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				tname.setEditable(true);
				tseat.setEditable(true);
				cbcourse.setEnabled(true);
				cbenroll.setEnabled(true);
				
				try 
				{
					String en = (String)cbenroll.getSelectedItem();
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","vapking","aa");
					PreparedStatement sa = con.prepareStatement("select * from student where enrollno="+en+"");
					ResultSet rs = sa.executeQuery();
					
					while(rs.next())
					{
						tname.setText(rs.getString("name"));
						tseat.setText(rs.getString("seatno"));
						cbcourse.setSelectedItem(rs.getString("course"));
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
		
		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				try 
				{
					String en = (String)cbenroll.getSelectedItem();
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","vapking","aa");
					PreparedStatement sa = con.prepareStatement("update student set name=?,seatno=?,course=? where enrollno="+en+"");
					
					sa.setString(1,tname.getText());
					sa.setString(2,tseat.getText());
					sa.setString(3,(String) cbcourse.getSelectedItem());
					int count = sa.executeUpdate();
					
					if(count > 0 )
        			{
        				String imsg = "New Row Is Added !";
        				JOptionPane.showMessageDialog(null,imsg,null,JOptionPane.INFORMATION_MESSAGE);
        				sa.close();
        				con.close();
        			}
        			else
        			{
        				String emsg = "Row Is Not Added !";
        				JOptionPane.showMessageDialog(null,emsg,null,JOptionPane.ERROR_MESSAGE);
        				tname.setText("");
        				tseat.setText("");
        				dispose();
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
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				dispose();
				new M();
			}
		});
	}
	
	public ArrayList<Student> studentList()
	{
		@SuppressWarnings({ "unchecked", "rawtypes" })
		ArrayList <Student> studentList = new ArrayList();
		String query = "select * from student";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","vapking","aa");
			PreparedStatement sa = con.prepareStatement(query);
			ResultSet rs = sa.executeQuery();
			Student stud;
			while(rs.next())
			{
				stud = new Student(rs.getString("name"),rs.getLong("enrollno"),rs.getLong("seatno"),rs.getString("course"));
				studentList.add(stud);
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
		
		return studentList;
	}
	
	public void show_student()
	{
		ArrayList<Student> list = studentList();
		model =(DefaultTableModel)jt.getModel();
		String column[]={"Name","Enrollment No","Seat No","Course"};
		model.setColumnIdentifiers(column);
		Object[] row = new Object[4];
		for(int i=0;i<list.size();i++)
		{
			row[0]=list.get(i).getname();
			row[1]=list.get(i).getenrollno();
			row[2]=list.get(i).getseatno();
			row[3]=list.get(i).getcourse();
			
			model.addRow(row);
		}
	}
}