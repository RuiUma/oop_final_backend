package com.algonquincollege.oop_final_backend.dao;

import com.algonquincollege.oop_final_backend.vo.CourseDetailVo;
import com.algonquincollege.oop_final_backend.vo.CourseVo;

import java.util.List;

public interface CourseDao {
    CourseDetailVo getCourseDetailById(int courseId);
    List<CourseVo> getAllCourseByUserId(int userId);
}
