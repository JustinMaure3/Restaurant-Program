package tabs;



import Tables.FoodTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.chart.PieChart;
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
	
	//Pie chart for the month of January
	public static PieChart januaryPieChart() {	
		int january;

		PieChart pieChart = new PieChart();
		pieChart.setTitle("January");
		pieChart.setLabelsVisible(true);
		return pieChart;
	}
	
	
	//Pie chart for the month of February
	public static PieChart februaryPieChart() {
		int february;
				
		PieChart pieChart = new PieChart();
		pieChart.setTitle("February");
		pieChart.setLabelsVisible(true);
		return pieChart;
		
	}
	
	//Pie chart for the month of March
	public static PieChart marchPieChart() {
		int march;
				
		PieChart pieChart = new PieChart();
		pieChart.setTitle("March");
		pieChart.setLabelsVisible(true);
		return pieChart;
		
	}
	
	//Pie chart for the month of April
	public static PieChart aprilPieChart() {
		int paril;
				
		PieChart pieChart = new PieChart();
		pieChart.setTitle("April");
		pieChart.setLabelsVisible(true);
		return pieChart;
		
	}
	
	//Pie chart for the month of May
	public static PieChart mayPieChart() {
		int may;
				
		PieChart pieChart = new PieChart();
		pieChart.setTitle("May");
		pieChart.setLabelsVisible(true);
		return pieChart;
		
	}
	
	//Pie chart for the month of June
	public static PieChart junePieChart() {
		int june;
				
		PieChart pieChart = new PieChart();
		pieChart.setTitle("June");
		pieChart.setLabelsVisible(true);
		return pieChart;
		
	}
	
	//Pie chart for the month of July
	public static PieChart julyPieChart() {
		int july;
				
		PieChart pieChart = new PieChart();
		pieChart.setTitle("July");
		pieChart.setLabelsVisible(true);
		return pieChart;
		
	}
	
	//Pie chart for the month of August
	public static PieChart augustPieChart() {
		int august;
				
		PieChart pieChart = new PieChart();
		pieChart.setTitle("August");
		pieChart.setLabelsVisible(true);
		return pieChart;
		
	}
	

}