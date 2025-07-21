<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="s" value="${stats}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/adminDashboard.css" />
</head>
<body>
	
	    <!-- ---------- SIDEBAR ---------- -->
		<div class="sidebar">
		    <div class="nav">
		        <button class="active">Dashboard</button>
		        <button onclick="location.href='${pageContext.request.contextPath}/adminManageUser'">Manage Users</button>
		        <button onclick="location.href='${pageContext.request.contextPath}/adminManageAppointment'">Manage Appointment</button>
		    </div>
		
		    <div class="logout">
		        <a href="${pageContext.request.contextPath}/home" onclick="return confirm('Are you sure you want to log out?');">Logout</a>
		    </div>
		</div>

	
	    <!-- ---------- MAIN CONTENT ---------- -->
	    <div class="main-content">
	
			<!-- Welcome card -->
	        <div class="greeting">
                <h2>Welcome, Admin!</h2>
                <br>
	        </div>
	        
	        <!-- Info‑boxes (counts) -->
	        <div class="stats">
	            <div class="card"><h4>Total Client</h4>      <p>${s.client}</p></div>
	            <div class="card"><h4>Total Lawyer</h4>      <p>${s.lawyer}</p></div>
	            <div class="card"><h4>Total Appointment</h4> <p>${s.appointment}</p></div>
	            <div class="card"><h4>Completed Appointment</h4>    <p>${s.completed}</p></div>
	            <div class="card"><h4>Ongoing Appointment</h4>      <p>${s.ongoing}</p></div>
	            <div class="card"><h4>Cancelled Appointment</h4>    <p>${s.cancelled}</p></div>
	        </div>
	
	        
	
	        <!-- Recent logs -->
			<div class="logs">
			    <h3>System Message</h3>
			    <div class="log-entry" style="font-weight: bold;">
			        <span>#</span>
			        <span>Name</span>
			        <span>Email</span>
			        <span>Phone</span>
			        <span>Subject</span>
			        <span>Submitted At</span>
			    </div>
			
			    <c:forEach var="log" items="${logs}" varStatus="st">
			        <div class="log-entry">
			            <span>${st.index + 1}</span>
			            <span>${log.firstName} ${log.lastName}</span>
			            <span>${log.email}</span>
			            <span>${log.phone}</span>
			            <span>${log.subject}</span>
			            <span>${log.submittedAt}</span>
			        </div>
			    </c:forEach>
			
			    <c:if test="${empty logs}">
			        <div class="log-entry">
			            <span colspan="6" style="text-align:center;">No messages found.</span>
			        </div>
			    </c:if>
			</div>
	
	    </div><!-- /content -->

</body>
</html>