package Exam;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;

public class Main 
{
	public static void main(String args[])
	{
		@SuppressWarnings("unused")
		M obj = new M();
	}
}
@SuppressWarnings("serial")
class M extends JFrame
{
	
	JLabel background;
	JMenu II,rg,Man,st,ed;
	JMenuItem logout,impexcel,f3,paperseal,fillII,esn,ttd;
	Font f;
	ImageIcon ii = new ImageIcon("D:\\ECP Workspace\\Exam Management\\image\\12-08-2016-16-25-18-i c r e (1).jpg");
	
	public M()
	{
		setLayout(null);
		setVisible(true);
		setTitle("Main");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(0,0,1000,700);
		
		background = new JLabel(ii);
		background.setBounds(0,0,1000,700);
		add(background);
		
		JMenuBar mbr = new JMenuBar();
		
		//Menu
		
		f = new Font("Times New Roman",Font.BOLD|Font.ITALIC,20);
		
		II = new JMenu("Institute Information");
		II.setFont(f);
		rg = new JMenu("Report Generation");
		rg.setFont(f);
		st = new JMenu("System Tool");
		st.setFont(f);
		Man = new JMenu("Manual");
		Man.setFont(f);
		ed = new JMenu("Exam/Examinee Details");
		ed.setFont(f);
		
		//Menu Item
		impexcel = new JMenuItem("Import Excel File");
		impexcel.setFont(f);
		f3 = new JMenuItem("Format 3");
		f3.setFont(f);
		paperseal = new JMenuItem("PaperSeal");
		paperseal.setFont(f);
		fillII = new JMenuItem(" Fill Institute Information");
		fillII.setFont(f);
		logout = new JMenuItem("Logout");
		logout.setFont(f);
		ttd = new JMenuItem("Time Table Details");
		ttd.setFont(f);
		esn = new JMenuItem("Examinee Seat No. Entry/Edit");
		esn.setFont(f);
	
		mbr.add(II);
		mbr.add(ed);
		mbr.add(rg);
		mbr.add(st);
		mbr.add(logout);
		
		rg.add(Man);
		II.add(fillII);
		st.add(impexcel);
		Man.add(f3);
		Man.add(paperseal);
		ed.add(ttd);
		ed.add(esn);
		
		fillII.addActionListener(new ActionListener(){
			public  void actionPerformed(ActionEvent ae)
			{
				new exam();
				dispose();
			}
		});
		impexcel.addActionListener(new ActionListener(){
			public  void actionPerformed(ActionEvent ae)
			{
				new imp();
				dispose();
			}
		});
		f3.addActionListener(new ActionListener(){
			public  void actionPerformed(ActionEvent ae)
			{
				new F();
				dispose();
			}
		});
		paperseal.addActionListener(new ActionListener(){
			public  void actionPerformed(ActionEvent ae)
			{
				try 
				{
					new Seal();
				} 
				catch(Exception e) 
				{
					e.printStackTrace();
				}
				dispose();
			}
		});
		ttd.addActionListener(new ActionListener(){
			public  void actionPerformed(ActionEvent ae)
			{
				new tt();
				dispose();
			}
		});
		esn.addActionListener(new ActionListener(){
			public  void actionPerformed(ActionEvent ae)
			{
				new examin();
				dispose();
			}
		});
		logout.addActionListener(new ActionListener(){
			public  void actionPerformed(ActionEvent ae)
			{
				new verify();
				dispose();
			}
		});
		
		setJMenuBar(mbr);
		
	}
}
