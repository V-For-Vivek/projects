package Exam;

import java.awt.Font;
import javax.swing.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.awt.event.*;
import java.io.*;
import java.sql.*;


public class ImportExcel 
{
	public static void main(String args[])
	{
    	@SuppressWarnings("unused")
		imp obj = new imp();
	}
}

@SuppressWarnings("serial")
class imp extends JFrame
{
	JButton imp1,imp2,imp3,imp4,cancel;
	Font f;
	Connection con;
	public imp()
	{
		setLayout(null);
		setTitle("Import Files");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(400,100,410,480);
			
		f = new Font("Times New Roman",Font.BOLD|Font.ITALIC,20);		

		imp1 = new JButton("Import Student Data");
		imp2 = new JButton("Import Time Table");
		imp3 = new JButton("Import Subject Details");
		imp4 = new JButton("Import Staff List");
		cancel = new JButton("Cancel");
		
		imp1.setBounds(100,50,200,50);
		add(imp1);
		imp2.setBounds(100,120,200,50);
		add(imp2);
		imp3.setBounds(100,190,200,50);
		add(imp3);
		imp4.setBounds(100,260,200,50);
		add(imp4);
		cancel.setBounds(100,330,200,50);
		add(cancel);
		
		imp1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				
				try 
				{
					String query ="insert into student(name,enrollno,seatno,course) values(?,?,?,?)";
					
					Class.forName("com.mysql.jdbc.Driver");
					
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","vapking","aa");
					
					PreparedStatement sa = con.prepareStatement(query);
					
					JFileChooser jf = new JFileChooser();
					
					jf.setDialogTitle("Please Select the Excel File");
					
					int result = jf.showOpenDialog(null);
					
					if(result == JFileChooser.APPROVE_OPTION)
					{
						String excelpath = jf.getSelectedFile().getAbsolutePath();
						
						FileInputStream fs = new FileInputStream(new File(excelpath));
						
						@SuppressWarnings("resource")
						
						XSSFWorkbook wb = new XSSFWorkbook(fs);
						
						XSSFSheet sh = wb.getSheet("Sheet1");
						
						int tnr = sh.getLastRowNum();
						
						Row row;
						
						int count = 0;
						
						System.out.println(tnr);
						
						for(int i = 1;i<=tnr;i++)
						{
							row = sh.getRow(i);
					
							sa.setString(1,row.getCell(0).toString());
							sa.setLong(2,(long) row.getCell(1).getNumericCellValue());
							sa.setLong(3,(long) row.getCell(2).getNumericCellValue());
							sa.setString(4,row.getCell(3).toString());
							
							count = sa.executeUpdate();	
						}
							if(count >0)
							{ 
								String imsg ="New Row Is Added !";
								JOptionPane.showMessageDialog(null,imsg,null,JOptionPane.INFORMATION_MESSAGE);
								sa.close();
								con.close();
							}
							else
							{
								String emsg ="Row Is Not Added !";
								JOptionPane.showMessageDialog(null,emsg,null,JOptionPane.ERROR_MESSAGE);
							}			
					}
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}	
		});
		
		imp2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				
				try 
				{
					String query ="insert into time_table(time,subcode,subject,scheme) values(?,?,?,?)";
					
					Class.forName("com.mysql.jdbc.Driver");
					
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","vapking","aa");
					
					PreparedStatement sa = con.prepareStatement(query);
					
					JFileChooser jf = new JFileChooser();
					
					jf.setDialogTitle("Please Select the Excel File");
					
					int result = jf.showOpenDialog(null);
					
					if(result == JFileChooser.APPROVE_OPTION)
					{
						String excelpath = jf.getSelectedFile().getAbsolutePath();
						
						FileInputStream fs = new FileInputStream(new File(excelpath));
						
						@SuppressWarnings("resource")
						
						XSSFWorkbook wb = new XSSFWorkbook(fs);
						
						XSSFSheet sh = wb.getSheet("Sheet1");
						
						int tnr = sh.getLastRowNum();
						
						Row row;
						
						int count = 0;
						
						System.out.println(tnr);
						
						for(int i = 1;i<=tnr;i++)
						{
							row = sh.getRow(i);
					
							sa.setInt(1,(int) row.getCell(0).getNumericCellValue());
							sa.setInt(2,(int)row.getCell(1).getNumericCellValue());
							sa.setString(3,row.getCell(2).toString());
							sa.setString(4,row.getCell(3).toString());
							sa.setInt(4,(int) row.getCell(3).getNumericCellValue());
							
							count = sa.executeUpdate();	
						}
							if(count >0)
							{ 
								String imsg ="New Row Is Added !";
								JOptionPane.showMessageDialog(null,imsg,null,JOptionPane.INFORMATION_MESSAGE);
								sa.close();
								con.close();
							}
							else
							{
								String emsg ="Row Is Not Added !";
								JOptionPane.showMessageDialog(null,emsg,null,JOptionPane.ERROR_MESSAGE);
							}			
					}
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		});
		
		imp3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				
				try 
				{
					String query ="insert into subject(subcode,sub,subabb)values(?,?,?)";
					
					Class.forName("com.mysql.jdbc.Driver");
					
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","vapking","aa");
					
					PreparedStatement sa = con.prepareStatement(query);
					
					JFileChooser jf = new JFileChooser();
					
					jf.setDialogTitle("Please Select the Excel File");
					
					int result = jf.showOpenDialog(null);
					
					if(result == JFileChooser.APPROVE_OPTION)
					{
						String excelpath = jf.getSelectedFile().getAbsolutePath();
						
						FileInputStream fs = new FileInputStream(new File(excelpath));
						
						@SuppressWarnings("resource")
						
						XSSFWorkbook wb = new XSSFWorkbook(fs);
						
						XSSFSheet sh = wb.getSheet("Sheet1");
						
						int tnr = sh.getLastRowNum();
						
						Row row;
						
						int count = 0;
						
						System.out.println(tnr);
						
						for(int i = 1;i<=tnr;i++)
						{
							row = sh.getRow(i);
					
							sa.setInt(1,(int) row.getCell(0).getNumericCellValue());
							sa.setString(2,row.getCell(1).toString());
							sa.setString(3,row.getCell(2).toString());
							
							count = sa.executeUpdate();	
						}
							if(count >0)
							{ 
								String imsg ="New Row Is Added !";
								JOptionPane.showMessageDialog(null,imsg,null,JOptionPane.INFORMATION_MESSAGE);
								sa.close();
								con.close();
							}
							else
							{
								String emsg ="Row Is Not Added !";
								JOptionPane.showMessageDialog(null,emsg,null,JOptionPane.ERROR_MESSAGE);
							}			
					}
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		});
		
		imp4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				
				try 
				{
					String query ="insert into staff(name,contactno) values(?,?)";
					
					Class.forName("com.mysql.jdbc.Driver");
					
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","vapking","aa");
					
					PreparedStatement sa = con.prepareStatement(query);
					
					JFileChooser jf = new JFileChooser();
					
					jf.setDialogTitle("Please Select the Excel File");
					
					int result = jf.showOpenDialog(null);
					
					if(result == JFileChooser.APPROVE_OPTION)
					{
						String excelpath = jf.getSelectedFile().getAbsolutePath();
						
						FileInputStream fs = new FileInputStream(new File(excelpath));
						
						@SuppressWarnings("resource")
						
						XSSFWorkbook wb = new XSSFWorkbook(fs);
						
						XSSFSheet sh = wb.getSheet("Sheet1");
						
						int tnr = sh.getLastRowNum();
						
						Row row;
						
						int count = 0;
						
						System.out.println(tnr);
						
						for(int i = 1;i<=tnr;i++)
						{
							row = sh.getRow(i);
					
							sa.setString(1,row.getCell(0).toString());
							sa.setInt(2,(int) row.getCell(1).getNumericCellValue());
							
							count = sa.executeUpdate();	
						}
							if(count >0)
							{ 
								String imsg ="New Row Is Added !";
								JOptionPane.showMessageDialog(null,imsg,null,JOptionPane.INFORMATION_MESSAGE);
								sa.close();
								con.close();
							}
							else
							{
								String emsg ="Row Is Not Added !";
								JOptionPane.showMessageDialog(null,emsg,null,JOptionPane.ERROR_MESSAGE);
							}			
					}
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		});
		
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				dispose();
				new M();
			}
		});
	}
}
