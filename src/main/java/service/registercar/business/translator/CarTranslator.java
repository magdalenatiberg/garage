package service.registercar.business.translator;

import org.springframework.stereotype.Component;

import service.registercar.integration.api.Car;

@Component
public class CarTranslator {

	public Car translate(service.registercar.business.api.Car originalCar) {
		return new Car.Builder()
				.registrationNumber(originalCar.getRegistrationNumber())
				.manufacturer(originalCar.getManufacturer())
				.model(originalCar.getModel())
				.modelYear(originalCar.getModelYear())
				.build();
	}
}
