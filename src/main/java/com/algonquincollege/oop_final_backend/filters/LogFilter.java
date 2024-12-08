package com.algonquincollege.oop_final_backend.filters;

import com.algonquincollege.oop_final_backend.Exception.BusinessException;
import com.algonquincollege.oop_final_backend.Exception.UnAuthorizedException;
import com.algonquincollege.oop_final_backend.dto.ResponseObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


public class LogFilter implements Filter {

    private static final Logger logger = LogManager.getLogger(LogFilter.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("------------------------------------------------------------------------------------------");
        try {
            chain.doFilter(request, response);
        } catch (Exception e) {
            if (!(e instanceof BusinessException || e instanceof UnAuthorizedException)) {
                e.printStackTrace();
            }

            ResponseObject<Object> responseObject =  ResponseObject.failure(e.getMessage());
            String json = objectMapper.writeValueAsString(responseObject);
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.setContentType("application/json");
            httpResponse.setCharacterEncoding("UTF-8");
            httpResponse.getWriter().write(json);

            if (e instanceof UnAuthorizedException) {
                httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        }

        System.out.println("------------------------------------------------------------------------------------------");

    }
}
