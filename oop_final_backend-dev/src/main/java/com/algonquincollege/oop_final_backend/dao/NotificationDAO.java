package com.algonquincollege.oop_final_backend.dao;

import java.util.List;
import com.algonquincollege.oop_final_backend.dto.NotificationDTO;

/**
 * NotificationDAO defines methods for managing notifications in the database.
 * It provides an abstraction layer for creating, retrieving, and updating notifications.
 */
public interface NotificationDAO {

    /**
     * Creates a new notification in the database.
     *
     * @param notification The NotificationDTO object containing the details of the notification.
     * @return true if the notification was created successfully, false otherwise.
     */
    boolean createNotification(NotificationDTO notification);

    /**
     * Retrieves all notifications for a specific user.
     *
     * @param userID The unique identifier of the user whose notifications are to be retrieved.
     * @return A list of NotificationDTO objects containing the user's notifications.
     */
    List<NotificationDTO> getNotificationsByUserID(int userID);

    /**
     * Marks a notification as read in the database.
     *
     * @param notificationID The unique identifier of the notification to be marked as read.
     * @return true if the notification was marked as read successfully, false otherwise.
     */
    boolean markNotificationAsRead(int notificationID);
}
