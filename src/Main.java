import javafx.application.Application;

import javafx.stage.Stage;

public class Main extends Application {

	public static Stage mainStage;
	
	public static void main(String[] args) {
		Application.launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		//Mainstage is set up
		mainStage = primaryStage;
		mainStage.setResizable(false);
		mainStage.setScene(new HomeScene());
		mainStage.show();
		
	}

}