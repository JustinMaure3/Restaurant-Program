package Database;

import java.sql.Connection;
import java.sql.SQLException;



public class Database {

	//Create an instance variable
		private static Database instance = null;
		private Connection connection = null;
		
	//Private constructor
	private Database() {
		//If the connection exists
		if(connection == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				//connection = DriverManager.getConnection("jdbc:mysql://php.scweb.ca/" + Const.DB_NAME +"?useSSL=false", Const.DB_USER, Const.DB_PASS);
				System.out.println("Connection Sucessfully Created");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//getInstance method
		public static Database getInstance() {
			if(instance == null) {
				instance = new Database();
			}
			return instance;
		}
	
	public Connection getConnection() {
		return connection;
	}
	
	//Close connection method
	public void close() {
		System.out.println("Closing Connection");
		try {
			connection.close();
		}catch (SQLException e) {
			connection = null;
			e.printStackTrace();
		}
	}
	
}