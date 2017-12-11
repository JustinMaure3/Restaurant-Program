import javafx.application.Application;

import javafx.stage.Stage;

public class Main extends Application {
	
	

	public static Stage mainStage;
	
	public static void main(String[] args) {
		Application.launch(args);
		
//		private String name;
//		private String description;
//		private String picture;
//		private int rating;
		
		

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		//Main stage is set up
		mainStage = primaryStage;
		mainStage.setResizable(false);
		mainStage.setScene(new HomeScene());
		mainStage.show();
		
	}

}
