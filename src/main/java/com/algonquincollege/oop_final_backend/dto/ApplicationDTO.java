package com.algonquincollege.oop_final_backend.dto;

import java.time.LocalDateTime;

public class ApplicationDTO {
    private Integer applicationID;
    private Integer courseID;
    private Integer professionalID;
    private String status;
    private LocalDateTime submissionDate;
    private LocalDateTime reviewDate;
    private Integer reviewedBy;
    private String reason;

    public Integer getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(Integer applicationID) {
        this.applicationID = applicationID;
    }

    public Integer getCourseID() {
        return courseID;
    }

    public void setCourseID(Integer courseID) {
        this.courseID = courseID;
    }

    public Integer getProfessionalID() {
        return professionalID;
    }

    public void setProfessionalID(Integer professionalID) {
        this.professionalID = professionalID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(LocalDateTime submissionDate) {
        this.submissionDate = submissionDate;
    }

    public LocalDateTime getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDateTime reviewDate) {
        this.reviewDate = reviewDate;
    }

    public Integer getReviewedBy() {
        return reviewedBy;
    }

    public void setReviewedBy(Integer reviewedBy) {
        this.reviewedBy = reviewedBy;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "ApplicationDTO{" +
                "applicationID=" + applicationID +
                ", courseID=" + courseID +
                ", professionalID=" + professionalID +
                ", status='" + status + '\'' +
                ", submissionDate=" + submissionDate +
                ", reviewDate=" + reviewDate +
                ", reviewedBy=" + reviewedBy +
                ", reason='" + reason + '\'' +
                '}';
    }
}
