import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

@SuppressWarnings("serial")
public class super_act extends HttpServlet 
{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{		
		
		String nos =req.getParameter("nos");
		String noi =req.getParameter("noi");
		String date =req.getParameter("date");
		String time = req.getParameter("ftime");
		time = time+" To "+req.getParameter("ttime");
		String block =req.getParameter("block");
		String ycm =req.getParameter("ycm");
		String sub =req.getParameter("sub");
		String subcode =req.getParameter("subcode");
		
		String save = "insert into supervisior(noi,nos,date,time,block,ycm,sub,subcode)values(?,?,?,?,?,?,?,?)",delete="truncate supervisior";
		     
			try
    		{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","vapking","aa");
    			Statement st = con.createStatement();
    			ResultSet rs = st.executeQuery("select * from supervisior");
    		
    			
    			if(rs.next())
    			{
    				PreparedStatement del = con.prepareStatement(delete);
    				int count = del.executeUpdate();
    				
    	 			PreparedStatement sa = con.prepareStatement(save);
    	 			
					sa.setString(1,noi);
					sa.setString(2,nos);
					sa.setString(3,date);
					sa.setString(4,time);
					sa.setString(5,block);
					sa.setString(6,ycm);
					sa.setString(7,sub);
					sa.setString(8,subcode);
	        		
					count = sa.executeUpdate();
					
					if(count > 0)
					{ 
						JasperReport  jr = JasperCompileManager.compileReport("D:\\Eclipse WorkSpace\\Exam Managment System\\WebContent\\WEB-INF\\AppendexB.jrxml");
						JasperPrint jp = JasperFillManager.fillReport(jr,null,con);
						JasperExportManager.exportReportToPdfFile(jp,"D:\\Eclipse WorkSpace\\SuperVisior.pdf");
						JasperViewer.viewReport(jp);
						HttpSession session = req.getSession();
						session.removeAttribute("User");
						session.removeAttribute("pass");
						session.invalidate();
						st.close();
						con.close();
						res.sendRedirect("Main.jsp");
					}
					else
					{
						res.sendRedirect("Super.jsp");
					}
					
				}
    			else
    			{	
    				PreparedStatement sa = con.prepareStatement(save);
    	 			
    				sa.setString(1,noi);
					sa.setString(2,nos);
					sa.setString(3,date);
					sa.setString(4,time);
					sa.setString(5,block);
					sa.setString(6,ycm);
					sa.setString(7,sub);
					sa.setString(8,subcode);
    				
					int count = sa.executeUpdate();
					
					if(count > 0)
					{ 
						JasperReport  jr = JasperCompileManager.compileReport("D:\\Eclipse WorkSpace\\Exam Managment System\\WebContent\\WEB-INF\\AppendexB.jrxml");
						JasperPrint jp = JasperFillManager.fillReport(jr,null,con);
						JasperExportManager.exportReportToPdfFile(jp,"D:\\Eclipse WorkSpace\\SuperVisior.pdf");
						JasperViewer.viewReport(jp);
						HttpSession session = req.getSession();
						session.removeAttribute("User");
						session.removeAttribute("pass");
						session.invalidate();
						st.close();
						con.close();
						res.sendRedirect("Main.jsp");
					}
					else
					{
						res.sendRedirect("Super.jsp");
					}
    			}
    		}
			catch(Exception e)
			{
				System.out.println(e);
			}
		
	}

}
