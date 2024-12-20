package com.techtrack.backend.dto;


import com.techtrack.backend.Internship.model.InternshipModel;

public class ApplicationWithInternshipDTO {
    private String applicationId;
    private String userEmail;
    private InternshipModel internship;

    public ApplicationWithInternshipDTO(String applicationId, String userEmail, InternshipModel internship) {
        this.applicationId = applicationId;
        this.userEmail = userEmail;
        this.internship = internship;
    }

    // Getters and Setters
    public String getApplicationId() {
        return applicationId;
    }
    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public InternshipModel getInternship() {
        return internship;
    }
    public void setInternship(InternshipModel internship) {
        this.internship = internship;
    }
}
