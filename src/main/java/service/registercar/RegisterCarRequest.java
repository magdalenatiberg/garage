package service.registercar;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import service.common.api.validation.customer.CustomerId;
import service.registercar.api.Car;
import service.registercar.api.ServiceError;

public class RegisterCarRequest {

	@CustomerId(message=ServiceError.INVALID_CUSTOMER_ID)
	private String customerId;
	@Valid
	@NotNull(message=ServiceError.INVALID_CAR)
	private Car car;
	
	public RegisterCarRequest() {}
	
	public RegisterCarRequest(Builder builder) {
		this.customerId = builder.customerId;
		this.car = builder.car;
	}
	
	public static class Builder {
		private String customerId;
		private Car car;
		
		public Builder customerId(String customerId) {
			this.customerId = customerId;
			return this;
		}
		
		public Builder car(Car car) {
			this.car = car;
			return this;
		}
		
		public RegisterCarRequest build() {
			return new RegisterCarRequest(this);
		}
	}
}
