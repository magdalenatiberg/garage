package service.registercar.integration;

import service.registercar.integration.api.Car;

public class RegisterCarRequest {

	private String customerId;
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
