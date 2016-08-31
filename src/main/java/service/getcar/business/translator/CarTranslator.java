package service.getcar.business.translator;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import service.getcar.business.api.Car;

@Component("service.getcar.business.translator.CarTranslator")
public class CarTranslator {
	
	@Autowired
	AppointmentTranslator appointmentTranslator;

	public Car translate(ResultSet resultSet) throws SQLException  { 
		try {
			return new Car.Builder()
					.registrationNumber(resultSet.getString("REGISTRATION_NUMBER"))
					.manufacturer(resultSet.getString("MANUFACTURER"))
					.model(resultSet.getString("MODEL"))
					.modelYear(resultSet.getString("MODEL_YEAR"))
					//.appointments(appointmentTranslator.translate(resultSet))
					.build();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
}
