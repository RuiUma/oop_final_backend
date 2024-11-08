/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.algonquincollege.oop_final_backend;

import com.algonquincollege.oop_final_backend.servlets.FirstServlet;
import org.apache.catalina.startup.Tomcat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
/**
 *
 * @author mzr_u
 */
public class Oop_final_backend {
    private static final Logger logger = LogManager.getLogger(Oop_final_backend.class);


    public static void main(String[] args) throws LifecycleException {
        System.out.println("Hello World!");
        
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8082);

        String contextPath = "";
        String docBase = System.getProperty("java.io.tmpdir");


        Context ctx = tomcat.addContext(contextPath, docBase);
        
        tomcat.getConnector();
        
        Tomcat.addServlet(ctx, "FirstServlet", new FirstServlet());
        ctx.addServletMappingDecoded("/hello", "FirstServlet");


        logger.info("Starting embedded Tomcat server...");

        tomcat.start();
        tomcat.getServer().await();


    }
}
