<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" integrity="sha512-9usAa10IRO0HhonpyAIVpjrylPvoDwiPUiKdWk5t3PyolY1cOd4DSE0Ga+ri4AuTroPR5aQvXU9xC6qOPnzFeg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css" type="text/css" /> 		
	</head>
	
<body>

	<div class="top-bar">
	
		<a href="#">
			<i class="fab fa-facebook-f"></i>
			<i class="fab fa-instagram"></i>
		</a>
		
		<div class="language-dropdown">
		
			<div class="language-select">
				<span>EN</span> <i class="fas fa-caret-down"></i>
			</div>
			
			<div class="language-options">
				<a href="#">English</a>
				<a href="#">Nepali</a>
				<a href="#">Hindi</a>
			</div>
			
		</div>
	</div>

	<div class="nav-bar">

		<div class="logo-section">
			<a href="#">
				<img src="${pageContext.request.contextPath}/resources/images/logo.png" alt="logo">
			</a>

			<div class="logo-text">
				Online<br>
				Legal Aid<br>
				System
			</div>

		</div>

		<div class="nav-links">
			<a href="#">Find Lawyers</a>
			<a href="#">Court</a>
			<a href="#">About Us</a>
			<a href="#">Contact Us</a>
		</div>

		<div class="username-btn">
			<a href="#">
				<i class="fas fa-user"></i> userprofile
			</a>
		</div>
		
	</div>
	
</body>
</html>
