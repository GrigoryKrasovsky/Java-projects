package com.foxminded.model;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.foxminded.builder.RacerBuilder;

public class BestLapTableModel implements TableModel{

	@Override
	public List<Racer> createTableModel() throws URISyntaxException, IOException {
		
		RacerBuilder racerBuilder = new RacerBuilder();
		
		
		List<Racer> result = racerBuilder.buildRacers().stream()
				.filter(racer -> racer.getEndTime()!=null)
				.sorted(Comparator.comparingLong(Racer::getBestLapInLong))
				.collect(Collectors.toList());
		List<Racer> badRacers = racerBuilder.buildRacers().stream()
				.filter(racer -> racer.getEndTime()==null)
				.collect(Collectors.toList());
		badRacers.stream()
				.forEach(i ->result.add(i));
		return result;
	}
}
