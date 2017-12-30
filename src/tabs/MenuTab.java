package tabs;

import javafx.scene.control.Tab;

public class MenuTab extends Tab {
	
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
			Text name = new Text(foodDrinkItems.get(i).getName());
			Text rating = new Text(foodDrinkItems.get(i).getRating() + "");
			Text description = new Text(foodDrinkItems.get(i).getDescription());
			ImageView picture = new ImageView(foodDrinkItems.get(i).getPicture());
			Text price = new Text(foodDrinkItems.get(i).getPrice() + "");
			Text amountSold = new Text(foodDrinkItems.get(i).getAmountSold() + "");
			
			//Add all of the info into the hbox
			newItem.getChildren().addAll(name, rating, description, picture, price, amountSold);
			
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
	
	private MenuTab() { 

 		this.setText("Menu"); 

	//Create the pane used in this tab 

		//GridPane pane = new GridPane(); 

		//Using Justin's method, get an arraylist of all the database contents. 

		//menuItems = ArrayList<FoodDrink> getAllFoodDrink(); 

			//^ **NEED TO FIX** 

		//for loop to set the contents of the arraylist to their own panes 

		//while i < menuItems.length(){ 

			//would all the items in position 0 be the name of the food, it's picture, it's description, and it's price? 

			//if so, i can just set menuItems i to gridpane i that way, at the first place in the gridpane, it would 

			//display all of the items for the first food item. 
 
			//for the mvp, the only way to refresh the menu would be to close and re-open the app after changing the database 

			//If there's time afterwards, maybe think of making a refresh button. 

			//if not, then one solution could be to hard code the entire database into the menu tab which wouldn't be 

 
			//ideal since it'd be much more work and if we were to change something in the database, the menu tab wouldn't 

			//automatically update. 

		//} 

	//set the panes to the scene 


 
		//this.setContent(pane);  


 
 } 
	public static MenuTab getInstance() {
		if(tab == null) {
			tab = new MenuTab();
		}
		return tab;
	}
}
