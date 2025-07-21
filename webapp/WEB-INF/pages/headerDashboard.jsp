<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
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
			<a href="${pageContext.request.contextPath}/lawyerDashboard">
				<img src="${pageContext.request.contextPath}/resources/images/logo.png" alt="logo">
			</a>

			<div class="logo-text">
				Online<br>
				Legal Aid<br>
				System
			</div>

		</div>


		<div class="username-btn">
		    <a href="${pageContext.request.contextPath}/lawyerProfile">
		      <i class="fas fa-user"></i> My Profile
		    </a>
		</div>
		
	</div>
	
</body>
</body>
</html>