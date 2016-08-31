package service.getcustomer.integration.translator;

import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import service.getcustomer.integration.api.Customer;

@Component("service.getcustomer.integration.translator.CustomerTranslator")
public class CustomerTranslator {
	
	@Autowired
	@Qualifier("service.getcustomer.integration.translator.AddressTranslator")
	private AddressTranslator addressTranslator;

	public Customer translate(ResultSet resultSet) throws Exception {
		return new Customer.Builder()
				.customerId(resultSet.getString("customerid"))
                .firstName(resultSet.getString("firstname"))
                .lastName(resultSet.getString("lastname"))
                .address(addressTranslator.translate(resultSet))
                .phoneNumber(resultSet.getString("phone_number"))
                .emailAddress(resultSet.getString("email_address"))
                .build();
	}
}
