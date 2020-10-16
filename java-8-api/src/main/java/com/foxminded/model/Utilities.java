package com.foxminded.model;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.time.LocalDateTime;


public class Utilities {
	private Utilities() {
		throw new IllegalStateException("Utility class");
	}
	
	public static String convertLongToTime(long input) {

		return String.format("%1$tM:%1$tS.%1$tL", input);
	}
}
