package com.algonquincollege.oop_final_backend.dto;

import java.io.Serializable;

public class CourseDTO implements Serializable {
    private Integer courseID;
    private Integer institutionID;
    private Integer termID;
    private String title;
    private String code;
    private String schedule;
    private String deliveryMethod;
    private String outline;
    private String preferredQualifications;
    private Double compensation;

    public Integer getCourseID() {
        return courseID;
    }

    public void setCourseID(Integer courseID) {
        this.courseID = courseID;
    }

    public Integer getInstitutionID() {
        return institutionID;
    }

    public void setInstitutionID(Integer institutionID) {
        this.institutionID = institutionID;
    }

    public Integer getTermID() {
        return termID;
    }

    public void setTermID(Integer termID) {
        this.termID = termID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public String getOutline() {
        return outline;
    }

    public void setOutline(String outline) {
        this.outline = outline;
    }

    public String getPreferredQualifications() {
        return preferredQualifications;
    }

    public void setPreferredQualifications(String preferredQualifications) {
        this.preferredQualifications = preferredQualifications;
    }

    public Double getCompensation() {
        return compensation;
    }

    public void setCompensation(Double compensation) {
        this.compensation = compensation;
    }

    @Override
    public String toString() {
        return "CourseDTO{" +
                "courseID=" + courseID +
                ", institutionID=" + institutionID +
                ", termID=" + termID +
                ", title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", schedule='" + schedule + '\'' +
                ", deliveryMethod='" + deliveryMethod + '\'' +
                ", outline='" + outline + '\'' +
                ", preferredQualifications='" + preferredQualifications + '\'' +
                ", compensation=" + compensation +
                '}';
    }
}
