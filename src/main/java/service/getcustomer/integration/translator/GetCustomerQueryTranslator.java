package service.getcustomer.integration.translator;

import org.springframework.stereotype.Component;
import service.getcustomer.integration.GetCustomerRequest;

/**
 * Created by Magdalena on 8/28/2016.
 */
@Component
public class GetCustomerQueryTranslator {

    public String translate(GetCustomerRequest request) {
        String selectStatement = "select * from customer where customerId = '";
        StringBuilder query = new StringBuilder();
        query.append(selectStatement);
        query.append(request.getCustomerId());
        query.append("'");
        return query.toString();
    }
}
