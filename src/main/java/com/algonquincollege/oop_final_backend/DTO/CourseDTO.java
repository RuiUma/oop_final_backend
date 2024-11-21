package com.algonquincollege.oop_final_backend.DTO;

import java.io.Serializable;

public class CourseDTO implements Serializable {
    private String title;
    private String term;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }
}
