import java.sql.Connection;

import Database.Database;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import tabs.AddItemTab;
import tabs.HomeTab;
import tabs.MenuTab;
import tabs.RemoveItemTab;
import tabs.StatisticsTab;
import tabs.UpdateItemTab;

public class Main extends Application {

	public static Stage mainStage;
	public static String displayedTable = "";
	public static void main(String[] args) {
		Application.launch(args);

	
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		//Setting up a Menu bar
		MenuBar menu = new MenuBar();
		Menu fileMenu = new Menu("File");
		Menu creditsMenu = new Menu("Credits");
		Menu themes = new Menu("Themes");
		Menu display = new Menu("Display");

		//Adding menu items to the Display menu
		
		
		
		MenuItem food = new MenuItem("Food");
		food.setOnAction(e->{
			displayedTable = "food";
		});
		MenuItem employees = new MenuItem("Employees");
		employees.setOnAction(e->{
			displayedTable = "employees";
		});
		MenuItem locations = new MenuItem("Locations");
		locations.setOnAction(e->{
			displayedTable = "locations";
		});
		display.getItems().addAll(food,employees, locations);
														
		//Adding menu items to file menu
		MenuItem exit = new MenuItem("Exit");
		exit.setOnAction(e->{
			Database db = Database.getInstance();
			db.close();
			System.exit(0);
		});
		fileMenu.getItems().add(exit);
		
		//Adding menu items to themes menu

		MenuItem modern = new MenuItem("Modern");
		MenuItem seventies = new MenuItem("70's");
		MenuItem nineties = new MenuItem("90's");
		MenuItem defaultTheme = new MenuItem("Default");
		themes.getItems().addAll(defaultTheme, seventies, nineties, modern);
														
		//Adding menus into the menuBar
		menu.getMenus().addAll(fileMenu, creditsMenu, themes, display);
							
		
		//Create Tab Pane
		TabPane tpane = new TabPane();
		tpane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		HomeTab htab = HomeTab.getInstance();
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
	public String displayedTable() {
		return displayedTable;
	}
	

}
