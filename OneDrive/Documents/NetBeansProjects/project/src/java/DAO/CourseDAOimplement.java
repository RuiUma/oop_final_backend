/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import models.Course;
import java.sql.*;
/**
 *
 * @author baljo
 */

public class CourseDAOimplement implements CourseDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/coursemanagement?zeroDateTimeBehavior=CONVERT_TO_NULL [root on Default schema]";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Saini@2021";

    @Override
    public boolean insertCourse(Course course) {
        String query = "INSERT INTO courses (title, code, term) VALUES (?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, course.getTitle());
            preparedStatement.setString(2, course.getCode());
            preparedStatement.setString(3, course.getTerm());

            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Course fetchCourseByCode(String code) {
        String query = "SELECT title, code, term FROM courses WHERE code = ?";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, code);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Course(resultSet.getString("title"),
                                  resultSet.getString("code"),
                                  resultSet.getString("term"));
            }
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public boolean updateCourse(Course course) {
        String query = "UPDATE courses SET title = ?, term = ? WHERE code = ?";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, course.getTitle());
            preparedStatement.setString(2, course.getTerm());
            preparedStatement.setString(3, course.getCode());

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (Exception e) {
            return false;
        }
    }
}

