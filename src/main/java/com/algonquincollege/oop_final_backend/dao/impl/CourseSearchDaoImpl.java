/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquincollege.oop_final_backend.dao.impl;

import com.algonquincollege.oop_final_backend.config.ConnectionPool;
import com.algonquincollege.oop_final_backend.dao.CourseSearchDao;
import com.algonquincollege.oop_final_backend.vo.CourseVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * @author katie
 */
public class CourseSearchDaoImpl implements CourseSearchDao {

    @Override
    public List<CourseVo> searchCourses(String institutionName, String courseCode, String courseTitle, String term, String schedule, String deliveryMethod) {
        List<CourseVo> courses = new ArrayList<>();

        try {
            Connection connection = ConnectionPool.getInstance().getConnection();
            String sql = """
                SELECT C.CourseID, C.Title, C.Code, T.Name AS Term
                FROM Courses C
                JOIN Institutions I ON C.InstitutionID = I.InstitutionID
                JOIN Terms T ON C.TermID = T.TermID
                WHERE (? IS NULL OR I.Name = ?)
                  AND (? IS NULL OR C.Code = ?)
                  AND (? IS NULL OR C.Title LIKE ?)
                  AND (? IS NULL OR T.Name = ?)
                  AND (? IS NULL OR C.Schedule = ?)
                  AND (? IS NULL OR C.DeliveryMethod = ?)
            """;

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, institutionName);
            stmt.setString(2, institutionName);
            stmt.setString(3, courseCode);
            stmt.setString(4, courseCode);
            stmt.setString(5, courseTitle);
            stmt.setString(6, "%" + courseTitle + "%");
            stmt.setString(7, term);
            stmt.setString(8, term);
            stmt.setString(9, schedule);
            stmt.setString(10, schedule);
            stmt.setString(11, deliveryMethod);
            stmt.setString(12, deliveryMethod);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    CourseVo course = new CourseVo();
                    course.setCourseId(rs.getInt("CourseID"));
                    course.setTitle(rs.getString("Title"));
                    course.setCode(rs.getString("Code"));
                    course.setTerm(rs.getString("Term"));
                    courses.add(course);
                }
            }

            ConnectionPool.getInstance().releaseConnection(connection);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return courses;
    }
}

