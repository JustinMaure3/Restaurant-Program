package tabs;


import DAO.FoodDrinkDAO;
import PlaceHolder.FoodDrink;
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
//		FoodDrink table = new FoodDrink();
//	
//		int pennies = table.getItemCount();
//		
//		
//		PieChart chart = new PieChart();
//		chart.setTitle("All Coins Found");
//		chart.setLabelsVisible(true);
//		ObservableList<PieChart.Data> data = 
//				FXCollections.observableArrayList(new PieChart.Data("Penny: " + pennies, pennies),
//						new PieChart.Data("Nickel: " + nickel , nickel),
//						new PieChart.Data("Dime: " + dime , dime),
//						new PieChart.Data("Quarter: " + quarter , quarter),
//						new PieChart.Data("Loonie: " + loonie , loonie),
//						new PieChart.Data("Toonie: " + toonie , toonie));
//		chart.setData(data);
		return null;
	}
	
	
	
}
