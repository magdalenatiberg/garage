package service.createcustomer.integration;

import database.DatabaseConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ExceptionDepthComparator;
import org.springframework.stereotype.Service;
import service.createcustomer.integration.translator.CreateCustomerQueryTranslator;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by E600783 on 15.06.2016.
 */
@Service("integration.createcustomer")
public class CreateCustomerService {

    @Autowired
    private DatabaseConnector databaseConnector;

    @Autowired
    private CreateCustomerQueryTranslator createCustomerQueryTranslator;

    public CreateCustomerService () {}

    public void createCustomer(CreateCustomerRequest createCustomerRequest) throws SQLException, Exception {
        try {
            databaseConnector.connect();
            String query = createCustomerQueryTranslator.createQuery(createCustomerRequest);
            int numberOfAffectedRows = databaseConnector.executeQuery(query);
            databaseConnector.close();
            if(numberOfAffectedRows < 1) {
                System.out.println("No affected rows");
                throw new Exception("No customer created");
            }
            System.out.println("Numer of affected rows: " + numberOfAffectedRows);

        } catch(SQLException exception) {
            System.out.println("An error occured, error code: " + exception.getErrorCode());
            System.out.println("An error occured, message: " + exception.getSQLState());
            throw exception;
        }
    }
}
