package tabs;

import java.util.ArrayList;

import PlaceHolder.FoodDrink;
import Tables.FoodTable;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;

public class RemoveItemTab extends Tab {
	
	private static RemoveItemTab tab;

	private RemoveItemTab() {
		this.setText("Remove Item");
		
		//Create the layout
		BorderPane pane = new BorderPane();
		//Create a listVuew thatll hold a bunch of instances of food and drink
		ListView<FoodDrink> list = new ListView();
		//Create a food table
		FoodTable fTable = new FoodTable();
		//Create the array that'll give us all foodDrink in our database
//		ArrayList<FoodDrink> foodDrinkItems = fTable.getAllFoodDrink();
		
		//set the list with all the items in the arraylist
//		list.setItems(FXCollections.observableArrayList(foodDrinkItems));
		pane.setCenter(list);
		
		
		//Create the remove button
		Button remove = new Button("Remove");
		remove.setOnAction(e->{
			FoodDrink foodItem = list.getSelectionModel().getSelectedItem();
			fTable.deleteFoodDrink(foodItem);
			list.setItems(FXCollections.observableArrayList(fTable.getAllFoodDrink()));
		});
		pane.setBottom(remove);
		
		
		this.setContent(pane);
	}
	public static RemoveItemTab getInstance() {
		if(tab == null) {
			tab = new RemoveItemTab();
		}
		return tab;
	}
}
