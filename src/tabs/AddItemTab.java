package tabs;
/**
 * Add item tab that is used to add different items
 * to the database depending on which database you choose to add
 * @author Stefano,Max,Tomas,Justin
 *
 */
import PlaceHolder.CrewMember;
import PlaceHolder.FoodDrink;
import PlaceHolder.Manager;
import Tables.CrewMemberTable;
import Tables.FoodTable;
import Tables.ManagerTable;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.util.Duration;

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
		ComboBox<ENUMS.Pictures> picture = new ComboBox<>();
		picture.setItems(FXCollections.observableArrayList(ENUMS.Pictures.values()));
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
			
			//Try to create a food entry
			try {
			FoodDrink food = new FoodDrink(
					name.getText(),
					rating.getSelectionModel().getSelectedItem().ordinal() + 1,
					desc.getText(),
					getPictureDisplay(picture.getSelectionModel().getSelectedItem().name()),
					Double.parseDouble(price.getText()),
					Double.parseDouble(amountSold.getText()),
					month.getSelectionModel().getSelectedItem().name()
					);
			fTable.createFoodDrink(food);
			
			//reset the text of all textfields
			amountSold.setText("");
			price.setText("");
			desc.setText("");
			name.setText("");

			//Update all other tabs so they use the new item
			RemoveItemTab.refresh();
			UpdateItemTab.refresh();
			StatisticsTab.pane.setCenter(StatisticsTab.generateChart());
			MenuTab.tab.setContent(MenuTab.newFoodDrink());
			HomeTab.tab.setContent(HomeTab.homeRefresh());
			}catch(Exception e1){
				
				FadeTransition fade = new FadeTransition(Duration.millis(2000), submitButton);
				fade.setFromValue(0); //starting opacity
				fade.setToValue(1); //ending opacity (for 1 cycle)
				fade.setAutoReverse(true); //if the fade should play backwards
				fade.play();
				
				
				amountSold.setPromptText("Please enter a valid value");
				amountSold.setText("");
				
				price.setPromptText("Please enter a valid value");
				price.setText("");
				
				desc.setPromptText("Please enter a valid value");
				desc.setText("");
				
				name.setPromptText("Please enter a valid value");
				name.setText("");
			}
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
			
				//Try to create another employee
				try {
					CrewMember crewMember = new CrewMember(
							ename.getText(),
							Double.parseDouble(wage.getText()),
							uniform.getSelectionModel().getSelectedItem().name(),
							position.getSelectionModel().getSelectedItem().name(),
							Integer.parseInt(punchIn.getText()),
							Integer.parseInt(goldStar.getText())
							);
					cmTable.createCrewMember(crewMember);
					
					//reset all the textfields
					goldStar.setText("");
					punchIn.setText("");
					wage.setText("");
					ename.setText("");

					//Update the other tabs to use teh new employee
					RemoveItemTab.refresh();
					UpdateItemTab.refresh();
					StatisticsTab.pane.setCenter(StatisticsTab.generateChart());
					MenuTab.tab.setContent(MenuTab.newEmployee());
					HomeTab.tab.setContent(HomeTab.homeRefresh());
				}catch(Exception e1){
					FadeTransition fade = new FadeTransition(Duration.millis(2000), eSubmit);
					fade.setFromValue(0); //starting opacity
					fade.setToValue(1); //ending opacity (for 1 cycle)
					fade.setAutoReverse(true); //if the fade should play backwards
					fade.play();
					
					goldStar.setPromptText("Please enter a valid value");
					goldStar.setText("");
					
					punchIn.setPromptText("Please enter a valid value");
					punchIn.setText("");
					
					wage.setPromptText("Please enter a valid value");
					wage.setText("");
					
					ename.setPromptText("Please enter a valid value");
					ename.setText("");
				}
			
			
		});
		
		pane.add(eSubmit, 11, 6);
		
		//Add an Manager form
		
		//Create insert manager name row
		Text mnameText = new Text("Manager Name:");
		TextField mname = new TextField();
		pane.add(mnameText, 20, 0);
		pane.add(mname, 21, 0);
				
		//Create insert position row
		Text mPositionText = new Text("Position:");
		ComboBox<ENUMS.ManagerPositions> mPosition = new ComboBox<>();
		mPosition.setItems(FXCollections.observableArrayList(ENUMS.ManagerPositions.values()));
		pane.add(mPositionText, 20, 1);
		pane.add(mPosition, 21, 1);
				
		//Create insert uniform row
		Text mUniformText = new Text("Uniform Size:");
		ComboBox<ENUMS.UniformSizes> mUniform = new ComboBox<>();
		mUniform.setItems(FXCollections.observableArrayList(ENUMS.UniformSizes.values()));
		pane.add(mUniformText, 20, 2);
		pane.add(mUniform, 21, 2);
				
		//Create insert wage row
		Text mWageText = new Text("Wage:");
		TextField mWage = new TextField();
		pane.add(mWageText, 20, 3);
		pane.add(mWage, 21, 3);
				
		//Create insert manager ID row
		Text managerIDText = new Text("Manager ID:");
		TextField managerID = new TextField();
		pane.add(managerIDText, 20, 4);
		pane.add(managerID, 21, 4);
						
		//Create manager safe code row
		Text managerSafeCodeText = new Text("Manager Safe Code:");
		TextField managerSafeCode = new TextField();
		pane.add(managerSafeCodeText, 20, 5);
		pane.add(managerSafeCode, 21, 5);
				
		//Create add manager button
		Button mSubmit = new Button("Add Manager");
		mSubmit.setOnAction(e->{
			//Create an instance of the Manager table
			ManagerTable mTable = new ManagerTable();
				
			//Try to create a new manager
			try {
			Manager manager = new Manager(
					mname.getText(),
					Double.parseDouble(mWage.getText()),
					mUniform.getSelectionModel().getSelectedItem().name(),
					mPosition.getSelectionModel().getSelectedItem().name(),
					Integer.parseInt(managerID.getText()),
					Integer.parseInt(managerSafeCode.getText())
					);
			mTable.createManager(manager);
			
			//Reset the text
			managerSafeCode.setText("");
			managerID.setText("");
			mWage.setText("");
			mname.setText("");

			//Refresh the other tabs to use the new manager
			RemoveItemTab.refresh();
			UpdateItemTab.refresh();
			StatisticsTab.pane.setCenter(StatisticsTab.generateChart());
			MenuTab.tab.setContent(MenuTab.newEmployee());
			HomeTab.tab.setContent(HomeTab.homeRefresh());
			}catch(Exception e1){
				
				FadeTransition fade = new FadeTransition(Duration.millis(2000), mSubmit);
				fade.setFromValue(0); //starting opacity
				fade.setToValue(1); //ending opacity (for 1 cycle)
				fade.setAutoReverse(true); //if the fade should play backwards
				fade.play();
				
				
				managerSafeCode.setPromptText("Please enter a valid value");
				managerSafeCode.setText("");
				
				managerID.setPromptText("Please enter a valid value");
				managerID.setText("");

				mWage.setPromptText("Please enter a valid value");
				mWage.setText("");
				
				mname.setPromptText("Please enter a valid value");
				mname.setText("");
			}
					
		});
		pane.add(mSubmit, 21, 6);
		
		//set up the pages content
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
	
	//Method to check which picture is used for the input given from the Picture enum
	public static String getPictureDisplay(String pic) {
		String picture = "";
		if(pic == "Beet_Salad") {
			picture = "Beet Salad.jpg";
		} else if (pic == "American_Breakfast") {
			picture = "Classic American Breakfast.jpg";
		} else if (pic == "Cocktails") {
			picture = "Cocktails.jpg";
		} else if (pic == "Coffee") {
			picture = "Coffee.jpg";
		} else if (pic == "Cucumber_Water") {
			picture = "Cucumber Water.jpg";
		} else if (pic == "Curry") {
			picture = "curry-bowl-garnished-with-greens_4460x4460.jpg";
		} else if (pic == "Sandwich") {
			picture = "hotel-room-service-sandwich_4460x4460.jpg";
		} else if (pic == "Hummus") {
			picture = "Hummus.jpg";
		} else if (pic == "Penne") {
			picture = "Penne.jpg";
		} else if (pic == "Pizza") {
			picture = "Pizza.jpg";
		} else if (pic == "Rose_Wine") {
			picture = "Rose Wine.jpg";
		} else if (pic == "Sloppy_Joe") {
			picture = "Sloppy Joe.jpg";
		} else if (pic == "Tacos") {
			picture = "Taocs.jpg";
		} else if (pic == "Waffles") {
			picture = "Waffles.jpg";
		} 
		
		return picture;
	}

}