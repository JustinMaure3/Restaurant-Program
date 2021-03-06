package tabs;
/**
 * Used to remove a item of the users choosing on the table of their choosing
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
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

public class RemoveItemTab extends Tab {
	
	private static RemoveItemTab tab;
	
	public ListView<FoodDrink> list = new ListView<FoodDrink>();
	public ListView<CrewMember> elist = new ListView<CrewMember>();
	public ListView<Manager> mlist = new ListView<Manager>();

	private RemoveItemTab() {
		this.setText("Remove");
		
		GridPane gpane = new GridPane();
		
		
		
		//Create a button to launch to remove food/Drink form
		Button removeF = new Button("Remove Food/Drink");
		removeF.setOnAction(e->{
			//Create the layout
			BorderPane pane = new BorderPane();
			//Create a food table
			FoodTable fTable = new FoodTable();
			//Create the array that'll give us all foodDrink in our database
			ArrayList<FoodDrink> foodDrinkItems = fTable.getAllFoodDrink();
		
			//set the list with all the items in the arraylist
			list.setItems(FXCollections.observableArrayList(foodDrinkItems));
			list.setMaxWidth(600);
			list.setMaxHeight(600);
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
			pane.setCenter(list);
			
			
			//Create the remove button
			Button remove = new Button("Remove");
			remove.setOnAction(e1->{
				FoodDrink foodItem = list.getSelectionModel().getSelectedItem();
				fTable.deleteFoodDrink(foodItem);
				list.setItems(FXCollections.observableArrayList(fTable.getAllFoodDrink()));
				UpdateItemTab.refresh();
				RemoveItemTab.refresh();
				StatisticsTab.pane.setCenter(StatisticsTab.generateChart());
				MenuTab.tab.setContent(MenuTab.newFoodDrink());
				StatisticsTab.pane.setCenter(StatisticsTab.generateChart());

				HomeTab.tab.setContent(HomeTab.homeRefresh());
			});
			remove.setMaxWidth(200);
			pane.setBottom(remove);
			pane.setAlignment(remove, Pos.CENTER);
			
			//Create Back button
			Button back = new Button("Back");
			back.setOnAction(e1->{
				this.setContent(gpane);
			});
			back.setMaxWidth(200);
			pane.setTop(back);
			pane.setAlignment(back, Pos.CENTER);
			
			this.setContent(pane);
		});
		
		//Create button for the remove employee form
		Button removeE = new Button("Remove Employee");
		removeE.setOnAction(e->{
			//Create the layout
			BorderPane pane = new BorderPane();
			//Create a crew member table
			CrewMemberTable cmTable = new CrewMemberTable();
			//Create the array that'll give us all crew members in our database
			ArrayList<CrewMember> cmItems = cmTable.getAllCrewMembers();
			
			
			
			//set the list with all the items in the arraylist
			elist.setItems(FXCollections.observableArrayList(cmItems));
			elist.setMaxWidth(600);
			elist.setMaxHeight(600);
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
			pane.setCenter(elist);
			
			
			//Create the remove button
			Button remove = new Button("Remove");
			remove.setOnAction(e1->{
				CrewMember crewMember = elist.getSelectionModel().getSelectedItem();
				cmTable.deleteCrewMember(crewMember);
				elist.setItems(FXCollections.observableArrayList(cmTable.getAllCrewMembers()));
				UpdateItemTab.refresh();
				RemoveItemTab.refresh();
				StatisticsTab.pane.setCenter(StatisticsTab.generateChart());
				MenuTab.tab.setContent(MenuTab.newEmployee());
				StatisticsTab.pane.setCenter(StatisticsTab.generateChart());

				HomeTab.tab.setContent(HomeTab.homeRefresh());
			});
			remove.setMaxWidth(200);
			pane.setBottom(remove);
			pane.setAlignment(remove, Pos.CENTER);
			
			//Create Back button
			Button back = new Button("Back");
			back.setOnAction(e1->{
				this.setContent(gpane);
			});
			back.setMaxWidth(200);
			pane.setTop(back);
			pane.setAlignment(back, Pos.CENTER);
			
			this.setContent(pane);
		});
		
		//Create button for the remove Manager form
		Button removeM = new Button("Remove Manager");
		removeM.setOnAction(e->{
			//Create the layout
			BorderPane pane = new BorderPane();
			//Create a manager table
			ManagerTable mTable = new ManagerTable();
			//Create the array that'll give us all managers in our database
			ArrayList<Manager> mItems = mTable.getAllManagers();
					
			//set the list with all the items in the arraylist and display it
			mlist.setItems(FXCollections.observableArrayList(mItems));
			mlist.setMaxWidth(600);
			mlist.setMaxHeight(600);
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
			pane.setCenter(mlist);
					
					
			//Create the remove button
			Button remove = new Button("Remove");
			remove.setOnAction(e1->{
				Manager manager = mlist.getSelectionModel().getSelectedItem();
				mTable.deleteManager(manager);
				mlist.setItems(FXCollections.observableArrayList(mTable.getAllManagers()));
				UpdateItemTab.refresh();
				RemoveItemTab.refresh();
				StatisticsTab.pane.setCenter(StatisticsTab.generateChart());
				StatisticsTab.pane.setCenter(StatisticsTab.generateChart());
				MenuTab.tab.setContent(MenuTab.newEmployee());
				StatisticsTab.pane.setCenter(StatisticsTab.generateChart());

				HomeTab.tab.setContent(HomeTab.homeRefresh());
			});
			remove.setMaxWidth(200);
			pane.setBottom(remove);
			pane.setAlignment(remove, Pos.CENTER);
					
			//Create Back button
			Button back = new Button("Back");
			back.setOnAction(e1->{
				this.setContent(gpane);
			});
			back.setMaxWidth(200);
			pane.setTop(back);
			pane.setAlignment(back, Pos.CENTER);
					
			this.setContent(pane);
		});
		
		//set the three buttons on a grid pane
		gpane.add(removeF, 31, 28);
		gpane.add(removeE, 32, 28);
		gpane.add(removeM, 33, 28);
		
		gpane.setPadding(new Insets(10, 10, 10, 10));
		gpane.setVgap(10);
		gpane.setHgap(10);
		this.setContent(gpane);
	}
	public static RemoveItemTab getInstance() {
		if(tab == null) {
			tab = new RemoveItemTab();
		}
		return tab;
	}
	
	public static void refresh() {
		FoodTable fTable = new FoodTable();
		RemoveItemTab.tab.list.setItems(FXCollections.observableArrayList(fTable.getAllFoodDrink()));
		CrewMemberTable cmTable = new CrewMemberTable();
		RemoveItemTab.tab.elist.setItems(FXCollections.observableArrayList(cmTable.getAllCrewMembers()));
		ManagerTable mTable = new ManagerTable();
		RemoveItemTab.tab.mlist.setItems(FXCollections.observableArrayList(mTable.getAllManagers()));
	}
}
