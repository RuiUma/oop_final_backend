package com.algonquincollege.oop_final_backend.service;

import com.algonquincollege.oop_final_backend.dto.NotificationDTO;

import java.util.List;

public interface NotificationService {
    List<NotificationDTO> getNotificationsByUserId(int userId);
    Boolean markAsRead(int notificationId);
//    Boolean createNotification()
}
