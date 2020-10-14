package com.foxminded.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Test;

class RacerTest {

	@Test
	void shouldVerifyCorrectTimeReturned() {
	
		LocalTime localTime = LocalTime.from(DateTimeFormatter.ofPattern("HH:mm:ss.SSS").parse("12:30:13.057"));
		LocalDate localDate = LocalDate.parse("2018-05-24", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		Racer racer = new Racer("DRR", "Daniel Ricciardo", "RED BULL RACING TAG HEUER", localTime, localTime, localDate);
		LocalTime expected = localTime;
		assertEquals(expected, racer.getEndTime());
	}

}
