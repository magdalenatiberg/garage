package service.registercar.integration;

import java.sql.CallableStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Service;

import database.DatabaseConnector;

@Service("service.registercar.integration.RegisterCarService")
public class RegisterCarService {
	
	private static final String REGISTER_CAR_PROCEDURE_SIGNATURE = "{call REGISTER_CAR(?,?,?,?,?,?)}";
	private static final String OK_RESPONSE = "0";
	private static final String CAR_ALREADY_REGISTERED = "1";
	private static final String CAR_IS_ALREADY_REGISTERED_ON_CUSTOMER = "2";
	private static final String CUSTOMER_DOES_NOT_EXIST = "3";
	private	DatabaseConnector databaseConnector;
	
	public RegisterCarService() {
	    databaseConnector = new DatabaseConnector();
	}

	public void registerCar(RegisterCarRequest registerCarRequest) throws Exception {
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
			    checkResult(result);
		    }
		}

		catch(Exception exception) {
			throw exception;
		}
	}
	
	private void checkResult(String result) throws Exception {
		switch(result) {
		case OK_RESPONSE: {
			break;
		}
		case CAR_ALREADY_REGISTERED: {
			throw new Exception("The car has already been registered before");
		} 
		case CAR_IS_ALREADY_REGISTERED_ON_CUSTOMER: {
			throw new Exception("Car is already registered on the given customer");
		}
		case CUSTOMER_DOES_NOT_EXIST: {
			throw new Exception("Customer has not yet been registered in our system");
		}
		default: {
			throw new Exception("Unkown exception when calling registercar procedure");
		} 
		}
	}
}
