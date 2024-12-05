package com.algonquincollege.oop_final_backend.dto;

import java.time.LocalDateTime;

/**
 * NotificationDTO is a Data Transfer Object that represents a notification.
 * It is used to transfer notification data between different layers of the application.
 */
public class NotificationDTO {

    private Integer notificationID;     // Unique ID for the notification
    private Integer userID;             // ID of the user receiving the notification
    private String type;                // Type of notification (e.g., Request Accepted, Request Rejected)
    private String message;             // Notification message content
    private LocalDateTime createdAt;    // Time when the notification was created
    private Boolean readStatus;         // Whether the notification has been read
    private LocalDateTime expiresAt;    // Expiry time of the notification, if any

    // Getters and Setters

    /**
     * Gets the unique identifier of the notification.
     *
     * @return The notification ID.
     */
    public Integer getNotificationID() {
        return notificationID;
    }

    /**
     * Sets the unique identifier of the notification.
     *
     * @param notificationID The notification ID to set.
     */
    public void setNotificationID(Integer notificationID) {
        this.notificationID = notificationID;
    }

    /**
     * Gets the user ID associated with the notification.
     *
     * @return The user ID.
     */
    public Integer getUserID() {
        return userID;
    }

    /**
     * Sets the user ID associated with the notification.
     *
     * @param userID The user ID to set.
     */
    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    /**
     * Gets the type of the notification.
     *
     * @return The notification type.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the notification.
     *
     * @param type The notification type to set.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the message content of the notification.
     *
     * @return The notification message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message content of the notification.
     *
     * @param message The notification message to set.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the timestamp when the notification was created.
     *
     * @return The creation timestamp.
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the timestamp when the notification was created.
     *
     * @param createdAt The creation timestamp to set.
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets the read status of the notification.
     *
     * @return true if the notification has been read, false otherwise.
     */
    public Boolean getReadStatus() {
        return readStatus;
    }

    /**
     * Sets the read status of the notification.
     *
     * @param readStatus The read status to set.
     */
    public void setReadStatus(Boolean readStatus) {
        this.readStatus = readStatus;
    }

    /**
     * Gets the expiry timestamp of the notification.
     *
     * @return The expiry timestamp, or null if no expiry is set.
     */
    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    /**
     * Sets the expiry timestamp of the notification.
     *
     * @param expiresAt The expiry timestamp to set.
     */
    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    /**
     * Returns a string representation of the NotificationDTO object.
     *
     * @return A string containing the details of the notification.
     */
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
