package org.helpme.service.abs;

import java.util.Collection;

import org.helpme.bean.user.BSignup;
import org.helpme.model.User;

public interface UserService {
	public User findById(String id);
	public User findByCode(String code);
	public Collection<User> findAll();
	public User create(BSignup user);
}

