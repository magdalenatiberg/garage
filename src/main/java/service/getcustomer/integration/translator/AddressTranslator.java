package service.getcustomer.integration.translator;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import service.getcustomer.integration.api.Address;

@Component("service.getcustomer.integration.translator.AddressTranslator")
public class AddressTranslator {
	
	public Address translate(ResultSet resultSet) throws SQLException, Exception {
		try {
			return new Address.Builder()
					.street(resultSet.getString("address_street"))
					.zipCode(resultSet.getString("address_zipcode"))
					.city(resultSet.getString("address_city"))
					.build();
	
		} catch(Exception exception) {
			throw exception;
		}
	}			

}
