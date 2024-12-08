package com.algonquincollege.oop_final_backend.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class TermDTO implements Serializable {

    private Integer termID;
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public Integer getTermID() {
        return termID;
    }

    public void setTermID(Integer termID) {
        this.termID = termID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "TermDTO{" +
                "termID=" + termID +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
