package tabs;

import Tables.FoodTable;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class AddItemTab extends Tab{
	public AddItemTab() {
		this.setText("Add Item");
		//create the layout view
		GridPane pane = new GridPane();
		//Create an instance of the food table
		FoodTable fTable = new FoodTable();
		
		//Create insert name row
		Text nameText = new Text("Name:");
		TextField name = new TextField();
		pane.add(nameText, 0, 0);
		pane.add(name, 0, 1);
		
		
		//Create insert rating row
		Text ratingText = new Text("Rating:");
		ComboBox<ENUMS.Ratings> rating = new ComboBox<>();
		rating.setItems(FXCollections.observableArrayList(ENUMS.Ratings.values()));
		pane.add(ratingText, 1, 0);
		pane.add(rating, 1, 1);
		
		//Create insert description row
		
		//Create insert picture row
		
		//Create insert price row
		
		//Create insert amountSold row
		
		//Create submit button
		
		
		
		
		this.setContent(pane);
	}

}
