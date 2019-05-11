package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import models.StockDay;

public class NewStockController {
	@FXML
	private TextField newOpenText;
	@FXML
	private TextField newCloseText;
	@FXML
	private TextField newHighText;
	@FXML
	private TextField newLowText;
	@FXML
	private TextField newVolumeText;
	@FXML
	private Button newStockText;
	private Alert alert = createAlert();

	@FXML
	public void createNewStock(ActionEvent event) {
		try {
			if (checkFields()) {
				StockDay day = new StockDay(0, 0, 0, 0, 0);
				day.setOpen(Double.parseDouble(newOpenText.getText()));
				day.setClose(Double.parseDouble(newCloseText.getText()));
				day.setHigh(Double.parseDouble(newHighText.getText()));
				day.setLow(Double.parseDouble(newLowText.getText()));
				day.setVolume(Long.parseLong(newVolumeText.getText()));
				StockViewController.setNewStock(day);
				changeScene(event);
			} else {
				alert.showAndWait();
			}
		} catch (Exception e) {
			//e.printStackTrace();
			alert.showAndWait();
		}

	}

	private Alert createAlert() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText("Alert!");
		alert.setContentText("Make sure Entry is correct format, and that it is not empty");
		return alert;
	}

	private boolean checkFields() {
		if (newOpenText.getText().equals("") || newCloseText.getText().equals("") || newHighText.getText().equals("")
				|| newLowText.getText().equals("") || newVolumeText.getText().equals("")) {
			return false;
		} else if (notDouble(newOpenText.getText()) || notDouble(newCloseText.getText())
				|| notDouble(newHighText.getText()) || notDouble(newLowText.getText())
				|| notDouble(newVolumeText.getText())) {
			return false;
		}
		return true;
	}

	public boolean notDouble(String string) {
		try {
			Double.parseDouble(string);
			return false;
		} catch (NumberFormatException e) {
			return true;
		}

	}

	public boolean notLong(String string) {
		try {
			Long.parseLong(string);
			return false;
		} catch (NumberFormatException e) {
			return true;
		}

	}

	public void changeScene(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/resources/StockView.fxml"));
		try {
			Parent root = loader.load();
			Scene scene = root.getScene();
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
