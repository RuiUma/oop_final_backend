package com.algonquincollege.oop_final_backend.service;

import com.algonquincollege.oop_final_backend.vo.CourseVo;

import java.util.List;

public interface InstitutionService {
    List<CourseVo> getAllCourseByUserId(int userId);
}
