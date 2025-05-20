package com.eNyaya.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class LawyerProfile
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/lawyerProfile" })
public class LawyerProfileController extends HttpServlet {
    private final lawyerProfileService lawyerService = new lawyerProfileService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String idParam = req.getParameter("id");
        int id;
        try {
            id = Integer.parseInt(idParam);
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid lawyer ID");
            return;
        }

        lawyerModel lawyer = lawyerService.getLawyerById(id);
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

        int id = Integer.parseInt(req.getParameter("id"));
        lawyerModel updated = new lawyerModel();
        updated.setId(id);
        updated.setName(req.getParameter("name"));
        updated.setLicense(Integer.parseInt(req.getParameter("license")));
        updated.setExpYear(Integer.parseInt(req.getParameter("expYear")));
        updated.setEmail(req.getParameter("email"));
        updated.setDob(LocalDate.parse(req.getParameter("dob")));
        updated.setGender(req.getParameter("gender"));
        updated.setPhone(req.getParameter("phone"));
        updated.setAddress(req.getParameter("address"));
        updated.setDistrict(req.getParameter("district"));
        updated.setProvince(req.getParameter("province"));

        boolean ok = lawyerService.updateLawyer(updated);
        if (!ok) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                           "Could not update lawyer");
            return;
        }
        
        resp.sendRedirect(req.getContextPath()
            + "/lawyer/profile?id=" + id);
    }
}
