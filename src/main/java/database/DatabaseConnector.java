package database;

import org.springframework.stereotype.Repository;

import java.sql.*;

/**
 * Created by e600783 on 18.06.2016.
 */
@Repository
public class DatabaseConnector {

    Connection connection;

    public void connect() throws SQLException{

        try {
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "system",
                    "password");

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;

        }
    }

    public int executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeUpdate(query);
    }

    public void close() throws SQLException {
        if(connection != null) {
            connection.close();
        }
    }
}
