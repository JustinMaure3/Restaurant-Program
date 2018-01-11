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
	
	//Add a construct
	public FoodTable() {
		
	}

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
								   data.getString(Const.FOOD_DRINK_COLUMN_PICTURE),
								   data.getDouble(Const.FOOD_DRINK_COLUMN_PRICE),
								   data.getDouble(Const.FOOD_DRINK_COLUMN_AMOUNT_SOLD),
								   data.getString(Const.FOOD_DRINK_COLUMN_MONTH)));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return foodDrinks;
	}

	//Creating a method to get a single instance of a foodDrink class
	@Override
	public FoodDrink getFoodDrink(int foodID) {
		String query = "SELECT FROM " + Const.TABLE_FOOD_DRINK + " WHERE " 
				+ Const.FOOD_DRINK_COLUMN_ID + " = " + foodID;
		FoodDrink foodItem = new FoodDrink();
		try {
			Statement getItem = db.getConnection().createStatement();
			ResultSet data = getItem.executeQuery(query);
			data.next();
			foodItem = new FoodDrink(data.getInt(Const.FOOD_DRINK_COLUMN_ID),
					   data.getString(Const.FOOD_DRINK_COLUMN_NAME),
					   data.getInt(Const.FOOD_DRINK_COLUMN_RATING),
					   data.getString(Const.FOOD_DRINK_COLUMN_DESCRIPTION),
					   data.getString(Const.FOOD_DRINK_COLUMN_PICTURE),
					   data.getDouble(Const.FOOD_DRINK_COLUMN_PRICE),
					   data.getDouble(Const.FOOD_DRINK_COLUMN_AMOUNT_SOLD),
					   data.getString(Const.FOOD_DRINK_COLUMN_MONTH));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return foodItem;
	}
	
	
	//Creating a method to grab the top fooditem
		@Override
		public FoodDrink getTopFoodDrink (int foodSales) {
			String query = "SELECT * FROM " + Const.TABLE_FOOD_DRINK  + " ORDER BY " + Const.FOOD_DRINK_COLUMN_AMOUNT_SOLD + " DESC ";
			FoodDrink foodItem = new FoodDrink();
			try {
				Statement getItem = db.getConnection().createStatement();
				ResultSet data = getItem.executeQuery(query);
				data.next();
				foodItem = new FoodDrink(data.getString(Const.FOOD_DRINK_COLUMN_NAME),
						data.getDouble(Const.FOOD_DRINK_COLUMN_AMOUNT_SOLD),
						data.getString(Const.FOOD_DRINK_COLUMN_PICTURE));
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return foodItem;
		}

	//Creating method to update an instance of foodDrink class in the database table
	@Override
	public void updateFoodDrink(FoodDrink foodDrink) {
		String query = "UPDATE " + Const.TABLE_FOOD_DRINK + " SET " + 
				Const.FOOD_DRINK_COLUMN_RATING + " = " + foodDrink.getRating() + ", " +
				Const.FOOD_DRINK_COLUMN_DESCRIPTION + " = " + foodDrink.getDescription() + ", " +
				Const.FOOD_DRINK_COLUMN_PICTURE + " = " + foodDrink.getPicture() + ", " +
				Const.FOOD_DRINK_COLUMN_PRICE + " = " + foodDrink.getPrice() + ", " +
				Const.FOOD_DRINK_COLUMN_AMOUNT_SOLD + " = " + foodDrink.getAmountSold() + ", " +
				Const.FOOD_DRINK_COLUMN_MONTH + " = " + foodDrink.getMonth() + " WHERE " +
				Const.FOOD_DRINK_COLUMN_NAME + " = " + foodDrink.getName();
		try {
			db.getConnection().createStatement().execute(query);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	//Creating a method to delete an instance of foodDrink class from the database table
	@Override
	public void deleteFoodDrink(FoodDrink foodDrink) {
		String query = "DELETE FROM " + Const.TABLE_FOOD_DRINK + " WHERE " +
				   Const.FOOD_DRINK_COLUMN_ID + " = " + foodDrink.getID();
		try {
			db.getConnection().createStatement().execute(query);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	//Creating a method to add an instance of foodDrink class to the database table
	@Override
	public void createFoodDrink(FoodDrink foodDrink) {
		String query = "INSERT INTO " + Const.TABLE_FOOD_DRINK + 
				   "(" + Const.FOOD_DRINK_COLUMN_NAME + "," +
				   Const.FOOD_DRINK_COLUMN_RATING + "," +
				   Const.FOOD_DRINK_COLUMN_DESCRIPTION + "," +
				   Const.FOOD_DRINK_COLUMN_PICTURE + "," +
				   Const.FOOD_DRINK_COLUMN_PRICE + "," +
				   Const.FOOD_DRINK_COLUMN_AMOUNT_SOLD +  "," +
				   Const.FOOD_DRINK_COLUMN_MONTH + ") values ('"+
				   foodDrink.getName() + "','" + foodDrink.getRating() + "','" +
				   foodDrink.getDescription() + "','" + foodDrink.getPicture() + "','" +
				   foodDrink.getPrice() + "','" + foodDrink.getAmountSold() + "','" + foodDrink.getMonth() + "')";
		try {
			db.getConnection().createStatement().execute(query);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
