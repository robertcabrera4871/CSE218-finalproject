package models;

import java.util.HashMap;

public class CompareHashMap {
	private HashMap<Integer, StockDay> compareMap;
	private Integer nElems;
	private int maxSize;
	
	public CompareHashMap(int maxSize) {
		this.maxSize = maxSize;
		this.compareMap = new HashMap<Integer, StockDay>(maxSize);
		this.nElems = 0;
	}
	public void clear() {
		compareMap.clear();
		nElems = 0;
	}
	public void put(StockDay day) {
		compareMap.put(nElems++, day);
	}
	public HashMap<Integer, StockDay> getCompareMap() {
		return compareMap;
	}
	
}
