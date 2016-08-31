package service.createcustomer.business.translator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import service.createcustomer.business.api.Customer;
import service.createcustomer.integration.CreateCustomerRequest;

/**
 * Created by e600783 on 18.06.2016.
 */
@Component
public class CreateCustomerRequestTranslator {

    @Autowired
    @Qualifier("service.createcustomer.business.translator.CustomerTranslator")
    private CustomerTranslator customerTranslator;

    public CreateCustomerRequestTranslator() {}

    public CreateCustomerRequest translate(service.createcustomer.business.CreateCustomerRequest createCustomerRequest) {

        return new CreateCustomerRequest.Builder()
                .customer(customerTranslator.translate(createCustomerRequest.getCustomer()))
                .build();
    }
}
