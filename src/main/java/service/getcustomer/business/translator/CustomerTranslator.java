package service.getcustomer.business.translator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import service.getcustomer.business.api.Customer;

/**
 * Created by Magdalena on 8/28/2016.
 */
@Component("service.getcustomer.business.translator.CustomerTranslator")
public class CustomerTranslator {

    @Autowired
    @Qualifier("service.getcustomer.business.api.Address.AddressTranslator")
    private AddressTranslator addressTranslator;

    public Customer translate(service.getcustomer.integration.api.Customer customer) {
        return new Customer.Builder()
                .customerId(customer.getCustomerId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .address(addressTranslator.translate(customer.getAddress()))
                .phoneNumber(customer.getPhoneNumber())
                .emailAddress(customer.getEmailAddress())
                .build();
    }
}
