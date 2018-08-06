package org.helpme.repository;

import java.util.Optional;

import org.helpme.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
	Optional<User> findByCode(String code);
}
