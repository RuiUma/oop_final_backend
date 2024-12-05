package com.algonquincollege.oop_final_backend.dao;

import com.algonquincollege.oop_final_backend.dto.NotificationDTO;
import java.util.List;

public interface NotificationDAO {
    boolean createNotification(NotificationDTO notification);

    List<NotificationDTO> getNotificationsByUserID(int userID);

    boolean markNotificationAsRead(int notificationID);
}


