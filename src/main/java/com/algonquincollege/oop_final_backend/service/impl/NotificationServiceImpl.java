package com.algonquincollege.oop_final_backend.service.impl;

import com.algonquincollege.oop_final_backend.dao.NotificationDao;
import com.algonquincollege.oop_final_backend.dao.impl.NotificationDaoImpl;
import com.algonquincollege.oop_final_backend.dto.NotificationDTO;
import com.algonquincollege.oop_final_backend.service.NotificationService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationServiceImpl implements NotificationService {
    NotificationDao notificationDao = new NotificationDaoImpl();
    @Override
    public List<NotificationDTO> getNotificationsByUserId(int userId) {
        return notificationDao.getNotificationsByUserId(userId);
    }

    @Override
    public Boolean markAsRead(int notificationId) {

        return null;
    }
}
