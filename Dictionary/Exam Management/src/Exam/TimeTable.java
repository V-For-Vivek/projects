package Exam;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TimeTable 
{
	public static void main(String args[])
	{
		tt obj = new tt();
	}
}
@SuppressWarnings("serial")
class tt extends JFrame
{
	JTable jt;
	DefaultTableModel model;
	JButton back;
	Font f;
	public tt()
	{
		setLayout(null);
		setBounds(0,0,1000,700);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		f = new Font("Times New Roman",Font.BOLD|Font.ITALIC,20);
		
		jt =new JTable();
		show_TimeTable();
		jt.setModel(model);
		jt.setFont(f);
		jt.setEnabled(false);
		int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		JScrollPane jsp = new JScrollPane(jt,v,h);
		jsp.setBounds(0,0,992,250);
		add(jsp);
		
		back = new JButton("Back");
		back.setBounds(100,300,100,30);
		add(back);
		
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				dispose();
				new M();
			}
		});
	}
	
	public ArrayList<TimeT> TimeTableList()
	{
		@SuppressWarnings({ "unchecked", "rawtypes" })
		ArrayList <TimeT> TimeTableList = new ArrayList();
		String query = "select * from time_table";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","vapking","aa");
			PreparedStatement sa = con.prepareStatement(query);
			ResultSet rs = sa.executeQuery();
			TimeT tt;
			while(rs.next())
			{
				tt = new TimeT(rs.getString("time"),rs.getInt("subcode"),rs.getString("subject"),rs.getString("scheme"),rs.getInt("date"));
				TimeTableList.add(tt);
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
		
		return TimeTableList;
	}
	
	public void show_TimeTable()
	{
		ArrayList<TimeT> list = TimeTableList();
		model =(DefaultTableModel)jt.getModel();
		String column[]={"Time","Subject Code","Subject","Scheme","Date"};
		model.setColumnIdentifiers(column);
		Object[] row = new Object[5];
		for(int i=0;i<list.size();i++)
		{
			row[0]=list.get(i).getTime();
			row[1]=list.get(i).getsubcode();
			row[2]=list.get(i).getsub();
			row[3]=list.get(i).getscheme();
			row[4]=list.get(i).getdate();
			
			model.addRow(row);
		}
	}
}
