package com.foxminded.builder;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.URISyntaxException;
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
		Map<Object, Object> expected = Stream.of(
				  new AbstractMap.SimpleEntry<>("abbreviation", "LSW"),
				  new AbstractMap.SimpleEntry<>("name", "Lance Stroll"), 
				  new AbstractMap.SimpleEntry<>("team", "WILLIAMS MERCEDES"), 
				  new AbstractMap.SimpleEntry<>("startTime", "12:06:13.511"), 
				  new AbstractMap.SimpleEntry<>("endTime", "12:07:26.834"), 
				  new AbstractMap.SimpleEntry<>("date", "2018-05-24"))
				  .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		assertEquals(expected, racerBuilder.buildRacers().get(10).toMap());
		
		Map<String,List<Racer>> map = racerBuilder.buildRacers().stream()
				.collect(Collectors.groupingBy(Racer::getStartTime));
		assertEquals(map, racerBuilder.buildRacers());

	}
}
