package service.createcustomer.business;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import service.createcustomer.business.api.Customer;
import service.createcustomer.business.api.ServiceError;

public class CreateCustomerRequest {
	@NotNull(message=ServiceError.INVALID_CUSTOMER)
	@Valid
	private Customer customer;
	
	public CreateCustomerRequest(Builder builder) {
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}
	
	public static class Builder {
		private Customer customer;
		
		public Builder customer(Customer customer) {
			this.customer = customer;
			return this;
		}
		
		public CreateCustomerRequest build() {
			return new CreateCustomerRequest(this);
		}
	}

}
