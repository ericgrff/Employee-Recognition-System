import java.sql.*;
import javax.swing.*;
public class databaseConnect {

	// Global variable. This is part of the java
	// dot SQL class above (import java.sql).
	Connection con = null;
	
	// Database Method Connect. This Method will
	// return the connection above (Connection
	// con = null).
	public static Connection dbConnector() {
		
		try {
			// Define the class for connection to 
			// the SQLite
			Class.forName("org.sqlite.JDBC");
			// Create the connection
			Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Eric\\workspace\\School Project\\EmployeeDB.sqlite");
			return con;
			
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, e); // shows message if not connection.
			return null;
		}
		
	}
	
}
