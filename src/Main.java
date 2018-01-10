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
		themes.getItems().add(modern);

		MenuItem seventies = new MenuItem("70's");
		MenuItem nineties = new MenuItem("90's");
		themes.getItems().addAll(seventies, nineties);
														
		//Adding menus into the menuBar
		menu.getMenus().addAll(fileMenu, creditsMenu, themes);
							
		
		//Create Tab Pane
		TabPane tpane = new TabPane();
		tpane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		HomeTab htab = HomeTab.getInstance();
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
			scene.getStylesheets().add("Themes/seventiesTheme.css");

		});
		modern.setOnAction(e->{
			scene.getStylesheets().add("Themes/modernStyleSheet.css");
		});
		

		//Adding theme
		scene.getStylesheets().add("Themes/seventiesTheme.css"); 

		//Set the 90's theme when clicked on in the menu menu
		nineties.setOnAction(e->{
			scene.getStylesheets().add("Themes/ninetiesTheme.css");
		});

		//Default theme for the application
		scene.getStylesheets().add("Themes/defaultTheme.css");
		
		//Mainstage is set up
		mainStage = primaryStage;
		mainStage.setResizable(false);
		mainStage.setScene(scene);
		mainStage.show();
		
	}

}
