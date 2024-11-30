/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquincollege.oop_final_backend.servlets;


import com.algonquincollege.oop_final_backend.config.ConnectionPool;
import com.algonquincollege.oop_final_backend.config.ResponseWrapper;
import com.algonquincollege.oop_final_backend.dto.CourseDTO;
import com.algonquincollege.oop_final_backend.dto.ResponseDTO;

import javax.servlet.http.*;
//import java.sql.*;
import javax.servlet.annotation.WebServlet;

import com.algonquincollege.oop_final_backend.dto.UserDTO;
import com.algonquincollege.oop_final_backend.service.AuthService;
import com.algonquincollege.oop_final_backend.service.impl.AuthServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;

/**
 *
 * @author mzr_u
 */

@WebServlet("/hello")
public class FirstServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(FirstServlet.class);
    private AuthService authService = new AuthServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException {
        
        // database part.
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        int rowCount = 0;
        try {
            String sql = "SELECT count(*) as total FROM Users";
            PreparedStatement stmt = connection.prepareStatement(sql);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    rowCount = rs.getInt("total");
                }
            }

        } catch (Exception e) {
            throw new ServletException("Database error", e);
        }
        
        logger.info("log from first servlet");
        
        
        // logic part.
        List<CourseDTO> data = new ArrayList<>();
        data.add(new CourseDTO());
        data.add(new CourseDTO());
//        data.add("test string 1");
//        data.add("test string 2");

        Map map = new HashMap();
        map.put("listData",data);
        map.put("total row number", rowCount);


        ResponseDTO<Map> responseDTO = ResponseDTO.success(map);
        ResponseWrapper rw = (ResponseWrapper)resp;
        rw.setResponseDTO(responseDTO);
        try {
            ConnectionPool.getInstance().releaseConnection(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Map parsedBody = (Map) req.getAttribute("parsedBody");
        UserDTO userDTO = new UserDTO();
        userDTO.setPassword(parsedBody.get("password").toString());
        userDTO.setEmail(parsedBody.get("email").toString());

        logger.info(userDTO);
        String jwt = authService.login(userDTO);

        logger.info(jwt);

        resp.setHeader("jwt", jwt);
        resp.getWriter().write(jwt);
    }

}
