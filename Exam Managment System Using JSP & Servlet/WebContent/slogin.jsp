<%@ page language="java"%>
<%
	response.setHeader("Second-Session-Control","no-cache, no-store, must-revalidate");

	if(session.getAttribute("UserName")==null && session.getAttribute("Password")==null)
	{
%>
<html>
	<head>
		<title>Super Login</title>
	</head>
	<body>
		<form method="post" action="Slog_act">
		<h2>Login</h2> 
		<label>UserName :</label>
		<input type="text" name="uname">
		 <label>Password :</label>
		<input type="password" name="pass">
		<input type="submit" value="Login">
		</form>
	</body>
</html>
<%
	}
	else
	{
		response.sendRedirect("year.jsp");
	}
%>