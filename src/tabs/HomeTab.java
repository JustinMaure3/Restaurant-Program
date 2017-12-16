package tabs;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class HomeTab extends Tab {

	public HomeTab() {
		this.setText("Home");
		
		Label restName = new Label("Dinner Diner");
		Label popName = new Label();
		
		Button next = new Button("Next");
		Button prev = new Button("Prev");
		
		Text desc = new Text();
		
		HBox title = new HBox();
		
		
		title.getChildren().add(restName);
		this.setContent(title);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
