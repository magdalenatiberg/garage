package service.createcustomer.business.translator;

import org.springframework.stereotype.Component;
import service.createcustomer.business.api.Customer;
import service.getcustomer.business.GetCustomerRequest;

@Component("service.createcustomer.business.translator.GetCustomerRequestTranslator")
public class GetCustomerRequestTranslator {

	public GetCustomerRequest translate(Customer customer) {
		return new GetCustomerRequest.Builder()
				.customerId(customer.getCustomerId())
				.build();
	}
}
