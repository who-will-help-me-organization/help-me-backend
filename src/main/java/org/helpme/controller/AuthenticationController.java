package org.helpme.controller;

import org.helpme.bean.BLogin;
import org.helpme.bean.BRAuth;
import org.helpme.model.User;
import org.helpme.service.abs.AuthenticationService;
import org.helpme.util.request.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(UrlProvider.authentication)
public class AuthenticationController {
	private AuthenticationService authService;
	
	@Autowired
	private void setAuthService(AuthenticationService authService) {
		this.authService = authService;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<BRAuth> login(@RequestBody BLogin bLogin) {
		User user = authService.authenticate(bLogin);
		
		String token;

        try {
            token = authService.tokenFor(user);
            BRAuth authBean = new BRAuth(token, user);
            return new ResponseEntity<>(authBean, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
}
