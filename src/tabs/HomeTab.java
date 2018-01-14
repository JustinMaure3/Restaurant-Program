package tabs;
<<<<<<< HEAD
<<<<<<< HEAD
=======

=======
/**
 * Hometab displays employee of the year and fooddrink of the year and displays a random tip
 * @author Stefano,Max,Tomas,Justin
 *
 */
>>>>>>> 5e56a841696a57729f55521f2e8f58d3fc1f9d21
import java.util.Random;
>>>>>>> 57bb8cc65d12063f5d4d458b25a00ebe2cd3c05c
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
<<<<<<< HEAD

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
        ImageView foodImage = new ImageView("Pictures/star.png");
        //If its empty then we now have a default value preventing crashes
        if(topFoodItem.getName() == null ) {
             popName = new Text("There seems to be no top food please enter one");
        }

        //If its empty we now have a default value preventing crashes
        if(topCrewMember.getName() == null) {
            empName = new Text("There seems to be no employee of the year sorry!");
        }

        //Setting size of food images
        foodImage.setFitHeight(300);
        foodImage.setFitWidth(350);

        Random r = new Random();
int randomTip = r.nextInt(3);


        //Tip for the restaurant
        Text tipText = new Text("RANDOM TIP I WILL BE GENERATING VERY SHORTLY");

        //Switch case changes everytime the app opens
        switch(randomTip){
        case 0:
            tipText = new Text("If a food item is not selling a great idea is to remove the item from the menu and maybe try another item");
            break;

        case 1:
            tipText = new Text("If an employee goes above and beyond their work give them a gold star to show you appreciate them!");
            break;

        case 2:
            tipText = new Text("Running out of supplies? Check out the locations table to find a location for one of our branches");
            break;

            default:
                tipText = new Text("We seen to not have any tips for you at the moment");
                break;
        }

        tipText.setTextAlignment(CENTER);
        //HBox containing the title of the restaurant
        VBox main = new VBox();
        HBox title = new HBox();
        VBox foodTitlePic = new VBox();
        HBox foodTitle = new HBox();
        HBox foodPicture = new HBox();
        HBox tip = new HBox();
        HBox emp = new HBox();

        title.setPadding(new Insets(25, 0, 0, 0));
        foodTitle.setPadding(new Insets(15, 0, 0, 0));
        foodPicture.setPadding(new Insets(5, 0, 5, 0));
        emp.setPadding(new Insets(15, 0, 25, 0));

        //Font specifically for the title
        Font titleFont = Font.font("Times New Roman",FontPosture.REGULAR, 40);
        Font tipFont = Font.font("Times New Roman", FontPosture.ITALIC, 20);
        Font subTitleFont = Font.font("Times New Roman", FontPosture.REGULAR, 25);
        restName.setFont(titleFont);
        popName.setFont(subTitleFont);
        empName.setFont(subTitleFont);
        tipText.setFont(tipFont);
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
=======
	
	private static HomeTab tab;
	public static TextAlignment CENTER;
	private HomeTab() {
		this.setText("Home");
		
		FoodTable menuItems = new FoodTable();
		CrewMemberTable crewMember = new CrewMemberTable();
		
		FoodDrink topFoodItem = menuItems.getTopFoodDrink(1);
		CrewMember topCrewMember = crewMember.getCrewMemberOfMonth(1);
		
		//Restaurant name and the popular foodname and employee of the month 
		Text restName = new Text("Dinner Diner");
		
		
		Text popName = new Text("There seems to be no top food at the moment. Why not enter one using the add item tab?");//Here would grab the most popular food item name
		Text empName = new Text("There seems to be no employee of the month. Why not enter one using the add item tab?");
		
		if((topCrewMember.getName() != null) && (topFoodItem.getName() != null)) {
		 popName = new Text(topFoodItem.getName() + " is the best selling item this year!");//Here would grab the most popular food item name
		 empName = new Text(topCrewMember.getName() + " is the top employee of this year!");
		}
		
		//ImageViews
		ImageView foodImage = new ImageView("Pictures/" + topFoodItem.getPicture());
		//If its empty then we now have a default value preventing crashes
		if(topFoodItem.getName() == null ) {
			 popName = new Text("There seems to be no top food please enter one");
			 foodImage = new ImageView("Pictures/star.png");
		}
		
		//If its empty we now have a default value preventing crashes
		if(topCrewMember.getName() == null) {
			empName = new Text("There seems to be no employee of the year sorry!");
		}
		
		//Setting size of food images
		foodImage.setFitHeight(300);
		foodImage.setFitWidth(350);
		
		Random r = new Random();
		
		int randomTip = r.nextInt(3);
		

		//Tip for the restaurant
		Text tipText = new Text("RANDOM TIP I WILL BE GENERATING VERY SHORTLY");
		
		//Switch case changes everytime the app opens
		switch(randomTip){
		case 0:
			tipText = new Text("If a food item is not selling a great idea is to remove the item from the menu and maybe try another item");
			break;
			
		case 1:
			tipText = new Text("If an employee goes above and beyond their work give them a gold star to show you appreciate them!");
			break;
			
		case 2:
			tipText = new Text("Running out of supplies? Check out the locations table to find a location for one of our branches");
			break;
			
			default:
				tipText = new Text("We seen to not have any tips for you at the moment");
				break;
		}
		
		tipText.setTextAlignment(CENTER);
		//HBox containing the title of the restaurant
		VBox main = new VBox();
		HBox title = new HBox();
		VBox foodTitlePic = new VBox();
		HBox foodTitle = new HBox();
		HBox foodPicture = new HBox();
		HBox tip = new HBox();
		HBox emp = new HBox();
		
		title.setPadding(new Insets(25, 0, 0, 0));
		foodTitle.setPadding(new Insets(15, 0, 0, 0));
		foodPicture.setPadding(new Insets(5, 0, 5, 0));
		emp.setPadding(new Insets(15, 0, 25, 0));
		
		//Font specifically for the title
		Font titleFont = Font.font("Times New Roman",FontPosture.REGULAR, 40);
		Font tipFont = Font.font("Times New Roman", FontPosture.ITALIC, 20);
		Font subTitleFont = Font.font("Times New Roman", FontPosture.REGULAR, 25);
		restName.setFont(titleFont);
		popName.setFont(subTitleFont);
		empName.setFont(subTitleFont);
		tipText.setFont(tipFont);
		
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
>>>>>>> 57bb8cc65d12063f5d4d458b25a00ebe2cd3c05c
