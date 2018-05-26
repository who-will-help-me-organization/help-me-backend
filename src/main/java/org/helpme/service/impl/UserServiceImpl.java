package org.helpme.service.impl;

import java.util.Optional;

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
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findById(String id) {
		Optional <User> user = userRepository.findById(id);
		
		if (user.isPresent()) {
			return user.get();
		} else {
			throw new RuntimeException();
		}
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User deleteById(String id) {
		User deletedUser = findById(id);
		
		if (deletedUser != null) {
			userRepository.deleteById(deletedUser.getId());
			return deletedUser;
		}
		throw new RuntimeException();
	}

	@Override
	public User findByUsercode(String usercode) {
		
		return null;
	}
}
