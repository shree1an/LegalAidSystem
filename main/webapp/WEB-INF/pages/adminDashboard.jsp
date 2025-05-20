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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/sidebar.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/adminDashboard.css" />
</head>
<body>
	<div class="container">
	
	    <!-- ---------- SIDEBAR ---------- -->
	    <div class="sidebar">
	        <ul class="nav">
	            <li><a href="${contextPath}/admin/dashboard"><span class="icon">🏠</span> Dashboard</a></li>
	            <li><a href="${contextPath}/manageUsers"><span class="icon">👥</span> Manage Users</a></li>
	            <li><a href="${contextPath}/verifyLawyers"><span class="icon">✅</span> Verify Lawyers</a></li>
	            <li><a href="${contextPath}/appointments"><span class="icon">📅</span> Appointments</a></li>
	            <li><a href="${contextPath}/cases"><span class="icon">📂</span> Cases</a></li>
	        </ul>
	
	        <div class="logout">
	            <form action="${contextPath}/logout" method="post">
	                <input type="submit" class="nav-button" value="Logout">
	            </form>
	        </div>
	    </div>
	
	    <!-- ---------- MAIN CONTENT ---------- -->
	    <div class="content">
	
	        <!-- Info‑boxes (counts) -->
	        <div class="header">
	            <div class="info-box"><h3>Total Client</h3>      <p>${s.client}</p></div>
	            <div class="info-box"><h3>Total Lawyer</h3>      <p>${s.lawyer}</p></div>
	            <div class="info-box"><h3>Total Appointment</h3> <p>${s.appointment}</p></div>
	            <div class="info-box"><h3>Completed Appointment</h3>    <p>${s.completed}</p></div>
	            <div class="info-box"><h3>Ongoing Appointment</h3>      <p>${s.ongoing}</p></div>
	            <div class="info-box"><h3>Cancelled Appointment</h3>    <p>${s.cancelled}</p></div>
	        </div>
	
	        <!-- Welcome card -->
	        <div class="card">
	            <div>
	                <h2>Welcome, Admin!</h2>
	                <p>Law‑Firm Management Dashboard</p><br>
	                <p>
	                    Use this dashboard to keep track of users, lawyers, cases, and appointments in one place.
	                    The statistics above refresh each time you open the page.
	                </p>
	            </div>
	            <img src="${contextPath}/resources/images/system/lawfirm.jpg" alt="Law firm">
	        </div>
	
	        <!-- Recent logs -->
	        <div class="table-container">
	            <h3>System Logs</h3>
	            <table>
	                <thead>
	                    <tr>
	                        <th>#</th><th>Message</th><th>When</th>
	                    </tr>
	                </thead>
	                <tbody>
	                    <c:forEach var="log" items="${logs}" varStatus="st">
	                        <tr>
	                            <td>${st.index + 1}</td>
	                            <td>${log.message}</td>
	                            <td>${log.age}</td>
	                        </tr>
	                    </c:forEach>
	                </tbody>
	            </table>
	        </div>
	
	    </div><!-- /content -->
	</div><!-- /container -->

</body>
</html>