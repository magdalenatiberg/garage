package service.registercar.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import service.common.response.ServiceError;
import service.registercar.business.translator.RegisterCarRequestTranslator;

@Service("service.registercar.business.RegisterCarService")
public class RegisterCarService {
	
	@Autowired
	private RegisterCarRequestTranslator requestTranslator;
	
	@Autowired
    private static final service.common.validation.ValidatorFactory<RegisterCarRequest> validator = new service.common.validation.ValidatorFactory<RegisterCarRequest>();;
	
	public @ResponseBody RegisterCarResponse registerCar(@RequestBody RegisterCarRequest request) {
		
		try {
            List<ServiceError> validationErrors = validator.validate(request);
            if (validationErrors != null && validationErrors.size() > 0) {
                return new RegisterCarResponse.Builder()
                        .serviceErrors(validationErrors)
                        .build();
            }
            return null;
		}
		catch(Exception exception) {
			List<ServiceError> errors = new ArrayList<>();
            errors.add(new ServiceError(ServiceError.Error.GENERAL_ERROR));
            return new RegisterCarResponse.Builder()
        			.serviceErrors(errors)
        			.build();
		}
		
	}
}
