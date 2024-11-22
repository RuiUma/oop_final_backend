package com.algonquincollege.oop_final_backend.Config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import javax.servlet.annotation.WebListener;

@WebListener
public class InitConfig implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            ConnectionPool.getInstance();
        } catch (Exception e) {
                throw new RuntimeException("Failed to initialize connection pool", e);
        }
    }
}
