/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.algonquincollege.oop_final_backend.service;

import com.algonquincollege.oop_final_backend.vo.CourseVo;

import java.util.List;

/**
 *
 * @author katie
 */
public interface CourseSearchService {
    List<CourseVo> searchCourses(String institutionName, String courseCode, String courseTitle, String term, String schedule, String deliveryMethod);

}
