package org.helpme.util.security;

import org.helpme.model.AuthenticatedUser;
import org.helpme.model.User;
import org.helpme.service.impl.AuthenticationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class UserAuthenticationProvider implements AuthenticationProvider {
	@Autowired
    private AuthenticationServiceImpl authenticationService;

    @Override
    public boolean supports(Class<? extends Object> authentication) {
        return (AuthenticatedUser.class.isAssignableFrom(authentication));
    }

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		try {
            User possibleProfile = authenticationService.getUserFromToken((String) authentication.getCredentials());
            
            return new AuthenticatedUser((String) authentication.getCredentials(), possibleProfile);
        } catch (Exception e) {
        	e.printStackTrace();
            throw new RuntimeException("Authentication failed: " + e.getMessage());
        }
	}
}