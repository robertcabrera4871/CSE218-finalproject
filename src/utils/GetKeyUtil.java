package utils;

import java.util.HashMap;
import java.util.Map.Entry;

import models.StockDay;

public class GetKeyUtil {

	public static String getKey(StockDay highestDay, HashMap<String, StockDay> stocks) {
		for(Entry<String,StockDay> entry: stocks.entrySet()) {
			if(entry.getValue().equals(highestDay)) {
				return entry.getKey();
			}
		}
		return null;
	}

}
