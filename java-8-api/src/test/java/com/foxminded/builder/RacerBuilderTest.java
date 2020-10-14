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
	void shouldVerifyCorrectNameReturned() throws URISyntaxException, IOException {
		RacerBuilder racerBuilder = new RacerBuilder();
		String expected = "Lance Stroll";
		assertEquals(expected, racerBuilder.buildRacers().get(10).getName());
	}
	@Test
	void shouldVerifyCorrectDateReturned() throws URISyntaxException, IOException {
		RacerBuilder racerBuilder = new RacerBuilder();
		String expected = "2018-05-24";
		assertEquals(expected, racerBuilder.buildRacers().get(10).getDate().toString());
	}
	@Test
	void shouldVerifyCorrectStartTimeReturned() throws URISyntaxException, IOException {
		RacerBuilder racerBuilder = new RacerBuilder();
		String expected = "12:06:13.511";
		assertEquals(expected, racerBuilder.buildRacers().get(10).getStartTime().toString());
	}
	@Test
	void shouldVerifyCorrectEndtimeReturned() throws URISyntaxException, IOException {
		RacerBuilder racerBuilder = new RacerBuilder();
		String expected = "12:07:26.834";
		assertEquals(expected, racerBuilder.buildRacers().get(10).getEndTime().toString());
	}
	@Test
	void shouldVerifyCorrectLapReturned() throws URISyntaxException, IOException {
		RacerBuilder racerBuilder = new RacerBuilder();
		String expected = "00:01:13.323";
		assertEquals(expected,racerBuilder.buildRacers().get(10).getLap().toString());
	}
	@Test
	void shouldVerifyCorrectTeamReturned() throws URISyntaxException, IOException {
		RacerBuilder racerBuilder = new RacerBuilder();
		String expected = "WILLIAMS MERCEDES";
		assertEquals(expected, racerBuilder.buildRacers().get(10).getTeam().toString());
	}
}
