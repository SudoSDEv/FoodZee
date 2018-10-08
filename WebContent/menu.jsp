<%@page import="com.bitehunter.model.Menu"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select your food items | foodzee</title>
<link rel="stylesheet" href="css/menustyle.css">
    <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
</head>
<body>
<script type="text/javascript">
function logout(){
	document.location.href="index.html";}
</script>
<div class="logo-container">
<img id="logo" src="logo.png">
<a id="logout" onclick=logout()>Logout</a>
</div>
<div class="container">
<h1>Select your food items </h1>
<hr />
<form action="MenuServ">
<% ArrayList<Menu> menus=(ArrayList<Menu>) request.getAttribute("Menus"); %>
<table>
<% for(Menu menu: menus) { %>

<tr>
<td><span id="foodname"><%=menu.getMenuName() %></span></td>
<td><input min="0" max="10" id="inputfood" type="number" name="<%= menu.getMid() %> <%= menu.getMenuName()%> <%= menu.getPrice()%>"></td>
<td><span id="foodprice">Rs. <%= menu.getPrice()%></span></td>
</tr>

 
<% } %>
</table>
<input class="submitbutton" type="submit" value="OK">
</form>
</div>
</body>
</html>