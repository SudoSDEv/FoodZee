<%@page import="com.bitehunter.dbo.DBLogic"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="ErrorPage.html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="css/innerrest.css">
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Choose a category | foodzee</title>
</head>
<body>
<script type="text/javascript">
function logout(){
	document.location.href="index.html";}
</script>
<div class="logo-container">
<img id="logo" src="logo.png">
<a id="logout" onclick=logout();>Logout</a>
</div>

<div class="container">
<% ArrayList<String> categories=(ArrayList<String>) request.getAttribute("categories");%>

<h1><%= DBLogic.fetchResName((String)request.getAttribute("resname")) %> - Select Cuisine</h1>

<form action="InnerRest" >

<select class="inputcuisine" name="choice">
<%
	for(String x: categories)
	{
%>
<option><%= x %></option>
<% } %>
</select>

<input type="hidden" name="resname" value="<%=request.getAttribute("resId") %>"> 
<input class="submitbutton" type="submit" value="Ok">
</form>
</div>
</body>
</html>