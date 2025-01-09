package com.techtrack.backend.Application.service;

import com.techtrack.backend.Application.model.ApplicationModel;
import com.techtrack.backend.Application.model.ApplicationStatusEnum;
import com.techtrack.backend.Application.repository.ApplicationRepository;
import com.techtrack.backend.Internship.model.InternshipModel;
import com.techtrack.backend.Internship.repository.InternshipRepository;
import com.techtrack.backend.dto.ApplicationWithInternshipDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;
    @Autowired
    private InternshipRepository internshipRepository;

    // Create a new application
    public ApplicationModel createApplication(ApplicationModel application) {
        //check if the internship ID is valid
        Optional<InternshipModel> internship = internshipRepository.findById(application.getInternshipId());
        if (internship.isEmpty()) {
            throw new IllegalArgumentException("Invalid Internship ID: " + application.getInternshipId());
        }

        //Check if the user has already applied for the internship
        List<ApplicationModel> exisitingApplications = applicationRepository.findByUserEmailAndInternshipId(application.getUserEmail(), application.getInternshipId());
        if (!exisitingApplications.isEmpty()) {
            throw new IllegalArgumentException("User has already applied for this internship");
        }

        //Set the status to "Applied" before saving
        application.setApplicationStatus(ApplicationStatusEnum.applied);
        return applicationRepository.save(application);
    }

    // Get all applications by use email
    public List<ApplicationWithInternshipDTO> getApplicationsByUserEmail(String userEmail) {
        // Fetch applications by user email
        List<ApplicationModel> applications = applicationRepository.findByUserEmail(userEmail);

        System.out.println("applications" + applications);

        // Map applications with internship details
        return applications.stream().map(application -> {
            InternshipModel internship = internshipRepository.findById(application.getInternshipId())
                    .orElseThrow(() -> new RuntimeException("Internship not found for ID: " + application.getInternshipId()));

            return new ApplicationWithInternshipDTO(application.getId(), application.getUserEmail(), application.getApplicationStatus(), internship);
        }).toList();
    }

    //Delete an application
    public boolean deleteApplication(String id) {
        if (applicationRepository.existsById(id)) {
            applicationRepository.deleteById(id);
            return true;
        }
        return false;
    }

    //Update application status
    public ApplicationModel updateApplicationStatus(String applicationId, ApplicationStatusEnum status) {
        ApplicationModel application = applicationRepository.findById(applicationId)
                .orElseThrow(() -> new IllegalArgumentException("Application not found with ID: " + applicationId));
        // Update the status
        application.setApplicationStatus(status);

        // Save the updated application
        return applicationRepository.save(application);
    }
}
