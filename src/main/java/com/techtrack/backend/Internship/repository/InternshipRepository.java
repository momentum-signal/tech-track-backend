package com.techtrack.backend.Internship.repository;

import org.springframework.stereotype.Repository;

import com.techtrack.backend.Internship.model.Internship;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface InternshipRepository extends MongoRepository<Internship, String> {

    // Additional query methods if needed:
}
