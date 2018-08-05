package org.helpme.service.impl;

import org.helpme.bean.BRating;
import org.helpme.exception.custom.resexists.RatingAlreadyExistsException;
import org.helpme.model.ModelFactory;
import org.helpme.model.Rating;
import org.helpme.model.Request;
import org.helpme.model.Tutor;
import org.helpme.model.User;
import org.helpme.repository.RatingRepository;
import org.helpme.service.abs.RatingService;
import org.helpme.service.abs.RequestService;
import org.helpme.service.abs.TutorService;
import org.helpme.service.abs.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {
	private RatingRepository ratingRepository;
	private RequestService requestService;
	private UserService userService;
	private TutorService tutorService;
	
	@Autowired
	private void setRatingRepository(RatingRepository repository){
		this.ratingRepository = repository;
	}
	
	@Autowired
	private void setUserService(UserServiceImpl service) {
		this.userService = service;
	}
	
	@Autowired
	private void setTutorService(TutorServiceImpl service) {
		this.tutorService = service;
	}
	
	@Autowired
	private void setRequestService(RequestServiceImpl service) {
		this.requestService = service;
	}

	@Override
	public Rating create(BRating body) {
		Request request = requestService.findById(body.getRequestId());
		User requester = userService.findById(body.getRequestingUserId());
		Tutor tutor = tutorService.findById(body.getTutorId());
		Rating rating = ModelFactory.createRating(body, requester, request, tutor);
		
		if (ratingRepository.findByRatedRequestId(request.getId()).isPresent()) {
			throw new RatingAlreadyExistsException();
		}
		
		Rating rate = ratingRepository.save(rating);
		tutorService.rate(tutor.getId(), body);
		
		return rate;
	}

	@Override
	public Rating findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}

	
