package controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import alerts.BeforeOpenAlert;
import alerts.ClosedAlert;
import alerts.MetaDataAlert;
import factories.DataFactory;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.CompareList;
import models.StockData;
import models.StockDay;
import utils.CheckDuplicateUtil;
import utils.GetKeyUtil;
import utils.UpdateStatsUtil;

public class StockViewController {
	private StockData msft = DataFactory.generateDataURL(
			"https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=MSFT&outputsize=full&apikey=8Y8VNRTWK1PBQ5AU&dataype=json");
	private StockData adx = DataFactory.generateDataURL(
			"https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=ADX&outputsize=full&apikey=8Y8VNRTWK1PBQ5AU&dataype=json");
//	private StockData msft = DataFactory
//			.generateDataString("C:\\Users\\rober\\eclipse-workspace-Hackathon\\CSE218-finalproject\\src\\msft.json");
//	private StockData adx = DataFactory
//			.generateDataString("C:\\Users\\rober\\eclipse-workspace-Hackathon\\CSE218-finalproject\\src\\adx.json");
	@FXML
	private DatePicker stockDayPicker;
	@FXML
	private DatePicker changeStockPicker;
	@FXML
	private DatePicker stockRangePicker;
	@FXML
	private DatePicker stockDayPicker1;
	@FXML
	private DatePicker changeStockPicker1;
	@FXML
	private DatePicker stockRangePicker1;
	@FXML
	private ListView<LocalDate> listView1;
	@FXML
	private ListView<LocalDate> listView2;
	@FXML
	private Text closeText;
	@FXML
	private Text openText;
	@FXML
	private Text highText;
	@FXML
	private Text lowText;
	@FXML
	private Text volumeText;
	@FXML
	private Text highestText;
	@FXML
	private Text avgText;
	@FXML
	private Text lowestText;
	@FXML
	private Text dateHighestText;
	@FXML
	private Text dateLowestText;
	@FXML
	private Text dateHighestText1;
	@FXML
	private Text dateLowestText1;
	@FXML
	private Text closeText1;
	@FXML
	private Text openText1;
	@FXML
	private Text highText1;
	@FXML
	private Text lowText1;
	@FXML
	private Text volumeText1;
	@FXML
	private Text highestText1;
	@FXML
	private Text avgText1;
	@FXML
	private Text lowestText1;

	@FXML
	private Button clearListButton;
	@FXML
	private Button clearListButton1;

	private ClosedAlert closedAlert = new ClosedAlert();
	private BeforeOpenAlert beforeAlert = new BeforeOpenAlert();
	private MetaDataAlert msftMeta = new MetaDataAlert(msft);
	private MetaDataAlert adxMeta = new MetaDataAlert(adx);

	private CompareList compareList1 = new CompareList();
	private ObservableList<LocalDate> dateListMSFT = compareList1.getStocksAsArrayList();

	private CompareList compareList2 = new CompareList();
	private ObservableList<LocalDate> dateListADX = compareList2.getStocksAsArrayList();

	private LocalDate msftOpenDate = LocalDate.of(1986, 3, 13);
	private LocalDate adxOpenDate = LocalDate.of(1980, 3, 1);

	private ArrayList<StockDay> stockListMSFT = new ArrayList<StockDay>();
	private ArrayList<StockDay> stockListADX = new ArrayList<StockDay>();

	private static StockDay tempStock = null;

	@FXML
	private Button metaDataButton;
	@FXML
	private Button metaDataButton1;

	@FXML
	public void findStock1(ActionEvent event) {
		LocalDate datePicked = stockDayPicker.getValue();
		StockDay day = msft.getStocks().get(datePicked.toString());
		if (checkDate(day, datePicked, msftOpenDate)) {
			openText.setText(String.valueOf(day.getOpen()));
			closeText.setText(String.valueOf(day.getClose()));
			highText.setText(String.valueOf(day.getHigh()));
			lowText.setText(String.valueOf(day.getLow()));
			volumeText.setText(String.valueOf(day.getVolume()));
		}
	}

	@FXML
	public void findStock2(ActionEvent event) {
		LocalDate datePicked = stockDayPicker1.getValue();
		StockDay day = adx.getStocks().get(datePicked.toString());
		if (checkDate(day, datePicked, adxOpenDate)) {
			openText1.setText(String.valueOf(day.getOpen()));
			closeText1.setText(String.valueOf(day.getClose()));
			highText1.setText(String.valueOf(day.getHigh()));
			lowText1.setText(String.valueOf(day.getLow()));
			volumeText1.setText(String.valueOf(day.getVolume()));
		}
	}

	// Have to iterate through ArrayList to make sure no duplicates
	@FXML
	public void addToList1(ActionEvent event) {
		LocalDate datePicked = stockRangePicker.getValue();
		StockDay day = msft.getStocks().get(datePicked.toString());
		try {
			listView1.getItems().get(0);
		} catch (Exception e) {
			listView1.setItems(dateListMSFT);
		}
		if (checkDateList(day, datePicked, msftOpenDate, dateListMSFT)) {
			stockListMSFT.add(day);
			dateListMSFT.add(datePicked);
			updateStats1(stockListMSFT);
		}
	}

