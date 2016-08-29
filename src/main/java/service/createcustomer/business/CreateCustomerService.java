package service.createcustomer.business;

import service.common.api.ServiceError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import service.createcustomer.business.api.Customer;
import service.createcustomer.business.translator.CreateCustomerRequestTranslator;
import service.createcustomer.business.translator.GetCustomerRequestTranslator;
import service.createcustomer.integration.CreateCustomerRequest;
import service.getcustomer.business.GetCustomerResponse;
import service.getcustomer.business.GetCustomerService;

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
    private CreateCustomerRequestTranslator createCustomerRequestTranslator;
    
    @Autowired
    private GetCustomerRequestTranslator getCustomerRequestTranslator;

    @Autowired
    private service.createcustomer.integration.CreateCustomerService createCustomerService;
    
    @Autowired
    private GetCustomerService getCustomerService;
    
    private boolean isCustomerRegistered(Customer customer) {
        //GetCustomerRequest getCustomerRequest = getCustomerRequestTranslator.translate(customer);

        GetCustomerResponse getCustomerResponse = getCustomerService.getCustomer(customer.getCustomerId());
        if(getCustomerResponse != null) {
        	return true;
        }
        return false;
    }
    
    private ServiceError getCustomerIsRegisteredError() {
    	String errorCode = service.createcustomer.business.api.ServiceError.CUSTOMER_IS_REGISTERED;
    	return new ServiceError.Builder()
    			.code(errorCode)
    			.build();
    }

    @RequestMapping(method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody CreateCustomerResponse createCustomer(@RequestBody Customer customer) {

        try {
            List<ServiceError> validationErrors = validator.validate(customer);
            if (validationErrors != null && validationErrors.size() > 0) {
                return new CreateCustomerResponse.Builder()
                        .serviceErrors(validationErrors)
                        .build();
            }

            if(isCustomerRegistered(customer)) {
            	List<ServiceError> serviceErrors = new ArrayList<>();
            	serviceErrors.add(getCustomerIsRegisteredError());
            	return new CreateCustomerResponse.Builder()
                        .serviceErrors(serviceErrors)
                        .build();
            }
            
            
            
            CreateCustomerRequest request = createCustomerRequestTranslator.translate(customer);
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
