package tabs;

import java.util.ArrayList;

import PlaceHolder.FoodDrink;
import Tables.CrewMemberTable;
import Tables.FoodTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;

public class StatisticsTab extends Tab {
	
	private static StatisticsTab tab;
	
	public static BorderPane pane;
	
	
	private StatisticsTab() {
		this.setText("Statistics Tab");
		pane = new BorderPane();
		pane.setCenter(generateChart());
		this.setContent(pane);
	}

	public static StatisticsTab getInstance() {
		if(tab == null) {
			tab = new StatisticsTab();
		}
		return tab;
	}
	
	public static PieChart generateChart() {
		//Create a listVuew that'll hold a bunch of instances of food and drink
				ListView<FoodDrink> list = new ListView<FoodDrink>();
				//Create a food table
				FoodTable fTable = new FoodTable();
				//Create the array that'll give us all foodDrink in our database
				ArrayList<FoodDrink> foodDrinkItems = fTable.getAllFoodDrink();
				
				//set the list with all the items in the arraylist
				list.setItems(FXCollections.observableArrayList(foodDrinkItems));
	
		
		PieChart chart = new PieChart();
		chart.setLabelsVisible(true);
		
		
		
		
		//chart.setData(list);
		return chart;
	}
	
	
	
}


