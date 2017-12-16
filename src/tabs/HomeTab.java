package tabs;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;

public class HomeTab extends Tab {

	public HomeTab() {
		this.setText("Home");
		
		//Restaurant name and the name of the popular food
		Text restName = new Text("Dinner Diner");
		Text popName = new Text();
		
		//Buttons that will let you go through the foods
		Button next = new Button("Next");
		Button prev = new Button("Prev");
		
		//description of the Restaurant
		Text desc = new Text();
		
		//HBox containing the title of the restaurant
		HBox title = new HBox();
		
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
