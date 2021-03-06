package org.helpme.exception.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotBlank;

import org.helpme.exception.validator.DayValidator;

@NotBlank(message = "Day should not be blank")

@Retention(RUNTIME)
@Target({ METHOD, FIELD, PARAMETER })
@Constraint(validatedBy = {DayValidator.class})
@Documented
public @interface ValidDay {
	String message() default "Day is not valid!";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}