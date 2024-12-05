package com.algonquincollege.oop_final_backend.dao.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.algonquincollege.oop_final_backend.config.ConnectionPool;
import com.algonquincollege.oop_final_backend.dao.CourseDAO;
import com.algonquincollege.oop_final_backend.dto.CourseDTO;

public class CourseDAOTest {
    private static Connection connection;
    private static CourseDAO courseDAO;

    @BeforeClass
    public static void setUpClass() throws Exception {
        connection = ConnectionPool.getInstance().getConnection();
        courseDAO = new CourseDAOImpl();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        ConnectionPool.getInstance().releaseConnection(connection);
    }

    @Test
    public void testCreateCourse() {
        CourseDTO course = new CourseDTO();
        course.setInstitutionID(1);
        course.setTermID(1);
        course.setTitle("Test Course");
        course.setCode("TEST123");
        course.setSchedule("Morning");
        course.setDeliveryMethod("In-Person");
        course.setOutline("This is a test course outline.");
        course.setPreferredQualifications("None");
        course.setCompensation(5000.0);

        boolean result = courseDAO.createCourse(course);
        assertTrue("Course should be created successfully", result);
    }

    @Test
    public void testUpdateCourse() {
        CourseDTO course = new CourseDTO();
        course.setInstitutionID(1);
        course.setTermID(1);
        course.setTitle("Updated Test Course");
        course.setCode("TEST123");
        course.setSchedule("Evening");
        course.setDeliveryMethod("Hybrid");
        course.setOutline("Updated outline for the test course.");
        course.setPreferredQualifications("Updated qualifications.");
        course.setCompensation(6000.0);

        boolean result = courseDAO.updateCourse(course);
        assertTrue("Course should be updated successfully", result);
    }

    @Test
    public void testGetCoursesByInstitution() {
        int institutionId = 1;
        assertNotNull("Course list should not be null", courseDAO.getCoursesByInstitution(institutionId));
    }
}
