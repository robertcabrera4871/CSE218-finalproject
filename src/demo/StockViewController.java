package demo;

import java.time.LocalDate;
import java.util.ArrayList;

import alerts.BeforeOpenAlert;
import alerts.ClosedAlert;
import alerts.MetaDataAlert;
import factories.DataFactory;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import models.CompareList;
import models.StockData;
import models.StockDay;
import utils.UpdateStatsUtil;

public class StockViewController {
	// private StockData msft =
	// DataFactory.generateDataURL("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=MSFT&outputsize=full&apikey=8Y8VNRTWK1PBQ5AU&dataype=json");
	// private StockData adx =
	// DataFactory.generateDataURL("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=ADX&outputsize=full&apikey=8Y8VNRTWK1PBQ5AU&dataype=json");
	private StockData msft = DataFactory
			.generateDataString("C:\\Users\\rober\\eclipse-workspace-Hackathon\\CSE218-finalproject\\src\\msft.json");
	private StockData adx = DataFactory
			.generateDataString("C:\\Users\\rober\\eclipse-workspace-Hackathon\\CSE218-finalproject\\src\\adx.json");
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
	private ListView listView1;
	@FXML
	private ListView listView2;
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
	private Text dateHighestText1;
	@FXML
	private Text dateLowestText1;

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
	
	private ArrayList<StockDay> stockListMSFT = new ArrayList<StockDay>(100);
	private ArrayList<StockDay> stockListADX = new ArrayList<StockDay>(100); 

	@FXML
	private Button metaDataButton;
	@FXML
	private Button metaDataButton1;

	// Event Listener on DatePicker[#stockDayPicker].onAction
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

	@FXML
	public void addToList1(ActionEvent event) {
		LocalDate datePicked = stockRangePicker.getValue();
		StockDay day = msft.getStocks().get(datePicked.toString());
		try {
			listView1.getItems().get(0);
		} catch (Exception e) {
			listView1.setItems(dateListMSFT);
		}
		if (checkDate(day, datePicked, msftOpenDate)) {
			stockListMSFT.add(day);
			dateListMSFT.add(datePicked);
			updateStats1(stockListMSFT);
		}
	}

	@FXML
	public void addToList2(ActionEvent event) {
		LocalDate datePicked = stockRangePicker1.getValue();
		StockDay day = msft.getStocks().get(datePicked.toString());
		try {
			listView2.getItems().get(0);
		} catch (Exception e) {
			listView2.setItems(dateListADX);
		}
		if(checkDate(day,datePicked,adxOpenDate)) {
			stockListADX.add(day);
			dateListADX.add(stockRangePicker1.getValue());
			updateStats2(stockListADX);
		}
	}
	private void updateStats1(ArrayList<StockDay> stockList) {
		avgText.setText(UpdateStatsUtil.updateAvg(stockList));
		highestText.setText(UpdateStatsUtil.updateHighest(stockList));
		lowestText.setText(UpdateStatsUtil.updateLowest(stockList));
	}
	private void updateStats2(ArrayList<StockDay> stockList) {
		avgText1.setText(UpdateStatsUtil.updateAvg(stockList));
		highestText1.setText(UpdateStatsUtil.updateHighest(stockList));
		lowestText1.setText(UpdateStatsUtil.updateLowest(stockList));
	}

	@FXML
	void clearList(ActionEvent event) {
		dateListMSFT.clear();
		stockListMSFT.clear();
	}

	@FXML
	void clearList1(ActionEvent event) {
		dateListADX.clear();
		stockListADX.clear();
	}

	@FXML
	public void createNewStock1(ActionEvent event) {
		// TODO Autogenerated
	}

	@FXML
	public void createNewStock2(ActionEvent event) {
		// TODO Autogenerated
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

}
