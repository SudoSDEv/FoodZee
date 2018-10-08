<%@page import="com.bitehunter.model.Category"%>
<%@page import="com.bitehunter.dbo.DBLogic"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bitehunter.model.Menu"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remove categories | foodzee</title>
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
<h1>Note: Removing categories removes all of its menus and also all restaurants stop selling the category.</h1>

<% 		ArrayList<Category> cats=DBLogic.fetchCategories(); 
%>
<form action="RemoveCatServ">
<table align="center" class="table">
<tr>
<th>Available Categories</th>

</tr>
<% 	for(Category cat:cats)
	{
%>
<tr>

<td><%= cat.getCname()  %></td>
</tr>
<%} %>


</table>
<div style="text-align:center">
<br/>
<input type="text" name="cname">
<input type="submit" value="Submit">
</div>
</form>

	<%
			if(request.getAttribute("over")!=null && (int)request.getAttribute("over")==1)
			{
		%>
		<b style="color: red;">Category removed successfully and also all of its menus. All of your branches have also stopped selling such category</b>
		<%  } else if(request.getAttribute("over")!=null && (int)request.getAttribute("over")==-1) { %>
				<b style="color: red;">Category doesn't exist!</b>
		<% }%>
 

</body>

</body>
</html>