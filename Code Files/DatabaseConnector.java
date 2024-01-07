package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

	    
	    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/eventvista";
	    private static final String USERNAME = "root";
	    private static final String PASSWORD = "maham123";

	    
	    private static Connection connection;

	    // Open a connection to the database
	    public static Connection connect() {
	        try {
	            if (connection == null || connection.isClosed()) {
	                Class.forName("com.mysql.cj.jdbc.Driver");
	                connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
	            }
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	            // Handle the exception (e.g., show an error message)
	        }
	        return connection;
	    }

	    // Close the connection to the database
	    public static void disconnect() {
	        try {
	            if (connection != null && !connection.isClosed()) {
	                connection.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            
	        }
	    }
}
