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
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.util.Callback;
import javafx.util.Duration;

public class UpdateItemTab extends Tab {
	
	private static UpdateItemTab tab;
	
	//Create the listviews we will be needing later to display our tables
	public ListView<FoodDrink> list = new ListView<>();
	public ListView<CrewMember> elist = new ListView<>();
	public ListView<Manager> mlist = new ListView<>();
	
	private UpdateItemTab() {
		this.setText("Update");
		//Create basic layout
		GridPane pane = new GridPane();
		
		//create food title
		Text foodDrinkText = new Text("Food/Drink");
		pane.add(foodDrinkText, 1, 0);
		
		//Create a food table
		FoodTable fTable = new FoodTable();
		//Create the array that'll give us all foodDrink in our database
		ArrayList<FoodDrink> foodDrinkItems = fTable.getAllFoodDrink();
		
		//set the list with all the items in the arraylist
		list.setItems(FXCollections.observableArrayList(foodDrinkItems));
		list.setMaxWidth(300);
		list.setMaxHeight(300);
		//Change the text of the listview to show the name of each item instead of placeholder
		list.setCellFactory(new Callback<ListView<FoodDrink>, ListCell<FoodDrink>>(){
			@Override
			public ListCell<FoodDrink> call(ListView<FoodDrink> param) {
				ListCell<FoodDrink> cell = new ListCell<FoodDrink>() {
					@Override
					protected void updateItem(FoodDrink item, boolean empty) {
						super.updateItem(item, empty);
						if(item != null) {
							setText(item.getName());
						} else {
							setText(null);
						}
					}
				};
				return cell;
			}
		});
		pane.add(list, 1, 1);
		
		//Create Button for food update
		Button fUpdate = new Button("Update Food/Drink");
		fUpdate.setOnAction(e->{
			if(!list.getSelectionModel().isEmpty()) {
				FoodDrink foodDrink = list.getSelectionModel().getSelectedItem();
				getHiddenFood(pane, foodDrink, list);
				
			}
		});
		pane.add(fUpdate, 1, 2);
		
		//create employee title
		Text employeeText = new Text("Employee");
		pane.add(employeeText, 11, 0);
		
		//Create a crew member table
		CrewMemberTable cmTable = new CrewMemberTable();
		//Create the array that'll give us all crew members in our database
		ArrayList<CrewMember> cmItems = cmTable.getAllCrewMembers();
		
		//set the list with all the items in the arraylist
		elist.setItems(FXCollections.observableArrayList(cmItems));
		elist.setMaxWidth(300);
		elist.setMaxHeight(300);
		//Change the text of the listview to show the name of each employee instead of placeholder
		elist.setCellFactory(new Callback<ListView<CrewMember>, ListCell<CrewMember>>(){
			@Override
			public ListCell<CrewMember> call(ListView<CrewMember> param) {
				ListCell<CrewMember> cell = new ListCell<CrewMember>() {
					@Override
					protected void updateItem(CrewMember item, boolean empty) {
						super.updateItem(item, empty);
						if(item != null) {
							setText(item.getName());
						} else {
							setText(null);
						}
					}
				};
				return cell;
			}
		});
		pane.add(elist, 11, 1);
		
		//create button for crew member update
		Button eUpdate = new Button("Update Employee");
		eUpdate.setOnAction(e->{
			if(!elist.getSelectionModel().isEmpty()) {
				CrewMember crewMember = elist.getSelectionModel().getSelectedItem();
				getHiddenEmployees(pane, crewMember, elist);
			}
		});
		pane.add(eUpdate, 11, 2);
		
		//create manager title
		Text managerText = new Text("Manager");
		pane.add(managerText, 21, 0);
				
		//Create a manager table
		ManagerTable mTable = new ManagerTable();
		//Create the array that'll give us all managers in our database
		ArrayList<Manager> mItems = mTable.getAllManagers();
				
		//set the list with all the items in the arraylist
		mlist.setItems(FXCollections.observableArrayList(mItems));
		mlist.setMaxWidth(300);
		mlist.setMaxHeight(300);
		//Change the text of the listview to show the name of each manager instead of placeholder
		mlist.setCellFactory(new Callback<ListView<Manager>, ListCell<Manager>>(){
			@Override
			public ListCell<Manager> call(ListView<Manager> param) {
				ListCell<Manager> cell = new ListCell<Manager>() {
					@Override
					protected void updateItem(Manager item, boolean empty) {
						super.updateItem(item, empty);
						if(item != null) {
							setText(item.getName());
						} else {
							setText(null);
						}
					}
				};
				return cell;
			}
		});
		pane.add(mlist, 21, 1);
				
		//create button for manager update
		Button mUpdate = new Button("Update Manager");
		mUpdate.setOnAction(e->{
			if(!mlist.getSelectionModel().isEmpty()) {
				Manager manager = mlist.getSelectionModel().getSelectedItem();
				getHiddenManagers(pane, manager, mlist);
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
	
	public void getHiddenFood(GridPane pane, FoodDrink foodDrink, ListView list) {
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
				try {
				//Update a food item with all the new records
				foodDrink.setName(foodName.getText());
				foodDrink.setRating(rating.getSelectionModel().getSelectedItem().ordinal());
				foodDrink.setDescription(desc.getText());
				foodDrink.setPicture(AddItemTab.getPictureDisplay(picture.getSelectionModel().getSelectedItem().name()));
				foodDrink.setPrice(Double.parseDouble(price.getText()));
				foodDrink.setAmountSold(Double.parseDouble(amountSold.getText()));
				foodDrink.setMonth(month.getSelectionModel().getSelectedItem().name());
				
				
					fTable.updateFoodDrink(foodDrink);

					//update the other tabs
					RemoveItemTab.refresh();
					list.setItems(FXCollections.observableArrayList(fTable.getAllFoodDrink()));
					this.setContent(pane);
					StatisticsTab.pane.setCenter(StatisticsTab.generateChart());
					MenuTab.tab.setContent(MenuTab.newFoodDrink());
					HomeTab.tab.setContent(HomeTab.homeRefresh());
				}catch(Exception e1) {
					FadeTransition fade = new FadeTransition(Duration.millis(2000), fUpdate);
					fade.setFromValue(0); //starting opacity
					fade.setToValue(1); //ending opacity (for 1 cycle)
					fade.setAutoReverse(true); //if the fade should play backwards
					fade.play();
					
					foodName.setPromptText("Please enter a valid value");
					foodName.setText("");
					
					desc.setPromptText("Please enter a valid value");
					desc.setText("");
					
					price.setPromptText("Please enter a valid value");
					price.setText("");
					
					amountSold.setPromptText("Please enter a valid value");
					amountSold.setText("");
				}
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
	
	public void getHiddenEmployees(GridPane pane, CrewMember crewMember, ListView elist) {
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
							
				try {
				//Update the crew member
				crewMember.setName(eName.getText());
				crewMember.setWage(Double.parseDouble(wage.getText()));
				crewMember.setUniform(uniform.getSelectionModel().getSelectedItem().name());
				crewMember.setPosition(position.getSelectionModel().getSelectedItem().name());
				crewMember.setCrewMemberPunchIn(Integer.parseInt(punchIn.getText()));
				crewMember.setCrewMemberGoldStar(Integer.parseInt(goldStar.getText()));
				
				cmTable.updateCrewMember(crewMember);

				//update the other tabs
				RemoveItemTab.refresh();
				elist.setItems(FXCollections.observableArrayList(cmTable.getAllCrewMembers()));
				this.setContent(pane);
				StatisticsTab.pane.setCenter(StatisticsTab.generateChart());
				MenuTab.tab.setContent(MenuTab.newEmployee());
				HomeTab.tab.setContent(HomeTab.homeRefresh());
				}catch(Exception e1){
					

					FadeTransition fade = new FadeTransition(Duration.millis(2000), eUpdate);
					fade.setFromValue(0); //starting opacity
					fade.setToValue(1); //ending opacity (for 1 cycle)
					fade.setAutoReverse(true); //if the fade should play backwards
					fade.play();
					
					
					eName.setPromptText("Please enter a valid value");
					eName.setText("");
					
					wage.setPromptText("Please enter a valid value");
					wage.setText("");
					
					punchIn.setPromptText("Please enter a valid value");
					punchIn.setText("");
					
					goldStar.setPromptText("Please enter a valid value");
					goldStar.setText("");
				}
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
	
	public void getHiddenManagers(GridPane pane, Manager manager, ListView mlist) {
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
					
				try {
				//Update the manager
				manager.setName(mName.getText());
				manager.setWage(Double.parseDouble(wage.getText()));
				manager.setUniform(uniform.getSelectionModel().getSelectedItem().name());
				manager.setPosition(position.getSelectionModel().getSelectedItem().name());
				manager.setManagerID(Integer.parseInt(managerID.getText()));
				manager.setManagerSafeCode(Integer.parseInt(managerSC.getText()));
				
				mTable.updateManager(manager);

				//update the other tabs
				RemoveItemTab.refresh();
				mlist.setItems(FXCollections.observableArrayList(mTable.getAllManagers()));
				this.setContent(pane);
				StatisticsTab.pane.setCenter(StatisticsTab.generateChart());
				MenuTab.tab.setContent(MenuTab.newEmployee());
				HomeTab.tab.setContent(HomeTab.homeRefresh());
				}catch(Exception e1) {
					
					FadeTransition fade = new FadeTransition(Duration.millis(2000), mUpdate);
					fade.setFromValue(0); //starting opacity
					fade.setToValue(1); //ending opacity (for 1 cycle)
					fade.setAutoReverse(true); //if the fade should play backwards
					fade.play();
					
					mName.setPromptText("Please enter a valid value");
					mName.setText("");
					
					wage.setPromptText("Please enter a valid value");
					wage.setText("");
					
					managerID.setPromptText("Please enter a valid value");
					managerID.setText("");
					
					managerSC.setPromptText("Please enter a valid value");
					managerSC.setText("");
					
				}
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
	
	//Method to refresh all the listviews on updateTab
	public static void refresh() {
		FoodTable fTable = new FoodTable();
		UpdateItemTab.tab.list.setItems(FXCollections.observableArrayList(fTable.getAllFoodDrink()));
		CrewMemberTable cmTable = new CrewMemberTable();
		UpdateItemTab.tab.elist.setItems(FXCollections.observableArrayList(cmTable.getAllCrewMembers()));
		ManagerTable mTable = new ManagerTable();
		UpdateItemTab.tab.mlist.setItems(FXCollections.observableArrayList(mTable.getAllManagers()));
	}
	
}
