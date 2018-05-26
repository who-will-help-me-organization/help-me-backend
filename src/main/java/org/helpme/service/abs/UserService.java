package org.helpme.service.abs;

import org.helpme.model.User;

public interface UserService {
	public Iterable<User> findAll();
	public User findById(String id);
	public User findByUsercode(String usercode);
	public User save(User user);
	public User deleteById(String username);
}

