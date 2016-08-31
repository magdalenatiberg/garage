package service.getcar.business;

import javax.validation.constraints.NotNull;

import service.common.validation.registrationnumber.RegistrationNumber;
import service.getcar.business.api.ServiceError;

public class GetCarRequest {
	
	@NotNull(message=ServiceError.INVALID_REGISTRATION_NUMBER)
	@RegistrationNumber(message=ServiceError.INVALID_REGISTRATION_NUMBER)
	private String registrationNumber;
	
	public GetCarRequest(Builder builder) {
		this.registrationNumber = builder.registrationNumber;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}
	
	public static class Builder {
		private String registrationNumber;
		
		public Builder registrationNumber(String registrationNumber) {
			this.registrationNumber = registrationNumber;
			return this;
		}
		
		public GetCarRequest build() {
			return new GetCarRequest(this);
		}
	}

}
