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
import javafx.geometry.Insets;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
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
		MenuItem addTable = new MenuItem("Add all to Table");
		
		//Creating an onClick for the food button
		food.setOnAction(e->{
			MenuTab.displayedTable = "food";
			VBox data = new VBox();	

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
			
			
			Font subTitleFont = Font.font("Times New Roman", FontPosture.REGULAR, 25);
			foodNameTitle.setFont(subTitleFont);
			ratingTitle.setFont(subTitleFont);
			descriptionTitle.setFont(subTitleFont);
			pictureTitle.setFont(subTitleFont);
			priceTitle.setFont(subTitleFont);
			amountSoldTitle.setFont(subTitleFont);
			
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
				foodPicture.setFitHeight(30);
				foodPicture.setFitWidth(30);
				pictureColumn.setPadding(new Insets(0, 0, 0, 15));
				
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
			
			//Create an HBox to hold the information about the current food item
			HBox newItemCrew = new HBox();
			
			//Create a VBoxes that will act as the columns of the table
			VBox nameColumn = new VBox();
			nameColumn.setSpacing(10.0);
			nameColumn.setPadding(new Insets(0, 0, 0, 15));
			VBox wageColumn = new VBox();
			wageColumn.setSpacing(10.0);
			VBox uniformColumn = new VBox();
			uniformColumn.setSpacing(10.0);
			VBox positionColumn = new VBox();
			positionColumn.setSpacing(10.0);
			VBox crewMemberPunchInColumn = new VBox();
			crewMemberPunchInColumn.setSpacing(10.0);
			VBox crewMemberGoldStarColumn = new VBox();
			crewMemberGoldStarColumn.setSpacing(10.0);
			
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
			
			Font subTitleFont = Font.font("Times New Roman", FontPosture.REGULAR, 25);
			nameTitle.setFont(subTitleFont);
			wageTitle.setFont(subTitleFont);
			positionTitle.setFont(subTitleFont);
			uniformTitle.setFont(subTitleFont);
			crewMemberPunchInTitle.setFont(subTitleFont);
			crewMemberGoldStarTitle.setFont(subTitleFont);
			
			//Loop to set the contents of the arraylist to their own panes
			int i = 0;
			while(i < crewMemberItems.size()){				
				
				//Create objects to hold the food's information and then add them to the HBox
				Text empName = new Text("  " + crewMemberItems.get(i).getName() + "  ");
				nameColumn.getChildren().addAll(empName);
				
				Text empWage = new Text(crewMemberItems.get(i).getWage() + "  ");
				wageColumn.getChildren().addAll(empWage);
				
				Text empUniform = new Text(crewMemberItems.get(i).getUniform() + "  ");
				uniformColumn.getChildren().addAll(empUniform);
				
				Text empPosition = new Text(crewMemberItems.get(i).getPosition() + "  ");
				positionColumn.getChildren().addAll(empPosition);
				
				Text crewMemberPunchIn = new Text(crewMemberItems.get(i).getCrewMemberPunchIn() + "  ");
				crewMemberPunchInColumn.getChildren().addAll(crewMemberPunchIn);
				
				Text crewMemberGoldStar = new Text("  " + crewMemberItems.get(i).getCrewMemberGoldStar() + "  ");
				crewMemberGoldStarColumn.getChildren().addAll(crewMemberGoldStar);				
			
				//Increment i
				i++;
			}
			
			//Add all of the info into the hbox
			newItemCrew.getChildren().addAll(nameColumn, wageColumn, uniformColumn, positionColumn, crewMemberPunchInColumn, crewMemberGoldStarColumn);
			
			//Add the HBox to the VBox
			data.getChildren().add(newItemCrew);
			
			VBox dataTwo = new VBox();
			//Create an arraylist
			ManagerTable managerList = new ManagerTable();
			
			//Populate the arraylist with the database contents
			ArrayList<Manager> managerItems = managerList.getAllManagers();	
			
			//Create an HBox to hold the information about the current food item
			HBox newItemManager = new HBox();
			
			//Create a VBoxes that will act as the columns of the table
			VBox managerNameColumn = new VBox();
			managerNameColumn.setSpacing(10.0);
			managerNameColumn.setPadding(new Insets(0, 0, 0, 15));
			VBox managerWageColumn = new VBox();
			managerWageColumn.setSpacing(10.0);
			VBox managerUniformColumn = new VBox();
			managerUniformColumn.setSpacing(10.0);
			VBox managerPositionColumn = new VBox();
			managerPositionColumn.setSpacing(10.0);
			VBox managerIDColumn = new VBox();
			managerIDColumn.setSpacing(10.0);
			VBox managerSafeCodeColumn = new VBox();
			managerSafeCodeColumn.setSpacing(10.0);
			
			//Create titles for each column
			Text managerNameTitle = new Text("Name");
			managerNameColumn.getChildren().addAll(managerNameTitle);
			
			Text managerWageTitle = new Text("Wage");
			managerWageColumn.getChildren().addAll(managerWageTitle);
			
			Text managerUniformTitle = new Text("Uniform");
			managerUniformColumn.getChildren().addAll(managerUniformTitle);
			
			Text managerPositionTitle = new Text("Position");
			managerPositionColumn.getChildren().addAll(managerPositionTitle);
			
			Text managerIDTitle = new Text("Manager ID");
			managerIDColumn.getChildren().addAll(managerIDTitle);
			
			Text managerSafeCodeTitle = new Text("Manager Safe Code");
			managerSafeCodeColumn.getChildren().addAll(managerSafeCodeTitle);
			
			managerNameTitle.setFont(subTitleFont);
			managerWageTitle.setFont(subTitleFont);
			managerUniformTitle.setFont(subTitleFont);
			managerPositionTitle.setFont(subTitleFont);
			managerIDTitle.setFont(subTitleFont);
			managerSafeCodeTitle.setFont(subTitleFont);
			
			//Loop to set the contents of the arraylist to their own panes
			int e1 = 0;
			while(e1 < managerItems.size()){
				
				//Create objects to hold the food's information and then add them to the HBox
				Text name = new Text("  " + managerItems.get(e1).getName() + "  ");
				managerNameColumn.getChildren().addAll(name);
				
				Text wage = new Text(managerItems.get(e1).getWage() + "  ");
				managerWageColumn.getChildren().addAll(wage);
				
				Text uniform = new Text(managerItems.get(e1).getUniform() + "  ");
				managerUniformColumn.getChildren().addAll(uniform);
				
				Text position = new Text(managerItems.get(e1).getPosition() + "  ");
				managerPositionColumn.getChildren().addAll(position);
				
				Text managerID = new Text(managerItems.get(e1).getManagerID() + "  ");
				managerIDColumn.getChildren().addAll(managerID);
				
				Text managerSafeCode = new Text("  " + managerItems.get(e1).getManagerSafeCode() + "  ");
				managerSafeCodeColumn.getChildren().addAll(managerSafeCode);				
				
				//Increment i
				e1++;
			}
			
			//Add all of the info into the hbox
			newItemManager.getChildren().addAll(managerNameColumn, managerWageColumn, managerUniformColumn, managerPositionColumn, managerIDColumn, managerSafeCodeColumn);

			//Add the HBox to the VBox
			dataTwo.getChildren().add(newItemManager);
				VBox all = new VBox();
				all.getChildren().addAll(data,dataTwo);
			MenuTab.tab.setContent(all);
		});		
		
		MenuItem locations = new MenuItem("Locations");
		locations.setOnAction(e->{
			MenuTab.displayedTable = "locations";
			
			VBox locationData = new VBox();
			//Create an arraylist
			StoreLocationsTable locationsList = new StoreLocationsTable();
			
			//Populate the arraylist with the database contents
			ArrayList<StoreLocations> locationItems = locationsList.getAllStoreLocations();	
			
			//Create an HBox to hold the information about the current food item
			HBox newItemLocations = new HBox();
			
			//Create a VBoxes that will act as the columns of the table
			VBox locationColumn = new VBox();
			locationColumn.setSpacing(10.0);
			locationColumn.setPadding(new Insets(0, 0, 0, 15));
			VBox santScoreColumn = new VBox();
			santScoreColumn.setSpacing(10.0);
			VBox regionalManColumn = new VBox();
			regionalManColumn.setSpacing(10.0);
			VBox custReviewColumn = new VBox();
			custReviewColumn.setSpacing(10.0);
			
			//Create titles for each column
			Text locationTitle = new Text("Location");
			locationColumn.getChildren().addAll(locationTitle);
			
			Text santScoreTitle = new Text("Sanitation Score");
			santScoreColumn.getChildren().addAll(santScoreTitle);
			
			Text regionalManTitle = new Text("Regional Manager");
			regionalManColumn.getChildren().addAll(regionalManTitle);
			
			Text custReviewTitle = new Text("Customer Review");
			custReviewColumn.getChildren().addAll(custReviewTitle);
			

			Font subTitleFont = Font.font("Times New Roman", FontPosture.REGULAR, 25);
			locationTitle.setFont(subTitleFont);
			santScoreTitle.setFont(subTitleFont);
			regionalManTitle.setFont(subTitleFont);
			custReviewTitle.setFont(subTitleFont);
			
			//Loop to set the contents of the arraylist to their own panes
			int e1 = 0;
			while(e1 < locationItems.size()){
				
				//Create objects to hold the food's information and then add them to the HBox
				Text location = new Text("  " + locationItems.get(e1).getLocation() + "  ");
				locationColumn.getChildren().addAll(location);
				
				Text santScore = new Text(locationItems.get(e1).getSantScore() + "  ");
				santScoreColumn.getChildren().addAll(santScore);
				
				Text regionalMan = new Text(locationItems.get(e1).getRegionalMan() + "  ");
				regionalManColumn.getChildren().addAll(regionalMan);
				
				Text custReview = new Text(locationItems.get(e1).getCustReview() + "  ");
				custReviewColumn.getChildren().addAll(custReview);
				
				//Increment i
				e1++;
			}
			//Add all of the info into the hbox
			newItemLocations.getChildren().addAll(locationColumn, santScoreColumn, regionalManColumn, custReviewColumn);

			//Add the HBox to the VBox
			locationData.getChildren().add(newItemLocations);
			MenuTab.tab.setContent(locationData);
			
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
								
		
		addTable.setOnAction(e->{
			FoodTable fTable = new FoodTable();
			FoodDrink foodAdd = new FoodDrink();
			 foodAdd = new FoodDrink("Pizza", 5, "Nice and greasy!", "Pizza.jpg", 3.99, 10.0, "APRIL");
			 fTable.createFoodDrink(foodAdd);
			 foodAdd = new FoodDrink("Beet_Salad", 4, "Ew", "Beet Salad.jpg", 3.44, 16.0, "MARCH");
			 fTable.createFoodDrink(foodAdd);
			 foodAdd = new FoodDrink("American_Breakfast", 2, "Soothing", "Classic American Breakfast.jpg", 1.55, 6.0, "JUNE");
			 fTable.createFoodDrink(foodAdd);
			 foodAdd = new FoodDrink("Cocktails", 1, "Party!", "Cocktails.jpg", 5.00, 10.0, "JULY");
			 fTable.createFoodDrink(foodAdd);
			 foodAdd = new FoodDrink("Coffee", 6, "Bitter", "Coffee.jpg", 1.00, 2.0, "SEPTEMBER");
			 fTable.createFoodDrink(foodAdd);
			 foodAdd = new FoodDrink("Cucumber_Water", 9, "10 dollars?!", "Cucumber Water.jpg", 10.00, 7.0, "OCTOBER");
			 fTable.createFoodDrink(foodAdd);
			 foodAdd = new FoodDrink("Curry", 8, "Tastes great!", "curry-bowl-garnished-with-greens_4460x4460.jpg", 9.99, 4.0, "NOVEMBER");
			 fTable.createFoodDrink(foodAdd);
			 
			 
			 	CrewMemberTable cTable = new CrewMemberTable();
				CrewMember crewAdd = new CrewMember();
				
				crewAdd = new CrewMember("Tomas", 12.99, "L", "Cook", 3325, 5);  
				cTable.createCrewMember(crewAdd);
				
				crewAdd = new CrewMember("Justin", 14.99, "M", "Dish_Washer", 3145, 9);  
				cTable.createCrewMember(crewAdd);
				
				crewAdd = new CrewMember("Max", 11.99, "S", "Waiter", 1425, 2);  
				cTable.createCrewMember(crewAdd);
				
				crewAdd = new CrewMember("Stefano", 9.99, "XXL", "Pizza_Maker", 12315, 1);  
				cTable.createCrewMember(crewAdd);
				
				ManagerTable mTable = new ManagerTable();
				Manager manAdd = new Manager();
				
				manAdd = new Manager("Desmond", 16.99, "L", "Manager", 12312, 5123); 
				mTable.createManager(manAdd);
				
				manAdd = new Manager("Cody", 17.99, "M", "General_manager", 12451, 91234);  
				mTable.createManager(manAdd);
				
				manAdd = new Manager("Jess", 18.99, "S", "Supervisor", 6543, 24123);  
				mTable.createManager(manAdd);
				
				manAdd = new Manager("Alex", 19.99, "XXL", "General_manager_assistant", 9876, 11234);  
				mTable.createManager(manAdd);	
				
				
				
				StoreLocationsTable lTable = new StoreLocationsTable();
				StoreLocations locAdd = new StoreLocations();
				
				locAdd = new StoreLocations("532 Cool Street", "David Blake", 75, 44); 
				lTable.createStoreLocations(locAdd);
				
				locAdd = new StoreLocations("51341 WhereAmI Street?", "Cody", 44, 43);
				lTable.createStoreLocations(locAdd);
				
				locAdd = new StoreLocations("8827 PleaseStop", "Alduin", 76, 65);  
				lTable.createStoreLocations(locAdd);
				
				locAdd = new StoreLocations("77 ImFallen rd",  "Billy", 11, 87);  
				lTable.createStoreLocations(locAdd);
				
				
		});
	
		creditsMenu.setOnAction(e->{
			mainStage.setScene(new CreditsScene());
		});
		//Adding menus into the menuBar
		fileMenu.getItems().addAll(themes,display,creditsMenu, addTable, exit);
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

<<<<<<< HEAD
		MenuItem employees = new MenuItem("Employees");

		MenuItem locations = new MenuItem("Locations");

		display.getItems().addAll(food,employees, locations);
		//Creating an onClick for the food button
				food.setOnAction(e->{
					MenuTab.tab.setContent(MenuTab.newFoodDrink());
					MenuTab.displayedTable = "food";
				});
				
				
				employees.setOnAction(e->{
					MenuTab.tab.setContent(MenuTab.newEmployee());
					MenuTab.displayedTable = "employee";
				
				});		
				locations.setOnAction(e->{
					MenuTab.tab.setContent(MenuTab.newLocations());
					MenuTab.displayedTable = "locations";
				});

				
				

				tpane.getTabs().addAll(htab, mtab, addTab, removeTab, updateTab, stab);
=======
		
		tpane.getTabs().addAll(htab, mtab, addTab, removeTab, updateTab, stab);
>>>>>>> 5f6b8773379419783c08acd1f8ea053775c40495



		
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

