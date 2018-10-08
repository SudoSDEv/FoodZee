<%@page import="com.bitehunter.dbo.DBLogic"%>
<%@page import="com.bitehunter.model.Menu"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remove menus | foodzee</title>
<style>

table,th,td{
	 border-collapse: collapse;
	  border: 1px solid black;
	    padding: 5px;
    	text-align: left;
}
tr:nth-child(even) {background-color: #f2f2f2}
th {
    background-color: #7f8c8d;
    color: white;
}
</style>
</head>
<body>
<% 		ArrayList<Menu> menus=DBLogic.fetchMenus(); 
%>
<h1>Note: Removing menus by their id numbers.</h1>
<form action="RemoveMenusServ">
<table align="center" class="table">

<tr>
<th>Id</th>
<th>Category</th>
<th>Name</th>
<th>Price per plate</th>
</tr>
<% 	for(Menu menu:menus)
	{
%>
<tr>
<td><%= menu.getMid() %></td>
<td><%= menu.getcName() %></td>
<td><%= menu.getMenuName() %></td>
<td><%= menu.getPrice() %></td>

</tr>
<%} %>


</table>
<div style="text-align:center">
<br/>
<input type="text" name="mId">
<input type="submit" value="Submit">
</div>
</form>

	<%
			if(request.getAttribute("over")!=null && (int)request.getAttribute("over")==1)
			{
		%>
		<b style="color: red;">Menu removed successfully</b>
		<%  } else if(request.getAttribute("over")!=null && (int)request.getAttribute("over")==-1) { %>
				<b style="color: red;">Menu doesn't exist!</b>
		<% }%>
 

</body>
</html>