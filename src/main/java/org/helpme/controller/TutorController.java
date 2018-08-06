package org.helpme.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.helpme.bean.tutor.BAddDay;
import org.helpme.bean.tutor.BAddLocation;
import org.helpme.bean.tutor.BDonate;
import org.helpme.bean.tutor.BSignTutor;
import org.helpme.model.Tutor;
import org.helpme.service.abs.TutorService;
import org.helpme.service.impl.TutorServiceImpl;
import org.helpme.util.request.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(UrlProvider.TUTOR)
public class TutorController {
	private TutorService tutorService;
	
	@Autowired
	private void setTutorService(TutorServiceImpl tutorService) {
		this.tutorService = tutorService;
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Tutor> getTutorById(@PathVariable String id) {
		return new ResponseEntity<>(tutorService.findById(id), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<Collection<Tutor>> getAllTutors() {
		return new ResponseEntity<>(tutorService.findAll(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Tutor> create(@Valid @RequestBody BSignTutor body) {		
		return new ResponseEntity<>(tutorService.create(body), HttpStatus.OK);
	}
	
	@PatchMapping(value = "/{id}/day")
	public ResponseEntity<Tutor> addDay(@PathVariable String id, @Valid @RequestBody BAddDay body) {		
		return new ResponseEntity<>(tutorService.addDay(id, body), HttpStatus.OK);
	}	
	
	@PatchMapping(value = "/{id}/location")
	public ResponseEntity<Tutor> addLocation(@PathVariable String id, @Valid @RequestBody BAddLocation body) {		
		return new ResponseEntity<>(tutorService.addLocation(id, body), HttpStatus.OK);
	}
	
	@PatchMapping(value = "/{id}/donate")
	public ResponseEntity<Tutor> donate(@PathVariable String id, @Valid @RequestBody BDonate body) {
		return new ResponseEntity<>(tutorService.donate(id, body), HttpStatus.OK);
	}
}
