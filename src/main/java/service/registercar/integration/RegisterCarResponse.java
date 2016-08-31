package service.registercar.integration;

import service.common.response.ServiceError;

public class RegisterCarResponse {
	private ServiceError serviceError;
	
	public RegisterCarResponse(Builder builder) {
		this.serviceError = builder.serviceError;
	}

	public ServiceError getServiceError() {
		return serviceError;
	}
	
	public static class Builder {
		private ServiceError serviceError;
		
		public Builder serviceErrors(ServiceError serviceError) {
			this.serviceError = serviceError;
			return this;
		}
		
		public RegisterCarResponse build() {
			return new RegisterCarResponse(this);
		}
	}

}
