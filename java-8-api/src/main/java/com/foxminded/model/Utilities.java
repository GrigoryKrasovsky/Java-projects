package com.foxminded.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Utilities {
	private Utilities() {
		throw new IllegalStateException("Utility class");
	}
	private static List<Integer> convertLongToList(long input) {
		
		List<Integer> list = new ArrayList<>();
		
		int h = (int) (input/1000/60/60);
		int m = (int) (input/1000/60);
		int s = (int) (input/1000%60);
		int sss = (int) (input%1000);
		list.add(h);
		list.add(m);
		list.add(s);
		list.add(sss*1000000);
		
		return list;
	}
	
	public static LocalTime convertLongToTime(long input) {

		List<Integer> list = convertLongToList(input);		
		return LocalTime.of(list.get(0),
				list.get(1),
				list.get(2),
				list.get(3));
	}
}
