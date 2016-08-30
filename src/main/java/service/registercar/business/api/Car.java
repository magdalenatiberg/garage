package service.registercar.business.api;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import service.common.api.validation.registrationnumber.RegistrationNumber;

public class Car {

	@RegistrationNumber(message=ServiceError.INVALID_REGISTRATION_NUMBER)
	@NotNull(message=ServiceError.INVALID_REGISTRATION_NUMBER)
	private String registrationNumber;
	@NotNull(message=ServiceError.INVALID_MANUFACTURER)
	private String manufacturer;
	@NotNull(message=ServiceError.INVALID_MODEL)
	private String model;
	@NotNull(message=ServiceError.INVALID_MODEL_YEAR)
	@Pattern(regexp="^(19|20)\\d{2}", message=ServiceError.INVALID_MODEL_YEAR)
	private String modelYear;
	
	public Car(Builder builder) {
		this.registrationNumber = builder.registrationNumber;
		this.manufacturer = builder.manufacturer;
		this.model = builder.model;
		this.modelYear = builder.modelYear;
	}
	
	public Car() {}
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public String getModel() {
		return model;
	}
	public String getModelYear() {
		return modelYear;
	}
	
	public static class Builder {
		private String registrationNumber;
		private String manufacturer;
		private String model;
		private String modelYear;

		public Builder registrationNumber(String registrationNumber) {
			this.registrationNumber = registrationNumber;
			return this;
		}
		
		public Builder manufacturer(String manufacturer) {
			this.manufacturer = manufacturer;
			return this;
		}

		public Builder model(String model) {
			this.model = model;
			return this;
		}

		public Builder modelYear(String modelYear) {
			this.modelYear = modelYear;
			return this;
		}

		public Car build() {
			return new Car(this);
		}
	}
}
