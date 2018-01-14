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
				
				//Create a VBoxes that will act as the columns of the table
				VBox nameColumn = new VBox();
				VBox ratingColumn = new VBox();
				VBox descriptionColumn = new VBox();
				VBox pictureColumn = new VBox();
				VBox priceColumn = new VBox();
				VBox amountSoldColumn = new VBox();
				
				//Create titles for each column
				Text nameTitle = new Text("Name");
				nameColumn.getChildren().addAll(nameTitle);
				
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
				
				//Create objects to hold the food's information and then add them to the HBox
				Text name = new Text("  " + foodDrinkItems.get(i).getName() + "  ");
				nameColumn.getChildren().addAll(name);
				
				Text rating = new Text(foodDrinkItems.get(i).getRating() + "  ");
				ratingColumn.getChildren().addAll(rating);
				
				Text description = new Text(foodDrinkItems.get(i).getDescription() + "  ");
				descriptionColumn.getChildren().addAll(description);
				
				ImageView picture = new ImageView("Pictures/" + foodDrinkItems.get(i).getPicture());
				pictureColumn.getChildren().addAll(picture);
				picture.setFitHeight(100);
				picture.setFitWidth(100);
				
				Text price = new Text(foodDrinkItems.get(i).getPrice() + "  ");
				priceColumn.getChildren().addAll(price);
				
				Text amountSold = new Text("  " + foodDrinkItems.get(i).getAmountSold() + "  ");
				amountSoldColumn.getChildren().addAll(amountSold);
				
				//Add all of the info into the hbox
				
				newItemFood.getChildren().addAll(pictureColumn, nameColumn, ratingColumn, descriptionColumn, priceColumn, amountSoldColumn);
				
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
				
				//Create a VBoxes that will act as the columns of the table
				VBox nameColumn = new VBox();
				VBox wageColumn = new VBox();
				VBox uniformColumn = new VBox();
				VBox positionColumn = new VBox();
				VBox crewMemberPunchInColumn = new VBox();
				VBox crewMemberGoldStarColumn = new VBox();
				
				//Create titles for each column
				Text nameTitle = new Text("Name");
				nameColumn.getChildren().addAll(nameTitle);
				
				Text wageTitle = new Text("Wage");
				wageColumn.getChildren().addAll(wageTitle);
				
				Text uniformTitle = new Text("Uniform");
				uniformColumn.getChildren().addAll(uniformTitle);
				
				Text positionTitle = new Text("Position");
				positionColumn.getChildren().addAll(positionTitle);
				
				Text crewMemberPunchInTitle = new Text("Punch In Number");
				crewMemberPunchInColumn.getChildren().addAll(crewMemberPunchInTitle);
				
				Text crewMemberGoldStarTitle = new Text("Gold Stars");
				crewMemberGoldStarColumn.getChildren().addAll(crewMemberGoldStarTitle);
				
				//Create objects to hold the food's information and then add them to the HBox
				Text name = new Text("  " + crewMemberItems.get(i).getName() + "  ");
				nameColumn.getChildren().addAll(name);
				
				Text wage = new Text(crewMemberItems.get(i).getWage() + "  ");
				wageColumn.getChildren().addAll(wage);
				
				Text uniform = new Text(crewMemberItems.get(i).getUniform() + "  ");
				uniformColumn.getChildren().addAll(uniform);
				
				Text position = new Text(crewMemberItems.get(i).getPosition() + "  ");
				positionColumn.getChildren().addAll(position);
				
				Text crewMemberPunchIn = new Text(crewMemberItems.get(i).getCrewMemberPunchIn() + "  ");
				crewMemberPunchInColumn.getChildren().addAll(crewMemberPunchIn);
				
				Text crewMemberGoldStar = new Text("  " + crewMemberItems.get(i).getCrewMemberGoldStar() + "  ");
				crewMemberGoldStarColumn.getChildren().addAll(crewMemberGoldStar);
				
				//Add all of the info into the hbox
				newItemCrew.getChildren().addAll(nameColumn, wageColumn, uniformColumn, positionColumn, crewMemberPunchInColumn, crewMemberGoldStarColumn);
				
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
				
				//Create a VBoxes that will act as the columns of the table
				VBox nameColumn = new VBox();
				VBox wageColumn = new VBox();
				VBox uniformColumn = new VBox();
				VBox positionColumn = new VBox();
				VBox managerIDColumn = new VBox();
				VBox managerSafeCodeColumn = new VBox();
				
				//Create titles for each column
				Text nameTitle = new Text("Name");
				nameColumn.getChildren().addAll(nameTitle);
				
				Text wageTitle = new Text("Wage");
				wageColumn.getChildren().addAll(wageTitle);
				
				Text uniformTitle = new Text("Uniform");
				uniformColumn.getChildren().addAll(uniformTitle);
				
				Text positionTitle = new Text("Position");
				positionColumn.getChildren().addAll(positionTitle);
				
				Text managerIDTitle = new Text("Manager ID");
				managerIDColumn.getChildren().addAll(managerIDTitle);
				
				Text managerSafeCodeTitle = new Text("Manager Safe Code");
				managerSafeCodeColumn.getChildren().addAll(managerSafeCodeTitle);
				
				//Create objects to hold the food's information and then add them to the HBox
				Text name = new Text("  " + managerItems.get(e1).getName() + "  ");
				nameColumn.getChildren().addAll(name);
				
				Text wage = new Text(managerItems.get(e1).getWage() + "  ");
				wageColumn.getChildren().addAll(wage);
				
				Text uniform = new Text(managerItems.get(e1).getUniform() + "  ");
				uniformColumn.getChildren().addAll(uniform);
				
				Text position = new Text(managerItems.get(e1).getPosition() + "  ");
				positionColumn.getChildren().addAll(position);
				
				Text managerID = new Text(managerItems.get(e1).getManagerID() + "  ");
				managerIDColumn.getChildren().addAll(managerID);
				
				Text managerSafeCode = new Text("  " + managerItems.get(e1).getManagerSafeCode() + "  ");
				managerSafeCodeColumn.getChildren().addAll(managerSafeCode);
				
				//Add all of the info into the hbox
				newItemManager.getChildren().addAll(nameColumn, wageColumn, uniformColumn, positionColumn, managerIDColumn, managerSafeCodeColumn);
				
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
			StoreLocationsTable locationsList = new StoreLocationsTable();
			
			//Populate the arraylist with the database contents
			ArrayList<StoreLocations> locationItems = locationsList.getAllStoreLocations();			
			
			//Loop to set the contents of the arraylist to their own panes
			int e1 = 0;
			while(e1 < locationItems.size()){
				
				//Create an HBox to hold the information about the current food item
				HBox newItemLocations = new HBox();
				
				//Create a VBoxes that will act as the columns of the table
				VBox locationColumn = new VBox();
				VBox santScoreColumn = new VBox();
				VBox regionalManColumn = new VBox();
				VBox custReviewColumn = new VBox();
				
				//Create titles for each column
				Text locationTitle = new Text("Location");
				locationColumn.getChildren().addAll(locationTitle);
				
				Text santScoreTitle = new Text("Sanitation Score");
				santScoreColumn.getChildren().addAll(santScoreTitle);
				
				Text regionalManTitle = new Text("Regional Manager");
				regionalManColumn.getChildren().addAll(regionalManTitle);
				
				Text custReviewTitle = new Text("Customer Review");
				custReviewColumn.getChildren().addAll(custReviewTitle);
				
				//Create objects to hold the food's information and then add them to the HBox
				Text location = new Text("  " + locationItems.get(e1).getLocation() + "  ");
				locationColumn.getChildren().addAll(location);
				
				Text santScore = new Text(locationItems.get(e1).getSantScore() + "  ");
				santScoreColumn.getChildren().addAll(santScore);
				
				Text regionalMan = new Text(locationItems.get(e1).getRegionalMan() + "  ");
				regionalManColumn.getChildren().addAll(regionalMan);
				
				Text custReview = new Text(locationItems.get(e1).getCustReview() + "  ");
				custReviewColumn.getChildren().addAll(custReview);
				
				//Add all of the info into the hbox
				newItemLocations.getChildren().addAll(locationColumn, santScoreColumn, regionalManColumn, custReviewColumn);
				
				//Add the HBox to the VBox
				data.getChildren().add(newItemLocations);
				//Increment i
				e1++;
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

