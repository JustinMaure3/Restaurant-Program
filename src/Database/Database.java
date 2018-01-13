package Database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	//Create an instance variable
	private static Database instance = null;
	private Connection connection = null;
	
	//Create a string that will be used in a query to create the food drink table
	public static final String CREATE_TABLE_FOOD_DRINK = 
			"CREATE TABLE " + Const.TABLE_FOOD_DRINK + " (" +
			Const.FOOD_DRINK_COLUMN_ID + " int NOT NULL AUTO_INCREMENT, " +
			Const.FOOD_DRINK_COLUMN_NAME + " VARCHAR(50), " +
			Const.FOOD_DRINK_COLUMN_RATING + " VARCHAR(50), " +
			Const.FOOD_DRINK_COLUMN_DESCRIPTION + " VARCHAR(100), " +
			Const.FOOD_DRINK_COLUMN_PICTURE + " VARCHAR(50), " +
			Const.FOOD_DRINK_COLUMN_PRICE + " VARCHAR(50), " +
			Const.FOOD_DRINK_COLUMN_AMOUNT_SOLD + " VARCHAR(50), " +
			Const.FOOD_DRINK_COLUMN_MONTH + " VARCHAR(50), " +
			"PRIMARY KEY(" + Const.FOOD_DRINK_COLUMN_ID + ")" + ");";
	
	//Create a string that will be used as a query to create the crewmembers table
	public static final String CREATE_TABLE_CREWMEMBER = 
			"CREATE TABLE " + Const.TABLE_CREWMEMBER + " (" +
			Const.CREWMEMBER_COLUMN_ID + " int NOT NULL AUTO_INCREMENT, " +
			Const.CREWMEMBER_COLUMN_NAME + " VARCHAR(50), " +
			Const.CREWMEMBER_COLUMN_WAGE + " VARCHAR(50), " +
			Const.CREWMEMBER_COLUMN_UNIFORM + " VARCHAR(50), " +
			Const.CREWMEMBER_COLUMN_POSITION + " VARCHAR(50), " +
			Const.CREWMEMBER_COLUMN_CREWMEMBERPUNCHIN + " VARCHAR(50), " +
			Const.CREWMEMBER_COLUMN_CREWMEMBERGOLDSTAR + " VARCHAR(50), " +
			"PRIMARY KEY(" + Const.CREWMEMBER_COLUMN_ID + ")" + ");";
	
	//Create a string that will be used as a query to create the Managers table
		public static final String CREATE_TABLE_MANAGER = 
				"CREATE TABLE " + Const.TABLE_MANAGER + " (" +
				Const.MANAGER_COLUMN_ID + " int NOT NULL AUTO_INCREMENT, " +
				Const.MANAGER_COLUMN_NAME + " VARCHAR(50), " +
				Const.MANAGER_COLUMN_WAGE + " VARCHAR(50), " +
				Const.MANAGER_COLUMN_UNIFORM + " VARCHAR(50), " +
				Const.MANAGER_COLUMN_POSITION + " VARCHAR(50), " +
				Const.MANAGER_COLUMN_MANAGERID + " VARCHAR(50), " +
				Const.MANAGER_COLUMN_MANAGERSAFECODE + " VARCHAR(50), " +
				"PRIMARY KEY(" + Const.MANAGER_COLUMN_ID + ")" + ");";
	
	//Create a string that will be used as a query to create the Locations table
	public static final String CREATE_TABLE_LOCATIONS =
			"CREATE TABLE " + Const.TABLE_STORELOCATIONS + " (" +
			Const.STORELOCATIONS_COLUMN_ID + " int NOT NULL AUTO_INCREMENT, " +
			Const.STORELOCATIONS_COLUMN_LOCATION + " VARCHAR(50)," +
			Const.STORELOCATIONS_COLUMN_REGIONALMAN + " VARCHAR(50), " +
			Const.STORELOCATIONS_COLUMN_SANTSCORE + " VARCHAR(50), " +
			Const.STORELOCATIONS_COLUMN_CUSTREVIEW + " VARCHAR(50), " +
			"PRIMARY KEY(" + Const.STORELOCATIONS_COLUMN_ID + ")" + ");";
	
	
	
	//Private constructor
	private Database() {
		//If the connection exists
		if(connection == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				//connection = DriverManager.getConnection("jdbc:mysql://php.scweb.ca/" + Const.DB_NAME +"?useSSL=false", Const.DB_USER, Const.DB_PASS);
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Const.DB_NAME +"?useSSL=false", Const.DB_USER, Const.DB_PASS);

				System.out.println("Connection Sucessfully Created");
			} catch (Exception e) {
				e.printStackTrace();
			}
			//create the food drink table
			createTable(Const.TABLE_FOOD_DRINK, CREATE_TABLE_FOOD_DRINK, connection);
			createTable(Const.TABLE_CREWMEMBER, CREATE_TABLE_CREWMEMBER, connection);
			createTable(Const.TABLE_STORELOCATIONS, CREATE_TABLE_LOCATIONS, connection);
			createTable(Const.TABLE_MANAGER, CREATE_TABLE_MANAGER, connection);
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
	
	//Create a method that will create a table
	public void createTable(String tableName, String tableQuery, Connection connection) {
		Statement createTables;
		try {
			DatabaseMetaData md = connection.getMetaData();
			ResultSet result = md.getTables(null, null, tableName, null);
			//Check to see if the table exists
			if(result.next()) {
				System.out.println(tableName + " Table already exists");
			} 
			//if it doesnt already exist then create the table
			else {
				createTables = connection.createStatement();
				createTables.execute(tableQuery);
				System.out.println("Table has been created");
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}