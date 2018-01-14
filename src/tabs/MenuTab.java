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

	
	public static MenuTab tab;
	
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

}




