<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
	body {
	margin: 0;
	font-family: Arial, sans-serif;
}

.top-bar {
	background: white;
	padding: 10px 20px;
	display: flex;
	justify-content: flex-end;
	align-items: center;
	border-bottom: 1px solid #ccc;
}

.top-bar i {
	margin-left: 15px;
	font-size: 18px;
}

.nav-bar {
	background-color: #1c2f50;
	display: flex;
	justify-content: space-between;
	align-items: center;
	padding: 10px 20px;
	color: white;
}

.logo-section {
	display: flex;
	align-items: center;
	margin-right: 40px;
}

.logo-section img {
	height: 40px;
	margin-right: 10px;
}

.logo-text {
	font-size: 12px;
	line-height: 1.5;
}

.nav-links {
	display: flex;
	gap: 30px;
}

.nav-links a {
	color: #ccc;
}

.nav-links a:hover {
	color: #fff;	
}

.nav-links div {
	font-size: 14px;	
}

.username-btn {
	border: 1px solid white;
	border-radius: 20px;
	padding: 5px 15px;
	display: flex;
	align-items: center;
}

.username-btn i {
	margin-right: 8px;
}
</style>
</head>
<body>
	<div class="top-bar">
  <i class="fab fa-facebook-f"></i>
  <i class="fab fa-instagram"></i>
  <span style="margin-left: 15px;">EN <i class="fas fa-caret-down"></i></span>
</div>

<div class="nav-bar">
  <div class="logo-section">
    <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/8/88/Justice_scales_icon.svg/1024px-Justice_scales_icon.svg.png" alt="Logo">
    <div class="logo-text">
      Online<br>
      Legal Aid<br>
      System
    </div>
  </div>
  
  <div class="nav-links">
    <a href="#">Find Lawyers</a>
    <a href="#">About Us</a>
    <a href="#">Contact Us</a>
  </div>
  
  <div class="username-btn">
    <i class="fas fa-user"></i> username
  </div>
</div>

</html>