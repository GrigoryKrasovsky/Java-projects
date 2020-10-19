package com.foxminded.parser;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.foxminded.model.DateAndTimeInfo;

class TimeParserTest {

	@Test
	void shouldVerifyCorrectTimeAndDateOutput() throws IOException, URISyntaxException {
		DateAndTimeInfo dateTimeInfo;
		Path path = Paths.get(getClass().getClassLoader()
			      .getResource("start1.log").toURI());
		Parser tp = new TimeParser(path);
		
		dateTimeInfo = (DateAndTimeInfo) tp.parse().get("VBM");
		String dateExpected = "2019-07-12";
		String timeExpected = "12:27:30.724";
		
		assertTrue(tp.parse().containsKey("VBM"));
		assertEquals(dateExpected, dateTimeInfo.getLocalDate().get(0).toString());
		assertEquals(timeExpected, dateTimeInfo.getLocalTime().get(1).toString());
	}
	@Test
	void shouldVerifyCorrectNullOutputForRacerWithoutAnyLapCompletion() throws URISyntaxException, IOException {
		

		Parser endTimeParser = new TimeParser(Paths.get(getClass().getClassLoader()
			      .getResource("end1.log").toURI()));
		
		assertNull(endTimeParser.parse().get("RKW"));
		
	}
}
