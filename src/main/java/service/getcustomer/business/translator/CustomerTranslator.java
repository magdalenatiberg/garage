package service.getcustomer.business.translator;

import org.springframework.stereotype.Component;
import service.getcustomer.business.api.Customer;

/**
 * Created by Magdalena on 8/28/2016.
 */
@Component
public class CustomerTranslator {

    public Customer translate(service.getcustomer.integration.api.Customer customer) {
        return new Customer.Builder()
                .customerId(customer.getCustomerId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .build();
    }
}
