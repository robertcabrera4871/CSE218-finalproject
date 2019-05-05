package demo;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.StockData;

public class Demo {

	public static void main(String[] args) {
		try {
			URL source = new URL(
					"https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=MSFT&apikey=8Y8VNRTWK1PBQ5AU&dataype=json");
			JsonFactory factory = new JsonFactory();
			//JsonParser parser = factory.createParser(source);
			
			File file = new File("C:\\Users\\rober\\eclipse-workspace-Hackathon\\CSE Final Project\\src\\stock.json");
			//File file = new File("stock.json");
					
			ObjectMapper mapper = new ObjectMapper();
			mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			
			StockData test = mapper.readValue(source, StockData.class);
			
			TypeReference<HashMap<String,Object>> typeRef = new TypeReference<HashMap<String,Object>>() {};
			
			HashMap<String,Object> map = mapper.readValue(source, typeRef);
			
			//HashMap<String, Object> map2 = mapper.readValue(file, HashMap.class);
			//System.out.println(map2.keySet());
			//System.out.println(map2.get("Time Series (Daily)"));
			
			
			//This makes an Object, but that Object is not a StockDay Object. Cannot users get/set
			HashMap<String, HashMap<String, Object>> map3 = mapper.readValue(file, new TypeReference<HashMap>(){});
			System.out.println(map3.keySet());
			System.out.println(map3.get("Meta Data").keySet());
			System.out.println(map3.get("Meta Data").get("2. Symbol"));
			System.out.println(map3.get("Time Series (Daily)").keySet());
			System.out.println(map3.get("Time Series (Daily)").get("2019-05-03").toString());
		
			
			//System.out.println(test);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
