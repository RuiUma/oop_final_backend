package com.algonquincollege.oop_final_backend.filters;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;


//@WebFilter(urlPatterns = "/*", filterName = "RequestBodyToMapFilter")
public class RequestBodyToMapFilter implements Filter {
    private static final Logger logger = LogManager.getLogger(RequestBodyToMapFilter.class);

    private final ObjectMapper objectMapper = new ObjectMapper();

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
