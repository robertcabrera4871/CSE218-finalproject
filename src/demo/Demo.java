package demo;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;

import factories.DataFactory;
import models.StockData;
import models.StockDay;

public class Demo {

	public static void main(String[] args) {	
		StockData msft = DataFactory.generateData("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=MSFT&apikey=8Y8VNRTWK1PBQ5AU&dataype=json");
		StockData adx = DataFactory.generateData("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=ADX&apikey=8Y8VNRTWK1PBQ5AU&dataype=json");;
	}

}
