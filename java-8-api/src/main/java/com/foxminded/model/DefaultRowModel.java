package com.foxminded.model;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultRowModel implements RowModel{

	@Override
	public List<Racer> createRowModel(List<Racer> racerList) {
		List<Racer> result = racerList.stream()
				.filter(racer -> racer.getEndTime()!=null)
				.sorted(Comparator.comparingLong(Racer::getBestLapInLong))
				.collect(Collectors.toList());
		List<Racer> badRacers = racerList.stream()
				.filter(racer -> racer.getEndTime()==null)
				.collect(Collectors.toList());
		badRacers.stream()
				.forEach(i ->result.add(i));
		return result;
	}
}
