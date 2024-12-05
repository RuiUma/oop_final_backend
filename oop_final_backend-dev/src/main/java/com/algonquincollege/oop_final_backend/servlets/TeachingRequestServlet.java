package com.algonquincollege.oop_final_backend.servlets;

import com.algonquincollege.oop_final_backend.config.DatabaseConfig;
import com.algonquincollege.oop_final_backend.dao.TeachingRequestDAO;
import com.algonquincollege.oop_final_backend.dto.TeachingRequestDTO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/teaching-requests")
public class TeachingRequestServlet extends HttpServlet {
    private TeachingRequestDAO teachingRequestDAO;

    public TeachingRequestServlet() throws SQLException {
        this.teachingRequestDAO = new TeachingRequestDAO(DatabaseConfig.getConnection()); // Ensure you have a DatabaseConnection class
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            int courseID = Integer.parseInt(req.getParameter("courseID"));
            int professionalID = Integer.parseInt(req.getParameter("professionalID"));
            String expertise = req.getParameter("expertise");

            TeachingRequestDTO request = new TeachingRequestDTO();
            request.setCourseID(courseID);
            request.setProfessionalID(professionalID);
            request.setExpertise(expertise);

            boolean success = teachingRequestDAO.createRequest(request);

            if (success) {
                resp.setStatus(HttpServletResponse.SC_CREATED);
                resp.getWriter().write("Teaching request created successfully.");
            } else {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                resp.getWriter().write("Failed to create teaching request.");
            }
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().write("Error: " + e.getMessage());
        }
    }
}
