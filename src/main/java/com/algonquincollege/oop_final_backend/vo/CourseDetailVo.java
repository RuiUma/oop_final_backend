package com.algonquincollege.oop_final_backend.vo;

public class CourseDetailVo {
    private String title;
    private String code;
    private String termName;
    private String schedule;
    private String deliveryMethod;
    private String compensation;
    private String preferredQualifications;
    private String outline;

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

    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
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

    public String getCompensation() {
        return compensation;
    }

    public void setCompensation(String compensation) {
        this.compensation = compensation;
    }

    public String getPreferredQualifications() {
        return preferredQualifications;
    }

    public void setPreferredQualifications(String preferredQualifications) {
        this.preferredQualifications = preferredQualifications;
    }

    public String getOutline() {
        return outline;
    }

    public void setOutline(String outline) {
        this.outline = outline;
    }

    @Override
    public String toString() {
        return "CourseDetailVo{" +
                "title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", termName='" + termName + '\'' +
                ", schedule='" + schedule + '\'' +
                ", deliveryMethod='" + deliveryMethod + '\'' +
                ", compensation='" + compensation + '\'' +
                ", preferredQualifications='" + preferredQualifications + '\'' +
                ", outline='" + outline + '\'' +
                '}';
    }
}
