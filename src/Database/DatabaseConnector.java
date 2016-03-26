package Database;
import java.sql.*;

import config.ConfigReader;

public class DatabaseConnector {
	/*Private Section*/
	private Connection connection;
	
	private void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	/*Public Section*/
	public DatabaseConnector() throws Exception{
		System.out.println("-------- Oracle JDBC Connection Testing ------");

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //Registriert den Treiber für die Datenbank
		} catch (ClassNotFoundException e) {

			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
		}

		System.out.println("Oracle JDBC Driver Registered!");

		this.setConnection(null);
		
		//Hole die Configuration
		config.ConfigReader config = new ConfigReader();
		String path = config.getDb_path();
		String user = config.getDb_user();
		String password = config.getDb_password();
		
		try {
			if(path != null && user != null && password != null){
				setConnection(DriverManager.getConnection(
						path, user,
						password));
				System.out.println("Mit dem Config-File hats funktioniert!");
			}else{
				/*setConnection(DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:BMDB", "SYSTEM",
						"2DSI6bm4BSJ"));*/
				Exception e = new Exception("In Datei config.props fehlen Angaben!");
				throw e;
			}
		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return connection;
	}
}
