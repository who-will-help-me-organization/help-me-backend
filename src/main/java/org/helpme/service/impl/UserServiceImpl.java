package org.helpme.service.impl;

import java.util.Collection;
import java.util.Optional;

import org.helpme.bean.user.BSignup;
import org.helpme.exception.custom.resexists.UserAlreadyExistsException;
import org.helpme.exception.custom.resnotfound.UserNotFoundException;
import org.helpme.model.ModelFactory;
import org.helpme.model.User;
import org.helpme.repository.UserRepository;
import org.helpme.service.abs.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User findById(String id) {
		Optional <User> user = userRepository.findById(id);
		
		if (user.isPresent()) {
			return user.get();
		} else {
			throw new UserNotFoundException();
		}
	}
	
	@Override
	public User findByCode(String code) {
		Optional<User> user = userRepository.findByCode(code);
		
		if (user.isPresent()) {
			return user.get();	
		}
		
		throw new UserNotFoundException();
	}

	@Override
	public Collection<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User create(BSignup body) {
		User user = ModelFactory.createUser(body);
		
		if (userRepository.findByCode(user.getCode()).isPresent()) {
			throw new UserAlreadyExistsException();
		}
		
		return userRepository.save(user);
	}
}
