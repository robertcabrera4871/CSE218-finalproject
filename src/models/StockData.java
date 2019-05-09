package models;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StockData {
	@JsonProperty("Meta Data")
	private MetaData metaData;
	@JsonProperty("Time Series (Daily)")
	private HashMap<String, StockDay> stocks;
	
	public MetaData getMetaData() {
		return metaData;
	}
	public void setMetaData(MetaData metaData) {
		this.metaData = metaData;
	}
	public HashMap<String, StockDay> getStocks() {
		return stocks;
	}
	public void setStocks(HashMap<String, StockDay> stocks) {
		this.stocks = stocks;
	}
	
	
}
