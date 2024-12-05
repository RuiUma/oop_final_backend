package com.algonquincollege.oop_final_backend.factory;

import com.algonquincollege.oop_final_backend.dto.NotificationDTO;

public class NotificationFactory {
    public static NotificationDTO createNotification(int userId, String message) {
        NotificationDTO.Builder builder = new NotificationDTO.Builder();
        return builder.setUserID(userId).setMessage(message).build();
    }
}

