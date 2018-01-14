package DAO;

import java.util.ArrayList;
import PlaceHolder.Manager;

public interface ManagerDAO {
	//Everything we want to do with the table
	/**
	 * This grabs all the fooDrink items
	 */
			public ArrayList<Manager> getAllManagers();
			/**
			 * This gets one Manager item
			 */
			public Manager getManager(int itemID);
			/**
			 * This updates Manager item
			 */
			public void updateManager(Manager manager);
			/**
			 * This deletes Manager item
			 */
			public void deleteManager(Manager manager);;
			/**
			 * This creates Manager 
			 */
			public void createManager(Manager manager);
}
