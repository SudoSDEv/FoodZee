<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add menus | foodzee</title>
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
<h2 align="center" style="font: bold; font-family: fantasy; font-size: 38px;margin-bottom: 20px;">Menu Add</h2>

<form action="AddMenuServ">

<table align="center">

		<tr>
			<th>Category name&nbsp;</th>
			<td>
				<input type="text" name="cname" placeholder="Enter the category" required="required">
			</td>
		</tr>
		
		<tr>
			<th>Menu name&nbsp;</th>
			<td>
				<input type="text" name="menuname" placeholder="Enter menu name" required="required">
			</td>
		</tr>
		<tr>
			<th>Price per plate&nbsp;</th>
			<td>
				<input type="text" name="price" placeholder="Enter the price" required="required">
			</td>
		</tr>
					
		</table>
			<div style="text-align:center">  
    					<button type="submit" class="button">Submit</button>  
			</div>  
		
		<%
			if(request.getAttribute("over")!=null && (int)request.getAttribute("over")==1)
			{
		%>
		<b style="color: red;">Menu added successfully</b>
		<%  } else if(request.getAttribute("over")!=null && (int)request.getAttribute("over")==-1) { %>
				<b style="color: red;">Menu already exist or invalid category. Try again!</b>
		<% }%>
		
			
		
		
</form>

</body>
</html>