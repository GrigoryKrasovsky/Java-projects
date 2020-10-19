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
		String expected = "RGH";
		assertEquals(expected, racerBuilder.buildRacers().get(10).getAbbreviation());
	}
	@Test
	void shouldVerifyCorrectNameReturned() throws URISyntaxException, IOException {
		RacerBuilder racerBuilder = new RacerBuilder();
		String expected = "Romain Grosjean";
		assertEquals(expected, racerBuilder.buildRacers().get(10).getName());
	}
	@Test
	void shouldVerifyCorrectDateReturned() throws URISyntaxException, IOException {
		RacerBuilder racerBuilder = new RacerBuilder();
		String expected = "2019-07-12";
		assertEquals(expected, racerBuilder.buildRacers().get(10).getDate().toString());
	}
	@Test
	void shouldVerifyCorrectStartTimeReturned() throws URISyntaxException, IOException {
		RacerBuilder racerBuilder = new RacerBuilder();
		String expected = "12:29:28.352";
		assertEquals(expected, racerBuilder.buildRacers().get(10).getStartTime().get(0).toString());
	}
	@Test
	void shouldVerifyCorrectEndtimeReturned() throws URISyntaxException, IOException {
		RacerBuilder racerBuilder = new RacerBuilder();
		String expected = "12:30:54.699";
		assertEquals(expected, racerBuilder.buildRacers().get(10).getEndTime().get(0).toString());
	}
	@Test
	void shouldVerifyCorrectLapReturned() throws URISyntaxException, IOException {
		RacerBuilder racerBuilder = new RacerBuilder();
		String expected = "01:26.347";
		assertEquals(expected,racerBuilder.buildRacers().get(10).getLapList().get(0).toString());
	}
	@Test
	void shouldVerifyCorrectTeamReturned() throws URISyntaxException, IOException {
		RacerBuilder racerBuilder = new RacerBuilder();
		String expected = "HAAS FERRARI";
		assertEquals(expected, racerBuilder.buildRacers().get(10).getTeam());
	}
}
