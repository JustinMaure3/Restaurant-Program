package tabs;

import java.util.ArrayList;

import PlaceHolder.CrewMember;
import PlaceHolder.FoodDrink;
import PlaceHolder.Manager;
import PlaceHolder.StoreLocations;
import Tables.CrewMemberTable;
import Tables.FoodTable;
import Tables.ManagerTable;
import Tables.StoreLocationsTable;
import javafx.scene.control.Tab;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;



public class MenuTab extends Tab {	

	public static String displayedTable = "food";

	
	private static MenuTab tab;
	
	public static BorderPane pane;
	

	private MenuTab() {
		this.setText("Menu");
		pane = new BorderPane();
	
		//Create the panes necessary for this tab
		
		
		VBox data = new VBox();		
		
		//If statement checking what table is selected
		if(displayedTable == "food") {
		
			//Create an arraylist
			FoodTable menuItems = new FoodTable();
			
			//Populate the arraylist with the database contents
			ArrayList<FoodDrink> foodDrinkItems = menuItems.getAllFoodDrink();			
			
			//Loop to set the contents of the arraylist to their own panes
			int i = 0;
			while(i < foodDrinkItems.size()){
				
				//Create an HBox to hold the information about the current food item
				HBox newItemFood = new HBox();
				
				//Create objects to hold the food's information and then add them to the HBox
				Text name = new Text("  " + foodDrinkItems.get(i).getName() + "  ");
				Text rating = new Text(foodDrinkItems.get(i).getRating() + "  ");
				Text description = new Text(foodDrinkItems.get(i).getDescription() + "  ");
				ImageView picture = new ImageView("Pictures/" + foodDrinkItems.get(i).getPicture());
				picture.setFitHeight(100);
				picture.setFitWidth(100);
				Text price = new Text(foodDrinkItems.get(i).getPrice() + "  ");
				Text amountSold = new Text("  " + foodDrinkItems.get(i).getAmountSold() + "  ");
				
				//Add all of the info into the hbox
				newItemFood.getChildren().addAll(picture, name, rating, description, price, amountSold);
				
				//Add the HBox to the VBox
				data.getChildren().add(newItemFood);
				//Increment i
				i++;
			}
			
		}else if(displayedTable == "employees") {
			//Create an arraylist
			CrewMemberTable employeeList = new CrewMemberTable();
			
			//Populate the arraylist with the database contents
			ArrayList<CrewMember> crewMemberItems = employeeList.getAllCrewMembers();			
			
			//Loop to set the contents of the arraylist to their own panes
			int i = 0;
			while(i < crewMemberItems.size()){
				
				//Create an HBox to hold the information about the current food item
				HBox newItemCrew = new HBox();
				
				//Create objects to hold the food's information and then add them to the HBox
				Text name = new Text("  " + crewMemberItems.get(i).getName() + "  ");
				Text wage = new Text(crewMemberItems.get(i).getWage() + "  ");
				Text uniform = new Text(crewMemberItems.get(i).getUniform() + "  ");
				Text position = new Text(crewMemberItems.get(i).getPosition() + "  ");
				Text crewMemberPunchIn = new Text(crewMemberItems.get(i).getCrewMemberPunchIn() + "  ");
				Text crewMemberGoldStar = new Text("  " + crewMemberItems.get(i).getCrewMemberGoldStar() + "  ");
				
				//Add all of the info into the hbox
				newItemCrew.getChildren().addAll(name, wage, uniform, position, crewMemberPunchIn, crewMemberGoldStar);
				
				//Add the HBox to the VBox
				data.getChildren().add(newItemCrew);
				//Increment i
				i++;
			}
			
			//Create an arraylist
			ManagerTable managerList = new ManagerTable();
			
			//Populate the arraylist with the database contents
			ArrayList<Manager> managerItems = managerList.getAllManagers();			
			
			//Loop to set the contents of the arraylist to their own panes
			int e = 0;
			while(e < managerItems.size()){
				
				//Create an HBox to hold the information about the current food item
				HBox newItemManager = new HBox();
				
				//Create objects to hold the food's information and then add them to the HBox
				Text name = new Text("  " + managerItems.get(e).getName() + "  ");
				Text wage = new Text(managerItems.get(e).getWage() + "  ");
				Text uniform = new Text(managerItems.get(e).getUniform() + "  ");
				Text position = new Text(managerItems.get(e).getPosition() + "  ");
				Text managerID = new Text(managerItems.get(e).getManagerID() + "  ");
				Text managerSafeCode = new Text("  " + managerItems.get(e).getManagerSafeCode() + "  ");
				
				//Add all of the info into the hbox
				newItemManager.getChildren().addAll(name, wage, uniform, position, managerID, managerSafeCode);
				
				//Add the HBox to the VBox
				data.getChildren().add(newItemManager);
				//Increment i
				e++;
			}
			
		}else if(displayedTable == "locations") {
			//Create an arraylist
			StoreLocationsTable menuItems = new StoreLocationsTable();
			
			//Populate the arraylist with the database contents
			ArrayList<StoreLocations> LocationsItems = menuItems.getAllStoreLocations();			
			
			//Loop to set the contents of the arraylist to their own panes
			int i = 0;
			while(i < LocationsItems.size()){
				
				//Create an HBox to hold the information about the current food item
				HBox newItemLocations = new HBox();
				
				//Create objects to hold the food's information and then add them to the HBox
				Text location = new Text("  " + LocationsItems.get(i).getLocation() + "  ");
				Text santScore = new Text(LocationsItems.get(i).getSantScore() + "  ");
				Text regionalMan = new Text(LocationsItems.get(i).getRegionalMan() + "  ");
				Text custReview = new Text(LocationsItems.get(i).getCustReview() + "  ");
				
				//Add all of the info into the hbox
				newItemLocations.getChildren().addAll(location, santScore, regionalMan, custReview);
				
				//Add the HBox to the VBox
				data.getChildren().add(newItemLocations);
				//Increment i
				i++;
			}
		}
		
		
		
		//Add the menu to the main pane
		pane.getChildren().add(data);
		
		//Set the pane to the scene
		this.setContent(pane);
	}
	
	public static MenuTab getInstance() {
		if(tab == null) {
			tab = new MenuTab();
		}
		return tab;
	}
//	public static void refresh() {
//		MenuTab.setContent(pane);
//	}

}




