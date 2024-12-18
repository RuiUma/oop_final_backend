/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquincollege.oop_final_backend.filters;

import com.algonquincollege.oop_final_backend.config.ResponseWrapper;
import com.algonquincollege.oop_final_backend.dto.ResponseObject;
import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author mzr_u
 */
//@WebFilter(urlPatterns = "/*", filterName = "JsonResponseFilter")
public class JsonResponseFilter implements Filter {
    
    private static final Logger logger = LogManager.getLogger(JsonResponseFilter.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletResponse httpResponse = (HttpServletResponse) response;
        

        ResponseWrapper responseWrapper = new ResponseWrapper(httpResponse); 
        chain.doFilter(request, responseWrapper);
        
        ResponseObject<?> responseObject = responseWrapper.getResponseDTO();
        httpResponse.setStatus(200);
        
        if (responseObject != null) {
                String json = objectMapper.writeValueAsString(responseObject);

                httpResponse.setContentType("application/json");
                httpResponse.setCharacterEncoding("UTF-8");
                responseWrapper.getHeaders().forEach(httpResponse::setHeader);
                httpResponse.getWriter().write(json);
        } else {
            String originalResponse = responseWrapper.getCapturedResponse();
            writeResponse(httpResponse, responseWrapper.getHeaders(), originalResponse, httpResponse.getContentType());
        }
        
    }


    private void writeResponse(HttpServletResponse response, Map<String, String> headers, String content, String contentType)
            throws IOException {
        response.setContentType(contentType);
        response.setCharacterEncoding("UTF-8");

        headers.forEach(response::setHeader);

        response.getWriter().write(content);
    }

    
}
