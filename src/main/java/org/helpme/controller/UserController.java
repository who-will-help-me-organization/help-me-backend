package org.helpme.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.helpme.bean.user.BSignup;
import org.helpme.model.User;
import org.helpme.service.abs.UserService;
import org.helpme.service.impl.UserServiceImpl;
import org.helpme.util.request.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(UrlProvider.USER)
public class UserController {
	private UserService userService;
	
	@Autowired
	private void setUserService(UserServiceImpl userService) {
		this.userService = userService;
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> getUserById(@PathVariable String id) {
		return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<Collection<User>> getAllUsers() {
		return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<User> create(@Valid @RequestBody BSignup body) {		
		return new ResponseEntity<>(userService.create(body), HttpStatus.OK);
	}
}
