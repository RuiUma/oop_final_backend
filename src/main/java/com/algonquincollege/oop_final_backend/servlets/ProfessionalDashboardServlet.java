package com.algonquincollege.oop_final_backend.servlets;

import com.algonquincollege.oop_final_backend.config.ResponseWrapper;
import com.algonquincollege.oop_final_backend.dto.ResponseDTO;
import com.algonquincollege.oop_final_backend.service.ProfessionalService;
import com.algonquincollege.oop_final_backend.service.impl.ProfessionalServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@WebServlet("/professional/dashboard")
public class ProfessionalDashboardServlet extends HttpServlet {
    ProfessionalService professionalService = new ProfessionalServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map map = new HashMap();
        map.put("institution", Objects.requireNonNullElse(req.getParameter("institution"), ""));
        map.put("courseCode", Objects.requireNonNullElse(req.getParameter("courseCode"), ""));
        map.put("term", Objects.requireNonNullElse(req.getParameter("term"), ""));
        map.put("userEmail", req.getAttribute("userEmail"));
        map.put("userId", req.getAttribute("userId"));

        ResponseWrapper rw = (ResponseWrapper)resp;
        rw.setResponseDTO(ResponseDTO.success(professionalService.getDashBoard(map)));
    }
}
