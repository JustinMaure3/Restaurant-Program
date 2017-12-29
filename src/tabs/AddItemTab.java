package tabs;

import PlaceHolder.FoodDrink;
import Tables.FoodTable;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
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
		Text descText = new Text("Description:");
		TextField desc = new TextField();
		pane.add(descText, 2, 0);
		pane.add(desc, 2, 1);
		
		//Create insert picture row
		Text picText = new Text("Picture:");
		//Add enums for all pictures to choose from?
		TextField picture = new TextField();
		pane.add(picText, 3, 0);
		pane.add(picture, 3, 1);
		
		//Create insert price row
		Text priceText = new Text("Price:");
		TextField price = new TextField();
		pane.add(priceText, 4, 0);
		pane.add(price, 4, 1);
		
		//Create insert amountSold row
		Text amountSoldText = new Text("Amount Sold:");
		TextField amountSold = new TextField();
		pane.add(amountSoldText, 5, 0);
		pane.add(amountSold, 5, 1);
		
		//Create submit button
		Button submitButton = new Button("Submit");
		submitButton.setOnAction(e->{
			//Create an instance of the food table
			FoodTable fTable = new FoodTable();
			
			FoodDrink food = new FoodDrink(
					name.getText(),
					rating.getSelectionModel().getSelectedItem().ordinal(),
					desc.getText(),
					picture.getText(),
					Integer.parseInt(price.getText()) + 0.0,
					Integer.parseInt(amountSold.getText()) + 0.0
					);
			fTable.createFoodDrink(food);
		});
		pane.add(submitButton, 6, 2);
		
		
		this.setContent(pane);
	}

}
