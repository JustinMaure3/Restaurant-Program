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
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class UpdateItemTab extends Tab {
	
	//Create two booleans to determine if the page displays the update options
	private Boolean isFoodHidden = true;
	private Boolean isEmployeeHidden = true;
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
		
//		__________HIDDEN CATEGORIES________________
		//Create insert rating row
		Text ratingText = new Text("Rating:");
		ComboBox<ENUMS.Ratings> rating = new ComboBox<>();
		rating.setItems(FXCollections.observableArrayList(ENUMS.Ratings.values()));
		
		//Create insert description row
		Text descText = new Text("Description:");
		TextField desc = new TextField();
		
		//Create insert picture row
		Text picText = new Text("Picture:");
		//Add enums for all pictures to choose from?
		TextField picture = new TextField();
		
		//Create insert price row
		Text priceText = new Text("Price:");
		TextField price = new TextField();
		
		//Create insert amountSold row
		Text amountSoldText = new Text("Amount Sold:");
		TextField amountSold = new TextField();
		
		//Create insert month row
		Text monthText = new Text("Month");
		ComboBox<ENUMS.MonthlyStats> month = new ComboBox<>();
		month.setItems(FXCollections.observableArrayList(ENUMS.MonthlyStats.values()));
		
		
//		____________HIDDEN CATEGORIES END_____________
		
		//if food categories are not hidden show them
		if(!isFoodHidden) {
			//Show the rating row
			pane.add(ratingText, 0, 2);
			pane.add(rating, 1, 2);
			
			//Show the description row
			pane.add(descText, 0, 3);
			pane.add(desc, 1, 3);
			
			//Show the picture row
			pane.add(picText, 0, 4);
			pane.add(picture, 1, 4);
			
			//Show the price row
			pane.add(priceText, 0, 5);
			pane.add(price, 1, 5);
			
			//Show the amountSold row
			pane.add(amountSoldText, 0, 6);
			pane.add(amountSold, 1, 6);
			
			//Show the month row
			pane.add(monthText, 0, 7);
			pane.add(month, 1, 7);
		}
		
		//Create Button for food update
		Button fUpdate = new Button("Update Food/Drink");
		fUpdate.setOnAction(e->{
			if(!foodName.getText().isEmpty()) {
				if(isFoodHidden) {
					isFoodHidden = false;
					pane.add(fUpdate, 1, 8);
				} else {
					//Create an instance of the food table
					FoodTable fTable = new FoodTable();
					
					//Update a food item with all the new records
					FoodDrink food = new FoodDrink(
							foodName.getText(),
							rating.getSelectionModel().getSelectedItem().ordinal(),
							desc.getText(),
							picture.getText(),
							Integer.parseInt(price.getText()) + 0.0,
							Integer.parseInt(amountSold.getText()) + 0.0,
							month.getSelectionModel().getSelectedItem().name()
							);
					fTable.updateFoodDrink(food);
				}
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
		
		//Create insert position row
		Text positionText = new Text("Position:");
		ComboBox<ENUMS.Positions> position = new ComboBox<>();
		position.setItems(FXCollections.observableArrayList(ENUMS.Positions.values()));
				
		//Create insert uniform row
		Text uniformText = new Text("Uniform Size:");
		ComboBox<ENUMS.UniformSizes> uniform = new ComboBox<>();
		uniform.setItems(FXCollections.observableArrayList(ENUMS.UniformSizes.values()));
				
		//Create insert wage row
		Text wageText = new Text("Wage:");
		TextField wage = new TextField();
				
		//Create insert punch in row
		Text punchInText = new Text("Punch-in ID:");
		TextField punchIn = new TextField();
				
		//Create gold star row
		Text goldStarText = new Text("Gold Star:");
		TextField goldStar = new TextField();
		
//		____________HIDDEN CATEGORIES END_____________
		
		//if employee categories are not hidden show them
		if(!isEmployeeHidden) {
			//Show the position row
			pane.add(positionText, 10, 2);
			pane.add(position, 11, 2);
			
			//Show the uniform row
			pane.add(uniformText, 10, 3);
			pane.add(uniform, 11, 3);
			
			//Show the wage row
			pane.add(wageText, 10, 4);
			pane.add(wage, 11, 4);
			
			//Show the punch in row
			pane.add(punchInText, 10, 5);
			pane.add(punchIn, 11, 5);
			
			//Show the gold star row
			pane.add(goldStarText, 10, 6);
			pane.add(goldStar, 11, 6);
		}
//		____________HIDDEN CATEGORIES END_____________
		
		//create button for employee update
		Button eUpdate = new Button("Update Employee");
		eUpdate.setOnAction(e->{
			if(!eName.getText().isEmpty()) {
				if(isEmployeeHidden) {
					isEmployeeHidden = false;
					pane.add(eUpdate, 11, 7);
				} else {
					//Create an instance of the CrewMember table
					CrewMemberTable cmTable = new CrewMemberTable();
					
					//Update the crew member
					CrewMember crewMember = new CrewMember(
							eName.getText(),
							Integer.parseInt(wage.getText()) + 0.0,
							uniform.getSelectionModel().getSelectedItem().name(),
							position.getSelectionModel().getSelectedItem().name(),
							Integer.parseInt(punchIn.getText()),
							Integer.parseInt(goldStar.getText())
							);
					cmTable.updateCrewMember(crewMember);
				}
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
}
