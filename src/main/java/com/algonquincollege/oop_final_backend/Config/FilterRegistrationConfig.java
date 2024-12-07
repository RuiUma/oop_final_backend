package com.algonquincollege.oop_final_backend.Config;

import com.algonquincollege.oop_final_backend.Filters.DBConnctionFilter;
import com.algonquincollege.oop_final_backend.Filters.JsonResponseFilter;
import com.algonquincollege.oop_final_backend.Filters.RequestBodyToMapFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;

@WebListener
public class FilterRegistrationConfig implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        FilterRegistration.Dynamic requestBodyToMapFilter = servletContext.addFilter("RequestBodyToMapFilter", new RequestBodyToMapFilter());
        requestBodyToMapFilter.addMappingForUrlPatterns(null, false, "/*");

        FilterRegistration.Dynamic jsonResponseFilter = servletContext.addFilter("JsonResponseFilter", new JsonResponseFilter());
        jsonResponseFilter.addMappingForUrlPatterns(null, false, "/*");

        FilterRegistration.Dynamic dBConnctionFilter = servletContext.addFilter("DBConnctionFilter", new DBConnctionFilter());
        dBConnctionFilter.addMappingForUrlPatterns(null, false, "/*");

    }
}
