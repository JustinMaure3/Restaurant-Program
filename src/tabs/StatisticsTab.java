package tabs;



import java.util.ArrayList;

import ENUMS.MonthlyStats;
import PlaceHolder.FoodDrink;
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
	private static FoodTable table = new FoodTable();
	private static ArrayList<FoodDrink> foodDrinkItems = table.getAllFoodDrink();
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
		
		goBtn.setOnAction(e->{
			MonthlyStats stat = monthComboBox.getSelectionModel().getSelectedItem();
		});

	}
	public static StatisticsTab getInstance() {
		if(tab == null) {
			tab = new StatisticsTab();
		}
		return tab;
	}
	
	//Pie chart for the month of January
	public static PieChart januaryPieChart() {		
		ArrayList<Double> itemAmt = new ArrayList();
		
		int i = 0;
		while (i < foodDrinkItems.size()) {
			itemAmt.add(foodDrinkItems.get(i).getAmountSold());
		}
		
		PieChart pieChart = new PieChart();
		pieChart.setTitle("January");
		pieChart.setLabelsVisible(true);
		
		ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
		while (i < foodDrinkItems.size()) {
			data = FXCollections.observableArrayList(
				new PieChart.Data((foodDrinkItems.get(i).getName() + ": "), itemAmt.get(i)));
			i++;
		}
		return pieChart;
	}
	
	
	//Pie chart for the month of February
	public static PieChart februaryPieChart() {
		ArrayList<Double> itemAmt = new ArrayList();
		
		int i = 0;
		while (i < foodDrinkItems.size()) {
			itemAmt.add(foodDrinkItems.get(i).getAmountSold());
		}
				
		PieChart pieChart = new PieChart();
		pieChart.setTitle("February");
		pieChart.setLabelsVisible(true);
		
		ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
		while (i < foodDrinkItems.size()) {
			data = FXCollections.observableArrayList(
					new PieChart.Data((foodDrinkItems.get(i).getName() + ": "), itemAmt.get(i)));
			i++;
		}
		return pieChart;
		
	}
	
	//Pie chart for the month of March
	public static PieChart marchPieChart() {
		ArrayList<Double> itemAmt = new ArrayList();
		
		int i = 0;
		while (i < foodDrinkItems.size()) {
			itemAmt.add(foodDrinkItems.get(i).getAmountSold());
		}
				
		PieChart pieChart = new PieChart();
		pieChart.setTitle("March");
		pieChart.setLabelsVisible(true);
		
		ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
		while (i < foodDrinkItems.size()) {
			data = FXCollections.observableArrayList(
					new PieChart.Data((foodDrinkItems.get(i).getName() + ": "), itemAmt.get(i)));
			i++;
		}
		return pieChart;
		
	}
	
	//Pie chart for the month of April
	public static PieChart aprilPieChart() {
		ArrayList<Double> itemAmt = new ArrayList();
		
		int i = 0;
		while (i < foodDrinkItems.size()) {
			itemAmt.add(foodDrinkItems.get(i).getAmountSold());
		}
		PieChart pieChart = new PieChart();
		pieChart.setTitle("April");
		pieChart.setLabelsVisible(true);
		
		ObservableList<PieChart.Data>data = FXCollections.observableArrayList();
		while(i < foodDrinkItems.size()) {
			data = FXCollections.observableArrayList(
					new PieChart.Data((foodDrinkItems.get(i).getName() + ": "), itemAmt.get(i)));
			i++;
		}
		return pieChart;
		
	}
	
	//Pie chart for the month of May
	public static PieChart mayPieChart() {
		ArrayList<Double> itemAmt = new ArrayList();
		
		int i = 0;
		while (i < foodDrinkItems.size()) {
			itemAmt.add(foodDrinkItems.get(i).getAmountSold());
		}
				
		PieChart pieChart = new PieChart();
		pieChart.setTitle("May");
		pieChart.setLabelsVisible(true);
		
		ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
		while (i < foodDrinkItems.size()) {
			data = FXCollections.observableArrayList(
					new PieChart.Data((foodDrinkItems.get(i).getName() + ": "), itemAmt.get(i)));
			i++;
		}
		return pieChart;
		
	}
	
	//Pie chart for the month of June
	public static PieChart junePieChart() {
		ArrayList<Double> itemAmt = new ArrayList();
		
		int i = 0;
		while (i < foodDrinkItems.size()) {
			itemAmt.add(foodDrinkItems.get(i).getAmountSold());
		}
				
		PieChart pieChart = new PieChart();
		pieChart.setTitle("June");
		pieChart.setLabelsVisible(true);
		
		ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
		while (i < foodDrinkItems.size()) {
			data = FXCollections.observableArrayList(
					new PieChart.Data((foodDrinkItems.get(i).getName() + ": "), itemAmt.get(i)));
			i++;
		}
		return pieChart;
		
	}
	
	//Pie chart for the month of July
	public static PieChart julyPieChart() {
		ArrayList<Double> itemAmt = new ArrayList();
		
		int i = 0;
		while (i < foodDrinkItems.size()) {
			itemAmt.add(foodDrinkItems.get(i).getAmountSold());
		}
		PieChart pieChart = new PieChart();
		pieChart.setTitle("July");
		pieChart.setLabelsVisible(true);
		
		ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
		while (i < foodDrinkItems.size()) {
			data = FXCollections.observableArrayList(
					new PieChart.Data((foodDrinkItems.get(i).getName() + ": "), itemAmt.get(i)));
			i++;
		}
		return pieChart;
		
	}
	
	//Pie chart for the month of August
	public static PieChart augustPieChart() {
		ArrayList<Double> itemAmt = new ArrayList();
				
		int i = 0;
		while (i < foodDrinkItems.size()) {
			itemAmt.add(foodDrinkItems.get(i).getAmountSold());
		}
		PieChart pieChart = new PieChart();
		pieChart.setTitle("August");
		pieChart.setLabelsVisible(true);
		
		ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
		while (i < foodDrinkItems.size()) {
			data = FXCollections.observableArrayList(
					new PieChart.Data((foodDrinkItems.get(i).getName() + ": "), itemAmt.get(i)));
			i++;
		}
		return pieChart;
		
	}
	
	//Pie chart for the month of September
	public static PieChart septemberPieChart() {
		ArrayList<Double> itemAmt = new ArrayList();
		
		int i = 0;
		while (i <foodDrinkItems.size()) {
			itemAmt.add(foodDrinkItems.get(i).getAmountSold());
		}
		PieChart pieChart = new PieChart();
		pieChart.setTitle("September");
		pieChart.setLabelsVisible(true);
		
		ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
		while (i < foodDrinkItems.size()) {
			data = FXCollections.observableArrayList(
					new PieChart.Data((foodDrinkItems.get(i).getName() + ": "), itemAmt.get(i)));
			i++;
		}
		return pieChart;
		
	}
	
	//Pie chart for the month of October
	public static PieChart octoberPieChart() {
		ArrayList<Double> itemAmt = new ArrayList();
		
		int i = 0;
		while (i <foodDrinkItems.size()) {
			itemAmt.add(foodDrinkItems.get(i).getAmountSold());
		}
				
		PieChart pieChart = new PieChart();
		pieChart.setTitle("October");
		pieChart.setLabelsVisible(true);
		
		ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
		while (i < foodDrinkItems.size()) {
			data = FXCollections.observableArrayList(
					new PieChart.Data((foodDrinkItems.get(i).getName() + ": "), itemAmt.get(i)));
			i++;
		}
		return pieChart;
		
	}
	
	//Pie chart for the month of November
	public static PieChart novemberPieChart() {
		ArrayList<Double> itemAmt = new ArrayList();
		
		int i = 0;
		while (i <foodDrinkItems.size()) {
			itemAmt.add(foodDrinkItems.get(i).getAmountSold());
		}
				
		PieChart pieChart = new PieChart();
		pieChart.setTitle("November");
		pieChart.setLabelsVisible(true);
		
		ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
		while (i < foodDrinkItems.size()) {
			data = FXCollections.observableArrayList(
					new PieChart.Data((foodDrinkItems.get(i).getName() + ": "), itemAmt.get(i)));
			i++;
		}
		return pieChart;
		
	}
	
	//Pie chart for the month of December
	public static PieChart decemberPieChart() {
		ArrayList<Double> itemAmt = new ArrayList();
		
		int i = 0;
		while (i <foodDrinkItems.size()) {
			itemAmt.add(foodDrinkItems.get(i).getAmountSold());
		}
				
		PieChart pieChart = new PieChart();
		pieChart.setTitle("December");
		pieChart.setLabelsVisible(true);
		
		ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
		while (i < foodDrinkItems.size()) {
			data = FXCollections.observableArrayList(
					new PieChart.Data((foodDrinkItems.get(i).getName() + ": "), itemAmt.get(i)));
			i++;
		}
		return pieChart;
		
	}
	
	

}