/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquincollege.oop_final_backend.servlets;

import com.algonquincollege.oop_final_backend.config.ResponseWrapper;
import com.algonquincollege.oop_final_backend.dto.ResponseDTO;
import com.algonquincollege.oop_final_backend.service.CourseSearchService;
import com.algonquincollege.oop_final_backend.service.impl.CourseSearchServiceImpl;
import com.algonquincollege.oop_final_backend.vo.CourseVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 
 * 
 * @author katie
 */
@WebServlet("/searchCourses")
public class CourseSearchServlet extends HttpServlet {
    private CourseSearchService courseSearchService = new CourseSearchServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String institutionName = req.getParameter("institutionName");
        String courseCode = req.getParameter("courseCode");
        String courseTitle = req.getParameter("courseTitle");
        String term = req.getParameter("term");
        String schedule = req.getParameter("schedule");
        String deliveryMethod = req.getParameter("deliveryMethod");

        List<CourseVo> courses = courseSearchService.searchCourses(
                institutionName,
                courseCode,
                courseTitle,
                term,
                schedule,
                deliveryMethod
        );

        ResponseWrapper rw = (ResponseWrapper)resp;
        rw.setResponseDTO(ResponseDTO.success(courses));
        
        
    }
}

