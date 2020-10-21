package com.foxminded.model;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.foxminded.builder.RacerBuilder;

public class NamesInAlphabeticalOrderTableModel implements TableModel{

	@Override
	public List<Racer> createTableModel() throws URISyntaxException, IOException {
		RacerBuilder racerBuilder = new RacerBuilder();
		
		return racerBuilder.buildRacers().stream()
				.sorted(Comparator.comparing(Racer::getName))
				.collect(Collectors.toList());
	}
}
