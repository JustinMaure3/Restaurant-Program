import javafx.application.Application;

import javafx.stage.Stage;

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
		//Main stage is set up
		mainStage = primaryStage;
		mainStage.setResizable(false);
		mainStage.setScene(new HomeScene());
		mainStage.show();
		
	}

}
