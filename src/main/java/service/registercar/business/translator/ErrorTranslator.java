package service.registercar.business.translator;

import org.springframework.stereotype.Component;

import service.common.response.ServiceError;

@Component("service.registercar.business.translator.ErrorTranslator")
public class ErrorTranslator {

	public ServiceError translate(ServiceError serviceError) {
		String errorCode = serviceError.getCode();
		switch(errorCode) {
		case service.registercar.integration.api.ServiceError.CAR_ALREADY_REGISTERED_CODE: {
			return new ServiceError.Builder()
					.code(service.registercar.business.api.ServiceError.CAR_ALREADY_REGISTERED)
					.build();
		}
		case service.registercar.integration.api.ServiceError.CAR_IS_ALREADY_REGISTERED_ON_CUSTOMER_CODE: {
			return new ServiceError.Builder()
					.code(service.registercar.business.api.ServiceError.CAR_IS_ALREADY_REGISTERED_ON_CUSTOMER)
					.build();
		}
		case service.registercar.integration.api.ServiceError.CUSTOMER_DOES_NOT_EXIST_CODE: {
			return new ServiceError.Builder()
					.code(service.registercar.business.api.ServiceError.CUSTOMER_DOES_NOT_EXIST)
					.build();
		}
		default: {
			return new ServiceError(ServiceError.Error.GENERAL_ERROR);
		}
	}
	}
}
