package com.algonquincollege.oop_final_backend.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import java.io.IOException;

public class LogFilter implements Filter {

    private static final Logger logger = LogManager.getLogger(LogFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("------------------------------------------------------------------------------------------");
        chain.doFilter(request, response);
        System.out.println("------------------------------------------------------------------------------------------");

    }
}
