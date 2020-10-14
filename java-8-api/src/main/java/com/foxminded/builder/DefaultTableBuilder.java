package com.foxminded.builder;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.foxminded.model.Racer;

public class DefaultTableBuilder implements TableBuilder {

	@Override
	public Map<?, List<Racer>> buildTable() throws URISyntaxException, IOException {
		
		RacerBuilder racerBuilder = new RacerBuilder();

		return racerBuilder.buildRacers().stream()
				.collect(Collectors.groupingBy(Racer::getName));		
	}
}
