package com.algonquincollege.oop_final_backend.dao.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.time.LocalDateTime;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.algonquincollege.oop_final_backend.config.ConnectionPool;
import com.algonquincollege.oop_final_backend.dao.NotificationDAO;
import com.algonquincollege.oop_final_backend.dto.NotificationDTO;

public class NotificationDAOTest {
    private static Connection connection;
    private static NotificationDAO notificationDAO;

    @BeforeClass
    public static void setUpClass() throws Exception {
        connection = ConnectionPool.getInstance().getConnection();
        notificationDAO = new NotificationDAOImpl();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        ConnectionPool.getInstance().releaseConnection(connection);
    }

    @Test
    public void testCreateNotification() {
        NotificationDTO notification = new NotificationDTO();
        notification.setUserID(1);
        notification.setType("ApplicationUpdate");
        notification.setMessage("Your application was accepted.");
        notification.setCreatedAt(LocalDateTime.now());
        notification.setReadStatus(false);
        notification.setExpiresAt(null);

        boolean result = notificationDAO.createNotification(notification);
        assertTrue("Notification should be created successfully", result);
    }

    @Test
    public void testGetNotificationsByUserID() {
        int userID = 1;
        assertNotNull("Notification list should not be null", notificationDAO.getNotificationsByUserID(userID));
    }

    @Test
    public void testMarkNotificationAsRead() {
        int notificationID = 1; 
        boolean result = notificationDAO.markNotificationAsRead(notificationID);
        assertTrue("Notification should be marked as read successfully", result);
    }
}
