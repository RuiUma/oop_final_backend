package com.algonquincollege.oop_final_backend.service.impl;

import com.algonquincollege.oop_final_backend.dao.CourseDao;
import com.algonquincollege.oop_final_backend.dao.impl.CourseDaoImpl;
import com.algonquincollege.oop_final_backend.dto.CourseDTO;
import com.algonquincollege.oop_final_backend.service.CourseService;
import com.algonquincollege.oop_final_backend.vo.CourseDetailVo;

public class CourseServiceImpl implements CourseService {
    CourseDao courseDao = new CourseDaoImpl();

    @Override
    public CourseDetailVo getCourseDetail(int courseId) {
        
        return courseDao.getCourseDetailById(courseId);
    }

    @Override
    public Boolean createCourse(CourseDTO courseDTO) {
        return courseDao.createCourse(courseDTO);
    }

    @Override
    public Boolean modifyCourse(CourseDTO courseDTO) {
        return courseDao.modifyCourse(courseDTO);
    }

    @Override
    public CourseDTO getInstitutionCourseDetail(int courseId) {
        return courseDao.getInstitutionCourseDetail(courseId);
    }
}
