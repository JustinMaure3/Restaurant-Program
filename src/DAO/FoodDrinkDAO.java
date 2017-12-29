package DAO;

import java.util.ArrayList;

import PlaceHolder.FoodDrink;

public interface FoodDrinkDAO {
	//Everything we want to do with the able
	//Get all
	public ArrayList<FoodDrink> getAllFoodDrink();
	//Get 1
	public FoodDrink getFoodDrink(int itemID);
	//Update
	public void updateFoodDrink(FoodDrink foodDrink);
	//Delete
	public void deleteFoodDrink(FoodDrink foodDrink);
	//Create
	public void createFoodDrink(FoodDrink foodDrink);
	FoodDrink getTopFoodDrink(int foodSales);
	
}
