<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>Lawyer Profile</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css" />
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/footer.css" />
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/clientProfile.css" />
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/updateClientProfile.css" />
</head>

<body>

  <jsp:include page="headerDashboard.jsp" />

  <div class="layout">
    <aside class="sidebar">
      <ul>
        <li><a href="${pageContext.request.contextPath}/lawyerProfile">User Profile</a></li>
      </ul>
      <div class="logout">
        <a href="${pageContext.request.contextPath}/home" onclick="return confirm('Are you sure you want to log out?');">Logout</a>
      </div>
    </aside>

    <main class="content">
      <div class="profile-card">
      
        <div class="profile-card__header">
          <div class="avatar"><i class="fas fa-user"></i></div>
          <div class="profile-card__info">
            <span><strong>Lawyer ID:</strong> #<c:out value="${lawyer.lawyerID}"/></span>
            <a href="#" class="btn-edit" onclick="openEditProfilePopup()">Edit Profile</a>
          </div>
        </div>
        
        <div class="profile-card__details">
          <div><strong>Full Name:</strong>   <c:out value="${lawyer.lawyerName}"/></div>
          <div><strong>License Number:</strong> <c:out value="${lawyer.licenseNumber}"/></div>
          <div><strong>Date Joined:</strong> <c:out value="${lawyer.dateJoined}"/></div>
          <div><strong>Email:</strong>         <c:out value="${lawyer.lawyerEmail}"/></div>
          <div><strong>Gender:</strong>        <c:out value="${lawyer.gender}"/></div>
          <div><strong>Phone:</strong>         <c:out value="${lawyer.lawyerNumber}"/></div>
          <div><strong>District:</strong>      <c:out value="${lawyer.district}"/></div>
          <div><strong>Province:</strong>      <c:out value="${lawyer.province}"/></div>
        </div>
        
      </div>
    </main>
  </div>

  <!-- Modal for Edit -->
  <div id="editProfilePopup" class="modal">
    <div class="modal-content">
      <span class="close-button">&times;</span>
      <h2>Edit Profile</h2>
      <form action="${pageContext.request.contextPath}/lawyerProfile" method="post">
		  <div class="form-group">
		    <label for="name">Name:</label>
		    <input type="text" id="name" name="name" value="${lawyer.lawyerName}" readonly>
		  </div>
		  
		  <div class="form-group">
		    <label for="licenseNumber">License Number:</label>
		    <input type="text" id="licenseNumber" name="licenseNumber" value="${lawyer.licenseNumber}" readonly>
		  </div>
		  
		
		  <div class="form-group">
		    <label for="email">Email:</label>
		    <input type="email" id="email" name="email" value="${lawyer.lawyerEmail}">
		  </div>
		
		  <div class="form-group">
		    <label for="phone">Phone:</label>
		    <input type="text" id="phone" name="phone" value="${lawyer.lawyerNumber}">
		  </div>
		
		  <div class="form-group">
		    <label for="gender">Gender:</label>
		    <input type="text" id="gender" name="gender" value="${lawyer.gender}" readonly>
		  </div>
		
		  <div class="form-group">
		    <label for="district">District:</label>
		    <input type="text" id="district" name="district" value="${lawyer.district}">
		  </div>
		
		  <div class="form-group">
		    <label for="province">Province:</label>
		    <input type="text" id="province" name="province" value="${lawyer.province}">
		  </div>
		
		  <div class="form-actions">
		    <button type="submit" class="save-button">Save Changes</button>
		    <button type="button" class="cancel-button" onclick="closeEditProfilePopup()">Cancel</button>
		  </div>
      </form>
    </div>
  </div>

  <jsp:include page="footer.jsp" />

  <script>
    function openEditProfilePopup() {
      document.getElementById("editProfilePopup").style.display = "block";
    }

    function closeEditProfilePopup() {
      document.getElementById("editProfilePopup").style.display = "none";
    }

    document.addEventListener('DOMContentLoaded', function() {
      const editButton = document.querySelector('.btn-edit');
      if (editButton) {
        editButton.addEventListener('click', function(event) {
          event.preventDefault();
          openEditProfilePopup();
        });
      }

      const modal = document.getElementById("editProfilePopup");
      window.addEventListener('click', function(event) {
        if (event.target == modal) {
          closeEditProfilePopup();
        }
      });

      const closeButton = document.querySelector('.close-button');
      if (closeButton) {
        closeButton.addEventListener('click', closeEditProfilePopup);
      }
    });
  </script>

</body>
</html>