package com.algonquincollege.oop_final_backend.service;

import com.algonquincollege.oop_final_backend.vo.CourseDetailVo;

public interface CourseService {
    CourseDetailVo getCourseDetail(int courseId);
}
