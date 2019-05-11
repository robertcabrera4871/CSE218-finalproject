package models;

import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CompareList {
	ObservableList<LocalDate> compareStocks;
	
	public CompareList() {
		compareStocks = FXCollections.observableArrayList();
	}
	public ObservableList<LocalDate> getStocksAsArrayList(){
		return compareStocks;
	}
	public void clearList() {
		compareStocks = FXCollections.observableArrayList();
	}
}
