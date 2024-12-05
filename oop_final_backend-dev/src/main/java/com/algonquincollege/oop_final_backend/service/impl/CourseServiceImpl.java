package com.algonquincollege.oop_final_backend.service.impl;

import java.util.List;

import com.algonquincollege.oop_final_backend.dao.CourseDAO;
import com.algonquincollege.oop_final_backend.dao.impl.CourseDAOImpl;
import com.algonquincollege.oop_final_backend.dto.CourseDTO;
import com.algonquincollege.oop_final_backend.service.CourseService;

public class CourseServiceImpl implements CourseService {
    private final CourseDAO courseDao = new CourseDAOImpl();

    @Override
    public boolean createCourse(CourseDTO course) {
        return courseDao.createCourse(course);
    }

    @Override
    public boolean updateCourse(CourseDTO course) {
        return courseDao.updateCourse(course);
    }

    @Override
    public List<CourseDTO> getCoursesByInstitution(int institutionId) {
        return courseDao.getCoursesByInstitution(institutionId);
    }
}
