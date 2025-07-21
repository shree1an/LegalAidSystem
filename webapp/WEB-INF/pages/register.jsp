<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Register</title>
  <link rel="stylesheet" type="text/css"
    href="${pageContext.request.contextPath}/css/register.css" />
  <style>
    .hidden { display: none; }
  </style>
</head>
<body>
  <div class="container">

    <!-- Left Side Text -->
    <div class="info-panel">
      <h1>Get the Legal Help<br>You Deserve</h1>
      <p>-- Anytime, Anywhere</p>
      <p>Access legal services and professional support with ease. Whether you're seeking justice or offering it, our platform connects clients with trusted lawyers in just a few clicks.</p>
    </div>
    
    <!-- Registration Form -->
    <div class="form-panel">
      <h1>Create an Account</h1>
  
      <div class="toggle-buttons">
        <button type="button" id="clientBtn" class="active" aria-pressed="true">Client</button>
        <button type="button" id="lawyerBtn" aria-pressed="false">Lawyer</button>
      </div>
      
            <!-- CLIENT FORM -->
      <form id="clientForm" method="post" action="${pageContext.request.contextPath}/register">
        <input type="hidden" name="role" value="Client" />
        <div class="form-group">
          <label for="clientName">Name</label>
          <input type="text" id="clientName" name="clientName" placeholder="Enter your Full Name" required>
        </div>
        <div class="form-group">
          <label for="clientEmail">Email</label>
          <input type="email" id="clientEmail" name="clientEmail" placeholder="Enter your Email Address" required>
        </div>
        <div class="form-row">
          <div class="form-group">
            <label for="clientPhone">Phone</label>
            <input type="text" id="clientNumber" name="clientNumber" placeholder="Enter your Phone Number" required>
          </div>
          <div class="form-group">
            <label for="clientGender">Gender</label>
            <select id="clientGender" name="clientGender" required>
              <option value="" disabled selected>Choose</option>
              <option value="male">Male</option>
              <option value="female">Female</option>
              <option value="other">Other</option>
            </select>
          </div>
        </div>
        <div class="form-group">
          <label for="clientAddress">Address</label>
		  <input type="text" id="clientAddress" name="clientAddress" placeholder="Enter your Address" required>

        </div>
        <div class="form-group">
          <label for="clientDOB">Date of Birth</label>
          <input type="date" id="clientDOB" name="clientDOB">
        </div>
        <div class="form-group">
          <label for="password">Password</label>
          <input type="password" id="clientPassword" name="clientPassword" placeholder="Enter Password" required>
        </div>
        <div class="form-group">
          <label for="confirmPassword">Confirm Password</label>
          <input type="password" id="clientConfirmPassword" name="confirmPassword" placeholder="Re-Enter Password" required>
        </div>
        <button type="submit" class="submit-btn">Create an Account</button>
        
        <div class="login-link">
          Already have an account? <a href="${pageContext.request.contextPath}/login">Log In</a>
        </div>
      </form>

      <!-- LAWYER FORM -->
      <form id="lawyerForm" class="hidden" method="post" action="${pageContext.request.contextPath}/register" >
        <input type="hidden" name="role" value="Lawyer" />
        <div class="form-group">
          <label for="lawyerName">Name</label>
          <input type="text" id="lawyerName" name="lawyerName" placeholder="Enter your Full Name" required>
        </div>
        <div class="form-group">
          <label for="lawyerEmail">Email</label>
          <input type="email" id="lawyerEmail" name="lawyerEmail" placeholder="Enter your Email Address" required>
        </div>
        <div class="form-row">
          <div class="form-group">
            <label for="lawyerPhone">Phone</label>
            <input type="text" id="lawyerNumber" name="lawyerNumber" placeholder="Enter your Phone Number" required>
          </div>
          <div class="form-group">
            <label for="lawyerGender">Gender</label>
            <select id="lawyerGender" name="lawyerGender" required>
              <option value="" disabled selected>Choose</option>
              <option value="male">Male</option>
              <option value="female">Female</option>
              <option value="other">Other</option>
            </select>
          </div>
        </div>
        <div class="form-row">
          <div class="form-group">
            <label for="licenseNumber">License Number</label>
            <input type="text" id="licenseNumber" name="licenseNumber" placeholder="Enter Lawyer License Number" required>
          </div>
          <div class="form-group">
            <label for="dateJoined">Date Joined</label>
            <input type="date" id="dateJoined" name="dateJoined" required>
          </div>
        </div>
        <div class="form-row">
          <div class="form-group">
            <label for="district">District</label>
            <input type="text" id="district" name="district" placeholder="Enter District" required>
          </div>
          <div class="form-group">
            <label for="province">Province</label>
            <select id="province" name="province" required>
              <option value="" disabled selected>Choose</option>
              <option value="koshi">Koshi</option>
              <option value="madhesh">Madhesh</option>
              <option value="bagmati">Bagmati</option>
              <option value="gandaki">Gandaki</option>
              <option value="lumbini">Lumbini</option>
              <option value="karnali">Karnali</option>
              <option value="sudurpaschim">Sudurpashchim</option>
            </select>
          </div>
        </div>
        <div class="form-group">
          <label for="password">Password</label>
          <input type="password" id="lawyerPassword" name="lawyerPassword" placeholder="Enter Password" required>
        </div>
        <div class="form-group">
          <label for="confirmPassword">Confirm Password</label>
          <input type="password" id="lawyerConfirmPassword" name="lawyerConfirmPassword" placeholder="Re-Enter Password" required>
        </div>
        <button type="submit" class="submit-btn">Create an Account</button>
        <div class="login-link">
          Already have an account? <a href="${pageContext.request.contextPath}/login">Log In</a>
        </div>
      </form>
      

    </div>
  </div>

  <!-- Error Messages -->
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
   <% 
    if (error != null) {
  %>
    <p style="color:red;"><%= error %></p>
  <%
    }
  %>

  <!-- JavaScript to toggle form -->
