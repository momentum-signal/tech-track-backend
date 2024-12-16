package com.techtrack.backend.Internship.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import com.techtrack.backend.Internship.model.Internship;
import com.techtrack.backend.Internship.repository.InternshipRepository;


@Service
public class InternshipService {

    @Autowired
    private InternshipRepository internshipRepository;

    // Create a new Internship
    public Internship createInternship(Internship internship) {
        return internshipRepository.save(internship);
    }

    public List<Internship> getAllInternships() {
        List<Internship> internships = internshipRepository.findAll();
        System.out.println("Fetched internships: " + internships);
        return internships;
    }
}
