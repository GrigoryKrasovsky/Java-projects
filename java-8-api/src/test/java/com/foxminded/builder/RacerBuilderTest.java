package com.foxminded.builder;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import com.foxminded.model.Racer;

class RacerBuilderTest {

	@Test
	void shouldVerifyCorrectAbbreviationReturned() throws URISyntaxException, IOException {
		Builder racerBuilder = new Builder();
		String expected = "RGH";
		assertEquals(expected, racerBuilder.buildListOfRacers().get(10).getAbbreviation());
	}
	@Test
	void shouldVerifyCorrectNameReturned() throws URISyntaxException, IOException {
		Builder racerBuilder = new Builder();
		String expected = "Romain Grosjean";
		assertEquals(expected, racerBuilder.buildListOfRacers().get(10).getName());
	}
	@Test
	void shouldVerifyCorrectDateReturned() throws URISyntaxException, IOException {
		Builder racerBuilder = new Builder();
		String expected = "2019-07-12";
		assertEquals(expected, racerBuilder.buildListOfRacers().get(10).getDate().toString());
	}
	@Test
	void shouldVerifyCorrectStartTimeReturned() throws URISyntaxException, IOException {
		Builder racerBuilder = new Builder();
		String expected = "12:29:28.352";
		assertEquals(expected, racerBuilder.buildListOfRacers().get(10).getStartTime().get(0).toString());
	}
	@Test
	void shouldVerifyCorrectEndtimeReturned() throws URISyntaxException, IOException {
		Builder racerBuilder = new Builder();
		String expected = "12:30:54.699";
		assertEquals(expected, racerBuilder.buildListOfRacers().get(10).getEndTime().get(0).toString());
	}
	@Test
	void shouldVerifyCorrectLapReturned() throws URISyntaxException, IOException {
		Builder racerBuilder = new Builder();
		String expected = "01:26.347";
		assertEquals(expected,racerBuilder.buildListOfRacers().get(10).getLapTimeList().get(0).toString());
	}
	@Test
	void shouldVerifyCorrectTeamReturned() throws URISyntaxException, IOException {
		Builder racerBuilder = new Builder();
		String expected = "HAAS FERRARI";
		assertEquals(expected, racerBuilder.buildListOfRacers().get(10).getTeam());
	}
	@Test
	void shouldVerifyCorrectLapsNumber() throws URISyntaxException, IOException {
		Builder racerBuilder = new Builder();
		Integer expected = 2;
		assertEquals(expected, racerBuilder.buildListOfRacers().get(10).findNumberOfLaps());
	}
	@Test
	void shouldVerifyCorrectAverageLapTime() throws URISyntaxException, IOException {
		Builder racerBuilder = new Builder();
		String expected = "01:26.552";
		assertEquals(expected, racerBuilder.buildListOfRacers().get(10).getAverageLapTime());
	}
	@Test
	void shouldVerifyCorrectAverageLapTimeInList() throws URISyntaxException, IOException {
		Builder racerBuilder = new Builder();
		Long expected = 86552L;
		assertEquals(expected, racerBuilder.buildListOfRacers().get(10).getAverageLapTimeInLong());
	}

}
