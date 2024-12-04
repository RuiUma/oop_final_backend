package com.algonquincollege.oop_final_backend.service.impl;

import com.algonquincollege.oop_final_backend.dao.CourseDao;
import com.algonquincollege.oop_final_backend.dao.impl.CourseDaoImpl;
import com.algonquincollege.oop_final_backend.service.InstitutionService;
import com.algonquincollege.oop_final_backend.vo.CourseVo;

import java.util.List;

public class InstitutionServiceImpl implements InstitutionService {
    private final CourseDao courseDao = new CourseDaoImpl();
    @Override
    public List<CourseVo> getAllCourseByUserId(int userId) {
        return courseDao.getAllCourseByUserId(userId);
    }
}
