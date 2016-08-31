package service.createcustomer.business;

import org.springframework.beans.factory.annotation.Qualifier;
import service.common.response.ServiceError;
import service.common.response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import service.createcustomer.business.api.Customer;
import service.createcustomer.business.translator.CreateCustomerRequestTranslator;
import service.createcustomer.business.translator.GetCustomerRequestTranslator;
import service.getcustomer.business.GetCustomerRequest;
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
    private static final service.common.validation.ValidatorFactory<CreateCustomerRequest> validator = new service.common.validation.ValidatorFactory<CreateCustomerRequest>();;

    @Autowired
    @Qualifier("service.createcustomer.business.translator.GetCustomerRequestTranslator")
    private GetCustomerRequestTranslator getCustomerRequestTranslator;
    
    @Autowired
    private GetCustomerService getCustomerService;
    
    @Autowired
    private CreateCustomerRequestTranslator createCustomerRequestTranslator;
    
    @Autowired
    private service.createcustomer.integration.CreateCustomerService createCustomerService;
    
    @RequestMapping(method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody CreateCustomerResponse createCustomer(@RequestBody CreateCustomerRequest createCustomerRequest) {

    	Customer customer = createCustomerRequest.getCustomer();
        try {
            List<ServiceError> validationErrors = validator.validate(createCustomerRequest);
            if (validationErrors != null && validationErrors.size() > 0) {
                return new CreateCustomerResponse.Builder()
                        .serviceErrors(validationErrors)
                        .build();
            }

            GetCustomerRequest getCustomerRequest = getCustomerRequestTranslator.translate(createCustomerRequest);
            GetCustomerResponse getCustomerResponse = getCustomerService.getCustomer(getCustomerRequest);
            if(isCustomerRegistered(getCustomerResponse)) {
            	String errorCode = service.createcustomer.business.api.ServiceError.CUSTOMER_IS_REGISTERED;
            	return new CreateCustomerResponse.Builder()
                        .serviceErrors(getErrorList(errorCode))
                        .build();
            }
            
            service.createcustomer.integration.CreateCustomerRequest createCustomerIntegrationRequest = createCustomerRequestTranslator.translate(createCustomerRequest);
            createCustomerService.createCustomer(createCustomerIntegrationRequest);
            return new CreateCustomerResponse.Builder()
            		.status(Status.OK.getStatus())
            		.build();
        }

        catch(Exception exception) {
            List<ServiceError> errors = new ArrayList<>();
            errors.add(new ServiceError(ServiceError.Error.GENERAL_ERROR));
            return new CreateCustomerResponse.Builder()
                    .serviceErrors(errors)
                    .build();
        }
    }

    private boolean isCustomerRegistered(GetCustomerResponse getCustomerResponse) {
        if(getCustomerResponse.getCustomer() != null) {
            return true;
        }
        return false;
    }

    private List<ServiceError> getErrorList(String errorCode) {
    	List<ServiceError> serviceErrors = new ArrayList<>();
    	serviceErrors.add(getCustomerIsRegisteredError(errorCode));
        return serviceErrors;
    }
    
    private ServiceError getCustomerIsRegisteredError(String errorCode) {
        return new ServiceError.Builder()
                .code(errorCode)
                .build();
    }
}
