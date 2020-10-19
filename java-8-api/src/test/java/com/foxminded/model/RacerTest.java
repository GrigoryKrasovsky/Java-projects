package com.foxminded.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class RacerTest {

	@Test
	void shouldVerifyCorrectTimeReturned() {
	
		List<LocalTime> localTime = Arrays.asList(LocalTime.from(DateTimeFormatter.ofPattern("HH:mm:ss.SSS").parse("12:30:13.057")));
		List<LocalDate> localDate = Arrays.asList(LocalDate.parse("2018-05-24", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		
		Racer racer = new Racer("DRR", "Daniel Ricciardo", "RED BULL RACING TAG HEUER", localTime, localTime, localDate);
		List<LocalTime> expected = localTime;
		assertEquals(expected, racer.getEndTime());
	}
	
	@Test
	void shouldVerifyCorrectBestLapReturned() {
		
		List<LocalTime> startTime = Arrays.asList(LocalTime.from(DateTimeFormatter.ofPattern("HH:mm:ss.SSS").parse("12:30:13.057")),
				LocalTime.from(DateTimeFormatter.ofPattern("HH:mm:ss.SSS").parse("12:45:13.057")));
		List<LocalTime> endTime = Arrays.asList(LocalTime.from(DateTimeFormatter.ofPattern("HH:mm:ss.SSS").parse("12:36:13.057")),
				LocalTime.from(DateTimeFormatter.ofPattern("HH:mm:ss.SSS").parse("12:47:19.057")));
		List<LocalDate> localDate = Arrays.asList(LocalDate.parse("2018-05-24", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		
		Racer racer = new Racer("DRR", "Daniel Ricciardo", "RED BULL RACING TAG HEUER", startTime, endTime, localDate);
		List<String> expected = Arrays.asList("02:06.000");
		assertEquals(expected, racer.getBestLap());
	}
	@Test
	void shouldVerifyCorrectNullInput() {
		
		List<LocalTime> startTime = Arrays.asList(LocalTime.from(DateTimeFormatter.ofPattern("HH:mm:ss.SSS").parse("12:30:13.057")),
				LocalTime.from(DateTimeFormatter.ofPattern("HH:mm:ss.SSS").parse("12:45:13.057")));

		List<LocalDate> localDate = Arrays.asList(LocalDate.parse("2018-05-24", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		
		Racer racer = new Racer("DRR", "Daniel Ricciardo", "RED BULL RACING TAG HEUER", startTime, null, localDate);
		String expected = "Daniel Ricciardo has not completed any laps";
		assertEquals(expected, racer.getBestLap());
	}


}
