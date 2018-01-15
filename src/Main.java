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
			MenuTab.newFoodDrink();
			MenuTab.displayedTable = "Food";
			MenuTab.check = MenuTab.newFoodDrink();

			MenuTab.getInstance();
		});
		
		MenuItem employees = new MenuItem("Employees");
		
		employees.setOnAction(e->{
			MenuTab.newEmployee();
			MenuTab.displayedTable = "Employee";
			MenuTab.check = MenuTab.newEmployee();

			MenuTab.getInstance();
		
		});		
		
		MenuItem locations = new MenuItem("Locations");
		locations.setOnAction(e->{
			MenuTab.newLocations();
			MenuTab.displayedTable = "Employee";
			
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

