package com.algonquincollege.oop_final_backend.dao.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.time.LocalDateTime;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.algonquincollege.oop_final_backend.config.ConnectionPool;
import com.algonquincollege.oop_final_backend.dao.TeachingRequestDAO;
import com.algonquincollege.oop_final_backend.dto.TeachingRequestDTO;

public class TeachingRequestDAOTest {
    private static Connection connection;
    private static TeachingRequestDAO teachingRequestDAO;

    @BeforeClass
    public static void setUpClass() throws Exception {
        connection = ConnectionPool.getInstance().getConnection();
        teachingRequestDAO = new TeachingRequstDAOImpl();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        ConnectionPool.getInstance().releaseConnection(connection);
    }

    @Test
    public void testCreateTeachingRequest() {
        TeachingRequestDTO request = new TeachingRequestDTO();
        request.setCourseID(1);
        request.setProfessionalID(1);
        request.setExpertise("Expert in AI");
        request.setRequestDate(LocalDateTime.now());

        boolean result = teachingRequestDAO.createTeachingRequest(request);
        assertTrue("Teaching request should be created successfully", result);
    }

    @Test
    public void testUpdateTeachingRequestStatus() {
        int requestID = 1; 
        boolean result = teachingRequestDAO.updateTeachingRequestStatus(requestID, "Accepted");
        assertTrue("Teaching request status should be updated successfully", result);
    }

    @Test
    public void testGetTeachingRequestsByCourseID() {
        int courseID = 1;
        assertNotNull("Teaching request list should not be null", teachingRequestDAO.getTeachingRequestsByCourseID(courseID));
    }
}
