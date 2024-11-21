/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquincollege.oop_final_backend.servlets;


import javax.servlet.*;
import javax.servlet.http.*;
//import java.sql.*;
import javax.servlet.annotation.WebServlet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;

/**
 *
 * @author mzr_u
 */

@WebServlet("/hello")
public class FirstServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(FirstServlet.class);
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException {
        Connection connection = (Connection) req.getAttribute("connection");

        try {
            String sql = "SELECT * FROM Users";
            PreparedStatement stmt = connection.prepareStatement(sql);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    logger.info(rs.getInt("YEAR"));
                }
            }

        } catch (Exception e) {
            throw new ServletException("Database error", e);
        }
        
        logger.info("log from first servlet");
        resp.getWriter().println("Hello from @WebServlet!");
    }
}
