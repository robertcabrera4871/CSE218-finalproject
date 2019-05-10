package factories;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.StockData;

public class DataFactory {
	public static StockData generateDataURL(String sourceString) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			URL source = new URL(sourceString);
			return mapper.readValue(source, StockData.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static StockData generateDataString(String jsonString) {
		try {
			String contents = new String(Files.readAllBytes(Paths.get(jsonString)));
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(contents, StockData.class);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
}
