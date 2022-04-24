package Exam;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import net.sf.jasperreports.engine.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class PaperSeal	 
{
	public static void main(String args[]) throws Exception
	{
		@SuppressWarnings("unused")
		Seal s = new Seal();
	}
}
@SuppressWarnings("serial")
class Seal extends JFrame
{
	JLabel course,year,master,date,time,timeT,papercode,subabb,subject,nab,mn,so;
	JTextField tnab,tmn,tpc,tfti,ttti;
	@SuppressWarnings("rawtypes")
	JComboBox cbcourse,cbyear,cbmaster,cbsubabb,cbsub;
	Font  f;
	JDateChooser da,sd;
	JButton save,cancle;
	Connection con;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Seal() throws Exception
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","vapking","aa");
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		} 
		
		setLayout(null);
		setVisible(true);
		setTitle("Paperseal Report");
		setResizable(false);
		setBounds(200,10,1000,650);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		course = new JLabel("Course :");
		year = new JLabel("Year :");
		master = new JLabel("Master :");
		date = new JLabel("Date :");
		time = new JLabel("Time :");
		timeT = new JLabel("To :");
		papercode = new JLabel("Paper Code :");
		subabb = new JLabel("Subject Abberivation :");
		subject = new JLabel("Subject :");
		nab = new JLabel("No. of Ans. Books :");
		mn = new JLabel("Marksheet No :");
		so = new JLabel("Sealing On :");
		
		tpc = new JTextField();
		tnab = new JTextField();
		tmn = new JTextField();
		tfti = new JTextField();
		ttti = new JTextField();
		
		tfti.setText("HH:MM");
		ttti.setText("HH:MM");
		
		da= new JDateChooser();
		da.setDateFormatString("dd/MM/yyyy");	
	
		sd = new JDateChooser();
		sd.setDateFormatString("dd/MM/yyyy");
		
		save = new JButton("Save");
		cancle = new JButton("Cancle");
		
		f = new Font("Times New Roman",Font.BOLD|Font.ITALIC,20);
		
		String cou[]={"CO","CR","EJ","EE","IT","ME"};
		cbcourse = new JComboBox(cou);
		String ye[]={"1","2","3","4","5","6"};
		cbyear = new JComboBox(ye);
		String mas[]={"A","B","C","D","E","F","G","I"};
		cbmaster = new JComboBox(mas);
		
		cbsubabb = new JComboBox();
		cbsub = new JComboBox();
		
		PreparedStatement ps = con.prepareStatement("select * from subject");
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			cbsubabb.addItem(rs.getString("subabb"));
			cbsub.addItem(rs.getString("sub"));
		}
		
		
		course.setBounds(100,10,100,30);
		add(course);
		course.setFont(f);
		cbcourse.setBounds(220,10,100,30);
		cbcourse.setFont(f);
		add(cbcourse);
		
		year.setBounds(360,10,100,30);
		add(year);
		year.setFont(f);
		cbyear.setBounds(460,10,100,30);
		cbyear.setFont(f);
		add(cbyear);
		
		master.setBounds(600,10,100,30);
		add(master);
		master.setFont(f);
		cbmaster.setBounds(700,10,100,30);
		cbmaster.setFont(f);
		add(cbmaster);
		
		date.setBounds(300,70,100,30);
		date.setFont(f);
		add(date);
		da.setBounds(500,70,200,30);
		da.setFont(f);		
		add(da);
		
		
		time.setBounds(300,130,100,30);
		time.setFont(f);
		add(time);
		tfti.setBounds(500,130,100,30);
		tfti.setFont(f);
		add(tfti);
		timeT.setBounds(650,130,100,30);
		timeT.setFont(f);
		add(timeT);
		ttti.setBounds(750,130,100,30);
		ttti.setFont(f);
		add(ttti);
		
		papercode.setBounds(300,190,120,30);
		papercode.setFont(f);
		add(papercode);
		tpc.setBounds(500,190,170,30);
		tpc.setFont(f);
		add(tpc);
		
		subabb.setBounds(300,250,200,30);
		subabb.setFont(f);
		add(subabb);
		cbsubabb.setBounds(500,250,200,30);
		cbsubabb.setFont(f);
		add(cbsubabb);
		
		subject.setBounds(300,310,100,30);
		subject.setFont(f);
		add(subject);
		cbsub.setBounds(500,310,300,30);
		cbsub.setFont(f);
		add(cbsub);
		
		nab.setBounds(300,370,200,30);
		nab.setFont(f);
		add(nab);
		tnab.setBounds(500,370,200,30);
		tnab.setFont(f);
		add(tnab);
		
		mn.setBounds(300,430,180,30);
		mn.setFont(f);
		add(mn);
		tmn.setBounds(500,430,200,30);
		tmn.setFont(f);
		add(tmn);
		
		so.setBounds(300,490,130,30);
		so.setFont(f);
		add(so);
		sd.setBounds(500,490,200,30);
		sd.setFont(f);
		add(sd);
		
		save.setBounds(350,550,130,50);
		save.setFont(f);
		save.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(save);
		
		cancle.setBounds(500,550,130,50);
		cancle.setFont(f);
		cancle.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(cancle);
		
		
		tpc.addKeyListener(new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent ke)
			{
				int key = ke.getKeyCode();
				if((key>=KeyEvent.VK_0&&key<=KeyEvent.VK_9)||(key>=KeyEvent.VK_NUMPAD0&&key<=KeyEvent.VK_NUMPAD9)||(key==KeyEvent.VK_BACK_SPACE))
				{
					tpc.setEditable(true);
				}
				else
				{
					tpc.setEditable(false);
				}
			}
		});
		
		tnab.addKeyListener(new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent ke)
			{
				int key = ke.getKeyCode();
				if((key>=KeyEvent.VK_0&&key<=KeyEvent.VK_9)||(key>=KeyEvent.VK_NUMPAD0&&key<=KeyEvent.VK_NUMPAD9)||(key==KeyEvent.VK_BACK_SPACE))
				{
					tnab.setEditable(true);
				}
				else
				{
					tnab.setEditable(false);
				}
			}
		});
		
		tmn.addKeyListener(new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent ke)
			{
				int key = ke.getKeyCode();
				if((key>=KeyEvent.VK_0&&key<=KeyEvent.VK_9)||(key>=KeyEvent.VK_NUMPAD0&&key<=KeyEvent.VK_NUMPAD9)||(key==KeyEvent.VK_BACK_SPACE))
				{
					tmn.setEditable(true);
				}
				else
				{
					tmn.setEditable(false);
				}
			}
		});
		
		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
        	{
        		String save = "insert into paperseal(course,year,master,date,time,papercode,subabb,subject,nab,mn,so)values(?,?,?,?,?,?,?,?,?,?,?)",
        		delete="truncate paperseal";
        		// for Time 
        		String Time = tfti.getText()+" to "+ttti.getText();
				// for Date
        		String sdate = (((JTextField) da.getDateEditor().getUiComponent()).getText());
        		String sda = (((JTextField) sd.getDateEditor().getUiComponent()).getText());
        		
				try
        		{
        			Statement st = con.createStatement();
        			ResultSet rs = st.executeQuery("select * from paperseal");
        			
        			if(rs.next())
        			{
        				PreparedStatement del = con.prepareStatement(delete);
        				int count = del.executeUpdate();
        				
        	 			PreparedStatement sa = con.prepareStatement(save);
            			
            			sa.setString(1,(String) cbcourse.getSelectedItem());
            			sa.setString(2,(String) cbyear.getSelectedItem());
            			sa.setString(3,(String) cbmaster.getSelectedItem());
            			sa.setString(4,sdate);
            			sa.setString(5,Time);
            			sa.setString(6,tpc.getText());
            			sa.setString(7,(String) cbsubabb.getSelectedItem());
            			sa.setString(8,(String) cbsub.getSelectedItem());
            			sa.setString(9,tnab.getText());
            			sa.setString(10,tmn.getText());
            			sa.setString(11,sda);
           
            			count = sa.executeUpdate();
            			
            			if(count > 0 )
            			{
            				String imsg = "New Row Is Added !";
            				JOptionPane.showMessageDialog(null,imsg,null,JOptionPane.INFORMATION_MESSAGE);
            				JasperReport  jr = JasperCompileManager.compileReport("D:\\ECP Workspace\\Exam Management\\report\\PaperSeal.jrxml");
            				JasperPrint jp = JasperFillManager.fillReport(jr,null,con);
            				JasperExportManager.exportReportToPdfFile(jp,"D:\\ECP Workspace\\Exam Management\\PDF\\PaperSeal.pdf");
            				JOptionPane.showMessageDialog(null,"Report is Generated at :D:\\ECP Workspace\\Exam Management\\report",null,JOptionPane.INFORMATION_MESSAGE);
            				st.close();
            				con.close();
            				new M();
            				dispose();
            			}
            			else
            			{
            				String emsg = "Row Is Not Added !";
            				JOptionPane.showMessageDialog(null,emsg,null,JOptionPane.ERROR_MESSAGE);
            				new Seal();
            			}
        			}
        			else
        			{
        	 			PreparedStatement sa = con.prepareStatement(save);
            			
            			sa.setString(1,(String) cbcourse.getSelectedItem());
            			sa.setString(2,(String) cbyear.getSelectedItem());
            			sa.setString(3,(String) cbmaster.getSelectedItem());
            			sa.setString(4,sdate);
            			sa.setString(5,Time);
            			sa.setString(6,tpc.getText());
            			sa.setString(7,(String) cbsubabb.getSelectedItem());
            			sa.setString(8,(String) cbsub.getSelectedItem());
            			sa.setString(9,tnab.getText());
            			sa.setString(10,tmn.getText());
            			sa.setString(11,sda);
           
            			int count = sa.executeUpdate();
            			
            			if(count > 0 )
            			{
            				String imsg = "New Row Is Added !";
            				JOptionPane.showMessageDialog(null,imsg,null,JOptionPane.INFORMATION_MESSAGE);
            				JasperReport  jr = JasperCompileManager.compileReport("D:\\ECP Workspace\\Exam Management\\report\\PaperSeal.jrxml");
            				JasperPrint jp = JasperFillManager.fillReport(jr,null,con);
            				JasperExportManager.exportReportToPdfFile((jp),"D:\\ECP Workspace\\Exam Management\\PDF\\PaperSeal.pdf");
            				JOptionPane.showMessageDialog(null,"Report is Generated at :D:\\ECP Workspace\\Exam Management\\report",null,JOptionPane.INFORMATION_MESSAGE);
            				st.close();
            				con.close();
            				new M();
            				dispose();
            			}
            			else
            			{
            				String emsg = "Row Is Not Added !";
            				JOptionPane.showMessageDialog(null,emsg,null,JOptionPane.ERROR_MESSAGE);
            				new Seal();
            			}
        			}
        		}
        		catch(Exception e)
        		{
        			System.out.println(e);
        		}
        	}
		});
		cancle.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				dispose();
				new M();
			}
		});
		
	}
}