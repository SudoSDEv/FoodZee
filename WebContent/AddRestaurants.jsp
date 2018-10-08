<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add restaurants | foodzee</title>
<style>
body{
	background:	
}
.button{
		
		width:60px;
		border-radius:5px;
		}
</style>
</head>
<body>

<h2 align="center" style="font: bold; font-family: fantasy; font-size: 38px;margin-bottom: 20px;">Restaurant Add</h2>

<form action="AddResServ">

<table align="center">

		<tr>
			<th>Restaurant name&nbsp;</th>
			<td>
				<input type="text" name="rname" placeholder="enter the restaurant name" required="required">
			</td>
		</tr>
		
		<tr>
			<th>City&nbsp;</th>
			<td>
				<input type="text" name="cityname" placeholder="enter city" required="required">
			</td>
		</tr>
		<tr>
			<th>Address&nbsp;</th>
			<td>
				<input type="text" name="address" placeholder="Enter address" required="required">
			</td>
		</tr>
	<tr>
			<th>Phone&nbsp;</th>
			<td>
				<input type="number" name="phone" placeholder="Enter phone no." required="required">
			</td>
		</tr><tr>
			<th>Email&nbsp;</th>
			<td>
				<input type="text" name="email" placeholder="Enter email" required="required">
			</td>
		</tr>
		</table>
		
		
		<%
			if(request.getAttribute("over")!=null && (int)request.getAttribute("over")==1)
			{
		%>
		<b style="color: red;">Restaurant added successfully</b>
		<%  } else if(request.getAttribute("over")!=null && (int)request.getAttribute("over")==-1) { %>
				<b style="color: red;">Try again! Either restaurant already exists or invalid city.</b>
		<% }%>
		<div style="text-align:center">
				<button type="submit" value="Submit" class="button"><b>Submit</b></button>
		</div>
		
</form>

</body>
</html>