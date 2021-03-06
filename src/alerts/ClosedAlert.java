package alerts;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ClosedAlert {
	
	private Alert alert;
	
	public ClosedAlert() {
		this.alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText("Alert!");
		alert.setContentText("The market was closed on that date \n or the data"
				+ " does not go back that far (20 years)");
	}

	public void showAndWait() {
		alert.showAndWait();
	}
	
}
