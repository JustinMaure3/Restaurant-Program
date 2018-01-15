import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Credits extends BorderPane {

	public Credits() {
		VBox hbox = new VBox();
		
		Text text1 = new Text("XAMPP");
		Text text2 = new Text("Github.com");
		Text text3 = new Text("");
		Text text4 = new Text("");
		Text text5 = new Text("");
		Text text6 = new Text("");
		Text text7 = new Text("");
		Text text8 = new Text("");
		Text text9 = new Text("");
		Text text10 = new Text("");
		Text text11 = new Text("");
		Text text12 = new Text("");
		Text text13 = new Text("");
		
		hbox.getChildren().addAll(text1, text2,text3,text4,text5,text6,text7,text8,text9,text10,text11,text12,text13);
		
		Button goBack = new Button("Head on back");
		
		
		this.setBottom(goBack);
		this.setCenter(hbox);
	}
}
