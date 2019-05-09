package demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class Demo extends Application{

	public static void main(String[] args) {	
//		StockData msft = DataFactory.generateData("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=MSFT&apikey=8Y8VNRTWK1PBQ5AU&dataype=json");
//		StockData adx = DataFactory.generateData("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=ADX&apikey=8Y8VNRTWK1PBQ5AU&dataype=json");;
//		System.out.println(msft.getStocks().keySet());
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		TabPane root = (TabPane)FXMLLoader.load(getClass().getResource("StockView.fxml"));
		Scene scene = new Scene(root,600,400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
