package tabs;

import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class StatisticsTab extends Tab{

	public StatisticsTab() {
		this.setText("Statistics");
		
		//This GridPane will contain the content
		GridPane pane = new GridPane();
		
		//Text for the ComboBox named monthBox "Monthly Stats"
		Text monthBox = new Text("Monthly Stats");
		pane.add(monthBox, 0, 0);
		
		//ComboBox for the MonthlyStats
		ComboBox<ENUMS.MonthlyStats> monthComboBox = new ComboBox<>();
		
		
		pane.setPadding(new Insets(10,10,10,10));
		pane.setVgap(10);
		pane.setHgap(10);
		this.setContent(pane);
	}
}
