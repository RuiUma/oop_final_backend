package com.algonquincollege.oop_final_backend.dto;

/**
 * UserDTO is a Data Transfer Object that represents a user.
 * It is used to transfer user data between different layers of the application.
 */
public class UserDTO {

    private Integer userID;                // Unique ID of the user
    private String userType;              // Type of user (e.g., 'Professional', 'Institution')
    private String email;                 // Email of the user
    private String name;                  // Full name of the user
    private String password;              // User's password
    private String currentPosition;       // Current position of the user (for professionals)
    private Integer institutionID;        // ID of the institution associated with the user (if applicable)
    private String educationBackground;   // User's educational background (for professionals)
    private String areaOfExpertise;       // User's area of expertise (for professionals)
    private String address;               // User's address (for institutions)

    // Getters and Setters

    /**
     * Gets the unique ID of the user.
     *
     * @return The user ID.
     */
    public Integer getUserID() {
        return userID;
    }

    /**
     * Sets the unique ID of the user.
     *
     * @param userID The user ID to set.
     */
    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    /**
     * Gets the type of the user.
     *
     * @return The user type (e.g., 'Professional', 'Institution').
     */
    public String getUserType() {
        return userType;
    }

    /**
     * Sets the type of the user.
     *
     * @param userType The user type to set.
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * Gets the email of the user.
     *
     * @return The user's email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the user.
     *
     * @param email The email to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the full name of the user.
     *
     * @return The user's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the full name of the user.
     *
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the password of the user.
     *
     * @return The user's password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the current position of the user.
     *
     * @return The user's current position (for professionals).
     */
    public String getCurrentPosition() {
        return currentPosition;
    }

    /**
     * Sets the current position of the user.
     *
     * @param currentPosition The current position to set.
     */
    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    /**
     * Gets the institution ID associated with the user.
     *
     * @return The institution ID.
     */
    public Integer getInstitutionID() {
        return institutionID;
    }

    /**
     * Sets the institution ID associated with the user.
     *
     * @param institutionID The institution ID to set.
     */
    public void setInstitutionID(Integer institutionID) {
        this.institutionID = institutionID;
    }

    /**
     * Gets the educational background of the user.
     *
     * @return The user's educational background.
     */
    public String getEducationBackground() {
        return educationBackground;
    }

    /**
     * Sets the educational background of the user.
     *
     * @param educationBackground The educational background to set.
     */
    public void setEducationBackground(String educationBackground) {
        this.educationBackground = educationBackground;
    }

    /**
     * Gets the area of expertise of the user.
     *
     * @return The user's area of expertise.
     */
    public String getAreaOfExpertise() {
        return areaOfExpertise;
    }

    /**
     * Sets the area of expertise of the user.
     *
     * @param areaOfExpertise The area of expertise to set.
     */
    public void setAreaOfExpertise(String areaOfExpertise) {
        this.areaOfExpertise = areaOfExpertise;
    }

    /**
     * Gets the address of the user.
     *
     * @return The user's address (for institutions).
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the user.
     *
     * @param address The address to set.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns a string representation of the UserDTO object.
     *
     * @return A string containing the user's details.
     */
    @Override
    public String toString() {
        return "UserDTO{" +
                "userID=" + userID +
                ", userType='" + userType + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", currentPosition='" + currentPosition + '\'' +
                ", institutionID=" + institutionID +
                ", educationBackground='" + educationBackground + '\'' +
                ", areaOfExpertise='" + areaOfExpertise + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
