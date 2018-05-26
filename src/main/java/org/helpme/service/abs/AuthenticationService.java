package org.helpme.service.abs;

import org.helpme.model.User;

public interface AuthenticationService {
	public Iterable<User> findAll();
	public User findById(String id);
	public User save(User user);
	public User deleteById(String username);
}

