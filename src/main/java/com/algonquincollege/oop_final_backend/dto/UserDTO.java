package com.algonquincollege.oop_final_backend.dto;

public class UserDTO {
    private Integer userID;
    private String userType;
    private String email;
    private String name;
    private String password;
    private String profileCreated;
    private String currentPosition;
    private Integer institutionID;
    private String educationBackground;
    private String areaOfExpertise;
    private String address;

    public String getProfileCreated() {
        return profileCreated;
    }

    public void setProfileCreated(String profileCreated) {
        this.profileCreated = profileCreated;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Integer getInstitutionID() {
        return institutionID;
    }

    public void setInstitutionID(Integer institutionID) {
        this.institutionID = institutionID;
    }

    public String getEducationBackground() {
        return educationBackground;
    }

    public void setEducationBackground(String educationBackground) {
        this.educationBackground = educationBackground;
    }

    public String getAreaOfExpertise() {
        return areaOfExpertise;
    }

    public void setAreaOfExpertise(String areaOfExpertise) {
        this.areaOfExpertise = areaOfExpertise;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "UserDTO{" +
                "userID=" + userID +
                ", userType='" + userType + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", profileCreated='" + profileCreated + '\'' +
                ", currentPosition='" + currentPosition + '\'' +
                ", institutionID=" + institutionID +
                ", educationBackground='" + educationBackground + '\'' +
                ", areaOfExpertise='" + areaOfExpertise + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
