package com.foxminded.builder;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import com.foxminded.model.Racer;

class RacerBuilderTest {

	@Test
	void shouldVerifyCorrectAbbreviationReturned() throws URISyntaxException, IOException {
		RacerBuilder racerBuilder = new RacerBuilder();
		String expected = "LSW";
		assertEquals(expected, racerBuilder.buildRacers().get(10).getAbbreviation());
	}
	@Test
	void shouldVerifyCorrectGeneralInfoReturnedForRacerTen() throws URISyntaxException, IOException {
		RacerBuilder racerBuilder = new RacerBuilder();
		
		LocalTime startTime = LocalTime.from(DateTimeFormatter.ofPattern("HH:mm:ss.SSS").parse("12:06:13.511"));
		LocalTime endTime = LocalTime.from(DateTimeFormatter.ofPattern("HH:mm:ss.SSS").parse("12:07:26.834"));
		LocalDate localDate = LocalDate.parse("2018-05-24", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		Map<Object, Object> expected = Stream.of(
				  new AbstractMap.SimpleEntry<>("abbreviation", "LSW"),
				  new AbstractMap.SimpleEntry<>("name", "Lance Stroll"), 
				  new AbstractMap.SimpleEntry<>("team", "WILLIAMS MERCEDES"), 
				  new AbstractMap.SimpleEntry<>("startTime", startTime), 
				  new AbstractMap.SimpleEntry<>("endTime", endTime), 
				  new AbstractMap.SimpleEntry<>("date", localDate))
				  .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		assertEquals("LSW", racerBuilder.buildRacers().get(10).getAbbreviation());
		assertEquals(2018-05-24, racerBuilder.buildRacers().get(10).getDate());
		assertEquals(2, racerBuilder.buildRacers().get(10).getStartTime());
		assertEquals(3, racerBuilder.buildRacers().get(10).getEndTime());
		assertEquals(3, racerBuilder.buildRacers().get(10).getTeam());

		

	}
}
