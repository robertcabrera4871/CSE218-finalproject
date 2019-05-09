package factories;

import java.io.IOException;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.StockData;

public class DataFactory {
	public static StockData generateData(String sourceString) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			URL source = new URL(sourceString);
			return mapper.readValue(source, StockData.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
