package com.algonquincollege.oop_final_backend.dto;

import java.time.LocalDateTime;

/**
 * TeachingRequestDTO is a Data Transfer Object that represents a teaching request.
 * It is used to transfer teaching request data between different layers of the application.
 */
public class TeachingRequestDTO {

    private int requestID;             // Unique ID for the teaching request
    private int courseID;              // ID of the course being requested
    private int professionalID;        // ID of the academic professional making the request
    private String status;             // Current status of the request (e.g., Pending, Accepted, Rejected)
    private String expertise;          // Expertise details provided by the academic professional
    private LocalDateTime requestDate; // Date and time when the teaching request was submitted

    // Getters and Setters

    /**
     * Gets the unique identifier of the teaching request.
     *
     * @return The request ID.
     */
    public int getRequestID() {
        return requestID;
    }

    /**
     * Sets the unique identifier of the teaching request.
     *
     * @param requestID The request ID to set.
     */
    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    /**
     * Gets the ID of the course associated with the teaching request.
     *
     * @return The course ID.
     */
    public int getCourseID() {
        return courseID;
    }

    /**
     * Sets the ID of the course associated with the teaching request.
     *
     * @param courseID The course ID to set.
     */
    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    /**
     * Gets the ID of the academic professional making the teaching request.
     *
     * @return The professional ID.
     */
    public int getProfessionalID() {
        return professionalID;
    }

    /**
     * Sets the ID of the academic professional making the teaching request.
     *
     * @param professionalID The professional ID to set.
     */
    public void setProfessionalID(int professionalID) {
        this.professionalID = professionalID;
    }

    /**
     * Gets the current status of the teaching request.
     *
     * @return The status of the request.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the current status of the teaching request.
     *
     * @param status The status to set (e.g., Pending, Accepted, Rejected).
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the expertise details provided by the academic professional.
     *
     * @return The expertise details.
     */
    public String getExpertise() {
        return expertise;
    }

    /**
     * Sets the expertise details provided by the academic professional.
     *
     * @param expertise The expertise details to set.
     */
    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    /**
     * Gets the date and time when the teaching request was submitted.
     *
     * @return The request submission date and time.
     */
    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    /**
     * Sets the date and time when the teaching request was submitted.
     *
     * @param requestDate The request submission date and time to set.
     */
    public void setRequestDate(LocalDateTime requestDate) {
        this.requestDate = requestDate;
    }

    /**
     * Returns a string representation of the TeachingRequestDTO object.
     *
     * @return A string containing the details of the teaching request.
     */
    @Override
    public String toString() {
        return "TeachingRequestDTO{" +
                "requestID=" + requestID +
                ", courseID=" + courseID +
                ", professionalID=" + professionalID +
                ", status='" + status + '\'' +
                ", expertise='" + expertise + '\'' +
                ", requestDate=" + requestDate +
                '}';
    }
}
