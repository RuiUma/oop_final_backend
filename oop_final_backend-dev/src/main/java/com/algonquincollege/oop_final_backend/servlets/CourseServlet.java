package com.algonquincollege.oop_final_backend.servlets;

import com.algonquincollege.oop_final_backend.dto.CourseDTO;
import com.algonquincollege.oop_final_backend.dto.ResponseDTO;
import com.algonquincollege.oop_final_backend.service.CourseService;
import com.algonquincollege.oop_final_backend.service.impl.CourseServiceImpl;
import com.algonquincollege.oop_final_backend.config.ResponseWrapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/courses")
public class CourseServlet extends HttpServlet {
    private final CourseService courseService = new CourseServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Map<String, Object> parsedBody = (Map<String, Object>) req.getAttribute("parsedBody");
        CourseDTO course = new CourseDTO();
        course.setTitle(parsedBody.get("title").toString());
        course.setCode(parsedBody.get("code").toString());
        course.setTermID(parsedBody.get("term").toString());
        course.setOutline(parsedBody.get("outline").toString());
        course.setSchedule(parsedBody.get("schedule").toString());
        course.setPreferredQualifications(parsedBody.get("qualifications").toString());
        course.setDeliveryMethod(parsedBody.get("deliveryMethod").toString());
        course.setCompensation(Double.parseDouble(parsedBody.get("compensation").toString()));
        course.setInstitutionID((Integer) req.getAttribute("institutionID"));

        boolean result = courseService.createCourse(course);

        ResponseWrapper rw = (ResponseWrapper) resp;
        ResponseDTO<String> responseDTO = result 
            ? ResponseDTO.success("Course created successfully.") 
            : ResponseDTO.failure("Failed to create course.");
        rw.setResponseDTO(responseDTO);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Map<String, Object> parsedBody = (Map<String, Object>) req.getAttribute("parsedBody");
        CourseDTO course = new CourseDTO();
        course.setTitle(parsedBody.get("title").toString());
        course.setCode(parsedBody.get("code").toString());
        course.setTitle(parsedBody.get("term").toString());
        course.setOutline(parsedBody.get("outline").toString());
        course.setSchedule(parsedBody.get("schedule").toString());
        course.setPreferredQualifications(parsedBody.get("qualifications").toString());
        course.setDeliveryMethod(parsedBody.get("deliveryMethod").toString());
        course.setCompensation(Double.parseDouble(parsedBody.get("compensation").toString()));
        course.setInstitutionID((Integer) req.getAttribute("institutionID"));

        boolean result = courseService.updateCourse(course);

        ResponseWrapper rw = (ResponseWrapper) resp;
        ResponseDTO<String> responseDTO = result 
            ? ResponseDTO.success("Course updated successfully.") 
            : ResponseDTO.failure("Failed to update course.");
        rw.setResponseDTO(responseDTO);
    }
}
