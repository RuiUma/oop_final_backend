package com.algonquincollege.oop_final_backend.servlets;

import com.algonquincollege.oop_final_backend.Utils.GetUtil;
import com.algonquincollege.oop_final_backend.config.ResponseWrapper;
import com.algonquincollege.oop_final_backend.dto.ApplicationDTO;
import com.algonquincollege.oop_final_backend.dto.ResponseObject;
import com.algonquincollege.oop_final_backend.service.RequestService;
import com.algonquincollege.oop_final_backend.service.impl.RequestServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/request")
public class RequestServlet extends HttpServlet {
    private final RequestService requestService = new RequestServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResponseWrapper rw = (ResponseWrapper)resp;
        rw.setResponseDTO(ResponseObject.success(requestService.getApplicationsByUserId(Integer.parseInt(req.getAttribute("userId").toString()))));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map parsedBody = (Map) req.getAttribute("parsedBody");
        Integer professionalId = Integer.valueOf(req.getAttribute("userId").toString());
        Integer courseId = GetUtil.getIntValue(parsedBody, "courseId");
        ApplicationDTO applicationDTO = new ApplicationDTO();
        applicationDTO.setCourseID(courseId);
        applicationDTO.setProfessionalID(professionalId);
        ResponseWrapper rw = (ResponseWrapper)resp;
        rw.setResponseDTO(ResponseObject.success(requestService.createRequest(applicationDTO)));

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map parsedBody = (Map) req.getAttribute("parsedBody");
        Integer applicationId = GetUtil.getIntValue(parsedBody, "applicationId");
        String status = parsedBody.get("status").toString();
        ResponseWrapper rw = (ResponseWrapper)resp;
        rw.setResponseDTO(ResponseObject.success(requestService.makeDecision(applicationId, status)));

    }
}
