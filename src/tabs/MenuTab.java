package tabs;

import java.util.ArrayList;

import PlaceHolder.FoodDrink;
import javafx.scene.control.Tab;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MenuTab extends Tab {

	public MenuTab() {
		this.setText("Menu");
		
		//Create the panes necessary for this tab
		
		BorderPane pane = new BorderPane();
		VBox menu = new VBox();
				
		
		//Get an arraylist of all the database contents.
		
		ArrayList<FoodDrink> menuItems = new ArrayList<FoodDrink>(FoodDrink.getAllFoodDrink());			
		
		//Loop to set the contents of the arraylist to their own panes
		int i = 0;
		while(i < menuItems.length()){
			
			//Create an HBox to hold the information about the current food item
			HBox newItem = new HBox();
			
			//Create objects to hold the food's information and then add them to the HBox
			Text name = new Text(menuItems(i).getName());
			Text rating = new Text(menuItems(i).getRating());
			Text description = new Text(menuItems(i).getDescription());
			ImageView picture = new ImageView(menuItems(i).getPicture());
			Text price = new Text(menuItems(i).getPrice());
			Text amountSold = new Text(menuItems(i).getAmountSold());
			
			//Add all of the info into the hbox
			newItem.addAll(name, rating, description, picture, price, amountSold);
			
			//Add the HBox to the VBox
			menu.add(newItem);
			//Increment i
			i++;
		}
		
		//set the panes to the scene
		this.setContent(pane);
		
	}
}
