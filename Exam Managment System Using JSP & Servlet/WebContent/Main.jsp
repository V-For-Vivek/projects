<%@ page language="java"%>

<%
	response.setHeader("Session-Controle","no-cache, no-store, must-revalidate");

	if(session.getAttribute("UserName")==null && session.getAttribute("password")==null)
	{
		response.sendRedirect("Login.jsp");
	}
	else
	{
%>
<html>
<head>
<title>Main</title>
</head>
<body>
		<ul>
			<li><a href ="Main.jsp">Home</a></li>
			<li><a href ="slogin.jsp">Report Generation</a></li>
			<li><a href ="logout">Logout</a></li>
		</ul>
</body>
</html>
<%
	}
%>