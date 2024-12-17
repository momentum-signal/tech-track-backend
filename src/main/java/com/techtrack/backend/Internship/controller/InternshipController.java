package com.techtrack.backend.Internship.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.techtrack.backend.Internship.model.InternshipModel;
import com.techtrack.backend.Internship.service.InternshipService;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api/internships")
public class InternshipController {

    @Autowired
    private InternshipService internshipService;

    @PostMapping
    public ResponseEntity<InternshipModel> createInternship(@RequestBody InternshipModel internshipBody) {
        internshipBody.setCreatedDate(LocalDateTime.now());
        InternshipModel createdInternship = internshipService.createInternship(internshipBody);
        return new ResponseEntity<>(createdInternship, HttpStatus.CREATED);
    }

    @GetMapping
    public List<InternshipModel> getAllInternships() {
        return internshipService.getAllInternships();
    }
}