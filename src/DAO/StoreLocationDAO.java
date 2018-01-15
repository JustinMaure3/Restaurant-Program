package DAO;

import java.util.ArrayList;
import PlaceHolder.StoreLocations;

public interface StoreLocationDAO {
	//Everything we want to do with the table
	/**
	 * This grabs all the StoreLocations items
	 */
	public ArrayList<StoreLocations> getAllStoreLocations();
	/**
	 * This gets one StoreLocations item
	 */
	public StoreLocations getStoreLocation(int itemID);
	/**
	 * This updates StoreLocations item
	 */
	public void updateStoreLocation(StoreLocations storeLocations);
	/**
	 * This deletes StoreLocations item
	 */
	public void deleteStoreLocation(StoreLocations storeLocations);;
	/**
	 * This creates StoreLocations 
	 */
	public void createStoreLocation(StoreLocations storeLocations);
}
