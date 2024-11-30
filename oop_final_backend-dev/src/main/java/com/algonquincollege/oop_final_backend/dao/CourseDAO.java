package com.algonquincollege.oop_final_backend.dao;

import com.algonquincollege.oop_final_backend.dto.CourseDTO;

import java.util.List;

public interface CourseDAO {
    boolean createCourse(CourseDTO course);
    boolean updateCourse(CourseDTO course);
    List<CourseDTO> getCoursesByInstitution(int institutionId);
}
