package service.common.validation.registrationnumber;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target( { METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = RegistrationNumberValidator.class)
@Documented
public @interface RegistrationNumber {
	String message() default "{com.mycompany.constraints.checkcase}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
