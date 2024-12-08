package com.algonquincollege.oop_final_backend.filters;

import javax.servlet.Filter;

import com.algonquincollege.oop_final_backend.servlets.FirstServlet;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;


//@WebFilter(urlPatterns = "/*", filterName = "RequestBodyToMapFilter")
public class RequestBodyToMapFilter implements Filter {
    private static final Logger logger = LogManager.getLogger(RequestBodyToMapFilter.class);

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String method = httpRequest.getMethod();
        if ("POST".equalsIgnoreCase(method) || "PUT".equalsIgnoreCase(method)) {

            String body = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

            if (body == null || body.isEmpty()) {
                request.setAttribute("parsedBody", null);
                logger.info("Request Body: null");

            } else {
                Map bodyMap = objectMapper.readValue(body, Map.class);
                request.setAttribute("parsedBody", bodyMap);
                logger.info("Request Body: " + bodyMap);
            }


        }

        chain.doFilter(request,response);
    }
}
