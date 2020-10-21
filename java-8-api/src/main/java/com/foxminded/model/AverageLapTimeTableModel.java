package com.foxminded.model;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.foxminded.builder.RacerBuilder;

public class AverageLapTimeTableModel implements TableModel{

	@Override
	public List<Racer> createTableModel() throws URISyntaxException, IOException {
		RacerBuilder racerBuilder = new RacerBuilder();	
		
		return racerBuilder.buildRacers().stream()
				.filter(racer -> racer.getEndTime()!=null)
				.sorted(Comparator.comparingInt(Racer::findNumberOfLaps).reversed())
				.collect(Collectors.toList());
	}
}
