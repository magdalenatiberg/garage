package service.createcustomer.business.translator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import service.createcustomer.integration.api.Customer;

/**
 * Created by e600783 on 18.06.2016.
 */
@Component("service.createcustomer.business.translator.CustomerTranslator")
public class CustomerTranslator {

    @Autowired
    @Qualifier("service.createcustomer.business.translator.AddressTranslator")
    private AddressTranslator addressTranslator;

    public CustomerTranslator() {}

    public Customer translate(service.createcustomer.business.api.Customer customer) {
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
