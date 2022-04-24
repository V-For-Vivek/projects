import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class year_act extends HttpServlet 
{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{		
		
		String sea=req.getParameter("season");
		String pass=req.getParameter("year");
		
		String save = "insert into eyear(es,ey)values(?,?)",delete="truncate eyear";
		     
			try
    		{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","vapking","aa");
    			Statement st = con.createStatement();
    			ResultSet rs = st.executeQuery("select * from eyear");
    			
    			if(rs.next())
    			{
    				PreparedStatement del = con.prepareStatement(delete);
    				int count = del.executeUpdate();
    				
    	 			PreparedStatement sa = con.prepareStatement(save);
    	 			
					sa.setString(1,sea);
					sa.setString(2,pass);
	        		
					count = sa.executeUpdate();
					
					if(count > 0)
					{ 
						st.close();
						con.close();
						res.sendRedirect("Super.jsp");
					}
					else
					{
						res.sendRedirect("year.jsp");
					}
					
				}
    			else
    			{	
    				PreparedStatement sa = con.prepareStatement(save);
    	 			
    				sa.setString(1,sea);
					sa.setString(2,pass);
					
					int count = sa.executeUpdate();
					
					if(count > 0)
					{ 
						st.close();
						con.close();
						res.sendRedirect("Super.jsp");
					}
					else
					{
						res.sendRedirect("year.jsp");
					}
    			}
    		}
			catch(Exception e)
			{
				System.out.println(e);
			}
		
	}

}
