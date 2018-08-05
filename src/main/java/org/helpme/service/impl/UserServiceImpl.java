package org.helpme.service.impl;

import java.util.Collection;
import java.util.Optional;

import org.helpme.bean.BSignup;
import org.helpme.exception.custom.resexists.UserAlreadyExists;
import org.helpme.exception.custom.resnotfound.UserNotFoundException;
import org.helpme.model.ModelFactory;
import org.helpme.model.User;
import org.helpme.repository.UserRepository;
import org.helpme.service.abs.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	private UserRepository userRepository;
	
	@Autowired
	private void setUserRepository(UserRepository repository){
		this.userRepository = repository;
	}

	@Override
	public Collection<User> findAll() {
		return userRepository.findAll();
	}

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
	public User create(BSignup body) {
		User user = ModelFactory.createUser(body);
		
		if (userRepository.findByUsercode(user.getUsercode()).isPresent()) {
			throw new UserAlreadyExists();
		}
		
		return userRepository.save(user);
	}

	@Override
	public User deleteById(String id) {
		Optional<User> user = userRepository.findById(id);
		
		if (user.isPresent()) {
			userRepository.delete(user.get());
			return user.get();
		}
		
		throw new UserNotFoundException();
	}

	@Override
	public User findByUsercode(String usercode) {
		
		return null;
	}
}
