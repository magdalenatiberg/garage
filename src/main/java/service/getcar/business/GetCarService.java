package service.getcar.business;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import database.DatabaseConnector;
import service.common.response.ServiceError;
import service.getcar.business.translator.CarTranslator;
import service.getcar.business.translator.GetCarQueryTranslator;

@CrossOrigin(origins = "http://localhost:63342")
@RequestMapping("/rest/getcar")
@RestController()
public class GetCarService {
    private DatabaseConnector databaseConnector;
    private static final String GET_CUSTOMER_QUERY = "select * from car where registration_number = '";
	
	@Autowired
    private static final service.common.validation.ValidatorFactory<GetCarRequest> validator = new service.common.validation.ValidatorFactory<GetCarRequest>();;

    @Autowired
    private GetCarQueryTranslator getCarQueryTranslator;
    
    @Autowired
    @Qualifier("service.getcar.business.translator.CarTranslator")
    private CarTranslator carTranslator;
    
    public GetCarService() {
        databaseConnector = new DatabaseConnector();
    }
    
    @RequestMapping(method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody GetCarResponse getCar(@RequestBody GetCarRequest getCarRequest) throws SQLException {
    	try {
    		List<ServiceError> validationErrors = validator.validate(getCarRequest);
            if (validationErrors != null && validationErrors.size() > 0) {
                return new GetCarResponse.Builder()
                        .serviceErrors(validationErrors)
                        .build();
            }
            ResultSet resultSet = databaseConnector.executeQuery(getCarQueryTranslator.translate(getCarRequest.getRegistrationNumber()));
            
            while(resultSet.next()) {
            	return new GetCarResponse.Builder()
                		.car(carTranslator.translate(resultSet))
                		.build();                	
            }
            List<ServiceError> serviceErrors = new ArrayList<>();
            ServiceError serviceError = new ServiceError.Builder()
            		.code(service.getcar.business.api.ServiceError.NO_CAR_FOUND)
            		.build();
            serviceErrors.add(serviceError);
            return new GetCarResponse.Builder()
            		.serviceErrors(serviceErrors)
            		.build();
            
    	}
    	catch(Exception exception) {
            List<ServiceError> serviceErrors = new ArrayList<>();
    		ServiceError serviceError = new ServiceError(ServiceError.Error.GENERAL_ERROR);
            serviceErrors.add(serviceError);
            return new GetCarResponse.Builder()
            		.serviceErrors(serviceErrors)
            		.build();
    	}
	}
}
