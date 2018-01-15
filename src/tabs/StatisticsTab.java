package tabs;


import java.util.ArrayList;

import PlaceHolder.FoodDrink;
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
		FoodTable table = new FoodTable();
		
		PieChart chart = new PieChart();
		chart.setTitle("Total Sales of Each Menu Item");
		chart.setLabelsVisible(true);
		ArrayList<FoodDrink> foodItems = table.getAllFoodDrink();
		ArrayList<PieChart.Data> foodItemData = new ArrayList<PieChart.Data>();
		for(int i = 0; i < foodItems.size(); i++) {
				foodItemData.add(new PieChart.Data(foodItems.get(i).getName(), foodItems.get(i).getAmountSold()));
		}
		
		ObservableList<PieChart.Data> data = FXCollections.observableArrayList(foodItemData);
		chart.setData(data);
		
		return chart;
	}
	
	
	
}
