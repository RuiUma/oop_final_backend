package com.algonquincollege.oop_final_backend.service;

import java.util.List;

import com.algonquincollege.oop_final_backend.dto.CourseDTO;

public interface CourseService {
    boolean createCourse(CourseDTO course);
    boolean updateCourse(CourseDTO course);
    List<CourseDTO> getCoursesByInstitution(int institutionId);
}

