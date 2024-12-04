package com.algonquincollege.oop_final_backend.service;

import com.algonquincollege.oop_final_backend.dto.CourseDTO;
import com.algonquincollege.oop_final_backend.vo.CourseDetailVo;

public interface CourseService {
    CourseDetailVo getCourseDetail(int courseId);

    Boolean createCourse(CourseDTO courseDTO);
    Boolean modifyCourse(CourseDTO courseDTO);
    CourseDTO getInstitutionCourseDetail(int courseId);
}
