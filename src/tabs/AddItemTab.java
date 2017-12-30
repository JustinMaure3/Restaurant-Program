package tabs;

import PlaceHolder.FoodDrink;
import Tables.FoodTable;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class AddItemTab extends Tab{
	
	private static AddItemTab tab;
	
	private AddItemTab() {
		this.setText("Add Item");
		//create the layout view
		GridPane pane = new GridPane();
		
		//Create insert name row
		Text nameText = new Text("Name:");
		TextField name = new TextField();
		pane.add(nameText, 0, 0);
		pane.add(name, 1, 0);
		
		
		//Create insert rating row
		Text ratingText = new Text("Rating:");
		ComboBox<ENUMS.Ratings> rating = new ComboBox<>();
		rating.setItems(FXCollections.observableArrayList(ENUMS.Ratings.values()));
		pane.add(ratingText, 0, 1);
		pane.add(rating, 1, 1);
		
		//Create insert description row
		Text descText = new Text("Description:");
		TextField desc = new TextField();
		pane.add(descText, 0, 2);
		pane.add(desc, 1, 2);
		
		//Create insert picture row
		Text picText = new Text("Picture:");
		//Add enums for all pictures to choose from?
		TextField picture = new TextField();
		pane.add(picText, 0, 3);
		pane.add(picture, 1, 3);
		
		//Create insert price row
		Text priceText = new Text("Price:");
		TextField price = new TextField();
		pane.add(priceText, 0, 4);
		pane.add(price, 1, 4);
		
		//Create insert amountSold row
		Text amountSoldText = new Text("Amount Sold:");
		TextField amountSold = new TextField();
		pane.add(amountSoldText, 0, 5);
		pane.add(amountSold, 1, 5);
		
		//Create submit button
		Button submitButton = new Button("Add Food/Drink");
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
		pane.add(submitButton, 1, 6);
		
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.setVgap(10);
		pane.setHgap(10);
		this.setContent(pane);
	}
	
	public static AddItemTab getInstance() {
		if(tab == null) {
			tab = new AddItemTab();
		}
		return tab;
	}

}
