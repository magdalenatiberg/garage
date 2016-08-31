package service.getcar.business;

import java.util.List;

import service.common.response.ServiceError;
import service.common.response.ServiceResponse;
import service.getcar.business.api.Car;

public class GetCarResponse implements ServiceResponse {

	private Car car;
	private String status;
	private List<ServiceError> serviceErrors;
	
	public GetCarResponse(Builder builder) {
		this.car = builder.car;
		this.status = builder.status;
		this.serviceErrors = builder.serviceErrors;
	}

	public Car getCar() {
		return car;
	}
	@Override
	public String getStatus() {
		return status;
	}

	@Override
	public List<ServiceError> getServiceErrors() {
		return serviceErrors;
	}
	
	public static class Builder {
		private Car car;
		private String status;
		private List<ServiceError> serviceErrors;

		public Builder car(Car car) {
			this.car = car;
			return this;
		}
		
		public Builder status(String status) {
			this.status = status;
			return this;
		}
		
		public Builder serviceErrors(List<ServiceError> serviceErrors) {
			this.serviceErrors = serviceErrors;
			return this;
		}
		
		public GetCarResponse build() {
			return new GetCarResponse(this);
		}
	}
}
