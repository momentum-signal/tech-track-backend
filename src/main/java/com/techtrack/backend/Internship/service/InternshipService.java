package com.techtrack.backend.Internship.service;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import com.techtrack.backend.Internship.model.InternshipModel;
import com.techtrack.backend.Internship.repository.InternshipRepository;


//@Service
@Component
public class InternshipService {

    @Autowired
    private InternshipRepository internshipRepository;

    // Create a new internship
    public InternshipModel createInternship(InternshipModel internship) {
        return internshipRepository.save(internship);
    }

    // Get all internships data by ID
    public List<InternshipModel> getAllInternships() {
        return internshipRepository.findAll();
    }

    // Get single internship data
    public Optional<InternshipModel> getSingleInternship(String id) {
        return internshipRepository.findById(id);
    }
    
    //Delete internship data
    public boolean deleteInternship(String id) {
        if(internshipRepository.existsById(id)) {
            internshipRepository.deleteById(id);
            return true;
        }
        else{
            return false;
        }
    }

    //Edit internship details
    public InternshipModel editInternship (String id, InternshipModel updatedInternship){
        Optional<InternshipModel> existingInternship = internshipRepository.findById(id);
        if(existingInternship.isPresent()){
            InternshipModel internship = existingInternship.get();
            if (updatedInternship.getCompanyName() != null) {
                internship.setCompanyName(updatedInternship.getCompanyName());
            }
            if (updatedInternship.getCompanyLogoUrl() != null) {
                internship.setCompanyLogoUrl(updatedInternship.getCompanyLogoUrl());
            }
            if (updatedInternship.getInternshipTitle() != null) {
                internship.setInternshipTitle(updatedInternship.getInternshipTitle());
            }
            if (updatedInternship.getInternshipDescription() != null) {
                internship.setInternshipDescription(updatedInternship.getInternshipDescription());
            }
            if (updatedInternship.getSalaryRange() != null) {
                internship.setSalaryRange(updatedInternship.getSalaryRange());
            }
            if (updatedInternship.getLocation() != null) {
                internship.setLocation(updatedInternship.getLocation());
            }
            if (updatedInternship.getContactInformation() != null) {
                internship.setContactInformation(updatedInternship.getContactInformation());
            }
            if (updatedInternship.getNotes() != null) {
                internship.setNotes(updatedInternship.getNotes());
            }
            return internshipRepository.save(internship);
        } else {
            throw new IllegalArgumentException("Internship with ID: " + id + " not found");
        }
    }
}
