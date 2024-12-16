package com.techtrack.backend.Internship.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.techtrack.backend.Internship.model.Internship;
import com.techtrack.backend.Internship.service.InternshipService;
import org.springframework.http.ResponseEntity;

import java.util.*;

@RestController
@RequestMapping("/api/internships")
public class InternshipController {

    @Autowired
    private InternshipService internshipService;

    @PostMapping
    public ResponseEntity<Internship> createInternship(@RequestBody Internship internship) {
        Internship createdInternship = internshipService.createInternship(internship);
        return new ResponseEntity<>(createdInternship, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Internship> getAllInternships() {
        return internshipService.getAllInternships();
    }
}