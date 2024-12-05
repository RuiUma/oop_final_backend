package com.algonquincollege.oop_final_backend.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.algonquincollege.oop_final_backend.filters.JsonResponseFilter;
import com.algonquincollege.oop_final_backend.filters.LogFilter;
import com.algonquincollege.oop_final_backend.filters.RequestBodyToMapFilter;
import com.algonquincollege.oop_final_backend.filters.SessionFilter;

@WebListener
public class FilterRegistrationConfig implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        FilterRegistration.Dynamic logFilter = servletContext.addFilter("LogFilter", new LogFilter());
        logFilter.addMappingForUrlPatterns(null, false, "/*");

        FilterRegistration.Dynamic requestBodyToMapFilter = servletContext.addFilter("RequestBodyToMapFilter", new RequestBodyToMapFilter());
        requestBodyToMapFilter.addMappingForUrlPatterns(null, false, "/*");

        FilterRegistration.Dynamic jsonResponseFilter = servletContext.addFilter("JsonResponseFilter", new JsonResponseFilter());
        jsonResponseFilter.addMappingForUrlPatterns(null, false, "/*");


        FilterRegistration.Dynamic sessionFilter = servletContext.addFilter("SessionFilter", new SessionFilter());
        sessionFilter.addMappingForUrlPatterns(null, false, "/*");

    }
}
