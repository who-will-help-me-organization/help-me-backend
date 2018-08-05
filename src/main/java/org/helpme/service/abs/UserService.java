package org.helpme.service.abs;

import java.util.Collection;

import org.helpme.bean.BSignup;
import org.helpme.model.User;

public interface UserService {
	public Collection<User> findAll();
	public User findById(String id);
	public User findByUsercode(String usercode);
	public User create(BSignup user);
	public User deleteById(String id);
}

