package service.createcustomer.integration;

import database.DatabaseConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import service.createcustomer.integration.translator.CreateCustomerQueryTranslator;

import java.sql.SQLException;

/**
 * Created by E600783 on 15.06.2016.
 */
@Repository("integration.createcustomer")
public class CreateCustomerService {

    private DatabaseConnector databaseConnector;

    @Autowired
    private CreateCustomerQueryTranslator createCustomerQueryTranslator;

    public CreateCustomerService () {
        databaseConnector = new DatabaseConnector();
    }

    public void createCustomer(CreateCustomerRequest createCustomerRequest) throws SQLException, Exception {
        try {
            databaseConnector.connect();
            String query = createCustomerQueryTranslator.createQuery(createCustomerRequest);
            int numberOfAffectedRows = databaseConnector.executeUpdateQuery(query);
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
