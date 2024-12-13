package com.techtrack.backend.Internship.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;


@Document(collection = "internships")  // MongoDB collection name
public class Internship {

    @Id
    private String id;

    private String companyName;
    private String internshipTitle;
    private final LocalDateTime createdDate = LocalDateTime.now();
    private String internLocation;  // Optional field
    private String contactInformation;  // Optional field
    private String notes;  // Optional field
    private final InternshipStatus internshipStatus = InternshipStatus.APPLIED;  // Default status
}