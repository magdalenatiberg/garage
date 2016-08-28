package service.createcustomer.integration.translator;

import org.springframework.stereotype.Component;
import service.createcustomer.integration.CreateCustomerRequest;
import service.createcustomer.integration.api.Address;
import service.createcustomer.integration.api.Customer;

/**
 * Created by e600783 on 18.06.2016.
 */
@Component
public class CreateCustomerQueryTranslator {

    private static final boolean USE_COMMA = true;
    private static final boolean DO_NOT_USE_COMMA = false;

    public CreateCustomerQueryTranslator () {}

    public String getValuePart(String value, boolean endWithComma) {
        if(endWithComma) {
            return "'" + value + "'" + ", ";
        }
        return "'" + value + "'";
    }

    public String createQuery(CreateCustomerRequest createCustomerRequest) {
        StringBuilder query = new StringBuilder();

        String part1 = "insert into customer values(";
        query.append(part1);

        Customer customer = createCustomerRequest.getCustomer();
        query.append(getValuePart(customer.getCustomerId(), USE_COMMA));
        query.append(getValuePart(customer.getFirstName(), USE_COMMA));
        query.append(getValuePart(customer.getLastName(), USE_COMMA));

        Address address = customer.getAddress();
        query.append(getValuePart(address.getStreet(), USE_COMMA));
        query.append(getValuePart(address.getZipCode(), USE_COMMA));
        query.append(getValuePart(address.getCity(), DO_NOT_USE_COMMA));

        String part2 = ")";
        query.append(part2);

        return query.toString();
    }
}
