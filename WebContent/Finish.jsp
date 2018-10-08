<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="ErrorPage.html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="css/finish.css">
    <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
<title>Thank you | foodzee</title>
</head>
<body >
	<div class="logo-container">
<img id="logo" src="logo.png">
<a id="logout" onclick=logout()>Logout</a>
</div>
<div class="container">
	<h1><%=request.getParameter("value") %></h1>
</div>
<script type="text/javascript">
window.onhashchange = function() {
	alert("asd");
}


function logout(){
	document.location.href="index.html";}
</script>

</body>
</html>