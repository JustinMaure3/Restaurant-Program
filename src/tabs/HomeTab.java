package tabs;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;

public class HomeTab extends Tab {

	public HomeTab() {
		this.setText("Home");
		
		//Restaurant name and the popular foodname and employee of the month 
		Text restName = new Text("Dinner Diner");
		Text popName = new Text();
		Text empName = new Text();
		
		//Tip for the restaurant
		Text tipText = new Text();
		
		//HBox containing the title of the restaurant
		VBox main = new VBox();
		HBox title = new HBox();
		HBox empFood = new HBox();
		HBox tip = new HBox();
		
		//Font specifically for the title
		Font titleFont = Font.font("Times New Roman", FontPosture.REGULAR, 30);
		restName.setFont(titleFont);
		//Adding the title to the HBox then setting some padding and setting the title to the center top
		title.getChildren().add(restName);
		title.setAlignment(Pos.TOP_CENTER);
		title.setPadding(new Insets(25, 0, 0, 0));
		
		
		
		this.setContent(title);
		
		
		
	}
	
}
