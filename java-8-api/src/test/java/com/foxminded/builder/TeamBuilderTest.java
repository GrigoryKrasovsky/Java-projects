package com.foxminded.builder;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;

class TeamBuilderTest {

	@Test
	void shouldVerifyCorrectNumberOfRacersInTeam() throws URISyntaxException, IOException {
		Builder racerBuilder = new Builder();
		String expected = "RENAULT";
		assertEquals(expected, racerBuilder.buildListOfTeams().get(0).getTeamName());
	}

}
