package tabs;

import javafx.scene.control.Tab;

public class MenuTab extends Tab {
	
	private static MenuTab tab;

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
