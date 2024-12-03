package com.algonquincollege.oop_final_backend.dao;

import com.algonquincollege.oop_final_backend.dto.NotificationDTO;

import java.util.List;

public interface NotificationDao {
    List<NotificationDTO> getNotificationsByUserId(int userId);
    Boolean markAsRead(int notificationId);
}
