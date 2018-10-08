<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add categories | foodzee</title>
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
<h2 align="center" style="font: bold; font-family: fantasy; font-size: 38px;margin-bottom: 20px;">Category Add</h2>

<form action="AddCatServ">

<table  align="center">

		<tr>
			<th>Category name&nbsp;</th>
			<td>
				<input type="text" name="cname" placeholder="enter the category" required="required">
			</td>
		</tr>
		
		</table>
		
		<br/>
		<%
			if(request.getAttribute("over")!=null && (int)request.getAttribute("over")==1)
			{
		%>
		<b style="color: red;">Category added successfully</b>
		<%  } else if(request.getAttribute("over")!=null && (int)request.getAttribute("over")==-1) { %>
				<b style="color: red;">Category already exist!</b>
		<% }%>
		<div style="text-align:center"> 
		<button type="submit" value="Submit" class="button"><b>Submit</b></button>
		</div>
		
</form>

</body>
</html>