	@FXML
	public void addToList2(ActionEvent event) {
		LocalDate datePicked = stockRangePicker1.getValue();
		StockDay day = adx.getStocks().get(datePicked.toString());
		try {
			listView2.getItems().get(0);
		} catch (Exception e) {
			listView2.setItems(dateListADX);
		}
		if (checkDateList(day, datePicked, adxOpenDate, dateListADX)) {
			stockListADX.add(day);
			dateListADX.add(stockRangePicker1.getValue());
			updateStats2(stockListADX);
		}
	}

	// Unfortunately Have to iterate to get key
	private void updateStats1(ArrayList<StockDay> stockList) {
		avgText.setText(UpdateStatsUtil.updateAvg(stockList));
		StockDay highestDay = UpdateStatsUtil.updateHighest(stockList);
		String highKey = GetKeyUtil.getKey(highestDay, msft.getStocks());
		highestText.setText(String.valueOf(highestDay.getHigh()));
		dateHighestText.setText(highKey);
		StockDay lowestDay = UpdateStatsUtil.updateLowest(stockList);
		String lowestKey = GetKeyUtil.getKey(lowestDay, msft.getStocks());
		lowestText.setText(String.valueOf(lowestDay.getLow()));
		dateLowestText.setText(lowestKey);
	}

	private void updateStats2(ArrayList<StockDay> stockList) {
		avgText1.setText(UpdateStatsUtil.updateAvg(stockList));
		StockDay highestDay = UpdateStatsUtil.updateHighest(stockList);
		String highKey = GetKeyUtil.getKey(highestDay, adx.getStocks());
		highestText1.setText(String.valueOf(highestDay.getHigh()));
		dateHighestText1.setText(highKey);
		StockDay lowestDay = UpdateStatsUtil.updateLowest(stockList);
		String lowestKey = GetKeyUtil.getKey(lowestDay, adx.getStocks());
		lowestText1.setText(String.valueOf(lowestDay.getLow()));
		dateLowestText1.setText(lowestKey);
	}

	private void clearStats() {
		avgText.setText(String.valueOf(0.0));
		highestText.setText(String.valueOf(0.0));
		lowestText.setText(String.valueOf(0.0));
		dateHighestText.setText("Date");
		dateLowestText.setText("Date");
	}

	private void clearStats1() {
		avgText1.setText(String.valueOf(0.0));
		highestText1.setText(String.valueOf(0.0));
		lowestText1.setText(String.valueOf(0.0));
		dateHighestText1.setText("Date");
		dateLowestText1.setText("Date");
	}

	@FXML
	void clearList(ActionEvent event) {
		dateListMSFT.clear();
		stockListMSFT.clear();
		clearStats();
	}

	@FXML
	void clearList1(ActionEvent event) {
		dateListADX.clear();
		stockListADX.clear();
		clearStats1();
	}

	@FXML
	public void createNewStock1(ActionEvent event) {
		LocalDate datePicked = changeStockPicker.getValue();
		StockDay day = msft.getStocks().get(datePicked.toString());
		if (checkDate(day, datePicked, msftOpenDate)) {
			try {
				changeScene(event);
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (tempStock != null)
				day.replaceDay(tempStock);
			tempStock = null;
		}
	}

	@FXML
	public void createNewStock2(ActionEvent event) {
		LocalDate datePicked = changeStockPicker.getValue();
		StockDay day = adx.getStocks().get(datePicked.toString());
		if (checkDate(day, datePicked, adxOpenDate)) {
			try {
				changeScene(event);
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (tempStock != null)
				day.replaceDay(tempStock);
			tempStock = null;
		}
	}

	// To be set by NewStockController
	public static void setNewStock(StockDay userDay) {
		tempStock = userDay;
	}

	@FXML
	void showMetaData(ActionEvent event) {
		msftMeta.showAndWait();
	}

	@FXML
	void showMetaData1(ActionEvent event) {
		adxMeta.showAndWait();
	}

	public boolean checkDate(StockDay day, LocalDate datePicked, LocalDate openDate) {
		if (datePicked.isBefore(openDate)) {
			beforeAlert.showAndWait();
			return false;
		} else if (day == null) {
			closedAlert.showAndWait();
			return false;
		} else {
			return true;
		}
	}

	public boolean checkDateList(StockDay day, LocalDate datePicked, LocalDate openDate,
			ObservableList<LocalDate> dateList) {
		if (checkDate(day, datePicked, openDate)) {
			if (CheckDuplicateUtil.checkDupe(datePicked, dateList)) {
				return true;
			}
		}
		return false;
	}

	public void changeScene(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/resources/NewStock.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		Stage window = new Stage();
		Stage owner = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setTitle("New Stock");
		window.initModality(Modality.APPLICATION_MODAL);
		window.initOwner(owner);
		window.setScene(scene);
		window.showAndWait();

	}

}
