package service.common.api.validation.registrationnumber;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import service.common.api.validation.email.Email;

public class RegistrationNumberValidator implements ConstraintValidator<RegistrationNumber, String> {
	@Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value == null) {
			return true;
		}
		
		if(value.matches("[A-Z]{3}[0-9]{3}")){
			return true;
		}
		
		if(value.matches("[A-Z]{3,8}")) {
			return true;
		}
		
		return false;
		
	}

	@Override
	public void initialize(RegistrationNumber constraintAnnotation) {
		// TODO Auto-generated method stub
	}
}
