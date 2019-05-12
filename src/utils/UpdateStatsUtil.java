package utils;

import java.util.ArrayList;
import java.util.Iterator;

import models.StockDay;

public class UpdateStatsUtil {
	
	public static String updateAvg(ArrayList<StockDay> stockList) {
		double finalAvg = 0.0;
		Iterator<StockDay> iterator = stockList.iterator();
		while(iterator.hasNext()) {
			StockDay day = iterator.next();
			finalAvg += ((day.getOpen() + day.getClose()) / 2.0);
		}
		Double result = (double) Math.round(finalAvg /stockList.size() * 100.0) / 100.0;
		return String.valueOf(result);
	}

	public static StockDay updateHighest(ArrayList<StockDay> stockList) {
		Iterator<StockDay> iterator = stockList.iterator();
		double highest = 0.0;
		StockDay highestDay = null;
		while(iterator.hasNext()) {
			StockDay day = iterator.next();
			if(day.getHigh() > highest) {
				highestDay = day;
				highest = highestDay.getHigh();
			}
		}
		return highestDay;
	}

	public static StockDay updateLowest(ArrayList<StockDay> stockList) {
		Iterator<StockDay> iterator = stockList.iterator();
		double lowest = 0.0;
		StockDay lowestDay = null;
		while(iterator.hasNext()) {
			StockDay day = iterator.next();
			if(day.getLow() < lowest || lowest == 0) {
				lowestDay = day;
				lowest = lowestDay.getLow();
			}
		}
		return lowestDay;
	}
}
