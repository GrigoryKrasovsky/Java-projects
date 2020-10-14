package com.foxminded.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;

import org.junit.jupiter.api.Test;

class RacerTest {

	@Test
	void test() {
	
		
		
		
		Racer racer = new Racer("DRR", "Daniel Ricciardo", "RED BULL RACING TAG HEUER", "12:14", "12:15:24.067", "2018-05-24");
		int expected = 1;
		assertEquals(expected, racer.getEndTime());
	}

}
