package tabs;

import PlaceHolder.CrewMember;
import PlaceHolder.FoodDrink;
import Tables.CrewMemberTable;
import Tables.FoodTable;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class UpdateItemTab extends Tab {
	
	private static UpdateItemTab tab;
	
	private UpdateItemTab() {
		this.setText("Update");
		//Create basic layout
		GridPane pane = new GridPane();
		
		//create food title
		Text foodDrinkText = new Text("Food/Drink");
		pane.add(foodDrinkText, 1, 0);
		
		//create first row input for food
		Text foodNameText = new Text("Name:");
		TextField foodName = new TextField();
		pane.add(foodNameText, 0, 1);
		pane.add(foodName, 1, 1);
		
		//Create Button for food update
		Button fUpdate = new Button("Update Food/Drink");
		fUpdate.setOnAction(e->{
			if(!foodName.getText().isEmpty()) {
//				FoodTable ftable = new FoodTable();
				
//				FoodDrink foodDrink = ftable.getFoodDrink(foodName.getText());
//				getHiddenFood(pane, foodDrink);
				getHiddenFood(pane);
			}
		});
		pane.add(fUpdate, 1, 2);
		
		//create employee title
		Text employeeText = new Text("Employee");
		pane.add(employeeText, 11, 0);
		
		//create first row input for employee
		Text eNameText = new Text("Name:");
		TextField eName = new TextField();
		pane.add(eNameText, 10, 1);
		pane.add(eName, 11, 1);
		
		//create button for employee update
		Button eUpdate = new Button("Update Employee");
		eUpdate.setOnAction(e->{
			if(!eName.getText().isEmpty()) {
				getHiddenEmployees(pane);
			}
		});
		pane.add(eUpdate, 11, 2);
		
		//Setting the page up
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.setVgap(10);
		pane.setHgap(10);
		this.setContent(pane);
	}

	public static UpdateItemTab getInstance() {
		if(tab == null) {
			tab = new UpdateItemTab();
		}
		return tab;
	}
	
//	public void getHiddenFood(GridPane pane, FoodDrink foodDrink) {
	public void getHiddenFood(GridPane pane) {
		GridPane gpane = new GridPane();
		
		//create food title
		Text foodDrinkText = new Text("Food/Drink");
		gpane.add(foodDrinkText, 1, 0);
				
		//create first row input for food
		Text foodNameText = new Text("Name:");
		TextField foodName = new TextField();
//		foodName.setText(foodDrink.getName());
		gpane.add(foodNameText, 0, 1);
		gpane.add(foodName, 1, 1);
				
		//Create insert rating row
		Text ratingText = new Text("Rating:");
		ComboBox<ENUMS.Ratings> rating = new ComboBox<>();
		rating.setItems(FXCollections.observableArrayList(ENUMS.Ratings.values()));
		//Show the rating row
		gpane.add(ratingText, 0, 2);
		gpane.add(rating, 1, 2);
				
		//Create insert description row
		Text descText = new Text("Description:");
		TextField desc = new TextField();
//		desc.setText(foodDrink.getDescription());
		//Show the description row
		gpane.add(descText, 0, 3);
		gpane.add(desc, 1, 3);
				
		//Create insert picture row
		Text picText = new Text("Picture:");
		//Add enums for all pictures to choose from?
		ComboBox<ENUMS.Pictures> picture = new ComboBox<>();
		picture.setItems(FXCollections.observableArrayList(ENUMS.Pictures.values()));
		//Show the picture row
		gpane.add(picText, 0, 4);
		gpane.add(picture, 1, 4);
				
		//Create insert price row
		Text priceText = new Text("Price:");
		TextField price = new TextField();
//		price.setText(foodDrink.getPrice() + "");
		//Show the price row
		gpane.add(priceText, 0, 5);
		gpane.add(price, 1, 5);
				
		//Create insert amountSold row
		Text amountSoldText = new Text("Amount Sold:");
		TextField amountSold = new TextField();
//		amountSold.setText(foodDrink.getAmountSold() + "");
		//Show the amountSold row
		gpane.add(amountSoldText, 0, 6);
		gpane.add(amountSold, 1, 6);
				
		//Create insert month row
		Text monthText = new Text("Month");
		ComboBox<ENUMS.MonthlyStats> month = new ComboBox<>();
		month.setItems(FXCollections.observableArrayList(ENUMS.MonthlyStats.values()));
		//Show the month row
		gpane.add(monthText, 0, 7);
		gpane.add(month, 1, 7);
		
		Button fUpdate = new Button("Update Food/Drink");
		fUpdate.setOnAction(e->{
			if(!foodName.getText().isEmpty()) {
				//Create an instance of the food table
				FoodTable fTable = new FoodTable();
					
				//Update a food item with all the new records
				FoodDrink food = new FoodDrink(
						foodName.getText(),
						rating.getSelectionModel().getSelectedItem().ordinal(),
						desc.getText(),
						picture.getSelectionModel().getSelectedItem().name(),
						Double.parseDouble(price.getText()),
						Double.parseDouble(amountSold.getText()),
						month.getSelectionModel().getSelectedItem().name()
						);
				fTable.updateFoodDrink(food);
			}
		});
		gpane.add(fUpdate, 1, 8);
		
		Button back = new Button("Back");
		back.setOnAction(e->{
			this.setContent(pane);
		});
		gpane.add(back, 1, 9);
		
		//Setting the page up
		gpane.setPadding(new Insets(10, 10, 10, 10));
		gpane.setVgap(10);
		gpane.setHgap(10);
		this.setContent(gpane);
	}
	
	public void getHiddenEmployees(GridPane pane) {
		GridPane gpane = new GridPane();
		
		//create employee title
		Text employeeText = new Text("Employee");
		gpane.add(employeeText, 1, 0);
				
		//create first row input for employee
		Text eNameText = new Text("Name:");
		TextField eName = new TextField();
		gpane.add(eNameText, 0, 1);
		gpane.add(eName, 1, 1);
				
		//Create insert position row
		Text positionText = new Text("Position:");
		ComboBox<ENUMS.Positions> position = new ComboBox<>();
		position.setItems(FXCollections.observableArrayList(ENUMS.Positions.values()));
		//Show the position row
		gpane.add(positionText, 0, 2);
		gpane.add(position, 1, 2);
						
		//Create insert uniform row
		Text uniformText = new Text("Uniform Size:");
		ComboBox<ENUMS.UniformSizes> uniform = new ComboBox<>();
		uniform.setItems(FXCollections.observableArrayList(ENUMS.UniformSizes.values()));
		//Show the uniform row
		gpane.add(uniformText, 0, 3);
		gpane.add(uniform, 1, 3);
						
		//Create insert wage row
		Text wageText = new Text("Wage:");
		TextField wage = new TextField();
		//Show the wage row
		gpane.add(wageText, 0, 4);
		gpane.add(wage, 1, 4);
						
		//Create insert punch in row
		Text punchInText = new Text("Punch-in ID:");
		TextField punchIn = new TextField();
		//Show the punch in row
		gpane.add(punchInText, 0, 5);
		gpane.add(punchIn, 1, 5);
						
		//Create gold star row
		Text goldStarText = new Text("Gold Star:");
		TextField goldStar = new TextField();
		//Show the gold star row
		gpane.add(goldStarText, 0, 6);
		gpane.add(goldStar, 1, 6);
				
		//create button for employee update
		Button eUpdate = new Button("Update Employee");
		eUpdate.setOnAction(e->{
			if(!eName.getText().isEmpty()) {
				//Create an instance of the CrewMember table
				CrewMemberTable cmTable = new CrewMemberTable();
							
				//Update the crew member
				CrewMember crewMember = new CrewMember(
						eName.getText(),
						Double.parseDouble(wage.getText()),
						uniform.getSelectionModel().getSelectedItem().name(),
						position.getSelectionModel().getSelectedItem().name(),
						Integer.parseInt(punchIn.getText()),
						Integer.parseInt(goldStar.getText())
						);
				cmTable.updateCrewMember(crewMember);
			}
		});
		gpane.add(eUpdate, 1, 7);
		
		Button back = new Button("Back");
		back.setOnAction(e->{
			this.setContent(pane);
		});
		gpane.add(back, 1, 8);
		
		
		
		//Setting the page up
		gpane.setPadding(new Insets(10, 10, 10, 10));
		gpane.setVgap(10);
		gpane.setHgap(10);
		this.setContent(gpane);
	}
}
