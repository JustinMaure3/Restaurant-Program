package DAO;

import java.util.ArrayList;

import PlaceHolder.FoodDrink;

public interface FoodDrinkDAO {
	//Everything we want to do with the Table
	/**
	 * This grabs all the fooDrink items
	 */
	public ArrayList<FoodDrink> getAllFoodDrink();
	/**
	 * This gets one foodDrink item
	 */
	public FoodDrink getFoodDrink(String foodName);
	/**
	 * This updates foodDrink item
	 */
	public void updateFoodDrink(FoodDrink foodDrink);
	/**
	 * This deletes foodDrink item
	 */
	public void deleteFoodDrink(FoodDrink foodDrink);
	/**
	 * This creates foodDrink 
	 */
	public void createFoodDrink(FoodDrink foodDrink);
	
	/**
	 * This grabs the top foodDrink
	 */
	FoodDrink getTopFoodDrink(int foodSales);
	
}
