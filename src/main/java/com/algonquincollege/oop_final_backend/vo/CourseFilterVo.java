package com.algonquincollege.oop_final_backend.vo;

public class CourseFilterVo {
    private String institution;
    private String courseCode;
    private String term;


    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return "CourseFilterVo{" +
                "institution='" + institution + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", term='" + term + '\'' +
                '}';
    }
}
