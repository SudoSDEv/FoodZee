<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Welcome Admin | foodzee</title>
<style>
	body{
		background:
		}
	.button{
		
		width:200px;
		border-radius:5px;
		}
</style>
</head>
<body>
<div align="center" >

<img src="images/admin.jpeg"><br/>


<br/>
<button type=submit onclick="location.href='AddMenus.jsp'" class="button" ><b>Add Menus</b></button>
<br/>
<br/>
<button type=submit onclick="location.href='AddCategories.jsp'" class="button"><b>Add Categories</b></button>
<br/>
<br/>
<button type=submit onclick="location.href='RemoveMenus.jsp'" class="button"><b>Remove Menus</b></button>
<br/>
<br/>
<button type=submit onclick="location.href='RemoveCategories.jsp'" class="button"><b>Remove Categories</b></button>
<br/>
<br/>
<button type=submit onclick="location.href='AddRestaurants.jsp'" class="button"><b>Add Restaurants</b></button>
<br/>
<br/>
<button type=submit onclick="location.href='RemoveRestaurants.jsp'" class="button"><b>Remove Restaurants</b></button>
<br />
<br />
<button type=submit onclick="location.href='ViewOrders.jsp'" class="button"><b>View Orders</b></button>
<br/>
<br/>
<button type=submit onclick="location.href='RemoveOrders.jsp'" class="button"><b>Remove Orders</b></button>

</div>


</body>
</html>