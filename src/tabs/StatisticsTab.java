package tabs;

import java.util.ArrayList;

import PlaceHolder.FoodDrink;
import Tables.CrewMemberTable;
import Tables.FoodTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
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
		FoodTable menuItems = new FoodTable();
		ArrayList<FoodDrink> foodDrinkItems = menuItems.getAllFoodDrink();	
	
		int allFood = menuItems.getItemCount("Pizza");
		PieChart chart = new PieChart();
		chart.setLabelsVisible(true);
		
		ObservableList<PieChart.Data> data;
					
		 data = FXCollections.observableArrayList(new PieChart.Data("Pizza", allFood));
		
		
		chart.setData(data);
		return chart;
	}
	
	
	
}

