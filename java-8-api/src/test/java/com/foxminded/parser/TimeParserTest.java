package com.foxminded.parser;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

import com.foxminded.model.DateAndTimeInfo;

class TimeParserTest {

	@Test
	void shouldVerifyCorrectTimeAndDateOutput() throws IOException, URISyntaxException {
		DateAndTimeInfo dateTimeInfo;
		Path path = Paths.get(getClass().getClassLoader()
			      .getResource("start.log").toURI());
		Parser tp = new TimeParser(path);
		
		dateTimeInfo = (DateAndTimeInfo) tp.parse().get("VBM");
		String dateExpected = "2018-05-24";
		String timeExpected = "12:00";
		
		assertTrue(tp.parse().containsKey("VBM"));
		assertEquals(dateExpected, dateTimeInfo.getLocalDate().toString());
		assertEquals(timeExpected, dateTimeInfo.getLocalTime().toString());
	}
}
