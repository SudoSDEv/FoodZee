<%@page import="com.bitehunter.dbo.DBLogic"%>
<%@page import="com.bitehunter.model.Order"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Current orders | foodzee</title>
</head>
<body>
<%! double total=0; %>
<% ArrayList<Order> orders=DBLogic.fetchOrders(); %>

<table>
<tr>
<th>User Name</th>
<th>Restaurant Id</th>
<th>Restaurant Name</th>
<th>Order Id</th>
<th>Orders</th>
<th>Total Cost</th>
<th>Delivery Phone No</th>
<th>Date with time</th>
</tr>
<%for(Order order:orders) {  
%>
<tr>
<td><%= order.getUsname() %></td>
<td><%= order.getrId() %></td>
<td><%= DBLogic.fetchResName(order.getrId()) %></td>
<td><%= order.getOrderId() %></td>
<td>
<table>
<tr>
<th>Menus</th>
<th>Plates</th>
<th>Costs</th>
</tr>
<%
String[] menuIds=order.getMids().split(" ");
String[] plates=order.getPlates().split(" ");
String[] indiTotal=order.getTotal().split(" ");
String orderWithPlates="";
total=0;
for(int i=0;i<menuIds.length;i++)
{ 
total+=Double.parseDouble(indiTotal[i])*Double.parseDouble(plates[i]);
%>
<tr>
<td><%= DBLogic.fetchMenuName(menuIds[i])  %></td>
<td><%= plates[i] %></td>
<td><%=Double.parseDouble(indiTotal[i])*Double.parseDouble(plates[i]) %></td>
</tr>
<% } %>
</table>
</td>
<td><%= total %></td>
<td><%= order.getPhNo() %></td>
<td><%= order.getDate() %></td>
</tr>
<%}%>
</table>

</body>
</html>