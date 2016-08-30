package service.getcustomer.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import service.common.api.ServiceError;
import service.getcustomer.business.translator.CustomerTranslator;
import service.getcustomer.business.translator.GetCustomerRequestTranslator;
import service.getcustomer.integration.api.Customer;

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
    @Qualifier("service.getcustomer.business.translator.GetCustomerRequestTranslator")
    private GetCustomerRequestTranslator requestTranslator;

    @Autowired
    @Qualifier("service.getcustomer.business.translator.CustomerTranslator")
    private CustomerTranslator customerTranslator;

    @Autowired
    @Qualifier("integration.getcustomer")
    private service.getcustomer.integration.GetCustomerService getCustomerService;

    @RequestMapping(method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody GetCustomerResponse getCustomer(@RequestBody GetCustomerRequest request) {

        try {
            List<ServiceError> validationErrors = validator.validate(request);
            if (validationErrors != null && validationErrors.size() > 0) {
                return new GetCustomerResponse.Builder()
                        .serviceErrors(validationErrors)
                        .build();
            }

            service.getcustomer.integration.GetCustomerRequest getCustomerRequest = requestTranslator.translate(request);
            Customer customer = getCustomerService.getCustomer(getCustomerRequest);

            if(customer != null) {
            	return new GetCustomerResponse.Builder()
                        .customer(customerTranslator.translate(customer))
                        .build();
            } else {
            	List<ServiceError> errors = new ArrayList<>();
            	errors.add(getCustomerNotFoundError());
            	return new GetCustomerResponse.Builder()
            			.serviceErrors(errors)
            			.build();
            }
        	
        }

        catch(Exception exception) {
            List<ServiceError> errors = new ArrayList<>();
            errors.add(new ServiceError(ServiceError.Error.GENERAL_ERROR));
            return null;
        }
    }
   
    public ServiceError getCustomerNotFoundError() {
    	return new ServiceError.Builder()
    			.code(service.getcustomer.business.api.ServiceError.NO_CUSTOMER_FOUND)
    			.build();

    }
}
