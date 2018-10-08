<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="ErrorPage.html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="css/reg.css">
    <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
<title>Register | foodzee</title>
</head>
<body>

<div class="logo-container">
<img id="logo" src="logo.png">
</div>
<div class="container">
<h1>Registration Form</h1>
	<% if(request.getAttribute("error")!=null) { %>
	<div align="center"><h2 style="color: red; margin: 20px;"><%= (String) request.getAttribute("error") %></h2></div>
	<%} %>	
<form action="RegServ">	
		<table align="center" id="table1">
		<!--  caption style="font: bold; font-family: fantasy; font-size: 32px">Registration Form-->
		<tr>
			<th>Your Name&nbsp;</th>
			<td>
				<input id="textinput" type="text" name="customername" placeholder="enter your name" required="required">
			</td>
		</tr>
		
		<tr>
			<th>User Id&nbsp;</th>
			<td>
				<input id="textinput" type="text" name="username" placeholder="use it for login" required="required">
			</td>
		</tr>
		
		<tr>
			<th>Password&nbsp;</th>
			<td>
				<input id="textinput" type="password" name="userpassword" placeholder="enter your password" required="required">
			</td>
		</tr>
		<tr>
			<th>Renter password&nbsp;</th>
			<td>
				<input id="textinput" type="password" name="userpassword2" placeholder="reenter your password" required="required">
			</td>
		</tr>
		<tr>
			<th>Email&nbsp;</th>
			<td>
				<input id="textinput" type="text" name="useremail" placeholder="email" required="required">
			</td>
		</tr>
		<tr>
			<th>Phone&nbsp;</th>
			<td>
				<input id="textinput" type="number" name="userphone" placeholder="phone no" required="required">
			</td>
		</tr>
		
		<tr>
			<th>City&nbsp;</th>
			<td>
				<input id="textinput" type="text" name="usercity" placeholder="enter your city" required="required">
			</td>
		</tr>
		

		<tr>
			<th>Address&nbsp;</th>
			<td>
				<input id="textinput" type="text" name="useraddress" placeholder="enter your address" required="required">
			</td>
		</tr>
	
			
	
	
				
		</table>
		 <input class="submitbutton" type="submit" value="Register"></td>
</form>
</div>
	
</body>
</html>