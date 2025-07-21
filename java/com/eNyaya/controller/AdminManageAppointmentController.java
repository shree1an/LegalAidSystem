package com.eNyaya.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.eNyaya.config.DbConfig;
import com.eNyaya.model.AppointmentModel;
import com.eNyaya.service.AppointmentService;

/**
 * Servlet implementation class AdminManageAppointment
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/adminManageAppointment" })
public class AdminManageAppointmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AppointmentService appointmentService;

    @Override
    public void init() throws ServletException {
        appointmentService = new AppointmentService();
    }
    
    /**
	 * Handles GET requests to the login page.
	 *
	 * @param request  HttpServletRequest object
	 * @param response HttpServletResponse object
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 // Load all appointments for admin view:
	    List<AppointmentModel> appointmentList = appointmentService.getAllAppointments();

	    request.setAttribute("appointmentList", appointmentList);
		request.getRequestDispatcher("/WEB-INF/pages/adminManageAppointment.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	// Get session and check role
        HttpSession session = request.getSession(false);
        if (session == null || !"admin".equals(session.getAttribute("role"))) {
        	request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
            return;
        }
    	
    	String action = request.getParameter("action");

        if ("reschedule".equalsIgnoreCase(action)) {
            handleReschedule(request, response);
        } else if ("cancel".equalsIgnoreCase(action)) {
            handleCancel(request, response);
        } else {
        	request.getRequestDispatcher("/WEB-INF/pages/adminManageAppointment.jsp").forward(request, response); // Default redirect
        }
    }

    private void handleReschedule(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            int appointmentID = Integer.parseInt(request.getParameter("appointmentID"));
            String newDate = request.getParameter("newDate");  // Format: yyyy-MM-dd
            String selectedTime = request.getParameter("selectedTime");  // Format: HH:mm - HH:mm

            boolean success = appointmentService.rescheduleAppointment(appointmentID, newDate, selectedTime);

            if (success) {
                // Optionally add a success message in session or request
                HttpSession session = request.getSession();
                session.setAttribute("message", "Appointment rescheduled successfully.");
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("error", "Failed to reschedule appointment.");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            HttpSession session = request.getSession();
            session.setAttribute("error", "Invalid appointment ID.");
        }

        List<AppointmentModel> updatedList = appointmentService.getAllAppointments();
        request.setAttribute("appointmentList", updatedList);
        
        // Redirect back to manage appointments page to show updated list
        request.getRequestDispatcher("/WEB-INF/pages/adminManageAppointment.jsp").forward(request, response);
    }

    private void handleCancel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int appointmentID = Integer.parseInt(request.getParameter("appointmentID"));

            boolean deleted = cancelAppointment(appointmentID);

            if (deleted) {
                request.setAttribute("message", "Appointment canceled successfully.");
            } else {
                request.setAttribute("error", "Failed to cancel appointment.");
            }

        } catch (Exception e) {
            request.setAttribute("error", "Error occurred: " + e.getMessage());
            e.printStackTrace();
        }
        
        List<AppointmentModel> updatedList = appointmentService.getAllAppointments();
        request.setAttribute("appointmentList", updatedList);

        request.getRequestDispatcher("/WEB-INF/pages/adminManageAppointment.jsp").forward(request, response);
    }
    
    private boolean cancelAppointment(int appointmentID) {
        String query = "UPDATE Appointment SET Status = 'Cancelled' WHERE AppointmentID = ? ";
        try (Connection conn = DbConfig.getDbConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, appointmentID);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
