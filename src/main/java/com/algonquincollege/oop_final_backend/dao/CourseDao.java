package com.algonquincollege.oop_final_backend.dao;

import com.algonquincollege.oop_final_backend.vo.CourseDetailVo;

public interface CourseDao {
    CourseDetailVo getCourseDetailById(int courseId);
}
