package DAO;

import java.util.ArrayList;
import PlaceHolder.StoreLocations;

public interface StoreLocationDAO {
	//Everything we want to do with the table
	public ArrayList<StoreLocations> getAllStoreLocations();
	//Get 1
	public StoreLocations getStoreLocation(int itemID);
	//Update
	public void updateStoreLocation(StoreLocations storeLocations);
	//Delete
	public void deleteStoreLocation(StoreLocations storeLocations);;
	//Create
	public void createStoreLocation(StoreLocations storeLocations);
}
