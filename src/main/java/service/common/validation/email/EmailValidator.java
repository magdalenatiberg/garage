package service.common.validation.email;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<Email, String>{

	@Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value == null) {
			return true;
		}
		
		try {
		      InternetAddress emailAddr = new InternetAddress(value);
		      emailAddr.validate();
		      return true;
		      
		   } catch (AddressException ex) {
			   return false;
		   }
	}

	@Override
	public void initialize(Email constraintAnnotation) {
		// TODO Auto-generated method stub
	}
}
