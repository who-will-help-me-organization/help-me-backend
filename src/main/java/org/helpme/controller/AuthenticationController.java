package org.helpme.controller;

import org.helpme.bean.tutor.BLogin;
import org.helpme.bean.tutor.BRAuth;
import org.helpme.model.User;
import org.helpme.service.abs.AuthenticationService;
import org.helpme.service.impl.AuthenticationServiceImpl;
import org.helpme.util.request.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(UrlProvider.AUTHENTICATION)
public class AuthenticationController {
	private AuthenticationService authService;
	
	@Autowired
	private void setAuthService(AuthenticationServiceImpl authService) {
		this.authService = authService;
	}
	
	@PostMapping
	public ResponseEntity<BRAuth> login(@RequestBody BLogin bLogin) {
        User user = authService.authenticate(bLogin);
        String token = authService.tokenFor(user);
        BRAuth authBean = new BRAuth(token, user);
        
        return new ResponseEntity<>(authBean, HttpStatus.OK);
	}
}
