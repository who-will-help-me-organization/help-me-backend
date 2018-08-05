package org.helpme.repository;

import java.util.Optional;

import org.helpme.model.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RatingRepository extends MongoRepository<Rating, String> {
	public Optional<Rating> findByRatedRequestId(String id);
}
