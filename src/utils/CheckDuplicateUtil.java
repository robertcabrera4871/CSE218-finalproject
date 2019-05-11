package utils;

import java.time.LocalDate;
import java.util.Iterator;

import javafx.collections.ObservableList;

public class CheckDuplicateUtil {

	public static boolean checkDupe(LocalDate datePicked, ObservableList<LocalDate> dateList) {
		Iterator<LocalDate> iterator = dateList.iterator();
		while(iterator.hasNext()) {
			LocalDate next = iterator.next();
			if(datePicked.equals(next)) {
				return false;
			}
		}
		return true;
	}

}
