package database;

import java.sql.*;

/**
 * Created by E600783 on 11.06.2016.
 */
public class DatabaseTestFile {


    public static void main(String[] args) throws SQLException {

        System.out.println("-------- Oracle JDBC Connection Testing ------");

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
            return;

        }

        System.out.println("Oracle JDBC Driver Registered!");

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "system",
                    "password");

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;

        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
             Statement statement = connection.createStatement();
            String query = "insert into customer values('201208190980', 'Lennart', 'Lundgren Tiberg', 'Anderstorpsvägen 4', '17151', 'SOLNA')";
            System.out.println(query);
            int numberOfAffectedRows = statement.executeUpdate(query);

            if(numberOfAffectedRows < 1) {

            }


        } else {
            System.out.println("Failed to make connection!");
        }
        connection.close();
    }
}
