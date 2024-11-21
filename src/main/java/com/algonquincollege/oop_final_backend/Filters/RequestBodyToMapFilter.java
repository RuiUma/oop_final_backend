package com.algonquincollege.oop_final_backend.Filters;

import javax.servlet.Filter;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Map;
import java.util.stream.Collectors;


//@WebFilter(urlPatterns = "/*", filterName = "RequestBodyToMapFilter")
public class RequestBodyToMapFilter implements Filter {
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
            }else {
                Map bodyMap = objectMapper.readValue(body, Map.class);
                request.setAttribute("parsedBody", bodyMap);
            }


        }

        chain.doFilter(request,response);
    }
}
