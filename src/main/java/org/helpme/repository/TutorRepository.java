package org.helpme.repository;

import java.util.Optional;

import org.helpme.model.Tutor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TutorRepository extends MongoRepository<Tutor, String> {
	Optional<Tutor> findByUsercode(String usercode);
}
