package models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TimeSeries {
	@JsonProperty("2019-05-01")
	private StockDay stockDay;

	public StockDay getStockDay() {
		return stockDay;
	}

	public void setStockDay(StockDay stockDay) {
		this.stockDay = stockDay;
	}

	@Override
	public String toString() {
		return "TimeSeries [stockDay=" + stockDay + "]";
	}
	
}
