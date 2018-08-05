package org.helpme.model;

import org.helpme.bean.BSignup;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class ModelFactory {
	public static User createUser(BSignup b) {
		b.setPassword(BCrypt.hashpw(b.getPassword(), BCrypt.gensalt()));
		
		return new User(b.getUsercode(), 
				b.getPassword(), 
				b.getCourseCode(),
				b.getEmail(),
				b.getName(),
				b.getPhoneNumber());
	}
}
