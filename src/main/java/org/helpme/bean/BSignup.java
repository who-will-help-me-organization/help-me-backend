package org.helpme.bean;

import org.helpme.exception.annotation.ValidCourseCode;
import org.helpme.exception.annotation.ValidEmail;
import org.helpme.exception.annotation.ValidName;
import org.helpme.exception.annotation.ValidPassword;
import org.helpme.exception.annotation.ValidPhoneNumber;
import org.helpme.exception.annotation.ValidUserCode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BSignup {
	@ValidUserCode private String usercode;
	@ValidPassword private String password;
	private String passwordConfirmation;
	
	@ValidCourseCode private String courseCode;
	@ValidEmail private String email;
	@ValidName private String name;
	@ValidPhoneNumber private String phoneNumber;
}
