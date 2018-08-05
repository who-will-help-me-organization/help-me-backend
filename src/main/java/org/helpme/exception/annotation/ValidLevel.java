package org.helpme.exception.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Min(value = 1, message = "Minimum value is 1 and maximum value is 5")
@Max(value = 5, message = "Minimum value is 1 and maximum value is 5")

@Retention(RUNTIME)
@Target({ METHOD, FIELD })
@Constraint(validatedBy = {})
@Documented
public @interface ValidLevel {
	String message() default "Level is not valid!";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}