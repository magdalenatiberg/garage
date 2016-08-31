package service.registercar.business;

import java.util.ArrayList;
import java.util.List;

import service.common.response.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import service.common.response.ServiceError;
import service.registercar.business.translator.RegisterCarRequestTranslator;

@Service("service.registercar.business.RegisterCarService")
public class RegisterCarService {
	
	@Autowired
    private static final service.common.validation.ValidatorFactory<RegisterCarRequest> validator = new service.common.validation.ValidatorFactory<RegisterCarRequest>();
	
	@Autowired
	private RegisterCarRequestTranslator requestTranslator;

	@Autowired
	@Qualifier("service.registercar.integration.RegisterCarService")
	private service.registercar.integration.RegisterCarService registerCarService;
	
	public @ResponseBody RegisterCarResponse registerCar(@RequestBody RegisterCarRequest registerCarRequest) {
		
		try {
            List<ServiceError> validationErrors = validator.validate(registerCarRequest);
            if (validationErrors != null && validationErrors.size() > 0) {
                return new RegisterCarResponse.Builder()
                        .serviceErrors(validationErrors)
                        .build();
            }
            service.registercar.integration.RegisterCarRequest registerCarIntegrationRequest = requestTranslator.translate(registerCarRequest);
            registerCarService.registerCar(registerCarIntegrationRequest);
            return new RegisterCarResponse.Builder()
            		.status(Status.OK.getStatus())
            		.build();
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
