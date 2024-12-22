package com.techtrack.backend.Application.controller;

import com.techtrack.backend.Application.model.ApplicationModel;
import com.techtrack.backend.Application.service.ApplicationService;
import com.techtrack.backend.Internship.model.InternshipModel;
import com.techtrack.backend.Internship.service.InternshipService;
import com.techtrack.backend.Utils.ResponseHandler;
import com.techtrack.backend.Utils.ResponseProps;
import com.techtrack.backend.dto.ApplicationWithInternshipDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    // Create a new internship
    @PostMapping
    public ResponseEntity<Object> createApplication(@RequestBody ApplicationModel applicationBody) {
        try{
        ApplicationModel createdApplication = applicationService.createApplication(applicationBody);

            ResponseProps<ApplicationModel>responseProps = new ResponseProps<>(
                    true,
                    "Application created successfully",
                    createdApplication,
                    200
            );
            return ResponseHandler.sendResponse(responseProps);
        } catch (IllegalArgumentException e) {
            ResponseProps<Void> responseProps = new ResponseProps<>(
                    false,
                    "Internship ID is not valid",
                    null,
                    404
            );
            return ResponseHandler.sendResponse(responseProps);
        }
    }
    // Get all internships data
    @GetMapping("/{email}")
    public ResponseEntity<ResponseProps<List<ApplicationWithInternshipDTO>>> getApplicationsByEmail(
            @PathVariable("email") String email) {

        List<ApplicationWithInternshipDTO> applications = applicationService.getApplicationsByUserEmail(email);

        ResponseProps<List<ApplicationWithInternshipDTO>> responseProps;

        if (!applications.isEmpty()) {
            responseProps = new ResponseProps<>(
                    true,
                    "Applications retrieved successfully",
                    applications,
                    200
            );
        } else {
            responseProps = new ResponseProps<>(
                    false,
                    "No applications found for the given email",
                    null,
                    404
            );
        }

        return ResponseEntity.status(responseProps.getStatusCode()).body(responseProps);
    }


    //Delete an application
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteApplication(@PathVariable("id") String id) {
        boolean isDeleted = applicationService.deleteApplication(id);

        ResponseProps<Void> responseProps;
        if (isDeleted) {
            responseProps = new ResponseProps<>(
                    true,
                    "Application deleted successfully",
                    null,
                    200
            );
        } else {
            responseProps = new ResponseProps<>(
                    false,
                    "Failed to delete application",
                    null,
                    404
            );
        }
        return ResponseHandler.sendResponse(responseProps);
    }
}


