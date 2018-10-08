<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="ErrorPage.html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/login.css">
    <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login | foodzee
</title>
</head>
<body>


<div class="logo-container">
<img id="logo" src="logo.png">
</div>
<div class="container">
<% if(request.getAttribute("error")!=null) { %>
	<div align="center"><h2 style="color: red; margin: 20px;"><%= (String) request.getAttribute("error") %></h2></div>
	<%} %>	
<form action="LoginServ" method="post">
<table>
	
	<tr>
			<th>User name:&nbsp;</th>
			<td align="center">
			<input id="textinput" type="text"  name="username" placeholder="enter your name" style="font-size: 20px;">
			</td>
	</tr>
	
	
	<tr  >
		<th>Password :&nbsp;</th>
		<td>
			<input id="textinput" type="password" name="userpassword" placeholder="password" style="font-size: 20px;">
		</td>
	</tr>
	
	<tr>
	<td align="center">
		<input class="submitbutton" type="submit" value="Login">
	</td>
	</tr>

</table>

</form>
</div>

</body>


</body>
</html>