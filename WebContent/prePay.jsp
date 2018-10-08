<%@page import="com.sun.xml.internal.ws.api.streaming.XMLStreamWriterFactory.Zephyr"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bitehunter.dbo.Helper"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="ErrorPage.html" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Checkout | foodzee</title>
<link rel="stylesheet" href="css/prepay.css">
<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
<link rel="stylesheet" href="css/font-awesome.min.css">
</head>
<body>


<div class="logo-container">
<img id="logo" src="logo.png">
<a id="logout" onclick=logout();>Logout</a>
</div>
<div class="container">

<%	
	ArrayList<String> menus=(ArrayList<String>) request.getAttribute("menus");// all of the menus...kindly see the format of individual item below
	String total=Helper.calTotal(menus);//calculation total of preselected items.. 

%>

<h1>Checkout page</h1>
<hr/>
<%
	//String details[]=menus[i].split(" ");
	//design the items kart in this page to show
	//the items with increment and decrement functions for plates...
	//The itemDetails are present in details[].... details[0]=Menuid , details[details.length-1]=plates
	//details[details.length-2]=price per unit and "details[1] to details[details.length-3]" =Name of menu...
	
%>


<% int i = 1; %>
<form action="PlaceOrderServ">
<table>
<% for(String x:menus)
{
	
	
	String details[]=x.split(" ");  %>


	
<tr>
<td id="foodname">
<%= Helper.fetchName(x) %>
</td>
<td style="width: 0px;"><input  class="prices" id="price<%= i %>" type="hidden" value="<%= details[details.length-2] %>"></td>
<td><input id="inputfood<%= i %>" class="foods" name="<%= x %>" min="1" max="10" type="number" value="<%= details[details.length-1] %>"></td>
<td><a id="delete<%= i %>" href="#"><i class="fa fa-trash fa-2x deleteicon" aria-hidden="true"></i></a></td>
</tr>



<% i++; %>
<% } %>
</table>

<h1 id="total">Total: <%=total %></h1>

<input class="submitbutton" style="margin-left: 560px;" type="submit" value="Place Order">
</form>
</div>


<% i = 1; %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>

function logout(){
	document.location.href="index.html";}
	
	
var total = document.getElementById("total");
<% for(String x:menus) {
	 %>
	var del<%= i %> = document.getElementById("delete<%= i %>");
	var inputfood<%= i %> = document.getElementById("inputfood<%= i %>");
	del<%= i %>.onclick = function() {
		
		this.parentNode.parentNode.remove();
		var foods = document.getElementsByClassName("foods");
		var prices = document.getElementsByClassName("prices");
		var temptotal = 0;
		for(i = 0; i < foods.length; i++) {
			temptotal += foods[i].value * prices[i].value;
			console.log(temptotal);
		}
		total.textContent = "Total: " + temptotal;
		
	}
	inputfood<%= i %>.onchange = function() {
		var foods = document.getElementsByClassName("foods");
		var prices = document.getElementsByClassName("prices");
		var temptotal = 0;
		for(i = 0; i < foods.length; i++) {
			temptotal += foods[i].value * prices[i].value;
			console.log(temptotal);
		}
		total.textContent = "Total: " + temptotal;
	}
	
	<% i++; %>
	<% } %>

</script>
</body>


</html>