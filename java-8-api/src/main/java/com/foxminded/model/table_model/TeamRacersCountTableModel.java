package com.foxminded.model.table_model;

import static org.junit.jupiter.api.DynamicTest.stream;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.foxminded.builder.Builder;
import com.foxminded.model.Racer;

public class TeamRacersCountTableModel {


	public Map<String, List<Racer>> createTableModel() throws URISyntaxException, IOException {
		Builder racerBuilder = new Builder();	
		

		Map<String, List<Racer>> map = racerBuilder.buildListOfRacers().stream()
				.collect(Collectors.groupingBy(Racer::getTeam, LinkedHashMap::new, Collectors.toList()));
		return map;
		
	}
}
