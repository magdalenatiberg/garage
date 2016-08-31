package service.registercar.integration;

import java.sql.CallableStatement;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import database.DatabaseConnector;
import service.registercar.integration.translator.ErrorTranslator;

@Service("service.registercar.integration.RegisterCarService")
public class RegisterCarService {
	
	@Autowired
	@Qualifier("service.registercar.integration.translator.ErrorTranslator")
	private ErrorTranslator errorTranslator;
	
	private static final String REGISTER_CAR_PROCEDURE_SIGNATURE = "{call REGISTER_CAR(?,?,?,?,?,?)}";
	private static final String RESPONSE_OK = "1";
	private	DatabaseConnector databaseConnector;
	
	public RegisterCarService() {
	    databaseConnector = new DatabaseConnector();
	}

	public RegisterCarResponse registerCar(RegisterCarRequest registerCarRequest) throws Exception {
		try {
			databaseConnector.connect();
			CallableStatement callableStatement = databaseConnector.getCallableStatement(REGISTER_CAR_PROCEDURE_SIGNATURE);
			callableStatement.setString(1, registerCarRequest.getCustomerId());
			callableStatement.setString(2, registerCarRequest.getCar().getRegistrationNumber());
			callableStatement.setString(3, registerCarRequest.getCar().getManufacturer());
			callableStatement.setString(4, registerCarRequest.getCar().getModel());
			callableStatement.setString(5, registerCarRequest.getCar().getModelYear());
			callableStatement.registerOutParameter(6, java.sql.Types.VARCHAR);
			ResultSet resultSet = callableStatement.executeQuery();
			while (resultSet.next()) {
			    String result = resultSet.getString("RESULT");
			    if(resultIsOk(result)) {
			    	return new RegisterCarResponse.Builder()
			    			.build();
			    }
			    return new RegisterCarResponse.Builder()
			    		.serviceErrors(errorTranslator.translate(result))
			    		.build();
		    }
			throw new Exception("Something went wrong");
		}

		catch(Exception exception) {
			throw exception;
		}
	}
	
	public boolean resultIsOk(String result) {
		return result == RESPONSE_OK;
	}
	
}
