package com.techtrack.backend.Internship.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;


@Document(collection = "internships")
public class InternshipModel {

    @Id
    private String id;
    private String companyName;
    private String internshipTitle;
    private String location;  // Optional field

    private String contactInformation;  // Optional field



    private String notes;  // Optional field
    private LocalDateTime createdDate;


    public String getId() {
        return id;
    }
    public void setId(String _id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getInternshipTitle() {
        return internshipTitle;
    }
    public void setInternshipTitle(String internshipTitle) {
        this.internshipTitle = internshipTitle;
    }

    public void setLocation(String internLocation) {
        this.location = internLocation;
    }
    public String getLocation() {
        return location;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }
    public String getContactInformation() {
        return contactInformation;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public String getNotes() {
        return notes;
    }


    public LocalDateTime getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }


}