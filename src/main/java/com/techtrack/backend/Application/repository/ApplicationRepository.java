package com.techtrack.backend.Application.repository;

import com.techtrack.backend.Application.model.ApplicationModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public interface ApplicationRepository extends MongoRepository<ApplicationModel, String> {
    // Get all application by user email
    List<ApplicationModel> findByUserEmail(String userEmail);
}

