package com.algonquincollege.oop_final_backend.servlets;

import com.algonquincollege.oop_final_backend.config.ResponseWrapper;
import com.algonquincollege.oop_final_backend.dto.ResponseObject;
import com.algonquincollege.oop_final_backend.service.InstitutionService;
import com.algonquincollege.oop_final_backend.service.impl.InstitutionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/institution/dashboard")
public class InstitutionDashboard extends HttpServlet {
    private final InstitutionService institutionService = new InstitutionServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ResponseWrapper rw = (ResponseWrapper)resp;

        rw.setResponseDTO(ResponseObject.success(institutionService.getAllCourseByUserId(Integer.parseInt(req.getAttribute("userId").toString()))));

    }
}
