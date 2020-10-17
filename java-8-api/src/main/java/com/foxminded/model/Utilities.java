package com.foxminded.model;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.time.LocalDateTime;


public class Utilities {
	private Utilities() {
		throw new IllegalStateException("Utility class");
	}
	
	public static String convertLongToTime(long input) {

		return String.format("%1$tM:%1$tS.%1$tL", input);
	}
	
	public static List<Long> findLapTime (List<LocalTime> startTime, List<LocalTime> endTime) {
		List<Integer> numbers = Stream.iterate(0, n -> n + 1)
                .limit(endTime.size())
                .collect(Collectors.toList());
		System.out.println(numbers);
		return numbers.stream()
		.map(index ->ChronoUnit.MILLIS.between(startTime.get(index), endTime.get(index)))
		.collect(Collectors.toList());
	}
}
