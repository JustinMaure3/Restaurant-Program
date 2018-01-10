package tabs;

import PlaceHolder.CrewMember;
import PlaceHolder.Employee;
import PlaceHolder.FoodDrink;
import Tables.CrewMemberTable;
import Tables.FoodTable;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class AddItemTab extends Tab{
	
	private static AddItemTab tab;
	
	private AddItemTab() {
		this.setText("Add");
		//create the layout view
		GridPane pane = new GridPane();
		
		//Create insert name row
		Text nameText = new Text("Name of Food:");
		TextField name = new TextField();
		pane.add(nameText, 0, 0);
		pane.add(name, 1, 0);
		
		
		//Create insert rating row
		Text ratingText = new Text("Rating:");
		ComboBox<ENUMS.Ratings> rating = new ComboBox<>();
		rating.setItems(FXCollections.observableArrayList(ENUMS.Ratings.values()));
		pane.add(ratingText, 0, 1);
		pane.add(rating, 1, 1);
		
		//Create insert description row
		Text descText = new Text("Description:");
		TextField desc = new TextField();
		pane.add(descText, 0, 2);
		pane.add(desc, 1, 2);
		
		//Create insert picture row
		Text picText = new Text("Picture:");
		//Add enums for all pictures to choose from?
		TextField picture = new TextField();
		pane.add(picText, 0, 3);
		pane.add(picture, 1, 3);
		
		//Create insert price row
		Text priceText = new Text("Price:");
		TextField price = new TextField();
		pane.add(priceText, 0, 4);
		pane.add(price, 1, 4);
		
		//Create insert amountSold row
		Text amountSoldText = new Text("Amount Sold:");
		TextField amountSold = new TextField();
		pane.add(amountSoldText, 0, 5);
		pane.add(amountSold, 1, 5);
		
		//Create insert month row
		Text monthText = new Text("Month");
		ComboBox<ENUMS.MonthlyStats> month = new ComboBox<>();
		month.setItems(FXCollections.observableArrayList(ENUMS.MonthlyStats.values()));
		pane.add(monthText, 0, 6);
		pane.add(month, 1, 6);
		
		//Create submit button
		Button submitButton = new Button("Add Food/Drink");
		submitButton.setOnAction(e->{
			//Create an instance of the food table
			FoodTable fTable = new FoodTable();
			
			FoodDrink food = new FoodDrink(
					name.getText(),
					rating.getSelectionModel().getSelectedItem().ordinal(),
					desc.getText(),
					picture.getText(),
					Double.parseDouble(price.getText()),
					Double.parseDouble(amountSold.getText()),
					month.getSelectionModel().getSelectedItem().name()
					);
			fTable.createFoodDrink(food);
		});
		
		pane.add(submitButton, 1, 7);
		
		//Add an employee form
		
		//Create insert employee name row
		Text enameText = new Text("Employee Name:");
		TextField ename = new TextField();
		pane.add(enameText, 10, 0);
		pane.add(ename, 11, 0);
		
		//Create insert position row
		Text positionText = new Text("Position:");
		ComboBox<ENUMS.Positions> position = new ComboBox<>();
		position.setItems(FXCollections.observableArrayList(ENUMS.Positions.values()));
		pane.add(positionText, 10, 1);
		pane.add(position, 11, 1);
		
		//Create insert uniform row
		Text uniformText = new Text("Uniform Size:");
		ComboBox<ENUMS.UniformSizes> uniform = new ComboBox<>();
		uniform.setItems(FXCollections.observableArrayList(ENUMS.UniformSizes.values()));
		pane.add(uniformText, 10, 2);
		pane.add(uniform, 11, 2);
		
		//Create insert wage row
		Text wageText = new Text("Wage:");
		TextField wage = new TextField();
		pane.add(wageText, 10, 3);
		pane.add(wage, 11, 3);
		
		//Create insert punch in row
		Text punchInText = new Text("Punch-in ID:");
		TextField punchIn = new TextField();
		pane.add(punchInText, 10, 4);
		pane.add(punchIn, 11, 4);
		
		//Create gold star row
		Text goldStarText = new Text("Gold Star:");
		TextField goldStar = new TextField();
		pane.add(goldStarText, 10, 5);
		pane.add(goldStar, 11, 5);
		
		//Create add employee button
		Button eSubmit = new Button("Add Employee");
		eSubmit.setOnAction(e->{
			//Create an instance of the CrewMember table
			CrewMemberTable cmTable = new CrewMemberTable();
			
			CrewMember crewMember = new CrewMember(
					name.getText(),
					Integer.parseInt(wage.getText()) + 0.0,
					uniform.getSelectionModel().getSelectedItem().name(),
					position.getSelectionModel().getSelectedItem().name(),
					Integer.parseInt(punchIn.getText()),
					Integer.parseInt(goldStar.getText())
					);
			cmTable.createCrewMember(crewMember);
			
			
		});
		pane.add(eSubmit, 11, 6);
		
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.setVgap(10);
		pane.setHgap(10);
		this.setContent(pane);
	}
	
	public static AddItemTab getInstance() {
		if(tab == null) {
			tab = new AddItemTab();
		}
		return tab;
	}

}
