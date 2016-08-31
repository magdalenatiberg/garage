package service.registercar.business.translator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import service.registercar.integration.RegisterCarRequest;

@Component
public class RegisterCarRequestTranslator {

	@Autowired
	private CarTranslator carTranslator;
	
	public RegisterCarRequest translate(service.registercar.business.RegisterCarRequest registerCarRequest) {
		return new RegisterCarRequest.Builder()
				.customerId(registerCarRequest.getCustomerId())
				.car(carTranslator.translate(registerCarRequest.getCar()))
				.build();
	}
}
