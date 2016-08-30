package service.registercar.business.translator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import service.registercar.integration.RegisterCarRequest;

@Component
public class RegisterCarRequestTranslator {

	@Autowired
	private CarTranslator carTranslator;
	
	public RegisterCarRequest translate(service.registercar.business.RegisterCarRequest originalRequest) {
		return new RegisterCarRequest.Builder()
				.customerId(originalRequest.getCustomerId())
				.car(carTranslator.translate(originalRequest.getCar()))
				.build();
	}
}
