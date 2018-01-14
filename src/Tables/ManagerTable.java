package Tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Database.Const;
import Database.Database;
import PlaceHolder.CrewMember;
import PlaceHolder.Manager;
/**
 * Manager table with all of its methods
 * @author Stefano,Max,Tomas,Justin
 *
 */
public class ManagerTable {
			//Creating an instance of the database
			Database db = Database.getInstance();
			
			//Construct
			public ManagerTable() {
				
			}

			//Creating a method to get all instances of manager class within the table
			public ArrayList<Manager> getAllManagers() {
				String query = "SELECT * FROM " + Const.TABLE_MANAGER;
				ArrayList<Manager> manager = new ArrayList<Manager>();
				try {
					//Use the singleton an grab its connection to create a statement
					Statement getItems = db.getConnection().createStatement();
					ResultSet data = getItems.executeQuery(query);
					//This while loop will run once for each item in the result set
					while(data.next()) {
						//Build each item and add it to the ArrayList
						manager.add(new Manager(data.getInt(Const.MANAGER_COLUMN_ID),
										   data.getString(Const.MANAGER_COLUMN_NAME),
										   data.getDouble(Const.MANAGER_COLUMN_WAGE),
										   data.getString(Const.MANAGER_COLUMN_UNIFORM),
										   data.getString(Const.MANAGER_COLUMN_POSITION),
										   data.getInt(Const.MANAGER_COLUMN_MANAGERID),
										   data.getInt(Const.MANAGER_COLUMN_MANAGERSAFECODE)));
						
						
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}
				return manager;
			}

			//Creating a method to get a single instance of a manager class
			public Manager getManager(int managerID) {
				String query = "SELECT FROM " + Const.TABLE_MANAGER + " WHERE " + 
						   Const.MANAGER_COLUMN_ID + " = " + managerID;
				Manager manager = new Manager();
				try {
					Statement getItem = db.getConnection().createStatement();
					ResultSet data = getItem.executeQuery(query);
					data.next();
					//Build each item and add it to the ArrayList
					manager = new Manager(data.getInt(Const.MANAGER_COLUMN_ID),
							   data.getString(Const.MANAGER_COLUMN_NAME),
							   data.getDouble(Const.MANAGER_COLUMN_WAGE),
							   data.getString(Const.MANAGER_COLUMN_UNIFORM),
							   data.getString(Const.MANAGER_COLUMN_POSITION),
							   data.getInt(Const.MANAGER_COLUMN_MANAGERID),
							   data.getInt(Const.MANAGER_COLUMN_MANAGERSAFECODE));
				}catch(SQLException e) {
					e.printStackTrace();
				}
				return manager;
			}

			//Creating method to update an instance of the Manager class in the database table
			public void updateManager(Manager manager) {
				
				
			}

			//Creating a method to delete an instance of the Manager class from the database table
			public void deleteManager(Manager manager) {
				String query = "DELETE FROM " + Const.TABLE_MANAGER + " WHERE " +
						   Const.MANAGER_COLUMN_ID + " = " + manager.getID();
				try {
					db.getConnection().createStatement().execute(query);
				} catch(SQLException e) {
					e.printStackTrace();
				}
				
			}

			//Creating a method to add an instance of the store locations class to the database table
			public void createManager(Manager manager) {
				String query = "INSERT INTO " + Const.TABLE_MANAGER + 
						   "(" + Const.MANAGER_COLUMN_NAME + "," +
						   Const.MANAGER_COLUMN_POSITION + "," +
						   Const.MANAGER_COLUMN_UNIFORM + "," +
						   Const.MANAGER_COLUMN_WAGE + "," +
						   Const.MANAGER_COLUMN_MANAGERID + "," +
						   Const.MANAGER_COLUMN_MANAGERSAFECODE + ") values ('"+
						   manager.getName() + "','" + manager.getPosition() + "','" +
						   manager.getUniform() + "','" + manager.getWage() + "','" +
						   manager.getManagerID() + "','" + manager.getManagerSafeCode() + "')";
				try {
					db.getConnection().createStatement().execute(query);
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
			}
	}
