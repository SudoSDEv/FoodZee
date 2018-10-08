<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remove orders | foodzee</title>
</head>
<body>
<form action="RemoveOrder">
<%@ include file="ViewOrders.jsp" %>
<input type="text" placeholder="Enter an order Id" name="oId">
<input type="submit" value="Submit">
</form>

<%
			if(request.getAttribute("over")!=null && (int)request.getAttribute("over")==1)
			{
		%>
		<b style="color: red;">Order removed successfully</b>
		<%  } else if(request.getAttribute("over")!=null && (int)request.getAttribute("over")==-1) { %>
				<b style="color: red;">Order doesn't exist. Please try again!</b>
		<% }%>
 
</body>
</html>