package com.algonquincollege.oop_final_backend.vo;

public class ProfessionalApplicationVo {
    private String courseTitle;
    private Integer applicationID;
    private String status;

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public Integer getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(Integer applicationID) {
        this.applicationID = applicationID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ProfessionalApplicationVo{" +
                "courseTitle='" + courseTitle + '\'' +
                ", applicationID=" + applicationID +
                ", status='" + status + '\'' +
                '}';
    }
}
