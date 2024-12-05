package com.algonquincollege.oop_final_backend.dto;

import java.time.LocalDateTime;

public class TeachingRequestDTO {
    private int requestID;           // Unique ID for the request
    private int courseID;            // ID of the course being requested
    private int professionalID;      // ID of the academic professional making the request
    private String status;           // Status of the request (Pending, Accepted, Rejected)
    private String expertise;        // Expertise details provided by the professional
    private LocalDateTime requestDate; // Date and time of the request submission

    // Getters and Setters
    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getProfessionalID() {
        return professionalID;
    }

    public void setProfessionalID(int professionalID) {
        this.professionalID = professionalID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDateTime requestDate) {
        this.requestDate = requestDate;
    }

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
