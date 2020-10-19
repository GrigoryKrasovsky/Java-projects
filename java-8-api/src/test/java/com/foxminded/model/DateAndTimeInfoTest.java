package com.foxminded.model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

import com.foxminded.parser.Parser;
import com.foxminded.parser.TimeParser;

class DateAndTimeInfoTest {

	@Test
	void shouldVerifyCorrectDateAndTimeInfoOutput() {
		
		LocalTime localTime = LocalTime.from(DateTimeFormatter.ofPattern("HH:mm:ss.SSS").parse("12:30:13.057"));
		
		LocalDate localDate = LocalDate.parse("2018-05-24", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		DateAndTimeInfo dateAndTimeInfo = new DateAndTimeInfo(localTime,localDate);
		String expectedTime = "12:30:13.057";
		String expectedDate = "2018-05-24";
		assertEquals(expectedTime, dateAndTimeInfo.getLocalTime().get(0).toString());
		assertEquals(expectedDate, dateAndTimeInfo.getLocalDate().get(0).toString());
	}
	@Test
	void shouldVerifyCorrectNullOutput() {
		
		LocalTime localTime = null;
		
		LocalDate localDate = LocalDate.parse("2018-05-24", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		DateAndTimeInfo dateAndTimeInfo = new DateAndTimeInfo(localTime,localDate);
		String expectedTime = null;
		String expectedDate = "2018-05-24";
		assertEquals(expectedTime, dateAndTimeInfo.getLocalTime().get(0));
		assertEquals(expectedDate, dateAndTimeInfo.getLocalDate().get(0).toString());
	}
	

}
