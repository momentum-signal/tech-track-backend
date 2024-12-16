package com.techtrack.backend.Internship.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Document(collection = "internships")
public class Internship {

    @Id
    private String id;
    private String companyName;
    private String internshipTitle;
    private LocalDateTime createdDate = LocalDateTime.now();
    private String internLocation;  // Optional field
    private String contactInformation;  // Optional field
    private String notes;  // Optional field


    // No-args constructor for MongoDB
    public Internship() {
        this.createdDate = LocalDateTime.now();  // Default value for createdDate
    }

    // Parameterized constructor
    public Internship(String companyName, String internshipTitle, String internLocation,
                      String contactInformation, String notes) {
        this.companyName = companyName;
        this.internshipTitle = internshipTitle;
        this.createdDate = LocalDateTime.now();  // Assign current time during instantiation
        this.internLocation = internLocation;
        this.contactInformation = contactInformation;
        this.notes = notes;
    }
}