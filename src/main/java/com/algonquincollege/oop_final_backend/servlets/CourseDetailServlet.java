package com.algonquincollege.oop_final_backend.servlets;

import com.algonquincollege.oop_final_backend.config.ResponseWrapper;
import com.algonquincollege.oop_final_backend.dto.ResponseObject;
import com.algonquincollege.oop_final_backend.service.CourseService;
import com.algonquincollege.oop_final_backend.service.ProfessionalService;
import com.algonquincollege.oop_final_backend.service.impl.CourseServiceImpl;
import com.algonquincollege.oop_final_backend.service.impl.ProfessionalServiceImpl;
import com.algonquincollege.oop_final_backend.vo.CourseDetailVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/courseDetail")
public class CourseDetailServlet extends HttpServlet {
    CourseService courseService = new CourseServiceImpl();
    ProfessionalService professionalService = new ProfessionalServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map map = new HashMap();
        CourseDetailVo courseDetailVo = courseService.getCourseDetail(Integer.parseInt(req.getParameter("courseId")));
        String applicationStatus = professionalService.getApplicationStatus(Integer.parseInt(req.getParameter("courseId")), Integer.parseInt(req.getAttribute("userId").toString()));
        map.put("courseDetails", courseDetailVo);
        map.put("applicationStatus", applicationStatus);

        ResponseWrapper rw = (ResponseWrapper)resp;
        rw.setResponseDTO(ResponseObject.success(map));

    }
}
