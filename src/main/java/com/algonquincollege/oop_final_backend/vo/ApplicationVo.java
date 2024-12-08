package com.algonquincollege.oop_final_backend.vo;

public class ApplicationVo {
    private Integer applicationId;
    private String courseTitle;
    private String professionalName;

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getProfessionalName() {
        return professionalName;
    }

    public void setProfessionalName(String professionalName) {
        this.professionalName = professionalName;
    }

    @Override
    public String toString() {
        return "ApplicationVo{" +
                "applicationId=" + applicationId +
                ", courseTitle='" + courseTitle + '\'' +
                ", professionalName='" + professionalName + '\'' +
                '}';
    }
}
