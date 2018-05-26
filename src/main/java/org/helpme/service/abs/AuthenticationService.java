package org.helpme.service.abs;

import java.io.IOException;
import java.net.URISyntaxException;

import org.helpme.bean.BLogin;
import org.helpme.model.User;

public interface AuthenticationService {
	public User authenticate(BLogin bLogin);
	public String tokenFor(User user) throws IOException, URISyntaxException;
	public User getUserFromToken(String token) throws IOException, URISyntaxException;
}

