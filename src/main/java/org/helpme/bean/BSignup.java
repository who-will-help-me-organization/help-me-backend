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

@NoArgsConstructor
@AllArgsConstructor
public class BSignup {
	@ValidUserCode @Getter @Setter private String usercode;
	@ValidPassword @Getter @Setter private String password;
	@Getter @Setter private String passwordConfirmation;
	
	@ValidCourseCode @Getter @Setter private String courseCode;
	@ValidEmail @Getter @Setter private String email;
	@ValidName @Getter @Setter private String name;
	@ValidPhoneNumber @Getter @Setter private String phoneNumber;
}
