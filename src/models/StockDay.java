package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StockDay {
	private double open;
	private double high;
	private double low;
	private double close;
	private long volume;
	
	@JsonCreator
	public StockDay(@JsonProperty("1. open")double open, @JsonProperty("2. high")double high, 
			@JsonProperty("3. low")double low, @JsonProperty("4. close")double close,@JsonProperty("5. volume") long volume) {
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
	}

	public double getOpen() {
		return open;
	}

	public void setOpen(double open) {
		this.open = open;
	}

	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public double getLow() {
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public double getClose() {
		return close;
	}

	public void setClose(double close) {
		this.close = close;
	}

	public long getVolume() {
		return volume;
	}

	public void setVolume(long volume) {
		this.volume = volume;
	}

	public String toString() {
		return "StockDay [open=" + open + ", high=" + high + ", low=" + low + ", close=" + close + ", volume=" + volume
				+ "]";
	}

	
}
