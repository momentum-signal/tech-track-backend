package com.techtrack.backend.Application.service;

import com.techtrack.backend.Application.model.ApplicationModel;
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
        if(internship.isEmpty()){
            throw new IllegalArgumentException("Invalid Internship ID: "+ application.getInternshipId());
        }
        return applicationRepository.save(application);
    }

//     Get all applications by use email
        public List<ApplicationWithInternshipDTO> getApplicationsByUserEmail(String userEmail) {
            // Fetch applications by user email
            List<ApplicationModel> applications = applicationRepository.findByUserEmail(userEmail);

            // Map applications with internship details
            return applications.stream().map(application -> {
                InternshipModel internship = internshipRepository.findById(application.getInternshipId())
                        .orElseThrow(() -> new RuntimeException("Internship not found for ID: " + application.getInternshipId()));

                return new ApplicationWithInternshipDTO(application.getId(), application.getUserEmail(), internship);
            }).toList();
    }
    //Delete an application
    public boolean deleteApplication(String id) {
        if(applicationRepository.existsById(id)){        
            applicationRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
