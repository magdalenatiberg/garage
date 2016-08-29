package service.getcustomer.business.translator;

import org.springframework.stereotype.Component;
import service.getcustomer.integration.GetCustomerRequest;

/**
 * Created by Magdalena on 8/28/2016.
 */
@Component("service.getcustomer.business.translator.GetCustomerRequestTranslator")
public class GetCustomerRequestTranslator {

    public GetCustomerRequest translate(service.getcustomer.business.GetCustomerRequest originalRequest) {
        return new GetCustomerRequest.Builder()
                .customerId(originalRequest.getCustomerId())
                .build();
    }
}
