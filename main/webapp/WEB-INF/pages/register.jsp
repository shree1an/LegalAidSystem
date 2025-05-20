<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<link rel="stylesheet" type="text/css"
	href="${contextPath}/css/register.css" />
</head>
<body>
	<div class="container">

		<!-- Left Side Text -->
		<div class="info-panel">
			<h2>Get the Legal Help<br>You Deserve</h2>
			<p>-- Anytime, Anywhere</p>
			<p>Access legal services and professional support with ease. Whether you're seeking justice or offering it, our platform connects clients with trusted lawyers in just a few clicks.</p>
		</div>
		
		<!-- Registration Form -->
		<div class="form-panel">
			<h2>Create an Account</h2>
		
			<div class="toggle-buttons">
				<button id="userType" name="userType" class="active" aria-pressed="true">Client</button>
				<button id="userType" name="userType" aria-pressed="false">Lawyer</button>
			</div>
		
			<form id="registrationForm" action="${pageContext.request.contextPath}/registration" method="post">

			
				<label for="name">Name</label>
				<input type="text" id="name" name="name" placeholder="Enter your name" required />
				
				<label for="email">Email</label>
				<input type="email" id="email" name="email" placeholder="Enter your email" required />
				
				<label for="phone">Phone</label>
				<input type="tel" id="number" name="number" placeholder="Enter your phone number" required />
				
				<div id="dobGender" class="split">
					<div style="flex: 1;">
						<label for="dob">Date of Birth</label>
						<input type="date" id="dateOfBirth" name="dateOfBirth" />
					</div>
					<div style="flex: 1;">
						<label for="gender">Gender</label>
						<input type="text" id="gender" name="gender" placeholder="Gender" />
					</div>
				</div>
				
				<div id="lawyerFields" class="hidden">
					<div class="split">
						<div style="flex: 1;">
							<label for="license">License Number</label>
							<input type="text" id="licenseNumber" name="licenseNumber" placeholder="License Number" />
						</div>
						<div style="flex: 1;">
							<label for="province">Province</label>
							<input type="text" id="province" name="province" placeholder="Province" />
						</div>
					</div>
					
					<div class="split">
						<div style="flex: 1;">
							<label for="district">District</label>
							<input type="text" id="district" name="district" placeholder="District" />
						</div>
					</div>
				</div>
				
				<label for="password">Password</label>
				<input type="password" id="password" name="password" placeholder="Enter password" required />
				
				<label for="confirmPassword">Confirm Password</label>
				<input type="password" id="confirmPassword" name="confirmPassword" placeholder="Confirm password" required />
				
				<button type="submit" class="submit-btn">Create an Account</button>
				
				<p class="login-link">Already have an account? <a href="${pageContext.request.contextPath}/login.jsp">Log In</a></p>

			</form>
		</div>
	</div>
	
	<%
    String error = request.getParameter("error");
    if ("email_exists".equals(error)) {
	%>
	    <p style="color:red;">This email is already registered.</p>
	<% 
	    } else if ("password_mismatch".equals(error)) {
	%>
	    <p style="color:red;">Passwords do not match.</p>
	<%
	    } else if ("phone".equals(error)) {
	%>
	    <p style="color:red;">Invalid phone number format.</p>
	<%
	    }
	%>
	
	

	<script>
		clientBtn.addEventListener("click", () => {
			clientBtn.classList.add("active");
			lawyerBtn.classList.remove("active");
			lawyerFields.classList.add("hidden");
			dobGender.classList.remove("hidden");
			document.getElementById("role").value = "Client";
		});

		lawyerBtn.addEventListener("click", () => {
			lawyerBtn.classList.add("active");
			clientBtn.classList.remove("active");
			lawyerFields.classList.remove("hidden");
			dobGender.classList.add("hidden");
			document.getElementById("role").value = "Lawyer";
		});

	</script>
</body>
</html>