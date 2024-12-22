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
}
