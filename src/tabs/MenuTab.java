package tabs;
/**
 * Displays the database table depending on what table they wanted to see
 * @author Stefano,Max,Tomas,Justin
 *
 */
import java.util.ArrayList;
import PlaceHolder.CrewMember;
import PlaceHolder.FoodDrink;
import PlaceHolder.Manager;
import PlaceHolder.StoreLocations;
import Tables.CrewMemberTable;
import Tables.FoodTable;
import Tables.ManagerTable;
import Tables.StoreLocationsTable;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;



public class MenuTab extends Tab {	

	public static String displayedTable = "food";

	
	public static MenuTab tab;	

	private MenuTab() {
		this.setText("Menu");
		ScrollPane pane = new ScrollPane();
	
		//Create the panes necessary for this tab
		
		
		VBox data = new VBox();		
		
		//If statement checking what table is selected
		if(displayedTable == "food") {	

			//Create an arraylist
			FoodTable menuItems = new FoodTable();
			
			//Populate the arraylist with the database contents
			ArrayList<FoodDrink> foodDrinkItems = menuItems.getAllFoodDrink();
			
			//Create an HBox to hold the information about the current food item
			HBox newItemFood = new HBox();
			
			//Create a VBoxes that will act as the columns of the table
			VBox foodNameColumn = new VBox();
			foodNameColumn.setSpacing(10.0);
			VBox ratingColumn = new VBox();
			ratingColumn.setSpacing(10.0);
			VBox descriptionColumn = new VBox();
			descriptionColumn.setSpacing(10.0);
			VBox pictureColumn = new VBox();
			pictureColumn.setPadding(new Insets(5, 5, 5, 5));
			VBox priceColumn = new VBox();
			priceColumn.setSpacing(10.0);
			VBox amountSoldColumn = new VBox();
			amountSoldColumn.setSpacing(10.0);
			
			//Create titles for each column
			Text foodNameTitle = new Text("Name");
			foodNameColumn.getChildren().addAll(foodNameTitle);
			
			Text ratingTitle = new Text("Rating");
			ratingColumn.getChildren().addAll(ratingTitle);
			
			Text descriptionTitle = new Text("Description");
			descriptionColumn.getChildren().addAll(descriptionTitle);
			
			Text pictureTitle = new Text("Picture");
			pictureColumn.getChildren().addAll(pictureTitle);
			
			Text priceTitle = new Text("Price");
			priceColumn.getChildren().addAll(priceTitle);
			
			Text amountSoldTitle = new Text("Amount Sold");
			amountSoldColumn.getChildren().addAll(amountSoldTitle);
			
			//Loop to set the contents of the arraylist to their own panes
			int i = 0;
			while(i < foodDrinkItems.size()){
				
				//Create objects to hold the food's information and then add them to the HBox
				Text foodName = new Text("  " + foodDrinkItems.get(i).getName() + "  ");
				foodNameColumn.getChildren().addAll(foodName);
				
				Text foodRating = new Text(foodDrinkItems.get(i).getRating() + "  ");
				ratingColumn.getChildren().addAll(foodRating);
				
				Text foodDescription = new Text(foodDrinkItems.get(i).getDescription() + "  ");
				descriptionColumn.getChildren().addAll(foodDescription);
				
				ImageView foodPicture = new ImageView("Pictures/" + foodDrinkItems.get(i).getPicture());
				pictureColumn.getChildren().addAll(foodPicture);
				foodPicture.setFitHeight(25);
				foodPicture.setFitWidth(25);
				
				Text foodPrice = new Text(foodDrinkItems.get(i).getPrice() + "  ");
				priceColumn.getChildren().addAll(foodPrice);
				
				Text foodAmountSold = new Text("  " + foodDrinkItems.get(i).getAmountSold() + "  ");
				amountSoldColumn.getChildren().addAll(foodAmountSold);
				
				//Increment i
				i++;
			}
			
			//Add all of the info into the hbox
			newItemFood.getChildren().addAll(pictureColumn, foodNameColumn, ratingColumn, descriptionColumn, priceColumn, amountSoldColumn);
			
			//Add the HBox to the VBox
			data.getChildren().add(newItemFood);
		
		//Set the pane to the scene
		this.setContent(pane);
		}
	}
	
	public static MenuTab getInstance() {
		if(tab == null) {
			tab = new MenuTab();
		}
		return tab;
	}

}




