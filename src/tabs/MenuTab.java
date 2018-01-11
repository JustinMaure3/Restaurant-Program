package tabs;

import java.util.ArrayList;

import PlaceHolder.FoodDrink;
import Tables.FoodTable;
import javafx.scene.control.Tab;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;



public class MenuTab extends Tab {

	//public String changeTable(String table) {
		//if(table ==)
	//	return table;
	//}
	
	private static MenuTab tab;

	private MenuTab() {
		this.setText("Menu");
		
		//Create the panes necessary for this tab
		
		BorderPane pane = new BorderPane();
		VBox menu = new VBox();		
		
		//Create an arraylist
		FoodTable menuItems = new FoodTable();
		
		//Populate the arraylist with the database contents
		ArrayList<FoodDrink> foodDrinkItems = menuItems.getAllFoodDrink();			
		
		//Loop to set the contents of the arraylist to their own panes
		int i = 0;
		while(i < foodDrinkItems.size()){
			
			//Create an HBox to hold the information about the current food item
			HBox newItem = new HBox();
			
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
			newItem.getChildren().addAll(picture, name, rating, description, price, amountSold);
			
			//Add the HBox to the VBox
			menu.getChildren().add(newItem);
			//Increment i
			i++;
		}
		
		
		
		//Add the menu to the main pane
		pane.getChildren().add(menu);
		
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