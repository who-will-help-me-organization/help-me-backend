package org.helpme.service.impl;

import java.util.Collection;
import java.util.Optional;

import org.helpme.bean.BAddDay;
import org.helpme.bean.BAddLocation;
import org.helpme.bean.BDonate;
import org.helpme.bean.BRating;
import org.helpme.bean.BSignTutor;
import org.helpme.exception.custom.resexists.TutorAlreadyExistsException;
import org.helpme.exception.custom.resnotfound.TutorNotFoundException;
import org.helpme.exception.custom.resnotfound.UserNotFoundException;
import org.helpme.model.ModelFactory;
import org.helpme.model.Tutor;
import org.helpme.repository.TutorRepository;
import org.helpme.service.abs.RequestService;
import org.helpme.service.abs.TutorService;
import org.helpme.service.abs.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorServiceImpl implements TutorService {
	private TutorRepository tutorRepository;
	private UserService userService;
	private RequestService requestService;
	
	@Autowired
	private void setTutorRepository(TutorRepository repository){
		this.tutorRepository = repository;
	}
	
	@Autowired
	private void setUserService(UserServiceImpl service) {
		this.userService = service;
	}
	
	@Autowired
	private void setRequestService(RequestServiceImpl service) {
		this.requestService = service;
	}

	@Override
	public Collection<Tutor> findAll() {
		return tutorRepository.findAll();
	}

	@Override
	public Tutor findById(String id) {
		Optional <Tutor> tutor = tutorRepository.findById(id);
		
		if (tutor.isPresent()) {
			return tutor.get();
		} else {
			throw new UserNotFoundException();
		}
	}

	@Override
	public Tutor create(BSignTutor body) {
		Tutor tutor = ModelFactory.createTutor(body);
		
		userService.findByCode(tutor.getUsercode());
		
		if (tutorRepository.findByUsercode(tutor.getUsercode()).isPresent()) {
			throw new TutorAlreadyExistsException();
		}
		
		return tutorRepository.save(tutor);
	}

	@Override
	public Tutor findByUsercode(String usercode) {
		Optional<Tutor> tutor = tutorRepository.findByUsercode(usercode);
		
		if (tutor.isPresent()) {
			return tutor.get();	
		}
		
		throw new TutorNotFoundException();
	}

	@Override
	public Tutor addLocation(String id, BAddLocation body) {
		Optional<Tutor> tutor = tutorRepository.findById(id);
		
		if (tutor.isPresent()) {
			tutor.get().getLocations().add(body.getLocation());
			return tutorRepository.save(tutor.get());
		}
		
		throw new TutorNotFoundException();
	}
	
	@Override
	public Tutor addDay(String id, BAddDay body) {
		Optional<Tutor> tutor = tutorRepository.findById(id);
		
		if (tutor.isPresent()) {
			tutor.get().getDays().add(body.getDay());
			return tutorRepository.save(tutor.get());
		}
		
		throw new TutorNotFoundException();
	}

	@Override
	public Tutor rate(String id, BRating body) {
		Optional<Tutor> tutor = tutorRepository.findById(id);
		
		requestService.findById(body.getRequestId());
		
		if (tutor.isPresent()) {
			double newGrade = (tutor.get().getRating() * 5 + body.getGrade()) / 6.0;
			
			if (newGrade > 5.0) {
				newGrade = 5.0;
			}
			
			tutor.get().setRating(newGrade);
			return tutorRepository.save(tutor.get());
		}
		
		throw new TutorNotFoundException();
	}

	@Override
	public Tutor donate(String id, BDonate body) {
		Optional<Tutor> tutor = tutorRepository.findById(id);
		
		if (tutor.isPresent()) {
			tutor.get().setMoney(tutor.get().getMoney() + calculateDonation(tutor.get(), body.getAmount()));
			return tutorRepository.save(tutor.get());
		}
		
		
		throw new TutorNotFoundException();
	}
	
	private double calculateDonation(Tutor t, double amount) {
		String ratingLevel = t.getRatingLevel();
		
		if (ratingLevel.equalsIgnoreCase("TOP")) {
			return (0.9 + ((t.getRating() - 4.5) / 10.0) * amount);
		} else if (ratingLevel.equalsIgnoreCase("Tutor")) {
			return 0.8 * amount;
		} else {
			return (0.4 - ((3.0 - t.getRating()) / 10.0)) * amount;
		}
	}
}
