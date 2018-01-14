package Tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Database.Const;
import Database.Database;
import PlaceHolder.StoreLocations;
/**
 * Store locations table with all of its methods
 * @author Stefano,Max,Tomas,Justin
 *
 */
public class StoreLocationsTable {
	//Creating an instance of the database
	Database db = Database.getInstance();
	
	//Construct
	public StoreLocationsTable() {
		
	}

	//Creating a method to get all instances of store locations class within the table
	public ArrayList<StoreLocations> getAllStoreLocations() {
		String query = "SELECT * FROM " + Const.TABLE_STORELOCATIONS;
		ArrayList<StoreLocations> storelocations = new ArrayList<StoreLocations>();
		try {
			//Use the singleton an grab its connection to create a statement
			Statement getItems = db.getConnection().createStatement();
			ResultSet data = getItems.executeQuery(query);
			//This while loop will run once for each item in the result set
			while(data.next()) {
				//Build each item and add it to the ArrayList
				storelocations.add(new StoreLocations(data.getInt(Const.STORELOCATIONS_COLUMN_ID),
								   data.getString(Const.STORELOCATIONS_COLUMN_LOCATION),
								   data.getString(Const.STORELOCATIONS_COLUMN_REGIONALMAN),
								   data.getInt(Const.STORELOCATIONS_COLUMN_CUSTREVIEW),
								   data.getInt(Const.STORELOCATIONS_COLUMN_SANTSCORE)));
				
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return storelocations;
	}

	//Creating a method to get a single instance of a store locations class
	public StoreLocations getStoreLocation(int storelocationID) {
		String query = "SELECT FROM " + Const.TABLE_STORELOCATIONS + " WHERE " + 
				   Const.STORELOCATIONS_COLUMN_ID + " = " + storelocationID;
		StoreLocations storeLocations = new StoreLocations();
		try {
			Statement getItem = db.getConnection().createStatement();
			ResultSet data = getItem.executeQuery(query);
			data.next();
			//Build each item and add it to the ArrayList
			storeLocations = new StoreLocations(data.getInt(Const.STORELOCATIONS_COLUMN_ID),
					   data.getString(Const.STORELOCATIONS_COLUMN_LOCATION),
					   data.getString(Const.STORELOCATIONS_COLUMN_REGIONALMAN),
					   data.getInt(Const.STORELOCATIONS_COLUMN_CUSTREVIEW),
					   data.getInt(Const.STORELOCATIONS_COLUMN_SANTSCORE));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return storeLocations;
	}

	//Creating method to update an instance of the store locations class in the database table
	public void updateStoreLocations(StoreLocations storeLocations) {
		
	}

	//Creating a method to delete an instance of the store locations class from the database table
	public void deleteStoreLocations(StoreLocations storeLocations) {
		String query = "DELETE FROM " + Const.TABLE_STORELOCATIONS + " WHERE " +
				   Const.STORELOCATIONS_COLUMN_ID + " = " + storeLocations.getID();
		try {
			db.getConnection().createStatement().execute(query);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	//Creating a method to add an instance of the store locations class to the database table
	public void createStoreLocations(StoreLocations storeLocations) {
		String query = "INSERT INTO " + Const.TABLE_STORELOCATIONS + 
				   "(" + Const.STORELOCATIONS_COLUMN_LOCATION + "," +
				   Const.STORELOCATIONS_COLUMN_REGIONALMAN + "," +
				   Const.STORELOCATIONS_COLUMN_CUSTREVIEW + "," +
				   Const.STORELOCATIONS_COLUMN_SANTSCORE + ") values ('"+
				   storeLocations.getLocation() + "','" + storeLocations.getCustReview() + "','" +
				   storeLocations.getRegionalMan() + "','" + storeLocations.getSantScore() + "')";
		try {
			db.getConnection().createStatement().execute(query);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}