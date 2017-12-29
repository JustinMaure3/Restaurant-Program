package tabs;



import javafx.collections.FXCollections;

import javafx.geometry.Insets;

import javafx.scene.control.Button;

import javafx.scene.control.ComboBox;

import javafx.scene.control.Tab;

import javafx.scene.layout.GridPane;

import javafx.scene.text.Text;



public class StatisticsTab extends Tab{

	private static StatisticsTab tab;

	private StatisticsTab() {

		this.setText("Statistics");

		

		//This GridPane will contain the content

		GridPane pane = new GridPane();

		

		//Text for the ComboBox named monthBox "Monthly Stats"

		Text monthBoxText = new Text("Monthly Stats: ");

		pane.add(monthBoxText, 0, 0);

		

		//ComboBox for the MonthlyStats

		ComboBox<ENUMS.MonthlyStats> monthComboBox = new ComboBox<>();

		

		//Set the months to the monthComboBox

		monthComboBox.setItems(FXCollections.observableArrayList(ENUMS.MonthlyStats.values()));

		pane.add(monthComboBox, 1, 0);

		

		Button goBtn = new Button("GO");

		pane.add(goBtn, 0, 1);

		

		pane.setPadding(new Insets(10,10,10,10));

		pane.setVgap(10);

		pane.setHgap(10);

		this.setContent(pane);

	}
	public static StatisticsTab getInstance() {
		if(tab == null) {
			tab = new StatisticsTab();
		}
		return tab;
	}

}