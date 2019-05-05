package demo;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.StockData;

public class Demo {

	static Path path = Paths.get("C:\\Users\\rober\\eclipse-workspace-Hackathon\\CSE Final Project\\src\\stock.json");
	static URL source;

	public static void main(String[] args) {

		try {
			source = new URL(
					"https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=MSFT&apikey=8Y8VNRTWK1PBQ5AU&dataype=json");
			String json = new String(Files.readAllBytes(path));
			ObjectMapper mapper = new ObjectMapper();
			StockData data = mapper.readValue(json, StockData.class);
			System.out.println(data.getMetaData().toString());
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		

	}

}
