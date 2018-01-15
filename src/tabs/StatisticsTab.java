package Tabs;

import javafx.scene.control.Tab;

public class StatisticsTab extends Tab {
	
	private static StatisticsTab tab;
	
	private StatisticsTab() {
		this.setText("Statistics Tab");
	}

	public static StatisticsTab getInstance() {
		if(tab == null) {
			tab = new StatisticsTab();
		}
		return tab;
	}
}
