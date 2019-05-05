package models;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StockData {
	@JsonProperty("Meta Data")
	private MetaData metaData;
	@JsonProperty("Time Series (Daily)")
	private HashMap<String, TimeSeries> timeSeries;
	
	public MetaData getMetaData() {
		return metaData;
	}
	public void setMetaData(MetaData metaData) {
		this.metaData = metaData;
	}
	public HashMap<String, TimeSeries> getTimeSeries() {
		return timeSeries;
	}
	public void setTimeSeries(HashMap<String, TimeSeries> timeSeries) {
		this.timeSeries = timeSeries;
	}
	
	
}
