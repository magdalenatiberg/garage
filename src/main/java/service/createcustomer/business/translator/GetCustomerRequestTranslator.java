package service.createcustomer.business.translator;

import service.createcustomer.business.api.Customer;
import service.getcustomer.business.GetCustomerRequest;

public class GetCustomerRequestTranslator {

	public GetCustomerRequest translate(Customer customer) {
		return new GetCustomerRequest.Builder()
				.customerId(customer.getCustomerId())
				.build();
	}
}
