import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class logout extends HttpServlet 
{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{		
		HttpSession session = req.getSession();
		session.removeAttribute("UserName");
		session.removeAttribute("password");
		session.invalidate();
		res.sendRedirect("Login.jsp");		
	}
}
