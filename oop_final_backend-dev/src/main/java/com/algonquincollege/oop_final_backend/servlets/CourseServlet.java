package com.algonquincollege.oop_final_backend.servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algonquincollege.oop_final_backend.config.ResponseWrapper;
import com.algonquincollege.oop_final_backend.dto.CourseDTO;
import com.algonquincollege.oop_final_backend.dto.ResponseDTO;
import com.algonquincollege.oop_final_backend.service.CourseService;
import com.algonquincollege.oop_final_backend.service.impl.CourseServiceImpl;

/**
 * CourseServlet handles HTTP requests for managing courses.
 * It supports creating and updating courses using POST and PUT requests.
 */
@WebServlet("/courses")
public class CourseServlet extends HttpServlet {
    private final CourseService courseService = new CourseServiceImpl(); // Service to handle course-related logic

    /**
     * Handles HTTP POST requests to create a new course.
     *
     * @param req  The HTTP request object.
     * @param resp The HTTP response object.
     * @throws IOException if an input or output error occurs while processing the request.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Parse the request body into a map of key-value pairs
        Map<String, Object> parsedBody = (Map<String, Object>) req.getAttribute("parsedBody");
        
        // Create a CourseDTO object and populate it with data from the request
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

        // Call the service method to create the course
        boolean result = courseService.createCourse(course);

        // Prepare and send a response
        ResponseWrapper rw = (ResponseWrapper) resp; // Use the custom response wrapper
        ResponseDTO<String> responseDTO = result
            ? ResponseDTO.success("Course created successfully.") // Success message
            : ResponseDTO.failure("Failed to create course.");    // Failure message
        rw.setResponseDTO(responseDTO); // Set the response DTO to the response wrapper
    }

    /**
     * Handles HTTP PUT requests to update an existing course.
     *
     * @param req  The HTTP request object.
     * @param resp The HTTP response object.
     * @throws IOException if an input or output error occurs while processing the request.
     */
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Parse the request body into a map of key-value pairs
        Map<String, Object> parsedBody = (Map<String, Object>) req.getAttribute("parsedBody");

        // Create a CourseDTO object and populate it with data from the request
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

        // Call the service method to update the course
        boolean result = courseService.updateCourse(course);

        // Prepare and send a response
        ResponseWrapper rw = (ResponseWrapper) resp; // Use the custom response wrapper
        ResponseDTO<String> responseDTO = result
            ? ResponseDTO.success("Course updated successfully.") // Success message
            : ResponseDTO.failure("Failed to update course.");    // Failure message
        rw.setResponseDTO(responseDTO); // Set the response DTO to the response wrapper
    }
}
