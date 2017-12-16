package Tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DAO.FoodDrinkDAO;
import Database.Const;
import Database.Database;
import PlaceHolder.FoodDrink;

public class FoodTable implements FoodDrinkDAO {

	//Creating an instance of the database
	Database db = Database.getInstance();

	//Creating a method to get all instances of foodDrink class within the table
	@Override
	public ArrayList<FoodDrink> getAllFoodDrink() {
		String query = "SELECT * FROM " + Const.TABLE_FOOD_DRINK;
		ArrayList<FoodDrink> foodDrinks = new ArrayList<FoodDrink>();
		try {
			//Use the singleton an grab its connection to create a statement
			Statement getItems = db.getConnection().createStatement();
			ResultSet data = getItems.executeQuery(query);
			//This while loop will run once for each item in the result set
			while(data.next()) {
				//Build each item and add it to the ArrayList
				foodDrinks.add(new FoodDrink(data.getInt(Const.FOOD_DRINK_COLUMN_ID),
								   data.getString(Const.FOOD_DRINK_COLUMN_NAME),
								   data.getInt(Const.FOOD_DRINK_COLUMN_RATING),
								   data.getString(Const.FOOD_DRINK_COLUMN_DESCRIPTION),
								   data.getString(Const.FOOD_DRINK_COLUMN_PICTURE)));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return foodDrinks;
	}

	//Creating a method to get a single instance of a foodDrink class
	@Override
	public FoodDrink getFoodDrink(int itemID) {
		
		return null;
	}
	

	//Creating method to update an instance of foodDrink class in the database table
	@Override
	public void updateFoodDrink(FoodDrink foodDrink) {
		
		
	}

	//Creating a method to delete an instance of foodDrink class from the database table
	@Override
	public void deleteFoodDrink(FoodDrink foodDrink) {
		
		
	}

	//Creating a method to add an instance of foodDrink class to the database table
	@Override
	public void createFoodDrink(FoodDrink foodDrink) {
		
		
	}
	
	
}
