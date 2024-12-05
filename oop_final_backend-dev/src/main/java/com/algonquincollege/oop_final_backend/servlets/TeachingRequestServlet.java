package com.algonquincollege.oop_final_backend.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algonquincollege.oop_final_backend.config.DatabaseConfig;
import com.algonquincollege.oop_final_backend.dao.TeachingRequestDAO;
import com.algonquincollege.oop_final_backend.dto.TeachingRequestDTO;

/**
 * Servlet for handling teaching request operations.
 * Supports creating teaching requests via HTTP POST.
 */
@WebServlet("/teaching-requests")
public class TeachingRequestServlet extends HttpServlet {
    private TeachingRequestDAO teachingRequestDAO;

    /**
     * Constructor initializes the DAO with a database connection.
     *
     * @throws SQLException If the database connection cannot be established.
     */
    public TeachingRequestServlet() throws SQLException {
        this.teachingRequestDAO = new TeachingRequestDAO(DatabaseConfig.getConnection()); 
        // Ensures DAO has access to a valid database connection
    }

    /**
     * Handles HTTP POST requests to create a new teaching request.
     *
     * @param req  The HTTP request object containing input parameters.
     * @param resp The HTTP response object for sending the result.
     * @throws IOException If an I/O error occurs during request handling.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            // Extract parameters from the HTTP request
            int courseID = Integer.parseInt(req.getParameter("courseID"));           // Course ID for the request
            int professionalID = Integer.parseInt(req.getParameter("professionalID")); // Professional making the request
            String expertise = req.getParameter("expertise");                         // Expertise description

            // Create and populate the TeachingRequestDTO object
            TeachingRequestDTO request = new TeachingRequestDTO();
            request.setCourseID(courseID);
            request.setProfessionalID(professionalID);
            request.setExpertise(expertise);

            // Use DAO to create the teaching request
            boolean success = teachingRequestDAO.createTeachingRequest(request);

            // Respond to the client based on the success or failure of the operation
            if (success) {
                resp.setStatus(HttpServletResponse.SC_CREATED); // HTTP 201 Created
                resp.getWriter().write("Teaching request created successfully.");
            } else {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST); // HTTP 400 Bad Request
                resp.getWriter().write("Failed to create teaching request.");
            }
        } catch (Exception e) {
            // Handle any exceptions during the process
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); // HTTP 500 Internal Server Error
            resp.getWriter().write("Error: " + e.getMessage());
        }
    }
}

