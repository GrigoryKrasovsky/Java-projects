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
	void shouldVerifyCorrectInfoReturnedForRacerTen() throws URISyntaxException, IOException {
		RacerBuilder racerBuilder = new RacerBuilder();

		assertEquals("LSW", racerBuilder.buildRacers().get(10).getAbbreviation());
		assertEquals("2018-05-24", racerBuilder.buildRacers().get(10).getDate().toString());
		assertEquals("12:06:13.511", racerBuilder.buildRacers().get(10).getStartTime().toString());
		assertEquals("12:07:26.834", racerBuilder.buildRacers().get(10).getEndTime().toString());
		assertEquals("WILLIAMS MERCEDES", racerBuilder.buildRacers().get(10).getTeam().toString());
		assertEquals("00:01:13.323",racerBuilder.buildRacers().get(10).getLap().toString());
	}
}
