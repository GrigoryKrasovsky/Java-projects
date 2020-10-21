package com.foxminded.model.table_model;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.foxminded.builder.Builder;
import com.foxminded.model.Team;

public class TeamRacersCountTableModel implements TableModel {

	@Override
	public List<Team> createTableModel() throws URISyntaxException, IOException {
		Builder racerBuilder = new Builder();

		return racerBuilder.buildListOfTeams().stream()
				.sorted(Comparator.comparing(Team::getNumberOfRacers))
				.collect(Collectors.toList());
	}
}
