package com.foxminded.model.table_model;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.foxminded.builder.Builder;
import com.foxminded.model.Racer;

public class NamesInAlphabeticalOrderTableModel implements TableModel{

	@Override
	public List<Racer> createTableModel() throws URISyntaxException, IOException {
		Builder racerBuilder = new Builder();
		
		return racerBuilder.buildListOfRacers().stream()
				.sorted(Comparator.comparing(Racer::getName))
				.collect(Collectors.toList());
	}
}
