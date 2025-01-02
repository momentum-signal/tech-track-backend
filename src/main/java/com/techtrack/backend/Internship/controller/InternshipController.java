package com.techtrack.backend.Internship.controller;

import com.techtrack.backend.Utils.ResponseHandler;
import com.techtrack.backend.Utils.ResponseProps;
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

    // Create a new internship
    @PostMapping
    public ResponseEntity<Object> createInternship(@RequestBody InternshipModel internshipBody) {
        internshipBody.setCreatedDate(LocalDateTime.now());
        InternshipModel createdInternship = internshipService.createInternship(internshipBody);

        ResponseProps<InternshipModel> responseProps;
        if (createdInternship != null) {
            responseProps = new ResponseProps<>(
                    true,
                    "Internship created successfully",
                    createdInternship,
                    200
            );
        } else {
            responseProps = new ResponseProps<>(
                    false,
                    "Failed to create internship",

                    null,
                    404
            );
        }
        return ResponseHandler.sendResponse(responseProps);
    }

    // Get all internships data
    @GetMapping
    public ResponseEntity<Object> getAllInternships() {
        List<InternshipModel> internships = internshipService.getAllInternships();

        // SendResponse object
        ResponseProps<List<InternshipModel>> responseProps;

        if (!internships.isEmpty()) {
            responseProps = new ResponseProps<>(
                    true,
                    "All internships fetched successfully",
                    internships,
                    200
            );
        } else {
            responseProps = new ResponseProps<>(
                    false,
                    "No internships found",
                    null,
                    404
            );
        }

        return ResponseHandler.sendResponse(responseProps);
    }

    // Get single internship data by ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> getInternshipById(@PathVariable String id) {
        Optional<InternshipModel> internship = internshipService.getSingleInternship(id);

        // SendResponse object
        ResponseProps<InternshipModel> responseProps;
        responseProps = internship.map(internshipModel -> new ResponseProps<>(
                true,
                "Internship found successfully",
                internship.get(),
                200
        )).orElseGet(() -> new ResponseProps<>(
                false,
                "Internship not found",
                null,
                404
        ));

        return ResponseHandler.sendResponse(responseProps);
    }
    
    //Delete internship data
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteInternshipById(@PathVariable String id) {
        boolean isDeleted = internshipService.deleteInternship(id);

        ResponseProps<InternshipModel> responseProps;
        if(isDeleted) {
            responseProps = new ResponseProps<>(
                true,
                "Internship deleted successfully",
                null,
                200
            );
        } else {
            responseProps = new ResponseProps<InternshipModel>(
                false,
                "Internship not found",
                null,
                404
            );
        }
        
        return ResponseHandler.sendResponse(responseProps);
    }

    //Edit an internship
    @PutMapping("/{id}")
    public ResponseEntity<Object> editInternship(@PathVariable String id, @RequestBody InternshipModel internshipBody) {
        try{
            InternshipModel updatedInternship = internshipService.editInternship(id, internshipBody);

            ResponseProps<InternshipModel> responseProps = new ResponseProps<>(
                true,
                "Internship updated successfully",
                updatedInternship,
                200
            );
            return ResponseHandler.sendResponse(responseProps);
        }catch (IllegalArgumentException e){
            ResponseProps<Void> responseProps = new ResponseProps<>(
                false,
                e.getMessage(),
                null,
                404
            );
            return ResponseHandler.sendResponse(responseProps);
        }
    }
}