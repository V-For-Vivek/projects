import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Log_act extends HttpServlet 
{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{		
		
		String un=req.getParameter("uname");
		String pass=req.getParameter("pass");
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","vapking","aa");
			PreparedStatement ps = con.prepareStatement("select * from login where username=? and password=?");
			ps.setString(1,un);
			ps.setString(2,pass);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				HttpSession hs = req.getSession();
				hs.setAttribute("UserName",un);
				hs.setAttribute("password",pass);
				ps.close();
				con.close();
				res.sendRedirect("Main.jsp");
			}
			else
			{
				res.sendRedirect("Login.jsp");
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

}
