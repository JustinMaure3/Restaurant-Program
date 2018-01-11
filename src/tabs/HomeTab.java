package tabs;

import java.util.ArrayList;
import java.util.Random;

import PlaceHolder.CrewMember;
import PlaceHolder.FoodDrink;
import Tables.CrewMemberTable;
import Tables.FoodTable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Tab;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class HomeTab extends Tab {
	
	private static HomeTab tab;
	public static TextAlignment CENTER;
	private HomeTab() {
		this.setText("Home");
		
		FoodTable menuItems = new FoodTable();
		CrewMemberTable crewMember = new CrewMemberTable();
		
		FoodDrink topFoodItem = menuItems.getTopFoodDrink(1);
		CrewMember topCrewMember = crewMember.getCrewMemberOfMonthk(1);
		
		//Restaurant name and the popular foodname and employee of the month 
		Text restName = new Text("Dinner Diner");
		Text popName = new Text(topFoodItem.getName() + " is the best selling item this year!");//Here would grab the most popular food item name
		Text empName = new Text(topCrewMember.getName() + " is the top employee of this year!");
		
		//ImageViews
		ImageView foodImage = new ImageView("Pictures/" + topFoodItem.getPicture());
		
		foodImage.setFitHeight(300);
		foodImage.setFitWidth(300);
		
		Random r = new Random();
		
		int randomTip = r.nextInt(3);
		

		//Tip for the restaurant
		Text tipText = new Text("RANDOM TIP I WILL BE GENERATING VERY SHORTLY");
		
		switch(randomTip){
		case 0:
			tipText = new Text("If a food item is not selling a great idea is to remove \nthe item from the menu and maybe try another item");
			break;
			
		case 1:
			tipText = new Text("If an employee goes above and beyond their work give \nthem a gold star to show you appreciate them!");
			break;
			
		case 2:
			tipText = new Text("Running out of supplies? Check out the locations table to find a location for one of our branches");
			break;
			
			default:
				tipText = new Text("We seen to not have any tips for you at the moment");
				break;
		}
		
		//HBox containing the title of the restaurant
		VBox main = new VBox();
		HBox title = new HBox();
		VBox foodTitlePic = new VBox();
		HBox foodTitle = new HBox();
		HBox foodPicture = new HBox();
		HBox tip = new HBox();
		HBox emp = new HBox();
		
		//Font specifically for the title
		Font titleFont = Font.font("Times New Roman", FontPosture.REGULAR, 30);
		Font subTitleFont = Font.font("Times New Roman", FontPosture.REGULAR, 25);
		restName.setFont(titleFont);
		popName.setFont(subTitleFont);
		empName.setFont(subTitleFont);
		tipText.setFont(subTitleFont);
		
		tipText.setTextAlignment(CENTER);
		//Adding the title to the HBox then setting some padding and setting the title to the center top
		title.getChildren().add(restName);
		title.setAlignment(Pos.TOP_CENTER);
		title.setPadding(new Insets(25, 0, 0, 0));
		
		foodTitle.getChildren().add(popName);
		foodPicture.getChildren().add(foodImage);
		
		foodTitle.setAlignment(Pos.CENTER);
		foodPicture.setAlignment(Pos.CENTER);
		foodTitlePic.getChildren().addAll(foodTitle, foodPicture);
		
		tip.getChildren().add(tipText);
		tip.setAlignment(Pos.CENTER);
		
		emp.getChildren().add(empName);
		emp.setAlignment(Pos.CENTER);
		
		//Everything will be added to the main and it will go from top to bottom
		main.getChildren().addAll(title,foodTitlePic,emp, tip);
		
		this.setContent(main);
		
		
		
	}
	
	public static HomeTab getInstance() {
		if(tab == null) {
			tab = new HomeTab();
		}
		return tab;
	}
	
}
