package service.registercar.integration.translator;

import org.springframework.stereotype.Component;

import service.common.response.ServiceError;

@Component("service.registercar.integration.translator.ErrorTranslator")
public class ErrorTranslator {
	
	private static final String CAR_ALREADY_REGISTERED = "1";
	private static final String CAR_IS_ALREADY_REGISTERED_ON_CUSTOMER = "2";
	private static final String CUSTOMER_DOES_NOT_EXIST = "3";

	public ServiceError translate(String resultCode) {
		switch(resultCode) {
		case CAR_ALREADY_REGISTERED: {
			return getServiceError(service.registercar.integration.api.ServiceError.Error.CAR_ALREADY_REGISTERED);
		} 
		case CAR_IS_ALREADY_REGISTERED_ON_CUSTOMER: {
			return getServiceError(service.registercar.integration.api.ServiceError.Error.CAR_IS_ALREADY_REGISTERED_ON_CUSTOMER);
		}
		case CUSTOMER_DOES_NOT_EXIST: {
			return getServiceError(service.registercar.integration.api.ServiceError.Error.CUSTOMER_DOES_NOT_EXIST);
		}
		default: {
			return new ServiceError(ServiceError.Error.GENERAL_ERROR);
		}
		}
	}
		
	public ServiceError getServiceError(service.registercar.integration.api.ServiceError.Error serviceError) {
		return new ServiceError.Builder()
				.code(serviceError.getCode())
				.message(serviceError.getMessage())
				.build();
	}
}
