package service.createcustomer.business;

import org.springframework.beans.factory.annotation.Qualifier;
import service.common.api.ServiceError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import service.createcustomer.business.api.Customer;
import service.createcustomer.business.translator.CreateCustomerRequestTranslator;
import service.createcustomer.integration.CreateCustomerRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by E600783 on 05.06.2016.
 */
@CrossOrigin(origins = "http://localhost:63342")
@RequestMapping("/rest/createcustomer")
@RestController()
public class CreateCustomerService {

    @Autowired
    private static final service.common.validation.ValidatorFactory<Customer> validator = new service.common.validation.ValidatorFactory<Customer>();;

    @Autowired
    private CreateCustomerRequestTranslator requestTranslator;

    @Autowired
    private service.createcustomer.integration.CreateCustomerService createCustomerService;

    @RequestMapping(method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody CreateCustomerResponse createCustomer(@RequestBody Customer customer) {

        try {
            List<ServiceError> validationErrors = validator.validate(customer);
            if (validationErrors != null && validationErrors.size() > 0) {
                return new CreateCustomerResponse.Builder()
                        .serviceErrors(validationErrors)
                        .build();
            }

            CreateCustomerRequest request = requestTranslator.translate(customer);
            createCustomerService.createCustomer(request);
            return new CreateCustomerResponse.Builder().build();
        }

        catch(Exception exception) {
            List<ServiceError> errors = new ArrayList<>();
            errors.add(new ServiceError(ServiceError.Error.GENERAL_ERROR));
            return new CreateCustomerResponse.Builder()
                    .serviceErrors(errors)
                    .build();
        }
    }
}
