package tabs;
/**
 * Used to update different items that has been chosen by the user from tables chosen from the user
 * @author Stefano,Max,Tomas,Justin
 *
 */
import java.util.ArrayList;

import PlaceHolder.CrewMember;
import PlaceHolder.FoodDrink;
import PlaceHolder.Manager;
import Tables.CrewMemberTable;
import Tables.FoodTable;
import Tables.ManagerTable;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
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
		
		//Create a listVuew that'll hold a bunch of instances of food and drink
		ListView<FoodDrink> list = new ListView();
		//Create a food table
		FoodTable fTable = new FoodTable();
		//Create the array that'll give us all foodDrink in our database
		ArrayList<FoodDrink> foodDrinkItems = fTable.getAllFoodDrink();
		
		//set the list with all the items in the arraylist
		list.setItems(FXCollections.observableArrayList(foodDrinkItems));
		list.setMaxWidth(300);
		list.setMaxHeight(300);
		pane.add(list, 1, 1);
		
		//Create Button for food update
		Button fUpdate = new Button("Update Food/Drink");
		fUpdate.setOnAction(e->{
			if(!list.getSelectionModel().isEmpty()) {
				FoodDrink foodDrink = list.getSelectionModel().getSelectedItem();
				getHiddenFood(pane, foodDrink);
			}
		});
		pane.add(fUpdate, 1, 2);
		
		//create employee title
		Text employeeText = new Text("Employee");
		pane.add(employeeText, 11, 0);
		
		//Create a listView that'll hold a bunch of instances of employee
		ListView<CrewMember> elist = new ListView<CrewMember>();
		//Create a employee table
		CrewMemberTable cmTable = new CrewMemberTable();
		//Create the array that'll give us all employees in our database
		ArrayList<CrewMember> cmItems = cmTable.getAllCrewMembers();
		
		//set the list with all the items in the arraylist
		elist.setItems(FXCollections.observableArrayList(cmItems));
		elist.setMaxWidth(300);
		elist.setMaxHeight(300);
		pane.add(elist, 11, 1);
		
		//create button for employee update
		Button eUpdate = new Button("Update Employee");
		eUpdate.setOnAction(e->{
			if(!elist.getSelectionModel().isEmpty()) {
				CrewMember crewMember = elist.getSelectionModel().getSelectedItem();
				getHiddenEmployees(pane, crewMember);
			}
		});
		pane.add(eUpdate, 11, 2);
		
		//create manager title
		Text managerText = new Text("Manager");
		pane.add(managerText, 21, 0);
				
		//Create a listView that'll hold a bunch of instances of manager
		ListView<Manager> mlist = new ListView<Manager>();
		//Create a manager table
		ManagerTable mTable = new ManagerTable();
		//Create the array that'll give us all managers in our database
		ArrayList<Manager> mItems = mTable.getAllManagers();
				
		//set the list with all the items in the arraylist
		mlist.setItems(FXCollections.observableArrayList(mItems));
		mlist.setMaxWidth(300);
		mlist.setMaxHeight(300);
		pane.add(mlist, 21, 1);
				
		//create button for manager update
		Button mUpdate = new Button("Update Manager");
		mUpdate.setOnAction(e->{
			if(!mlist.getSelectionModel().isEmpty()) {
				Manager manager = mlist.getSelectionModel().getSelectedItem();
				getHiddenManagers(pane, manager);
			}
		});
		pane.add(mUpdate, 21, 2);
		
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
	
	public void getHiddenFood(GridPane pane, FoodDrink foodDrink) {
		GridPane gpane = new GridPane();
		
		//create food title
		Text foodDrinkText = new Text("Food/Drink");
		gpane.add(foodDrinkText, 1, 0);
				
		//create first row input for food
		Text foodNameText = new Text("Name:");
		TextField foodName = new TextField();
		foodName.setText(foodDrink.getName());
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
		desc.setText(foodDrink.getDescription());
		//Show the description row
		gpane.add(descText, 0, 3);
		gpane.add(desc, 1, 3);
				
		//Create insert picture row
		Text picText = new Text("Picture:");
		ComboBox<ENUMS.Pictures> picture = new ComboBox<>();
		picture.setItems(FXCollections.observableArrayList(ENUMS.Pictures.values()));
		//Show the picture row
		gpane.add(picText, 0, 4);
		gpane.add(picture, 1, 4);
				
		//Create insert price row
		Text priceText = new Text("Price:");
		TextField price = new TextField();
		price.setText(foodDrink.getPrice() + "");
		//Show the price row
		gpane.add(priceText, 0, 5);
		gpane.add(price, 1, 5);
				
		//Create insert amountSold row
		Text amountSoldText = new Text("Amount Sold:");
		TextField amountSold = new TextField();
		amountSold.setText(foodDrink.getAmountSold() + "");
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
				foodDrink.setName(foodName.getText());
				foodDrink.setRating(rating.getSelectionModel().getSelectedItem().ordinal());
				foodDrink.setDescription(desc.getText());
				foodDrink.setPicture(AddItemTab.getPictureDisplay(picture.getSelectionModel().getSelectedItem().name()));
				foodDrink.setPrice(Double.parseDouble(price.getText()));
				foodDrink.setAmountSold(Double.parseDouble(amountSold.getText()));
				foodDrink.setMonth(month.getSelectionModel().getSelectedItem().name());
				
				fTable.updateFoodDrink(foodDrink);
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
	
	public void getHiddenEmployees(GridPane pane, CrewMember crewMember) {
		GridPane gpane = new GridPane();
		
		//create employee title
		Text employeeText = new Text("Employee");
		gpane.add(employeeText, 1, 0);
				
		//create first row input for employee
		Text eNameText = new Text("Name:");
		TextField eName = new TextField();
		eName.setText(crewMember.getName());
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
		wage.setText(crewMember.getWage() + "");
		//Show the wage row
		gpane.add(wageText, 0, 4);
		gpane.add(wage, 1, 4);
						
		//Create insert punch in row
		Text punchInText = new Text("Punch-in ID:");
		TextField punchIn = new TextField();
		punchIn.setText(crewMember.getCrewMemberPunchIn() + "");
		//Show the punch in row
		gpane.add(punchInText, 0, 5);
		gpane.add(punchIn, 1, 5);
						
		//Create gold star row
		Text goldStarText = new Text("Gold Star:");
		TextField goldStar = new TextField();
		goldStar.setText(crewMember.getCrewMemberGoldStar() + "");
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
				crewMember.setName(eName.getText());
				crewMember.setWage(Double.parseDouble(wage.getText()));
				crewMember.setUniform(uniform.getSelectionModel().getSelectedItem().name());
				crewMember.setPosition(position.getSelectionModel().getSelectedItem().name());
				crewMember.setCrewMemberPunchIn(Integer.parseInt(punchIn.getText()));
				crewMember.setCrewMemberGoldStar(Integer.parseInt(goldStar.getText()));
				
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
	
	public void getHiddenManagers(GridPane pane, Manager manager) {
		GridPane gpane = new GridPane();
		
		//create manager title
		Text managerText = new Text("Manager");
		gpane.add(managerText, 1, 0);
				
		//create first row input for manager
		Text mNameText = new Text("Name:");
		TextField mName = new TextField();
		mName.setText(manager.getName());
		gpane.add(mNameText, 0, 1);
		gpane.add(mName, 1, 1);
				
		//Create insert position row
		Text positionText = new Text("Position:");
		ComboBox<ENUMS.ManagerPositions> position = new ComboBox<>();
		position.setItems(FXCollections.observableArrayList(ENUMS.ManagerPositions.values()));
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
		wage.setText(manager.getWage() + "");
		//Show the wage row
		gpane.add(wageText, 0, 4);
		gpane.add(wage, 1, 4);
						
		//Create insert manager ID row
		Text managerIDText = new Text("Manager ID:");
		TextField managerID = new TextField();
		managerID.setText(manager.getManagerID() + "");
		//Show the punch in row
		gpane.add(managerIDText, 0, 5);
		gpane.add(managerID, 1, 5);
						
		//Create gold star row
		Text managerSCText = new Text("Safety Code:");
		TextField managerSC = new TextField();
		managerSC.setText(manager.getManagerSafeCode() + "");
		//Show the gold star row
		gpane.add(managerSCText, 0, 6);
		gpane.add(managerSC, 1, 6);
				
		//create button for Manager update
		Button mUpdate = new Button("Update Manager");
		mUpdate.setOnAction(e->{
			if(!mName.getText().isEmpty()) {
				//Create an instance of the Manager table
				ManagerTable mTable = new ManagerTable();
							
				//Update the manager
				manager.setName(mName.getText());
				manager.setWage(Double.parseDouble(wage.getText()));
				manager.setUniform(uniform.getSelectionModel().getSelectedItem().name());
				manager.setPosition(position.getSelectionModel().getSelectedItem().name());
				manager.setManagerID(Integer.parseInt(managerID.getText()));
				manager.setManagerSafeCode(Integer.parseInt(managerSC.getText()));
				
				mTable.updateManager(manager);
			}
		});
		gpane.add(mUpdate, 1, 7);
		
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
