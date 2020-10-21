package com.foxminded.model.table_model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.foxminded.model.Team;

class TeamRacersCountTableModelTest {

	@Test
	void shouldVerifyCorrectRacersCountInTeams() throws URISyntaxException, IOException {
		TableModel model = new TeamRacersCountTableModel();
		Integer expected =2;
		@SuppressWarnings("unchecked")
		List<Team> list = (List<Team>) model.createTableModel();
		
		assertEquals(expected,list.stream().map(team -> team.getNumberOfRacers())
		.collect(Collectors.toList()).get(0));
	}

}
