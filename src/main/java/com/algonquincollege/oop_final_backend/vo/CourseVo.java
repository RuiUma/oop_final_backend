package com.algonquincollege.oop_final_backend.vo;

public class CourseVo {
    private String title;
    private String code;
    private String term;
    private Integer courseId;

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

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "CourseVo{" +
                "title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", term='" + term + '\'' +
                ", courseId=" + courseId +
                '}';
    }
}
