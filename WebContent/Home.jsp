<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="ErrorPage.html" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/cs-select.css">
    <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
    <title>Select Region | foodzee</title>
</head>
<body>
    <div class="container">
        <div class="video-container">
            <div class="text">
                <img id="logo" src="logo.png">
                <form action="HomeServ">
                	<div class="parent">
                	<a id="logout" onclick=logout();>Logout</a>
                		<div>
                			<select class="cs-select" name="city">
                			
								<option value="" disabled selected>Select your City</option>
								<option value="Kolkata" >Kolkata</option>
								<option value="Mumbai">Mumbai</option>
								<option value="Chennai">Chennai</option>
								<option value="Bangalore">Bangalore</option>
							</select>
						</div>
						<div><input class="submitcity" type="submit" value="Search"></div>
				
					</div>
				</form>
            </div>
            <video src="food.mp4" autoplay loop></video>
        </div>
    </div>
<script type="text/javascript">
function logout(){
	document.location.href="index.html";}
</script>    
    
</body>
</html>
