import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import tabs.HomeTab;

public class Home extends BorderPane {

	public Home() {
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
	}
}