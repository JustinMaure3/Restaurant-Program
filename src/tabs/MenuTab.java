package tabs;
import java.awt.Color;
/**
 * Displays the database table depending on what table they wanted to see
 * @author Stefano,Max,Tomas,Justin
 *
 */
import java.util.ArrayList;
import PlaceHolder.CrewMember;
import PlaceHolder.FoodDrink;
import PlaceHolder.Manager;
import PlaceHolder.StoreLocations;
import Tables.CrewMemberTable;
import Tables.FoodTable;
import Tables.ManagerTable;
import Tables.StoreLocationsTable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;



public class MenuTab extends Tab {	

	public static String displayedTable = "Food";
	public static VBox check = new VBox(newFoodDrink());
	
	public static MenuTab tab;	

	private MenuTab() {
		this.setText("Menu");
		ScrollPane pane = new ScrollPane();

		pane.setPadding(new Insets(10, 10, 10, 10));
			this.setContent(check);
		
	}
	
	
	public static MenuTab getInstance() {
		if(tab == null) {
			tab = new MenuTab();
		}
		return tab;
	}
	
	public static VBox newFoodDrink() {
		VBox data = new VBox();		
		//If statement checking what table is selected
		MenuTab.displayedTable = "food";	

		//Create an arraylist
		FoodTable menuItems = new FoodTable();
		
		//Populate the arraylist with the database contents
		ArrayList<FoodDrink> foodDrinkItems = menuItems.getAllFoodDrink();
		
		//Create an HBox to hold the information about the current food item
		HBox newItemFood = new HBox();
		
		//Create a VBoxes that will act as the columns of the table
		VBox foodNameColumn = new VBox();
		foodNameColumn.setSpacing(10.0);
		VBox ratingColumn = new VBox();
		ratingColumn.setSpacing(10.0);
		VBox descriptionColumn = new VBox();
		descriptionColumn.setSpacing(10.0);
		VBox pictureColumn = new VBox();
		pictureColumn.setPadding(new Insets(5, 5, 5, 5));
		VBox priceColumn = new VBox();
		priceColumn.setSpacing(10.0);
		VBox amountSoldColumn = new VBox();
		amountSoldColumn.setSpacing(10.0);
		
		//Create titles for each column
		Text foodNameTitle = new Text("Name");
		foodNameColumn.getChildren().addAll(foodNameTitle);
		
		Text ratingTitle = new Text("Rating");
		ratingColumn.getChildren().addAll(ratingTitle);
		
		Text descriptionTitle = new Text("Description");
		descriptionColumn.getChildren().addAll(descriptionTitle);
		
		Text pictureTitle = new Text("Picture");
		pictureColumn.getChildren().addAll(pictureTitle);
		pictureColumn.setPadding(new Insets(0, 0, 0, 15));
		
		
		Text priceTitle = new Text("Price");
		priceColumn.getChildren().addAll(priceTitle);
		
		Text amountSoldTitle = new Text("Amount Sold");
		amountSoldColumn.getChildren().addAll(amountSoldTitle);
		

		Font subTitleFont = Font.font("Times New Roman", FontPosture.REGULAR, 25);
		foodNameTitle.setFont(subTitleFont);
		ratingTitle.setFont(subTitleFont);
		descriptionTitle.setFont(subTitleFont);
		pictureTitle.setFont(subTitleFont);
		priceTitle.setFont(subTitleFont);
		amountSoldTitle.setFont(subTitleFont);
		
		//Loop to set the contents of the arraylist to their own panes
		int i = 0;
		while(i < foodDrinkItems.size()){
			
			//Create objects to hold the food's information and then add them to the HBox
			Text foodName = new Text("  " + foodDrinkItems.get(i).getName() + "  ");
			foodNameColumn.getChildren().addAll(foodName);
			
			Text foodRating = new Text(foodDrinkItems.get(i).getRating() + "  ");
			ratingColumn.getChildren().addAll(foodRating);
			
			Text foodDescription = new Text(foodDrinkItems.get(i).getDescription() + "  ");
			descriptionColumn.getChildren().addAll(foodDescription);
			
			ImageView foodPicture = new ImageView("Pictures/" + foodDrinkItems.get(i).getPicture());
			pictureColumn.getChildren().addAll(foodPicture);
			foodPicture.setFitHeight(30);
			foodPicture.setFitWidth(30);
			
			Text foodPrice = new Text(foodDrinkItems.get(i).getPrice() + "  ");
			priceColumn.getChildren().addAll(foodPrice);
			
			Text foodAmountSold = new Text("  " + foodDrinkItems.get(i).getAmountSold() + "  ");
			amountSoldColumn.getChildren().addAll(foodAmountSold);
			
			//Increment i
			i++;
		}
		
		//pictureColumn.setStyle("-fx-border-style: solid inside;");
		//Add all of the info into the hbox
		newItemFood.getChildren().addAll(pictureColumn, foodNameColumn, ratingColumn, descriptionColumn, priceColumn, amountSoldColumn);
		
		//Add the HBox to the VBox
		data.getChildren().add(newItemFood);
		return data;
	}
	
	
	public static VBox newEmployee() {
		VBox data = new VBox();	
		MenuTab.displayedTable = "employees";
		//Create an arraylist
		CrewMemberTable employeeList = new CrewMemberTable();
		
		//Populate the arraylist with the database contents
		ArrayList<CrewMember> crewMemberItems = employeeList.getAllCrewMembers();
		
		//Create an HBox to hold the information about the current food item
		HBox newItemCrew = new HBox();
		
		//Create a VBoxes that will act as the columns of the table
		VBox nameColumn = new VBox();
		nameColumn.setSpacing(10.0);
		nameColumn.setPadding(new Insets(0, 0, 0, 15));
		VBox wageColumn = new VBox();
		wageColumn.setSpacing(10.0);
		VBox uniformColumn = new VBox();
		uniformColumn.setSpacing(10.0);
		VBox positionColumn = new VBox();
		positionColumn.setSpacing(10.0);
		VBox crewMemberPunchInColumn = new VBox();
		crewMemberPunchInColumn.setSpacing(10.0);
		VBox crewMemberGoldStarColumn = new VBox();
		crewMemberGoldStarColumn.setSpacing(10.0);
		
		//Create titles for each column
		Text nameTitle = new Text("Name");
		nameColumn.getChildren().addAll(nameTitle);
		
		Text wageTitle = new Text("Wage");
		wageColumn.getChildren().addAll(wageTitle);
		
		Text uniformTitle = new Text("Uniform");
		uniformColumn.getChildren().addAll(uniformTitle);
		
		Text positionTitle = new Text("Position");
		positionColumn.getChildren().addAll(positionTitle);
		
		Text crewMemberPunchInTitle = new Text("Punch In Number");
		crewMemberPunchInColumn.getChildren().addAll(crewMemberPunchInTitle);
		
		Text crewMemberGoldStarTitle = new Text("Gold Stars");
		crewMemberGoldStarColumn.getChildren().addAll(crewMemberGoldStarTitle);
		
		Font subTitleFont = Font.font("Times New Roman", FontPosture.REGULAR, 25);
		nameTitle.setFont(subTitleFont);
		wageTitle.setFont(subTitleFont);
		positionTitle.setFont(subTitleFont);
		uniformTitle.setFont(subTitleFont);
		crewMemberPunchInTitle.setFont(subTitleFont);
		crewMemberGoldStarTitle.setFont(subTitleFont);
		
		//Loop to set the contents of the arraylist to their own panes
		int i = 0;
		while(i < crewMemberItems.size()){				
			
			//Create objects to hold the food's information and then add them to the HBox
			Text empName = new Text("  " + crewMemberItems.get(i).getName() + "  ");
			nameColumn.getChildren().addAll(empName);
			
			Text empWage = new Text(crewMemberItems.get(i).getWage() + "  ");
			wageColumn.getChildren().addAll(empWage);
			
			Text empUniform = new Text(crewMemberItems.get(i).getUniform() + "  ");
			uniformColumn.getChildren().addAll(empUniform);
			
			Text empPosition = new Text(crewMemberItems.get(i).getPosition() + "  ");
			positionColumn.getChildren().addAll(empPosition);
			
			Text crewMemberPunchIn = new Text(crewMemberItems.get(i).getCrewMemberPunchIn() + "  ");
			crewMemberPunchInColumn.getChildren().addAll(crewMemberPunchIn);
			
			Text crewMemberGoldStar = new Text("  " + crewMemberItems.get(i).getCrewMemberGoldStar() + "  ");
			crewMemberGoldStarColumn.getChildren().addAll(crewMemberGoldStar);				
		
			//Increment i
			i++;
		}
		
		//Add all of the info into the hbox
		newItemCrew.getChildren().addAll(nameColumn, wageColumn, uniformColumn, positionColumn, crewMemberPunchInColumn, crewMemberGoldStarColumn);
		
		//Add the HBox to the VBox
		data.getChildren().add(newItemCrew);
		
		VBox dataTwo = new VBox();
		//Create an arraylist
		ManagerTable managerList = new ManagerTable();
		
		//Populate the arraylist with the database contents
		ArrayList<Manager> managerItems = managerList.getAllManagers();	
		
		//Create an HBox to hold the information about the current food item
		HBox newItemManager = new HBox();
		
		//Create a VBoxes that will act as the columns of the table
		VBox managerNameColumn = new VBox();
		managerNameColumn.setSpacing(10.0);
		managerNameColumn.setPadding(new Insets(0, 0, 0, 15));
		VBox managerWageColumn = new VBox();
		managerWageColumn.setSpacing(10.0);
		VBox managerUniformColumn = new VBox();
		managerUniformColumn.setSpacing(10.0);
		VBox managerPositionColumn = new VBox();
		managerPositionColumn.setSpacing(10.0);
		VBox managerIDColumn = new VBox();
		managerIDColumn.setSpacing(10.0);
		VBox managerSafeCodeColumn = new VBox();
		managerSafeCodeColumn.setSpacing(10.0);
		
		//Create titles for each column
		Text managerNameTitle = new Text("Name");
		managerNameColumn.getChildren().addAll(managerNameTitle);
		
		Text managerWageTitle = new Text("Wage");
		managerWageColumn.getChildren().addAll(managerWageTitle);
		
		Text managerUniformTitle = new Text("Uniform");
		managerUniformColumn.getChildren().addAll(managerUniformTitle);
		
		Text managerPositionTitle = new Text("Position");
		managerPositionColumn.getChildren().addAll(managerPositionTitle);
		
		Text managerIDTitle = new Text("Manager ID");
		managerIDColumn.getChildren().addAll(managerIDTitle);
		
		Text managerSafeCodeTitle = new Text("Manager Safe Code");
		managerSafeCodeColumn.getChildren().addAll(managerSafeCodeTitle);
		
		managerNameTitle.setFont(subTitleFont);
		managerWageTitle.setFont(subTitleFont);
		managerUniformTitle.setFont(subTitleFont);
		managerPositionTitle.setFont(subTitleFont);
		managerIDTitle.setFont(subTitleFont);
		managerSafeCodeTitle.setFont(subTitleFont);
		
		//Loop to set the contents of the arraylist to their own panes
		int e1 = 0;
		while(e1 < managerItems.size()){
			
			//Create objects to hold the food's information and then add them to the HBox
			Text name = new Text("  " + managerItems.get(e1).getName() + "  ");
			managerNameColumn.getChildren().addAll(name);
			
			Text wage = new Text(managerItems.get(e1).getWage() + "  ");
			managerWageColumn.getChildren().addAll(wage);
			
			Text uniform = new Text(managerItems.get(e1).getUniform() + "  ");
			managerUniformColumn.getChildren().addAll(uniform);
			
			Text position = new Text(managerItems.get(e1).getPosition() + "  ");
			managerPositionColumn.getChildren().addAll(position);
			
			Text managerID = new Text(managerItems.get(e1).getManagerID() + "  ");
			managerIDColumn.getChildren().addAll(managerID);
			
			Text managerSafeCode = new Text("  " + managerItems.get(e1).getManagerSafeCode() + "  ");
			managerSafeCodeColumn.getChildren().addAll(managerSafeCode);				
			
			//Increment i
			e1++;
		}
		
		//Add all of the info into the hbox
		newItemManager.getChildren().addAll(managerNameColumn, managerWageColumn, managerUniformColumn, managerPositionColumn, managerIDColumn, managerSafeCodeColumn);

		//Add the HBox to the VBox
		dataTwo.getChildren().add(newItemManager);
			VBox all = new VBox();
			all.getChildren().addAll(data,dataTwo);
			
		return all;
	}
	
public static VBox newLocations() {
	
	MenuTab.displayedTable = "locations";
	
	VBox locationData = new VBox();
	//Create an arraylist
	StoreLocationsTable locationsList = new StoreLocationsTable();
	
	//Populate the arraylist with the database contents
	ArrayList<StoreLocations> locationItems = locationsList.getAllStoreLocations();	
	
	//Create an HBox to hold the information about the current food item
	HBox newItemLocations = new HBox();
	
	//Create a VBoxes that will act as the columns of the table
	VBox locationColumn = new VBox();
	locationColumn.setSpacing(10.0);
	locationColumn.setPadding(new Insets(0, 0, 0, 15));
	VBox santScoreColumn = new VBox();
	santScoreColumn.setSpacing(10.0);
	VBox regionalManColumn = new VBox();
	regionalManColumn.setSpacing(10.0);
	VBox custReviewColumn = new VBox();
	custReviewColumn.setSpacing(10.0);
	
	//Create titles for each column
	Text locationTitle = new Text("Location");
	locationColumn.getChildren().addAll(locationTitle);
	
	Text santScoreTitle = new Text("Sanitation Score");
	santScoreColumn.getChildren().addAll(santScoreTitle);
	
	Text regionalManTitle = new Text("Regional Manager");
	regionalManColumn.getChildren().addAll(regionalManTitle);
	
	Text custReviewTitle = new Text("Customer Review");
	custReviewColumn.getChildren().addAll(custReviewTitle);
	

	Font subTitleFont = Font.font("Times New Roman", FontPosture.REGULAR, 25);
	locationTitle.setFont(subTitleFont);
	santScoreTitle.setFont(subTitleFont);
	regionalManTitle.setFont(subTitleFont);
	custReviewTitle.setFont(subTitleFont);
	
	//Loop to set the contents of the arraylist to their own panes
	int e1 = 0;
	while(e1 < locationItems.size()){
		
		//Create objects to hold the food's information and then add them to the HBox
		Text location = new Text("  " + locationItems.get(e1).getLocation() + "  ");
		locationColumn.getChildren().addAll(location);
		
		Text santScore = new Text(locationItems.get(e1).getSantScore() + "  ");
		santScoreColumn.getChildren().addAll(santScore);
		
		Text regionalMan = new Text(locationItems.get(e1).getRegionalMan() + "  ");
		regionalManColumn.getChildren().addAll(regionalMan);
		
		Text custReview = new Text(locationItems.get(e1).getCustReview() + "  ");
		custReviewColumn.getChildren().addAll(custReview);
		
		//Increment i
		e1++;
	}
	//Add all of the info into the hbox
	newItemLocations.getChildren().addAll(locationColumn, santScoreColumn, regionalManColumn, custReviewColumn);

	//Add the HBox to the VBox
	locationData.getChildren().add(newItemLocations);
	return locationData;
	
}

}




