package com.eNyaya.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ClientHome
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/clientHome" })
public class ClientHomeController extends HttpServlet {
	
	private final clientService clientService = new clientService();
        private final lawyerProfileService lawyerProfileService = new lawyerProfileService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String idParam = req.getParameter("id");
        int id;
        try {
            id = Integer.parseInt(idParam);
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid client ID");
            return;
        }

        clientModel client = clientService.getClientById(id);
        if (client == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Client not found");
            return;
        }
        
        req.setAttribute("client", client);
        
        // --- new: load list of lawyers ---
        List<lawyerModel> lawyers = lawyerProfileService.getAllLawyers();
        req.setAttribute("lawyers", lawyers);

        req.getRequestDispatcher("/WEB-INF/pages/clientHome.jsp")
           .forward(req, resp);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
