<%@ page language="java"%>
<%
	response.setHeader("Second-Session-Control","no-cache, no-store, must-revalidate");

	if(session.getAttribute("User")==null && session.getAttribute("pass")==null)
	{
		response.sendRedirect("slogin.jsp");
	}
	else
	{
%>
<html>
<head>
<title>Year</title>
</head>
<body>
		<form method="post" action="year_act">
			<label>Exam Season :</label>
			<input type="radio" name="season" value="Suummer" required><span>Summer</span> 
			<input type="radio" name="season" value="Winter" required><span>Winter</span>
			<br><label>Exam Year :</label>
			<select name="year" required>
			<option value="2018">2018</option>
			<option value="2019">2019</option>
			</select>
			<input type="submit" value="Submit">
		</form>
</body>
</html>
<%
	}
%>