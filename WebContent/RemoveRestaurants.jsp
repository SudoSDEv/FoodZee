<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.bitehunter.dbo.DBLogic"%>
<%@page import="com.bitehunter.model.Restaurant"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remove restaurants | foodzee</title>
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
<h1>Note: Removing restaurants completely removes its trace from the database</h1>

<form action="RemoveResServ">
<% HashMap<String,ArrayList<Restaurant>> restaurants=(HashMap<String,ArrayList<Restaurant>>) DBLogic.fetchRestaurants(); %>
<table align="center" class="table">

<tr>
<th>RID</th>
<th>Name</th>
<th>City</th>
<th>Address</th>
<th>Phone</th>
<th>Email</th>
</tr>

<% for(Entry<String,ArrayList<Restaurant>> x:restaurants.entrySet())
{
	ArrayList<Restaurant> restaurants2=x.getValue();
	for(Restaurant r:restaurants2)
	{
%>

<tr>
<td><%=r.getrId() %></td>
<td><%=r.getrName() %></td>
<td><%= r.getCity()%></td>
<td><%=r.getAddress() %></td>
<td><%= r.getPhone() %></td>
<td><%= r.getEmail() %></td>
</tr>
<% } }%>
</table>
<div style="text-align:center">
<br/>
<input type="text" name="rId">
<input type="submit" value="Submit">
</div>
</form>

<%
			if(request.getAttribute("over")!=null && (int)request.getAttribute("over")==1)
			{
		%>
		<b style="color: red;">Restaurant removed successfully</b>
		<%  } else if(request.getAttribute("over")!=null && (int)request.getAttribute("over")==-1) { %>
				<b style="color: red;">Restaurant doesn't exist!</b>
		<% }%>
 


</body>
</html>