package com.foxminded.model;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultTableModel implements TableModel{

	@Override
	public List<Racer> createTableModel(List<Racer> racerList) {
		return racerList.stream()
				.sorted(Comparator.comparingLong(Racer::getLapInLong))
				.collect(Collectors.toList());
	}

}