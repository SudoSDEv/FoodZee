<%@page import="com.bitehunter.model.Restaurant"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="ErrorPage.html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="css/displaystyle.css">
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
        <link rel="stylesheet" href="css/font-awesome.min.css">
<title>Restaurants | foodzee</title>
</head>
<body>
<script type="text/javascript">
function logout(){
	document.location.href="index.html";}
</script>
<% 	ArrayList<Restaurant> restaurants=(ArrayList<Restaurant>) request.getAttribute("rests"); %>

<div class="logo-container">
<img id="logo" src="logo.png">
<a id="logout" onclick=logout();>Logout</a>
</div>
<div class="container">

	<%
		if(request.getAttribute("rests")!=null)
		{
		for(Restaurant x:restaurants)
		{
	%>
	
	<div onclick="location.href='RestaurantServ?resId=<%= x.getrId() %>';" class="rest">
			<span class="name"><h2><%= x.getrName() %></h2></span>
			<!--  <img class="image" src="img/restaurants/rest<%= x.getrId() %>.jpg"></img>-->
			
			<div class="location">
				<i class="fa fa-map-marker fa-2x" aria-hidden="true"></i><span class="locationtext"><%= x.getAddress() %>, <%= x.getCity() %></span>
			</div>
			<span class="right">
				<span class="phone"><i class="fa fa-mobile fa-2x" aria-hidden="true"></i><%= x.getPhone() %></span> <br />
				<span class="email"><i class="fa fa-envelope" aria-hidden="true"></i><%= x.getEmail() %></span>
			</span>
	</div>
		<% }
		} else { %>
		Not found <% } %>

</div>


</body>
</html>