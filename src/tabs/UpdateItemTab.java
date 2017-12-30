package tabs;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class UpdateItemTab extends Tab {
	
	private static UpdateItemTab tab;
	
	private UpdateItemTab() {
		this.setText("Update Item");
		//Create basic layout
		GridPane pane = new GridPane();
		
		//create food title
		Text foodDrinkText = new Text("Food/Drink");
		pane.add(foodDrinkText, 1, 0);
		
		//create first row input for food
		Text foodNameText = new Text("Name:");
		TextField foodName = new TextField();
		pane.add(foodNameText, 0, 1);
		pane.add(foodName, 1, 1);
		
		//Create Button for food update
		Button fUpdate = new Button("Update Food/Drink");
		fUpdate.setOnAction(e->{
			
		});
		pane.add(fUpdate, 1, 2);
		
		//create employee title
		Text employeeText = new Text("Employee");
		pane.add(employeeText, 11, 0);
		
		//create first row input for employee
		Text eNameText = new Text("Name:");
		TextField eName = new TextField();
		pane.add(eNameText, 10, 1);
		pane.add(eName, 11, 1);
		
		//create button for employee update
		Button eUpdate = new Button("Update Employee");
		eUpdate.setOnAction(e->{
			
		});
		pane.add(eUpdate, 11, 2);
		
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
}
