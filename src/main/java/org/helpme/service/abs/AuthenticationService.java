package org.helpme.service.abs;

import org.helpme.bean.tutor.BLogin;
import org.helpme.model.User;

public interface AuthenticationService {
	public User authenticate(BLogin bLogin);
	public String tokenFor(User user);
	public User getUserFromToken(String token);
}

