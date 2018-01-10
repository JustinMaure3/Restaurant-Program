package Tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Database.Const;
import Database.Database;
import PlaceHolder.CrewMember;
import PlaceHolder.Employee;
import PlaceHolder.FoodDrink;

public class CrewMemberTable {
	//Creating an instance of the database
		Database db = Database.getInstance();
		
		//Construct
		public CrewMemberTable() {
			
		}

		//Creating a method to get all instances of crewMember class within the table
		public ArrayList<CrewMember> getAllCrewMembers() {
			String query = "SELECT * FROM " + Const.TABLE_CREWMEMBER;
			ArrayList<CrewMember> crewMember = new ArrayList<CrewMember>();
			try {
				//Use the singleton an grab its connection to create a statement
				Statement getItems = db.getConnection().createStatement();
				ResultSet data = getItems.executeQuery(query);
				//This while loop will run once for each item in the result set
				while(data.next()) {
					//Build each item and add it to the ArrayList
					crewMember.add(new CrewMember(data.getInt(Const.CREWMEMBER_COLUMN_ID),
									   data.getString(Const.CREWMEMBER_COLUMN_NAME),
									   data.getDouble(Const.CREWMEMBER_COLUMN_WAGE),
									   data.getString(Const.CREWMEMBER_COLUMN_UNIFORM),
									   data.getString(Const.CREWMEMBER_COLUMN_POSITION),
									   data.getInt(Const.CREWMEMBER_COLUMN_CREWMEMBERGOLDSTAR),
									   data.getInt(Const.CREWMEMBER_COLUMN_CREWMEMBERPUNCHIN)));
					
					
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return crewMember;
		}

		//Creating a method to get a single instance of a crewMember class
		public CrewMember getCrewMember(int crewMemberID) {
			String query = "SELECT FROM " + Const.TABLE_CREWMEMBER + " WHERE " + 
					   Const.CREWMEMBER_COLUMN_ID + " = " + crewMemberID;
			CrewMember crewMember = new CrewMember();
			try {
				Statement getItem = db.getConnection().createStatement();
				ResultSet data = getItem.executeQuery(query);
				data.next();
				//Build each item and add it to the ArrayList
				crewMember = new CrewMember(data.getInt(Const.CREWMEMBER_COLUMN_ID),
								   data.getString(Const.CREWMEMBER_COLUMN_NAME),
								   data.getDouble(Const.CREWMEMBER_COLUMN_WAGE),
								   data.getString(Const.CREWMEMBER_COLUMN_UNIFORM),
								   data.getString(Const.CREWMEMBER_COLUMN_POSITION),
								   data.getInt(Const.CREWMEMBER_COLUMN_CREWMEMBERGOLDSTAR),
								   data.getInt(Const.CREWMEMBER_COLUMN_CREWMEMBERPUNCHIN));
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return crewMember;
		}
		
		
		//Creating a method to grab the employee of the month
			public CrewMember getCrewMemberOfMonthk(int crewMemberGoldStar) {
				String query = "SELECT * FROM " + Const.TABLE_CREWMEMBER  + " ORDER BY " + Const.CREWMEMBER_COLUMN_CREWMEMBERGOLDSTAR + " DESC ";
				CrewMember crewMember = new CrewMember();
				try {
					Statement getItem = db.getConnection().createStatement();
					ResultSet data = getItem.executeQuery(query);
					data.next();
					crewMember = new CrewMember(data.getString(Const.CREWMEMBER_COLUMN_NAME),
							data.getInt(Const.CREWMEMBER_COLUMN_CREWMEMBERGOLDSTAR));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return crewMember;
	}
		//Creating method to update an instance of the crewMember class in the database table
		public void updateCrewMember(CrewMember crewMember) {
			
			
		}

		//Creating a method to delete an instance of the crewMember class from the database table
		public void deleteCrewMember(CrewMember crewMember) {
			String query = "DELETE FROM " + Const.TABLE_CREWMEMBER + " WHERE " +
					   Const.CREWMEMBER_COLUMN_ID + " = " + crewMember.getID();
			try {
				db.getConnection().createStatement().execute(query);
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
		}

		//Creating a method to add an instance of the crewMember class to the database table
		public void createCrewMember(CrewMember crewMember) {
			String query = "INSERT INTO " + Const.TABLE_CREWMEMBER + 
					   "(" + Const.CREWMEMBER_COLUMN_NAME + "," +
					   Const.CREWMEMBER_COLUMN_POSITION + "," +
					   Const.CREWMEMBER_COLUMN_UNIFORM + "," +
					   Const.CREWMEMBER_COLUMN_WAGE + "," +
					   Const.CREWMEMBER_COLUMN_CREWMEMBERPUNCHIN + "," +
					   Const.CREWMEMBER_COLUMN_CREWMEMBERGOLDSTAR + ") values ('"+
					   crewMember.getName() + "','" + crewMember.getPosition() + "','" +
					   crewMember.getUniform() + "','" + crewMember.getWage() + "','" +
					   crewMember.getCrewMemberPunchIn() + "','" + crewMember.getCrewMemberGoldStar() + "')";
			try {
				db.getConnection().createStatement().execute(query);
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
}
