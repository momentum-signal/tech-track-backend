package com.techtrack.backend.Application.model;

import com.techtrack.backend.Internship.model.InternshipModel;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "applications")
public class ApplicationModel {
    @Id
    @NotNull(message = "ID is required")
    private String id;
    @NotNull(message = "User email is required")
    private String userEmail;
    @NotNull(message = "Internship ID is required")
    private String internshipId;


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getInternshipId() {
        return internshipId;
    }

    public void setInternshipId(String internshipId) {
        this.internshipId = internshipId;

    }
}
