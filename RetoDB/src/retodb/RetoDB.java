package retodb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetoDB {

    public static final String URL = "jdbc:sqlserver://;serverName=SQL5074.site4now.net;databaseName=db_a46019_test";
    public static final String USERNAME = "db_a46019_test_admin";
    public static final String PASSWORD = "test1234";
    

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
        } catch (Exception ex) {
            System.out.println("Error, no se ha podido cargar MySQL JDBC Driver");
        }
        try {

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            Statement statement = connection.createStatement();

            statement = connection.createStatement();
            

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return connection;
    }
}
