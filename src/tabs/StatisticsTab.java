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
		FoodTable foodTable = new FoodTable();
		

		ArrayList<FoodDrink> foodDrinkItems = foodTable.getAllFoodDrink();
		
		PieChart piechart = new PieChart();
		
		piechart.setLabelsVisible(true);
		ObservableList<PieChart.Data> data2 = null;
		
		for(int i = 0; i < foodTable.getAllFoodDrink().size(); i ++) {
		FoodDrink oneFood = foodDrinkItems.get(i);
		
			ObservableList<PieChart.Data> data = 
				FXCollections.observableArrayList(
						new PieChart.Data(oneFood.getName(), oneFood.getAmountSold()));
			
			 data2 = FXCollections.observableArrayList(data);

		}
		

		piechart.setData(data2);
		return piechart;
	}
	
	
	
}
