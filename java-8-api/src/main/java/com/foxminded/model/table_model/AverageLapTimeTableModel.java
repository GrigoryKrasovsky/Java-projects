package com.foxminded.model.table_model;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.foxminded.builder.Builder;
import com.foxminded.model.Racer;

public class AverageLapTimeTableModel implements TableModel{

	@Override
	public List<Racer> createTableModel() throws URISyntaxException, IOException {
		Builder racerBuilder = new Builder();
		
		
		List<Racer> result = racerBuilder.buildListOfRacers().stream()
				.filter(racer -> racer.getEndTime()!=null)
				.sorted(Comparator.comparingLong(Racer::getAverageLapTimeInLong))
				.collect(Collectors.toList());
		List<Racer> badRacers = racerBuilder.buildListOfRacers().stream()
				.filter(racer -> racer.getEndTime()==null)
				.collect(Collectors.toList());
		badRacers.stream()
				.forEach(i ->result.add(i));
		return result;
	}
}
