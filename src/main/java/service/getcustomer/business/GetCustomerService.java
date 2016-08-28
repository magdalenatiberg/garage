package service.getcustomer.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import service.common.api.ServiceError;

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
    private static final service.common.validation.ValidatorFactory<String> validator = new service.common.validation.ValidatorFactory<String>();;

    @RequestMapping(method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody GetCustomerResponse getCustomer(@RequestBody String customerId) {

        try {
            List<ServiceError> validationErrors = validator.validate(customerId);
            if (validationErrors != null && validationErrors.size() > 0) {
                return null;
            }

            return null;
        }

        catch(Exception exception) {
            List<ServiceError> errors = new ArrayList<>();
            errors.add(new ServiceError(ServiceError.Error.GENERAL_ERROR));
            return null;
        }
    }
}
