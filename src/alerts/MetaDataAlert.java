package alerts;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import models.StockData;

public class MetaDataAlert {
	private Alert alert;
	
	public MetaDataAlert(StockData data) {
		this.alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText("Meta Data for " + data.getMetaData().getSymbol());
		alert.setContentText(data.getMetaData().toString());
	}

	public void showAndWait() {
		alert.showAndWait();
	}
	
}
