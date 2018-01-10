package tabs;

import java.util.ArrayList;

import PlaceHolder.CrewMember;
import PlaceHolder.FoodDrink;
import Tables.CrewMemberTable;
import Tables.FoodTable;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class RemoveItemTab extends Tab {
	
	private static RemoveItemTab tab;

	private RemoveItemTab() {
		this.setText("Remove");
		
		GridPane gpane = new GridPane();
		
		//Create a button to launch to remove food/Drink form
		Button removeF = new Button("Remove Food/Drink");
		removeF.setOnAction(e->{
			//Create the layout
			BorderPane pane = new BorderPane();
			//Create a listVuew thatll hold a bunch of instances of food and drink
			ListView<FoodDrink> list = new ListView();
			//Create a food table
			FoodTable fTable = new FoodTable();
			//Create the array that'll give us all foodDrink in our database
//			ArrayList<FoodDrink> foodDrinkItems = fTable.getAllFoodDrink();
			
			//set the list with all the items in the arraylist
//			
//			//set the list with all the items in the arraylist
//			list.setItems(FXCollections.observableArrayList(foodDrinkItems));
			pane.setCenter(list);
			
			
			//Create the remove button
			Button remove = new Button("Remove");
			remove.setOnAction(e1->{
				FoodDrink foodItem = list.getSelectionModel().getSelectedItem();
				fTable.deleteFoodDrink(foodItem);
				list.setItems(FXCollections.observableArrayList(fTable.getAllFoodDrink()));
			});
			pane.setBottom(remove);
			
			//Create Back button
			Button back = new Button("Back");
			back.setOnAction(e1->{
				this.setContent(gpane);
			});
			pane.setTop(back);
			
			
			this.setContent(pane);
		});
		
		//Create button for the remove employee form
		Button removeE = new Button("Remove Employee");
		removeE.setOnAction(e->{
			//Create the layout
			BorderPane pane = new BorderPane();
			//Create a listView that'll hold a bunch of instances of food and drink
			ListView<CrewMember> list = new ListView<CrewMember>();
			//Create a food table
			CrewMemberTable cmTable = new CrewMemberTable();
			//Create the array that'll give us all foodDrink in our database
//			ArrayList<CrewMember> cmItems = cmTable.getAllCrewMembers();
			
			//set the list with all the items in the arraylist
//			
//			//set the list with all the items in the arraylist
//			list.setItems(FXCollections.observableArrayList(cmItems));
			pane.setCenter(list);
			
			
			//Create the remove button
			Button remove = new Button("Remove");
			remove.setOnAction(e1->{
				CrewMember crewMember = list.getSelectionModel().getSelectedItem();
				cmTable.deleteCrewMember(crewMember);
				list.setItems(FXCollections.observableArrayList(cmTable.getAllCrewMembers()));
			});
			pane.setBottom(remove);
			
			//Create Back button
			Button back = new Button("Back");
			back.setOnAction(e1->{
				this.setContent(gpane);
			});
			pane.setTop(back);
			
			this.setContent(pane);
		});
		//set the two buttons on a grid pane
		gpane.add(removeF, 0, 0);
		gpane.add(removeE, 1, 0);
		
		
		gpane.setPadding(new Insets(10, 10, 10, 10));
		gpane.setVgap(10);
		gpane.setHgap(10);
		this.setContent(gpane);
	}
	public static RemoveItemTab getInstance() {
		if(tab == null) {
			tab = new RemoveItemTab();
		}
		return tab;
	}
}
