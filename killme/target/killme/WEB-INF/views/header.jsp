<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Art Collection</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
	<link href="./resources/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="./resources/css/style.css" rel="stylesheet" media="screen">
    <script data-require="angular.js@1.0.x" src="http://code.angularjs.org/1.0.7/angular.min.js" data-semver="1.0.7"></script>
	<style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }    
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
	.carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      
      margin: auto;
  </style>
</head>
<body>
	<center>
		<h1>
			<img src="resources/images/arts/art.jpg" style="width: 50px; height: 50px">
			 ART COLLECTION
		</h1>
		<br>
	</center>
	<marquee>
		<h6>Welcome To MyArt Collection</h6>
	</marquee>
	<nav class="navbar navbar-default">
		<div class="container-fluid">

			<ul class="nav navbar-nav">
				<li class="active"><a href="login">Home</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">ARTS <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="login">PORTRAITS</a></li>
						<li><a href="login">DRAWINGS</a></li>
						<li><a href="login">PERFORMANCE ARTS</a></li>
						<li><a href="login">MIXED MEDIA</a></li>
					</ul></li>
				<li><a href="toContactUs">CONTACT US</a></li>
				<li><a href="toAboutUs">ABOUT US</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="CheckCustomer"><span class="glyphicon glyphicon-log-in"></span> login</a></li>
				<li><a href="toSignUp"><span class="glyphicon glyphicon-user"></span> sign up</a>
			</ul>
		</div>
	</nav>