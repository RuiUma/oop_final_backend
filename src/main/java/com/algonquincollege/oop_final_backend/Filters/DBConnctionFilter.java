/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquincollege.oop_final_backend.Filters;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.algonquincollege.oop_final_backend.Config.ConnectionPool;
import com.algonquincollege.oop_final_backend.Config.DatabaseConfig;
import java.sql.Connection;

/**
 *
 * @author mzr_u
 */

//@WebFilter(urlPatterns = "/*", filterName = "DBConnctionFilter")
public class DBConnctionFilter implements Filter  {
    private ConnectionPool connectionPool;
    private static final Logger logger = LogManager.getLogger(DBConnctionFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//            System.setProperty("javax.net.ssl.trustStore", "D:/Course/Code/OOP_FINAL/oop_final_backend/keystore.jks");
            connectionPool = ConnectionPool.getInstance(DatabaseConfig.DB_URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD, DatabaseConfig.POOL_SIZE);
        } catch (Exception e) {
            throw new ServletException("Failed to initialize connection pool", e);
        }
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        Connection connection = null;

        try {
            connection = connectionPool.getConnection();
            request.setAttribute("connection", connection);

            logger.info("info from DB filter");
            chain.doFilter(request, response);
        } catch (Exception e) {
            throw new ServletException("Error during database operation", e);
        } finally {
            if (connection != null) {
                connectionPool.releaseConnection(connection);
            }
        }
    }
    
    @Override
    public void destroy() {
        connectionPool.closeAllConnections();
    }
    
}
