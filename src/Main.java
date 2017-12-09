import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import tabs.HomeTab;

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
								
		//Adding menu items to file menu
		MenuItem exit = new MenuItem("Exit");
		fileMenu.getItems().add(exit);
								
		//Adding menus into the menuBar
		menu.getMenus().addAll(fileMenu, creditsMenu);
		
		//Create Tab Pane
		TabPane tpane = new TabPane();
		tpane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		HomeTab htab = new HomeTab();
		tpane.getTabs().addAll(htab);
		
		//Setting up the page
		BorderPane bpane = new BorderPane();
		bpane.setTop(menu);
		bpane.setCenter(tpane);
		Scene scene = new Scene(bpane, 1024, 768);
		
		//Mainstage is set up
				mainStage = primaryStage;
				mainStage.setResizable(false);
				mainStage.setScene(scene);
				mainStage.show();
		
	}

}
