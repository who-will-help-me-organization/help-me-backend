package org.helpme.exception.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@NotBlank(message = "User code should not be blank")
@Size(min = 9, max = 9, message = "User code must have exactly 9 digits")
@Pattern(regexp = "[0-9]+", message = "User code can have only numbers")

@Retention(RUNTIME)
@Target({ METHOD, FIELD })
@Constraint(validatedBy = {})
@Documented
public @interface ValidUserCode {
	String message() default "User code is not valid!";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}