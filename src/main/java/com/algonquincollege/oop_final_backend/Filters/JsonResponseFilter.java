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

/**
 *
 * @author mzr_u
 */
@WebFilter(urlPatterns = "/*", filterName = "JsonResponseFilter")
public class JsonResponseFilter implements Filter {
    
    private static final Logger logger = LogManager.getLogger(JsonResponseFilter.class);

    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        logger.info("test from filter");
        
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setContentType("application/json");
        httpResponse.setCharacterEncoding("UTF-8");

        chain.doFilter(request, response);
    }

    
}
