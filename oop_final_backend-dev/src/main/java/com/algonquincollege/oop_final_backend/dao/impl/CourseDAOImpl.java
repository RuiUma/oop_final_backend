package com.algonquincollege.oop_final_backend.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.algonquincollege.oop_final_backend.config.ConnectionPool;
import com.algonquincollege.oop_final_backend.dao.CourseDAO;
import com.algonquincollege.oop_final_backend.dto.CourseDTO;

public class CourseDAOImpl implements CourseDAO{

    @Override
    public boolean createCourse(CourseDTO course) {
        String sql = "INSERT INTO courses (title, code, term, outline, schedule, qualifications, delivery_method, compensation, institution_id) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, course.getTitle());
            stmt.setString(2, course.getCode());
            stmt.setLong(3, course.getTermID());
            stmt.setString(4, course.getOutline());
            stmt.setString(5, course.getSchedule());
            stmt.setString(6, course.getPreferredQualifications());
            stmt.setString(7, course.getDeliveryMethod());
            stmt.setDouble(8, course.getCompensation());
            stmt.setInt(9, course.getInstitutionID());
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create course: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean updateCourse(CourseDTO course) {
        String sql = "UPDATE courses SET title = ?, term = ?, outline = ?, schedule = ?, qualifications = ?, " +
                     "delivery_method = ?, compensation = ? WHERE code = ? AND institution_id = ?";
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, course.getTitle());
            stmt.setLong(2, course.getTermID());
            stmt.setString(3, course.getOutline());
            stmt.setString(4, course.getSchedule());
            stmt.setString(5, course.getPreferredQualifications());
            stmt.setString(6, course.getDeliveryMethod());
            stmt.setDouble(7, course.getCompensation());
            stmt.setString(8, course.getCode());
            stmt.setInt(9, course.getInstitutionID());
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            throw new RuntimeException("Failed to update course: " + e.getMessage(), e);
        }
    }

    @Override
    public List<CourseDTO> getCoursesByInstitution(int institutionId) {
        String sql = "SELECT * FROM courses WHERE institution_id = ?";
        List<CourseDTO> courses = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, institutionId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    CourseDTO course = new CourseDTO();
                    course.setCourseID(rs.getInt("course_id"));
                    course.setTitle(rs.getString("title"));
                    course.setCode(rs.getString("code"));
                    course.setTermID(rs.getString("term"));
                    course.setOutline(rs.getString("outline"));
                    course.setSchedule(rs.getString("schedule"));
                    course.setPreferredQualifications(rs.getString("qualifications"));
                    course.setDeliveryMethod(rs.getString("delivery_method"));
                    course.setCompensation(rs.getDouble("compensation"));
                    course.setInstitutionID(rs.getInt("institution_id"));
                    courses.add(course);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch courses: " + e.getMessage(), e);
        }
        return courses;
    }
}
