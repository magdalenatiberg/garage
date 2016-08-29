package service.getcustomer.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import service.common.api.ServiceError;
import service.getcustomer.business.api.Customer;
import service.getcustomer.business.translator.CustomerTranslator;
import service.getcustomer.business.translator.GetCustomerRequestTranslator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Magdalena on 8/27/2016.
 */
@CrossOrigin(origins = "http://localhost:63342")
@RequestMapping("/rest/getcustomer")
@RestController
public class GetCustomerService {

    @Autowired
    private static final service.common.validation.ValidatorFactory<GetCustomerRequest> validator = new service.common.validation.ValidatorFactory<GetCustomerRequest>();;

    @Autowired
    private GetCustomerRequestTranslator requestTranslator;

    @Autowired
    private CustomerTranslator customerTranslator;

    @Autowired
    @Qualifier("integration.getcustomer")
    private service.getcustomer.integration.GetCustomerService getCustomerService;

    @RequestMapping(method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody GetCustomerResponse getCustomer(@RequestBody GetCustomerRequest request) {

        String customerId = request.getCustomerId();
        try {
            List<ServiceError> validationErrors = validator.validate(request);
            if (validationErrors != null && validationErrors.size() > 0) {
                return new GetCustomerResponse.Builder()
                        .serviceErrors(validationErrors)
                        .build();
            }

            service.getcustomer.integration.GetCustomerRequest getCustomerRequest = requestTranslator.translate(request);
            Customer customer = customerTranslator.translate(getCustomerService.getCustomer(getCustomerRequest));

            return new GetCustomerResponse.Builder()
                    .customer(customer)
                    .build();
        }

        catch(Exception exception) {
            List<ServiceError> errors = new ArrayList<>();
            errors.add(new ServiceError(ServiceError.Error.GENERAL_ERROR));
            return null;
        }
    }
}
