package Database;
/**
 * This is used to create constants for every table
 * @author Stefano,Max,Tomas,Justin
 *
 */
public class Const {
	//My name user and password for the server
	public static final String DB_NAME = "school";
	//public static final String DB_USER = "siaconetti968";
	public static final String DB_USER = "root";
	public static final String DB_PASS = "turtledove";
	//public static final String DB_PASS = "q8hccq8hcc6pv7d6pv7d";
	
	//Creating constants for our Food Drink Table
	public static final String TABLE_FOOD_DRINK = "foodDrink";
	public static final String FOOD_DRINK_COLUMN_ID = "id";
	public static final String FOOD_DRINK_COLUMN_NAME = "name";
	public static final String FOOD_DRINK_COLUMN_DESCRIPTION = "description";
	public static final String FOOD_DRINK_COLUMN_PICTURE = "picture";
	public static final String FOOD_DRINK_COLUMN_RATING = "rating";
	public static final String FOOD_DRINK_COLUMN_PRICE = "price";
	public static final String FOOD_DRINK_COLUMN_AMOUNT_SOLD = "amountSold";
	public static final String FOOD_DRINK_COLUMN_MONTH = "month";
	
	//Creating constants for the crew member table
		public static final String TABLE_CREWMEMBER = "employees";
		public static final String CREWMEMBER_COLUMN_ID = "id";
		public static final String CREWMEMBER_COLUMN_NAME = "name";
		public static final String CREWMEMBER_COLUMN_WAGE = "wage";
		public static final String CREWMEMBER_COLUMN_UNIFORM = "uniform";
		public static final String CREWMEMBER_COLUMN_POSITION = "position";
		public static final String CREWMEMBER_COLUMN_CREWMEMBERPUNCHIN = "crewmemberpunchin";
		public static final String CREWMEMBER_COLUMN_CREWMEMBERGOLDSTAR = "crewmembergoldstar";
		
		//Creating constants for the manager table
		public static final String TABLE_MANAGER = "managers";
		public static final String MANAGER_COLUMN_ID = "id";
		public static final String MANAGER_COLUMN_NAME = "name";
		public static final String MANAGER_COLUMN_WAGE = "wage";
		public static final String MANAGER_COLUMN_UNIFORM = "uniform";
		public static final String MANAGER_COLUMN_POSITION = "position";
		public static final String MANAGER_COLUMN_MANAGERID= "managerID";
		public static final String MANAGER_COLUMN_MANAGERSAFECODE = "managersafecode";
		
		//Creating constants for the store locations table
		public static final String TABLE_STORELOCATIONS = "storelocations";
		public static final String STORELOCATIONS_COLUMN_ID = "id";
		public static final String STORELOCATIONS_COLUMN_LOCATION = "location";
		public static final String STORELOCATIONS_COLUMN_REGIONALMAN = "regionalman";
		public static final String STORELOCATIONS_COLUMN_CUSTREVIEW = "custreview";
		public static final String STORELOCATIONS_COLUMN_SANTSCORE = "santscore";
}
