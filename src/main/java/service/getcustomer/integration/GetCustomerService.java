package service.getcustomer.integration;

import database.DatabaseConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.getcustomer.integration.api.Customer;
import service.getcustomer.integration.translator.CustomerTranslator;
import service.getcustomer.integration.translator.GetCustomerQueryTranslator;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Magdalena on 8/27/2016.
 */
@Service("integration.getcustomer")
public class GetCustomerService {

    private DatabaseConnector databaseConnector;

    @Autowired
    private GetCustomerQueryTranslator queryTranslator;
    
    @Autowired
    private CustomerTranslator customerTranslator;
    
    public GetCustomerService () {
        databaseConnector = new DatabaseConnector();
    }

    public Customer getCustomer(GetCustomerRequest getCustomerRequest) throws SQLException, Exception {

        try {
            databaseConnector.connect();
            ResultSet resultSet = databaseConnector.executeQuery(queryTranslator.translate(getCustomerRequest));
            while(resultSet.next()) {
                return customerTranslator.translate(resultSet);
            }
            return null;
        }
        catch(SQLException sqlException) {
            throw sqlException;
        }
        catch(Exception exception) {
            throw exception;
        }
    }
}
