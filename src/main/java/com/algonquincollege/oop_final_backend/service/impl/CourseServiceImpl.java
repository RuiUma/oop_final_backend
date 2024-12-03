package com.algonquincollege.oop_final_backend.service.impl;

import com.algonquincollege.oop_final_backend.dao.CourseDao;
import com.algonquincollege.oop_final_backend.dao.impl.CourseDaoImpl;
import com.algonquincollege.oop_final_backend.service.CourseService;
import com.algonquincollege.oop_final_backend.vo.CourseDetailVo;

public class CourseServiceImpl implements CourseService {
    CourseDao courseDao = new CourseDaoImpl();

    @Override
    public CourseDetailVo getCourseDetail(int courseId) {
        
        return courseDao.getCourseDetailById(courseId);
    }
}
