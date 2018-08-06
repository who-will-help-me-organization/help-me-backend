package org.helpme.model;

import org.helpme.bean.BRating;
import org.helpme.bean.request.BOnlineRequest;
import org.helpme.bean.request.BPresentialRequest;
import org.helpme.bean.tutor.BSignTutor;
import org.helpme.bean.user.BSignup;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class ModelFactory {
	public static User createUser(BSignup b) {
		b.setPassword(BCrypt.hashpw(b.getPassword(), BCrypt.gensalt()));
		
		return new User(b.getCode(), 
						b.getPassword(), 
						b.getCourseCode(),
						b.getEmail(),
						b.getName(),
						b.getPhoneNumber());
	}
	
	public static Tutor createTutor(BSignTutor b) {
		return new Tutor(b.getUsercode(), 
						 b.getSubject(),
						 b.getKnowhow());
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
