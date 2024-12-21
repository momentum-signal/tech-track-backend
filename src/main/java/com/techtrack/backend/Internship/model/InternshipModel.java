package com.techtrack.backend.Internship.model;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.mongodb.core.mapping.Document;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;


@Document(collection = "internships")
public class InternshipModel {

    @Id
    @NotNull(message = "ID is required")
    private String id;
    @NotNull(message = "Company name is required")
    private String companyName;
    @NotNull(message = "Company logo url is required")
    private String companyLogoUrl;
    @NotNull(message = "Internship title is required")
    private String internshipTitle;
    @NotNull(message = "Internship title is required")
    private String internshipDescription;
    private String salaryRange;

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

    public String getCompanyLogoUrl() {
        return companyLogoUrl;
    }

    public void setCompanyLogoUrl(String companyLogoUrl) {
        this.companyLogoUrl = companyLogoUrl;
    }

    public String getInternshipTitle() {
        return internshipTitle;
    }

    public void setInternshipTitle(String internshipTitle) {
        this.internshipTitle = internshipTitle;
    }

    public String getInternshipDescription() {
        return internshipDescription;
    }

    public void setInternshipDescription(String internshipDescription) {
        this.internshipDescription = internshipDescription;
    }

    public String getSalaryRange() {
        return salaryRange;
    }

    public void setSalaryRange(String salaryRange) {
        this.salaryRange = salaryRange;
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