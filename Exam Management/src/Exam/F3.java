package Exam;

import javax.swing.*;
import net.sf.jasperreports.engine.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;

public class F3 
{
	public static void main(String args[])
	{
		@SuppressWarnings("unused")
		F obj = new F();
	}
}
@SuppressWarnings("serial")
class F extends JFrame
{
	JLabel doe,date,mbq,abq,tbr;
	JTextField tdoe,tmbq,tabq,ttbr;
	JDateChooser da;	
	Font f;
	JButton save,cancle;
	
	public F()
	{
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Format 3");
		setBounds(200,100,700,500);
		setResizable(false);
		
		
		doe = new JLabel("Date of Examination :");
		date = new JLabel("Date :");
		mbq = new JLabel("Bundle Of QP Received in Morning :");
		abq = new JLabel("Bundle Of QP Received in Afternoon :");
		tbr = new JLabel("Total Bundles Received :");
		
		tdoe = new JTextField();
		tmbq = new JTextField();
		tabq = new JTextField();
		ttbr = new JTextField();
		
		da= new JDateChooser();
		da.setDateFormatString("dd/MM/yyyy");	
		
		save = new JButton("Save");
		cancle = new JButton("Cancle");
		
		f = new Font("Times New Roman",Font.BOLD|Font.ITALIC,24);
		
		doe.setBounds(200,50,250,30);
		doe.setFont(f);
		add(doe);
		tdoe.setBounds(500,50,150,30);
		tdoe.setFont(f);
		add(tdoe);
		
		tdoe.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent ke)
			{
				int key = ke.getKeyCode();
				if((key>=KeyEvent.VK_0&&key<=KeyEvent.VK_9)||(key>=KeyEvent.VK_NUMPAD0&&key<=KeyEvent.VK_NUMPAD9)||(key==KeyEvent.VK_BACK_SPACE))
				{
					tdoe.setEditable(true);
				}
				else
				{
					tdoe.setEditable(false);
				}
			}
		});
		
		date.setBounds(360,110,100,30);
		date.setFont(f);
		add(date);
		da.setBounds(500,110,150,30);
		da.setFont(f);		
		add(da);
		
		mbq.setBounds(50,170,500,30);
		mbq.setFont(f);
		add(mbq);
		tmbq.setBounds(500,170,150,30);
		tmbq.setFont(f);		
		add(tmbq);
		
		tmbq.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent ke)
			{
				int key = ke.getKeyCode();
				if((key>=KeyEvent.VK_0&&key<=KeyEvent.VK_9)||(key>=KeyEvent.VK_NUMPAD0&&key<=KeyEvent.VK_NUMPAD9)||(key==KeyEvent.VK_BACK_SPACE))
				{
					tmbq.setEditable(true);
				}
				else
				{
					tmbq.setEditable(false);
				}
			}
		});
		
		abq.setBounds(35,230,500,30);
		abq.setFont(f);
		add(abq);
		tabq.setBounds(500,230,150,30);
		tabq.setFont(f);		
		add(tabq);
		
		tabq.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent ke)
			{
				int key = ke.getKeyCode();
				if((key>=KeyEvent.VK_0&&key<=KeyEvent.VK_9)||(key>=KeyEvent.VK_NUMPAD0&&key<=KeyEvent.VK_NUMPAD9)||(key==KeyEvent.VK_BACK_SPACE))
				{
					tabq.setEditable(true);
				}
				else
				{
					tabq.setEditable(false);
				}
			}
		});
		
		tbr.setBounds(165,290,500,30);
		tbr.setFont(f);
		add(tbr);
		ttbr.setBounds(500,290,150,30);
		ttbr.setFont(f);		
		add(ttbr);
		
		ttbr.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent ke)
			{
				int key = ke.getKeyCode();
				if((key>=KeyEvent.VK_0&&key<=KeyEvent.VK_9)||(key>=KeyEvent.VK_NUMPAD0&&key<=KeyEvent.VK_NUMPAD9)||(key==KeyEvent.VK_BACK_SPACE))
				{
					ttbr.setEditable(true);
				}
				else
				{
					ttbr.setEditable(false);
				}
			}
		});
		
		save.setBounds(100,350,200,50);
		save.setFont(f);
		add(save);
		
		cancle.setBounds(400,350,200,50);
		cancle.setFont(f);		
		add(cancle);
		
		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
        	{
				
        		String save = "insert into fthree(doe,date,mbq,abq,tbr)values(?,?,?,?,?)",
        		delete="truncate fthree";
     
        		String sdate = (((JTextField) da.getDateEditor().getUiComponent()).getText());
        		
				try
        		{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","vapking","aa");
        			Statement st = con.createStatement();
        			ResultSet rs = st.executeQuery("select * from fthree");
        			
        			if(rs.next())
        			{
        				PreparedStatement del = con.prepareStatement(delete);
        				int count = del.executeUpdate();
        				
        	 			PreparedStatement sa = con.prepareStatement(save);
            			sa.setString(1,tdoe.getText());
            			sa.setString(2,sdate);
            			sa.setString(3,tmbq.getText());
            			sa.setString(4,tabq.getText());
            			sa.setString(5,ttbr.getText());
           
            			count = sa.executeUpdate();
            			
            			if(count > 0 )
            			{
            				String imsg = "New Row Is Added !";
            				JOptionPane.showMessageDialog(null,imsg,null,JOptionPane.INFORMATION_MESSAGE);
            				JasperReport  jr = JasperCompileManager.compileReport("D:\\ECP Workspace\\Exam Management\\report\\Format3.jrxml");
            				JasperPrint jp = JasperFillManager.fillReport(jr,null,con);
            				JasperExportManager.exportReportToPdfFile(jp,"D:\\ECP Workspace\\Exam Management\\PDF\\Format3.pdf");
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
            			}
        			}
        			else
        			{
        				PreparedStatement del = con.prepareStatement(delete);
        				int count = del.executeUpdate();
        				
        	 			PreparedStatement sa = con.prepareStatement(save);
            			sa.setString(1,tdoe.getText());
            			sa.setString(2,sdate);
            			sa.setString(3,tmbq.getText());
            			sa.setString(4,tabq.getText());
            			sa.setString(5,ttbr.getText());
           
            			count = sa.executeUpdate();
            			
            			if(count > 0 )
            			{
            				String imsg = "New Row Is Added !";
            				JOptionPane.showMessageDialog(null,imsg,null,JOptionPane.INFORMATION_MESSAGE);
            				JasperReport  jr = JasperCompileManager.compileReport("D:\\ECP Workspace\\Exam Management\\report\\Format3.jrxml");
            				JasperPrint jp = JasperFillManager.fillReport(jr,null,con);
            				JasperExportManager.exportReportToPdfFile(jp,"D:\\ECP Workspace\\Exam Management\\PDF\\Format3.pdf");
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
            			}        			}
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
