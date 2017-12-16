package Tables;

import java.util.ArrayList;

import DAO.FoodDrinkDAO;
import Database.Database;
import PlaceHolder.FoodDrink;

public class FoodTable implements FoodDrinkDAO {

	//Creating an instance of the database
	Database db = Database.getInstance();

	//Creating a method to get all instances of foodDrink class
	@Override
	public ArrayList<FoodDrink> getAllFoodDrink() {
		
		return null;
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
