package org.helpme.service.impl;

import java.util.Collection;
import java.util.Optional;

import org.helpme.bean.request.BOnlineRequest;
import org.helpme.bean.request.BPresentialRequest;
import org.helpme.exception.custom.incomserv.NoTutorAvailableException;
import org.helpme.exception.custom.resnotfound.RequestNotFoundException;
import org.helpme.exception.custom.resnotfound.UserNotFoundException;
import org.helpme.model.ModelFactory;
import org.helpme.model.Request;
import org.helpme.model.Tutor;
import org.helpme.model.User;
import org.helpme.repository.RequestRepository;
import org.helpme.service.abs.RequestService;
import org.helpme.service.abs.TutorService;
import org.helpme.service.abs.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl implements RequestService {
	private RequestRepository requestRepository;
	private UserService userService;
	private TutorService tutorService;
	
	@Autowired
	private void setRequestRepository(RequestRepository repository){
		this.requestRepository = repository;
	}
	
	@Autowired
	private void setUserService(UserServiceImpl service) {
		this.userService = service;
	}
	
	@Autowired
	private void setTutorService(TutorServiceImpl service) {
		this.tutorService = service;
	}

	@Override
	public Request findById(String id) {
		Optional<Request> request = requestRepository.findById(id);
		
		if (request.isPresent()) {
			return request.get();
		} else {
			throw new UserNotFoundException();
		}
	}

	@Override
	public Request createOnline(BOnlineRequest body) {
		User requester = userService.findById(body.getUserId());
		Request request = ModelFactory.createOnlineRequest(body, requester);
		return requestRepository.save(request);
	}

	@Override
	public Request createPresential(BPresentialRequest body) {
		User requester = userService.findById(body.getUserId());
		Request request = ModelFactory.createPresentialRequest(body, requester);
		return requestRepository.save(request);
	}

	@Override
	public Tutor getTutor(String requestId) {
		Optional<Request> request = requestRepository.findById(requestId);
		
		if (request.isPresent()) {
			if (request.get().getDay() != null) {
				getTutorPresential(request.get());
			} else {
				getTutorOnline(request.get());
			}
		}
		
		throw new RequestNotFoundException();
	}
	
	private Tutor getTutorOnline(Request request) {
		Collection<Tutor> tutors = tutorService.findAll();
		Tutor bestChoice = null;
		
		for (Tutor tutor : tutors) {
			if (tutor.getSubject().equalsIgnoreCase(request.getSubject())) {
				if (bestChoice != null) {
					if (tutor.getRating() > bestChoice.getRating()) {
						bestChoice = tutor;
					}
				} else {
					bestChoice = tutor;
				}
				
			}
		}
		
		if (bestChoice != null) {
			return bestChoice;
		}
		
		throw new NoTutorAvailableException();
	}
	
	private Tutor getTutorPresential(Request request) {
		Collection<Tutor> tutors = tutorService.findAll();
		Tutor bestChoice = null;
		
		for (Tutor tutor : tutors) {
			if (tutor.getSubject().equals(request.getSubject()) && tutor.getDays().contains(request.getDay())) {
				if (bestChoice != null) {
					if (tutor.getRating() > bestChoice.getRating()) {
						bestChoice = tutor;
					}
 				} else {
					bestChoice = tutor;
				}
			}
		}
		
		if (bestChoice != null) {
			return bestChoice;
		}
		
		throw new NoTutorAvailableException();
	}
}
