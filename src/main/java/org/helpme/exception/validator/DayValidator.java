package org.helpme.exception.validator;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.helpme.exception.annotation.ValidDay;

public class DayValidator implements ConstraintValidator<ValidDay, String> {
	private final String[] possibleDays = {"seg", "ter", "qua", "qui", "sex"};
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (Arrays.asList(possibleDays).contains(value.toLowerCase())) {
			return true;
		}
		
		return false;
	}
}
