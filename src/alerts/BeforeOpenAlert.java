package alerts;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class BeforeOpenAlert {
	private Alert alert;
	
	public BeforeOpenAlert() {
		this.alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText("Alert!");
		alert.setContentText("The company was not public on that date");
	}

	public void showAndWait() {
		alert.showAndWait();
	}
}
