package com.algonquincollege.oop_final_backend.dao.impl;

import com.algonquincollege.oop_final_backend.config.ConnectionPool;
import com.algonquincollege.oop_final_backend.dao.NotificationDAO;
import com.algonquincollege.oop_final_backend.dto.NotificationDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class NotificationDAOImpl implements NotificationDAO {
    @Override
    public boolean createNotification(NotificationDTO notification) {
        String sql = "INSERT INTO notifications (user_id, type, message, created_at, read_status, expires_at) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, notification.getUserID());
            stmt.setString(2, notification.getType());
            stmt.setString(3, notification.getMessage());
            stmt.setTimestamp(4, Timestamp.valueOf(notification.getCreatedAt()));
            stmt.setBoolean(5, notification.getReadStatus());
            stmt.setTimestamp(6, notification.getExpiresAt() != null ? Timestamp.valueOf(notification.getExpiresAt()) : null);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create notification: " + e.getMessage(), e);
        }
    }

    @Override
    public List<NotificationDTO> getNotificationsByUserID(int userID) {
        String sql = "SELECT * FROM notifications WHERE user_id = ?";
        List<NotificationDTO> notifications = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userID);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    NotificationDTO notification = new NotificationDTO();
                    notification.setNotificationID(rs.getInt("notification_id"));
                    notification.setUserID(rs.getInt("user_id"));
                    notification.setType(rs.getString("type"));
                    notification.setMessage(rs.getString("message"));
                    notification.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                    notification.setReadStatus(rs.getBoolean("read_status"));
                    notification.setExpiresAt(rs.getTimestamp("expires_at") != null
                            ? rs.getTimestamp("expires_at").toLocalDateTime() : null);
                    notifications.add(notification);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve notifications: " + e.getMessage(), e);
        }
        return notifications;
    }

    @Override
    public boolean markNotificationAsRead(int notificationID) {
        String sql = "UPDATE notifications SET read_status = true WHERE notification_id = ?";
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, notificationID);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            throw new RuntimeException("Failed to mark notification as read: " + e.getMessage(), e);
        }
    }
}
