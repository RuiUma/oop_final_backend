package com.algonquincollege.oop_final_backend.dto;

import java.io.Serializable;

public class InstitutionDTO implements Serializable {
    private Integer institutionID;
    private String name;
    private String address;

    public Integer getInstitutionID() {
        return institutionID;
    }

    public void setInstitutionID(Integer institutionID) {
        this.institutionID = institutionID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "InstitutionDTO{" +
                "institutionID=" + institutionID +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
