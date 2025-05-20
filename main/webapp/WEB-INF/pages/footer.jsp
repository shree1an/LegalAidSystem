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

    .footer {
      background-color: #1c2f50;
      color: #ffffff;
      padding: 20px 10px;
    }

    .footer-container {
      display: flex;
      justify-content: space-between;
      flex-wrap: wrap;
      max-width: 1200px;
      margin: 0 auto;
      align-items: center;
    }

    .footer-logo {
      display: flex;
      align-items: center;
      gap: 15px;
    }

    .footer-logo img {
      width: 60px;
      height: auto;
    }

    .footer-logo h2 {
      margin: 0;
      font-size: 20px;
      line-height: 1.5;
      color: #ffffff;
    }

    .footer-links {
      text-align: left;
    }

    .footer-links h4 {
      margin-bottom: 10px;
    }

    .footer-links ul {
      list-style: none;
      padding: 0;
      margin: 0;
      text-align: center;
    }

    .footer-links ul li {
      margin: 5px 0;
    }

    .footer-links ul li a {
      text-decoration: none;
      color: #ccc;
      transition: color 0.3s;
    }

    .footer-links ul li a:hover {
      color: #fff;
    }

    .footer-socials {
      display: flex;
      gap: 15px;
      font-size: 20px;
    }

    .footer-socials a {
      color: #ffffff;
      text-decoration: none;
      transition: color 0.3s;
    }

    .footer-socials a:hover {
      color: #ccc;
    }

    .footer-bottom {
      background: #ffffff;
      color: #000000;
      text-align: center;
      padding: 5px;
      font-size: 14px;
      margin-top: 5px;
    }
  </style>
</head>
<body>

  <footer class="footer">
    <div class="footer-container">
      
      <!-- Logo + Title -->
      <div class="footer-logo">
        <img src="https://cdn-icons-png.flaticon.com/512/4024/4024517.png" alt="Logo">
        <h2>Online<br>Legal Aid<br>System</h2>
      </div>

      <!-- Quick Links -->
      <div class="footer-links">
        <h4>QUICK LINKS</h4>
        <ul>
          <li><a href="#">Find Lawyers</a></li>
          <li><a href="#">About Us</a></li>
          <li><a href="#">Contact Us</a></li>
        </ul>
      </div>

      <!-- Social Icons -->
      <div class="footer-socials">
        <a href="#"><i class="fab fa-facebook-f"></i></a>
        <a href="#"><i class="fab fa-instagram"></i></a>
        <a href="#"><i class="fab fa-linkedin-in"></i></a>
        <a href="#"><i class="fab fa-whatsapp"></i></a>
      </div>
    </div>
    
  </footer>

	<div class="footer-bottom">
		<p>2025 All right reserved</p>
	</div>

</body>
</html>