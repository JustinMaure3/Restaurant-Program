import java.util.ArrayList;

import Database.Database;
import PlaceHolder.CrewMember;
import PlaceHolder.FoodDrink;
import PlaceHolder.Manager;
import PlaceHolder.StoreLocations;
import Tables.CrewMemberTable;
import Tables.FoodTable;
import Tables.ManagerTable;
import Tables.StoreLocationsTable;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tabs.AddItemTab;
import tabs.HomeTab;
import tabs.MenuTab;
import tabs.RemoveItemTab;
import tabs.StatisticsTab;
import tabs.UpdateItemTab;

public class Main extends Application {

	public static Stage mainStage;
	public static void main(String[] args) {
		Application.launch(args);
	
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		//Setting up a Menu bar
		MenuBar menu = new MenuBar();
		Menu fileMenu = new Menu("File");

		//Adding menu items to the Display menu
		MenuItem food = new MenuItem("Food");
		food.setOnAction(e->{
			MenuTab.displayedTable = "food";
			VBox data = new VBox();	

			//Create an arraylist
			FoodTable menuItems = new FoodTable();
			
			//Populate the arraylist with the database contents
			ArrayList<FoodDrink> foodDrinkItems = menuItems.getAllFoodDrink();			
			
			//Loop to set the contents of the arraylist to their own panes
			int i = 0;
			while(i < foodDrinkItems.size()){
				
				//Create an HBox to hold the information about the current food item
				HBox newItemFood = new HBox();
				
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
				newItemFood.getChildren().addAll(picture, name, rating, description, price, amountSold);
				
				//Add the HBox to the VBox
				data.getChildren().add(newItemFood);
				//Increment i
				i++;
			}
			MenuTab.tab.setContent(data);
		});
		MenuItem employees = new MenuItem("Employees");
		employees.setOnAction(e->{
			VBox data = new VBox();	
			MenuTab.displayedTable = "employees";
			//Create an arraylist
			CrewMemberTable employeeList = new CrewMemberTable();
			
			//Populate the arraylist with the database contents
			ArrayList<CrewMember> crewMemberItems = employeeList.getAllCrewMembers();			
			
			//Loop to set the contents of the arraylist to their own panes
			int i = 0;
			while(i < crewMemberItems.size()){
				
				//Create an HBox to hold the information about the current food item
				HBox newItemCrew = new HBox();
				
				//Create objects to hold the food's information and then add them to the HBox
				Text name = new Text("  " + crewMemberItems.get(i).getName() + "  ");
				Text wage = new Text(crewMemberItems.get(i).getWage() + "  ");
				Text uniform = new Text(crewMemberItems.get(i).getUniform() + "  ");
				Text position = new Text(crewMemberItems.get(i).getPosition() + "  ");
				Text crewMemberPunchIn = new Text(crewMemberItems.get(i).getCrewMemberPunchIn() + "  ");
				Text crewMemberGoldStar = new Text("  " + crewMemberItems.get(i).getCrewMemberGoldStar() + "  ");
				
				//Add all of the info into the hbox
				newItemCrew.getChildren().addAll(name, wage, uniform, position, crewMemberPunchIn, crewMemberGoldStar);
				
				//Add the HBox to the VBox
				data.getChildren().add(newItemCrew);
				//Increment i
				i++;
			}
			
			VBox dataTwo = new VBox();
			//Create an arraylist
			ManagerTable managerList = new ManagerTable();
			
			//Populate the arraylist with the database contents
			ArrayList<Manager> managerItems = managerList.getAllManagers();			
			
			//Loop to set the contents of the arraylist to their own panes
			int e1 = 0;
			while(e1 < managerItems.size()){
				
				//Create an HBox to hold the information about the current food item
				HBox newItemManager = new HBox();
				
				//Create objects to hold the food's information and then add them to the HBox
				Text name = new Text("  " + managerItems.get(e1).getName() + "  ");
				Text wage = new Text(managerItems.get(e1).getWage() + "  ");
				Text uniform = new Text(managerItems.get(e1).getUniform() + "  ");
				Text position = new Text(managerItems.get(e1).getPosition() + "  ");
				Text managerID = new Text(managerItems.get(e1).getManagerID() + "  ");
				Text managerSafeCode = new Text("  " + managerItems.get(e1).getManagerSafeCode() + "  ");
				
				//Add all of the info into the hbox
				newItemManager.getChildren().addAll(name, wage, uniform, position, managerID, managerSafeCode);
				
				//Add the HBox to the VBox
				dataTwo.getChildren().add(newItemManager);
				//Increment i
				e1++;
			}
				VBox all = new VBox();
				all.getChildren().addAll(data,dataTwo);
			MenuTab.tab.setContent(all);
		});
		MenuItem locations = new MenuItem("Locations");
		locations.setOnAction(e->{
			MenuTab.displayedTable = "locations";
			VBox data = new VBox();	
			//Create an arraylist
			StoreLocationsTable menuItems = new StoreLocationsTable();
			
			//Populate the arraylist with the database contents
			ArrayList<StoreLocations> LocationsItems = menuItems.getAllStoreLocations();			
			
			//Loop to set the contents of the arraylist to their own panes
			int i = 0;
			while(i < LocationsItems.size()){
				
				//Create an HBox to hold the information about the current food item
				HBox newItemLocations = new HBox();
				
				//Create objects to hold the food's information and then add them to the HBox
				Text location = new Text("  " + LocationsItems.get(i).getLocation() + "  ");
				Text santScore = new Text(LocationsItems.get(i).getSantScore() + "  ");
				Text regionalMan = new Text(LocationsItems.get(i).getRegionalMan() + "  ");
				Text custReview = new Text(LocationsItems.get(i).getCustReview() + "  ");
				
				//Add all of the info into the hbox
				newItemLocations.getChildren().addAll(location, santScore, regionalMan, custReview);
				
				//Add the HBox to the VBox
				data.getChildren().add(newItemLocations);
				//Increment i
				i++;
			}
			MenuTab.tab.setContent(data);
			
		});

		Menu display = new Menu("Display");
		
		display.getItems().addAll(food,employees, locations);
														
		//Adding menu items to file menu
		MenuItem exit = new MenuItem("Exit");
		exit.setOnAction(e->{
			Database db = Database.getInstance();
			db.close();
			System.exit(0);
		});
		
		
		//Adding menu items to themes menu
		

		MenuItem creditsMenu = new MenuItem("Credits");
		Menu themes = new Menu("Themes");

		MenuItem modern = new MenuItem("Modern");
		MenuItem seventies = new MenuItem("70's");
		MenuItem nineties = new MenuItem("90's");
		MenuItem defaultTheme = new MenuItem("Default");
		themes.getItems().addAll(defaultTheme, seventies, nineties, modern);
										
	
		//Adding menus into the menuBar
		fileMenu.getItems().addAll(themes,display,creditsMenu,exit);
		menu.getMenus().addAll(fileMenu);
							
		
		//Create Tab Pane
		TabPane tpane = new TabPane();
		tpane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		HomeTab htab = HomeTab.getInstance();
		
		
		//Adding values into locations
		//StoreLocationsTable storelocationstable = new StoreLocationsTable();
		
		//StoreLocations storeLocations = new StoreLocations("330 GoodBoy Ave", "Jacob Makich", 32, 86);
		
		//storelocationstable.createStoreLocations(storeLocations);
		

		//MenuTab mtab = MenuTab.getInstance();

		MenuTab mtab = MenuTab.getInstance();
		AddItemTab addTab = AddItemTab.getInstance();
		RemoveItemTab removeTab = RemoveItemTab.getInstance();
		UpdateItemTab updateTab = UpdateItemTab.getInstance();
		StatisticsTab stab = StatisticsTab.getInstance();

		
		tpane.getTabs().addAll(htab, mtab, addTab, removeTab, updateTab, stab);



		
		//Setting up the main page
		BorderPane bpane = new BorderPane();
		bpane.setTop(menu);
		bpane.setCenter(tpane);
		Scene scene = new Scene(bpane, 1024, 768);
		
		//Set theme when clicked on in the theme menu
		seventies.setOnAction(e->{
			//Allow the user to switch between themes
			if(scene.getStylesheets().contains("Themes/defaultTheme.css") || 
					scene.getStylesheets().contains("Themes/ninetiesTheme.css") ||
					scene.getStylesheets().contains("Themes/modernStyleSheet.css") ) {
				
				scene.getStylesheets().remove("Themes/defaultTheme.css");
				scene.getStylesheets().remove("Themes/ninetiesTheme.css");
				scene.getStylesheets().remove("Themes/modernStyleSheet.css");
				scene.getStylesheets().add("Themes/seventiesTheme.css");	
			}
		});

		modern.setOnAction(e->{
			//Allow the user to switch between themes
			if(scene.getStylesheets().contains("Themes/defaultTheme.css") || 
					scene.getStylesheets().contains("Themes/ninetiesTheme.css") ||
					scene.getStylesheets().contains("Themes/seventiesTheme.css") ) {
				
				scene.getStylesheets().remove("Themes/defaultTheme.css");
				scene.getStylesheets().remove("Themes/ninetiesTheme.css");
				scene.getStylesheets().remove("Themes/seventiesTheme.css");
				scene.getStylesheets().add("Themes/modernStyleSheet.css");	
			}
		});

		//Set the 90's theme when clicked on in the menu menu
		nineties.setOnAction(e->{
			//Allow the user to switch between themes
			if(scene.getStylesheets().contains("Themes/defaultTheme.css") || 
					scene.getStylesheets().contains("Themes/modernStyleSheet.css") ||
					scene.getStylesheets().contains("Themes/seventiesTheme.css") ) {
				
				scene.getStylesheets().remove("Themes/defaultTheme.css");
				scene.getStylesheets().remove("Themes/defaultStyleSheet.css");
				scene.getStylesheets().remove("Themes/seventiesTheme.css");
				scene.getStylesheets().add("Themes/ninetiesTheme.css");	
			}
		});

		//Default theme for the application
		defaultTheme.setOnAction(e->{
			//Allow the user to switch between themes
			if(scene.getStylesheets().contains("Themes/ninetiesTheme.css") || 
					scene.getStylesheets().contains("Themes/modernStyleSheet.css") ||
					scene.getStylesheets().contains("Themes/seventiesTheme.css") ) {
				
				scene.getStylesheets().remove("Themes/ninetiesTheme.css");
				scene.getStylesheets().remove("Themes/defaultStyleSheet.css");
				scene.getStylesheets().remove("Themes/seventiesTheme.css");
				scene.getStylesheets().add("Themes/defaultTheme.css");	
			}
		});
		scene.getStylesheets().add("Themes/defaultTheme.css");
		
		//Mainstage is set up
		mainStage = primaryStage;
		mainStage.setResizable(false);
		mainStage.setScene(scene);
		mainStage.show();	
		
	}
	
	

}

