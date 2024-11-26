package com.algonquincollege.oop_final_backend.dto;

import java.time.LocalDateTime;

public class NotificationDTO {
    private Integer notificationID;
    private Integer userID;
    private String type;
    private String message;
    private LocalDateTime createdAt;
    private Boolean readStatus;
    private LocalDateTime expiresAt;

    public Integer getNotificationID() {
        return notificationID;
    }

    public void setNotificationID(Integer notificationID) {
        this.notificationID = notificationID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(Boolean readStatus) {
        this.readStatus = readStatus;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    @Override
    public String toString() {
        return "NotificationDTO{" +
                "notificationID=" + notificationID +
                ", userID=" + userID +
                ", type='" + type + '\'' +
                ", message='" + message + '\'' +
                ", createdAt=" + createdAt +
                ", readStatus=" + readStatus +
                ", expiresAt=" + expiresAt +
                '}';
    }

}
