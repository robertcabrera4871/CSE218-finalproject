package demo;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class Demo extends Application{

	public static void main(String[] args) {	
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		TabPane root = (TabPane)FXMLLoader.load(getClass().getResource("StockView.fxml"));
		Scene scene = new Scene(root,600,400);
		primaryStage.setTitle("Stock Application");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
