package com.algonquincollege.oop_final_backend.dao;

import com.algonquincollege.oop_final_backend.vo.CourseFilterVo;
import com.algonquincollege.oop_final_backend.vo.CourseVo;
import com.algonquincollege.oop_final_backend.vo.ProfessionalApplicationVo;

import java.util.List;

public interface ProfessionalDao {
    List<ProfessionalApplicationVo> getApplicationsByUserId(int id);
    List<CourseVo> searchCourseByFilters(CourseFilterVo vo);
    String getApplicationStatus(int courseId, int userId);
}
