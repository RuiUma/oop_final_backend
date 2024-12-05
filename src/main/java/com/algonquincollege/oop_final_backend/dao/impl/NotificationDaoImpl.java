package com.algonquincollege.oop_final_backend.dao.impl;

import com.algonquincollege.oop_final_backend.config.ConnectionPool;
import com.algonquincollege.oop_final_backend.dao.NotificationDao;
import com.algonquincollege.oop_final_backend.dto.NotificationDTO;
import com.algonquincollege.oop_final_backend.vo.SelectOption;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NotificationDaoImpl implements NotificationDao {
    @Override
    public List<NotificationDTO> getNotificationsByUserId(int userId) {
        List<NotificationDTO> resList = new ArrayList<>();

        try {
            Connection connection = ConnectionPool.getInstance().getConnection();
            String sql = "SELECT * FROM Notifications WHERE UserID = ? AND ReadStatus = 0";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, userId);

            try (ResultSet rs = stmt.executeQuery()) {
                while(rs.next()) {
                    NotificationDTO notification = new NotificationDTO();
                    notification.setNotificationID(rs.getInt("NotificationID"));
                    notification.setUserID(rs.getInt("UserID"));
                    notification.setCreatedAt(LocalDateTime.parse(rs.getString("CreatedAt")));
                    notification.setMessage(rs.getString("Message"));
                    notification.setReadStatus(rs.getBoolean("ReadStatus"));
                    notification.setExpiresAt(LocalDateTime.parse(rs.getString("ExpiresAt")));
                    notification.setType(rs.getString("Type"));
                    resList.add(notification);
                }
            }
            ConnectionPool.getInstance().releaseConnection(connection);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return resList;
    }

    @Override
    public Boolean markAsRead(int notificationId) {
        try {
            Connection connection = ConnectionPool.getInstance().getConnection();
            String sql = """
                    UPDATE Notifications set ReadStatus = true where NotificationID = ?
                """;
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, notificationId);

            int res = stmt.executeUpdate();
            ConnectionPool.getInstance().releaseConnection(connection);

            if (res > 0) {
                return true;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public Boolean createNotification(NotificationDTO notificationDTO) {
        return null;
    }
}
