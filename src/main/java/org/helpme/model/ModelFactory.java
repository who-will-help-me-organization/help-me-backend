package org.helpme.model;

import org.helpme.bean.BOnlineRequest;
import org.helpme.bean.BPresentialRequest;
import org.helpme.bean.BRating;
import org.helpme.bean.BSignTutor;
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
	
	public static Tutor createTutor(BSignTutor b) {
		return new Tutor(b.getUsercode(), 
						 b.getSubject(),
						 b.getLevel());
	}
	
	public static Request createOnlineRequest(BOnlineRequest b, User requester) {
		return new Request(b.getSubject(),
						   null,
						   null,
						   requester);
	}
	
	public static Request createPresentialRequest(BPresentialRequest b, User requester) {
		return new Request(b.getSubject(),
						   b.getDay(),
						   b.getLocation(),
						   requester);
	}
	
	public static Rating createRating(BRating b, User requester, Request request, Tutor tutor) {
		return new Rating(b.getGrade(),
						  requester,
						  tutor,
						  request);
	}
}
