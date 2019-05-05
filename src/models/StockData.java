package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import demo.MetaData;

//@JsonIgnoreProperties(ignoreUnknown=true)
public class StockData {
	@JsonProperty("Meta Data")
	private MetaData metaData;
	@JsonProperty("Time Series (Daily)")
	private TimeSeries timeSeries;
	
	public MetaData getMetaData() {
		return metaData;
	}
	public void setMetaData(MetaData metaData) {
		this.metaData = metaData;
	}
	@Override
	public String toString() {
		return "StockData [metaData=" + metaData + ", \ntimeSeries=" + timeSeries + "]";
	}
	public TimeSeries getTimeSeries() {
		return timeSeries;
	}
	public void setTimeSeries(TimeSeries timeSeries) {
		this.timeSeries = timeSeries;
	}
	
}
