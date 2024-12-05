/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquincollege.oop_final_backend.service.impl;

import com.algonquincollege.oop_final_backend.dao.CourseSearchDao;
import com.algonquincollege.oop_final_backend.dao.impl.CourseSearchDaoImpl;
import com.algonquincollege.oop_final_backend.service.CourseSearchService;
import com.algonquincollege.oop_final_backend.vo.CourseVo;

import java.util.List;


/**
 *
 * @author katie
 */
public class CourseSearchServiceImpl implements CourseSearchService {
    private CourseSearchDao courseSearchDao = new CourseSearchDaoImpl();

    @Override
    public List<CourseVo> searchCourses(String institutionName, String courseCode, String courseTitle, String term, String schedule, String deliveryMethod) {
        return courseSearchDao.searchCourses(institutionName, courseCode, courseTitle, term, schedule, deliveryMethod);
    }
}
