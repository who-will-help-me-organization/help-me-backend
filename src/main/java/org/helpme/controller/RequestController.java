package org.helpme.controller;

import javax.validation.Valid;

import org.helpme.bean.request.BOnlineRequest;
import org.helpme.bean.request.BPresentialRequest;
import org.helpme.model.Request;
import org.helpme.model.Tutor;
import org.helpme.service.abs.RequestService;
import org.helpme.service.impl.RequestServiceImpl;
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
@RequestMapping(UrlProvider.REQUEST)
public class RequestController {
	private RequestService requestService;
	
	@Autowired
	private void setRequestService(RequestServiceImpl service) {
		this.requestService = service;
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Request> getRequestById(@PathVariable String id) {
		return new ResponseEntity<>(this.requestService.findById(id), HttpStatus.OK);
	}
	
	@PostMapping(value = "/presential")
	public ResponseEntity<Request> createPresential(@Valid @RequestBody BPresentialRequest body) {
		return new ResponseEntity<>(this.requestService.createPresential(body), HttpStatus.OK);
	}
	
	@PostMapping(value = "/online")
	public ResponseEntity<Request> createOnline(@Valid @RequestBody BOnlineRequest body) {
		return new ResponseEntity<>(this.requestService.createOnline(body), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}/tutor")
	public ResponseEntity<Tutor> getTutor(@PathVariable String id) {
		return new ResponseEntity<>(this.requestService.getTutor(id), HttpStatus.OK);
	}
}