<script>
	const clientBtn = document.getElementById("clientBtn");
	const lawyerBtn = document.getElementById("lawyerBtn");
	const clientForm = document.getElementById("clientForm");
	const lawyerForm = document.getElementById("lawyerForm");
	
	clientBtn.addEventListener("click", () => {
	  clientBtn.classList.add("active");
	  lawyerBtn.classList.remove("active");
	
	  clientForm.classList.remove("hidden");
	  lawyerForm.classList.add("hidden");
	
	  // Enable only client form inputs
	  Array.from(clientForm.elements).forEach(el => el.disabled = false);
	  Array.from(lawyerForm.elements).forEach(el => el.disabled = true);
	
	  // Set role value
	  clientForm.querySelector('input[name="role"]').value = "Client";
	});
	
	lawyerBtn.addEventListener("click", () => {
	  lawyerBtn.classList.add("active");
	  clientBtn.classList.remove("active");
	
	  lawyerForm.classList.remove("hidden");
	  clientForm.classList.add("hidden");
	
	  // Enable only lawyer form inputs
	  Array.from(lawyerForm.elements).forEach(el => el.disabled = false);
	  Array.from(clientForm.elements).forEach(el => el.disabled = true);
	
	  // Set role value
	  lawyerForm.querySelector('input[name="role"]').value = "Lawyer";
	});
	
	// On page load, show client form and disable lawyer form inputs
	window.addEventListener("DOMContentLoaded", () => {
	  // Show client form and hide lawyer form initially
	  clientForm.classList.remove("hidden");
	  lawyerForm.classList.add("hidden");
	
	  // Enable client inputs, disable lawyer inputs
	  Array.from(clientForm.elements).forEach(el => el.disabled = false);
	  Array.from(lawyerForm.elements).forEach(el => el.disabled = true);
	
	  // Set clientBtn as active
	  clientBtn.classList.add("active");
	  lawyerBtn.classList.remove("active");
	
	  // Set role input value in client form
	  clientForm.querySelector('input[name="role"]').value = "Client";
	});

</script>

</body>
</html>
