package com.algonquincollege.oop_final_backend.servlets;

import com.algonquincollege.oop_final_backend.Utils.GetUtil;
import com.algonquincollege.oop_final_backend.config.ResponseWrapper;
import com.algonquincollege.oop_final_backend.dto.CourseDTO;
import com.algonquincollege.oop_final_backend.dto.ResponseObject;
import com.algonquincollege.oop_final_backend.service.CourseService;
import com.algonquincollege.oop_final_backend.service.impl.CourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/course")
public class CourseServlet extends HttpServlet {
    private final CourseService courseService = new CourseServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map parsedBody = (Map) req.getAttribute("parsedBody");
        CourseDTO courseDTO = new CourseDTO();

        courseDTO.setInstitutionId(GetUtil.getIntValue(req.getAttribute("userId")));

        courseDTO.setCode(GetUtil.getValue(parsedBody, "code"));
        courseDTO.setTermId(GetUtil.getIntValue(parsedBody,"termId"));
        courseDTO.setTitle(GetUtil.getValue(parsedBody,"title"));
        courseDTO.setSchedule(GetUtil.getValue(parsedBody,"schedule"));
        courseDTO.setDeliveryMethod(GetUtil.getValue(parsedBody, "deliveryMethod"));
        courseDTO.setOutline(GetUtil.getValue(parsedBody, "outline"));
        courseDTO.setPreferredQualifications(GetUtil.getValue(parsedBody, "preferredQualifications"));
        courseDTO.setCompensation(GetUtil.getDoubleValue(parsedBody, "compensation"));

        ResponseWrapper rw = (ResponseWrapper)resp;
        if (courseService.createCourse(courseDTO)) {
            rw.setResponseDTO(ResponseObject.success("Successfully created course."));
        } else {
            rw.setResponseDTO(ResponseObject.failure("Failed to create course."));
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map parsedBody = (Map) req.getAttribute("parsedBody");
        CourseDTO courseDTO = new CourseDTO();

        courseDTO.setInstitutionId(GetUtil.getIntValue(req.getAttribute("userId")));

        courseDTO.setCode(GetUtil.getValue(parsedBody, "code"));
        courseDTO.setTermId(GetUtil.getIntValue(parsedBody,"termId"));
        courseDTO.setTitle(GetUtil.getValue(parsedBody,"title"));
        courseDTO.setSchedule(GetUtil.getValue(parsedBody,"schedule"));
        courseDTO.setDeliveryMethod(GetUtil.getValue(parsedBody, "deliveryMethod"));
        courseDTO.setOutline(GetUtil.getValue(parsedBody, "outline"));
        courseDTO.setPreferredQualifications(GetUtil.getValue(parsedBody, "preferredQualifications"));
        courseDTO.setCompensation(GetUtil.getDoubleValue(parsedBody, "compensation"));
        courseDTO.setCourseId(GetUtil.getIntValue(parsedBody, "courseId"));

        ResponseWrapper rw = (ResponseWrapper)resp;
        if (courseService.modifyCourse(courseDTO)) {
            rw.setResponseDTO(ResponseObject.success("Successfully modified course."));
        } else {
            rw.setResponseDTO(ResponseObject.failure("Failed to modify course."));
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CourseDTO courseDTO = courseService.getInstitutionCourseDetail(Integer.parseInt(req.getParameter("courseId")));
        ResponseWrapper rw = (ResponseWrapper)resp;
        rw.setResponseDTO(ResponseObject.success(courseDTO));

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
