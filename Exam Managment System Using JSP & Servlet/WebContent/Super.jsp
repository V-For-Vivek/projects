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
<title>Super</title>
</head>
<body>
	<form method="post" action="super_act">
		<label>Name of SuperVisior :</label>
		<input type="text" name="nos" pattern="[A-Za-z\s]{2,}" required><br>
		<label>Name of Officer-Incharge :</label>
		<input type="text" name="noi" pattern="[A-Za-z\s]{2,}" required><br>
		<label>Date :</label>
		<input type="date" name="date" required><br>
		<label>Time from :</label>
		<input type="time" name="ftime" required>
		<label>To :</label>
		<input type="time" name="ttime" required><br>
		<label>Block :</label>
		<select name="block" required>
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<option value="4">4</option>
		<option value="5">5</option>
		</select><br>
		<label>Year-Course-Master :</label>
		<select name="ycm" required>
		<option value="CO-2-I">CO-2-I</option>
		<option value="CO-3-I">CO-3-I</option>
		<option value="CO-4-I">CO-4-I</option>
		<option value="CO-5-I">CO-5-I</option>
		<option value="CO-6-G">CO-6-G</option>
		</select><br>
		<label>Subject :</label>
		<input type="text" name="sub" pattern="[A-Za-z\s]{2,}" required><br>
		<label>Subject Code :</label>
		<input type="text" name="subcode" pattern="[0-9]{5,}" required><br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>
<%
	}
%>
