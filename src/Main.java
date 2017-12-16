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
		
//Food Items
		final FoodDrink classicAmericanBreakfast = new FoodDrink
				("Classic American Breakfast",
				14,
				"Two eggs, any way you'd like, fried potatoes, bacon, asparagus, and some cherry tomatoes. A fantastic start to any day.", 
				"Pictures/Classic American Breakfast.jpg");
		final FoodDrink penne = new FoodDrink
				("Penne",
				12,
				"House-made noodles, served in a delicious tomato sauce, and topped with parmesan cheese and a couple sprigs of parsley.", 
				"Pictures/Penne.jpg");
		final FoodDrink sloppyJoe = new FoodDrink
				("Sloppy Joe",
				10,
				"Our take on a Sloppy Joe. Has pickles, tomatoes, lettuce, onions, and cheese. Served with a side of kettle chips.", 
				"Pictures/Sloppy Joe.jpg");
		final FoodDrink tacos = new FoodDrink
				("Tacos",
				12,
				"Two small tacos filled with beef, corn, lettuce, tomatoes, onions, and shredded cheese.", 
				"Pictures/Tacos.jpg");
		final FoodDrink cinnamonWaffles = new FoodDrink
				("Cinnamon Waffles",
				8,
				"Four light and fluffy miniature waffles, covered in cinnamon and icing sugar. Served with fresh, house-made whipped cream and a side of maple syrup.", 
				"Pictures/Waffles.jpg");
		
//Drinks
		final FoodDrink coffee = new FoodDrink
				("Coffee",
				2,
				"Fresh brewed coffee made with beans from somewhere you've never heard of before.", 
				"Pictures/Coffee.jpg");
		final FoodDrink tea = new FoodDrink
				("Tea",
				2,
				"Pick one of our fantastic tea flavours either Earl Grey, Orange Pekoe, Chai, Blueberry, or Pomegranate.", 
				"Pictures/Tea.jpg");
		final FoodDrink cucumberWater = new FoodDrink
				("Cucumber Water",
				2,
				"Is it water with cucumbers in it or is it water made out of cucumber juices? You may never know.", 
				"Pictures/Cucumber Water.jpg");
		final FoodDrink juice = new FoodDrink
				("Fruit Juice",
				2,
				"Your choice of one of our fresh squeezed fruit juices. Either Orange, Apple, Peach, or Pineapple juice. Made to order..", 
				"Pictures/Juice.jpg");

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
<<<<<<< HEAD
		//Main stage is set up
=======
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
		MenuTab mtab = new MenuTab();
		AddItemTab addTab = new AddItemTab();
		RemoveItemTab removeTab = new RemoveItemTab();
		UpdateItemTab updateTab = new UpdateItemTab();
		StatisticsTab stab = new StatisticsTab();
		tpane.getTabs().addAll(htab, mtab, addTab, removeTab, updateTab, stab);
		
		//Setting up the main page
		BorderPane bpane = new BorderPane();
		bpane.setTop(menu);
		bpane.setCenter(tpane);
		Scene scene = new Scene(bpane, 1024, 768);
		
		//Mainstage is set up
>>>>>>> 8c0d43deb718e6abc47c307fdf322a674229a12a
		mainStage = primaryStage;
		mainStage.setResizable(false);
		mainStage.setScene(scene);
		mainStage.show();
		
	}

}
