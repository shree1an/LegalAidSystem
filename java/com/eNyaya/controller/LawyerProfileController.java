package com.eNyaya.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.eNyaya.model.LawyerModel;
import com.eNyaya.service.LawyerService;
import com.eNyaya.util.SessionUtil;

/**
 * Servlet implementation class LawyerProfile
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/lawyerProfile" })
public class LawyerProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 private final LawyerService lawyerService = new LawyerService();

	 @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {

	        // Get lawyerID from session
	        Integer lawyerId = (Integer) SessionUtil.getAttribute(req, "lawyerID");
	        if (lawyerId == null) {
	            resp.sendRedirect(req.getContextPath() + "/login");
	            return;
	        }

	        LawyerModel lawyer = lawyerService.getLawyerById(lawyerId);
	        if (lawyer == null) {
	            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Lawyer not found");
	            return;
	        }

	        req.setAttribute("lawyer", lawyer);
	        req.getRequestDispatcher("/WEB-INF/pages/lawyerProfile.jsp")
	           .forward(req, resp);
	    }

	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {

	        Integer lawyerId = (Integer) SessionUtil.getAttribute(req, "lawyerID");
	        if (lawyerId == null) {
	            resp.sendRedirect(req.getContextPath() + "/login");
	            return;
	        }

	        LawyerModel updated = new LawyerModel();
	        updated.setLawyerID(lawyerId);
	        updated.setLawyerName(req.getParameter("name"));
	        updated.setLicenseNumber(req.getParameter("licenseNumber"));
	        updated.setLawyerEmail(req.getParameter("email"));
	        updated.setLawyerNumber(req.getParameter("phone"));
	        updated.setGender(req.getParameter("gender"));
	        updated.setDistrict(req.getParameter("district"));
	        updated.setProvince(req.getParameter("province"));

	        boolean ok = lawyerService.updateLawyer(updated);
	        if (!ok) {
	            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Could not update lawyer");
	            return;
	        }

	        resp.sendRedirect(req.getContextPath() + "/lawyerProfile");
	    }

}
