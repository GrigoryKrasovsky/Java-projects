package com.foxminded.formatter;

import java.util.StringJoiner;

import com.foxminded.model.Racer;

public class BestLapRowFormatter implements RowFormatter{

	@Override
	public String format(Racer racer) {
		
		StringJoiner sj = new StringJoiner("|");
		sj.add(String.format("%-20s", racer.getName()))
		.add(String.format("%-25s",racer.getTeam()))
		.add(racer.getBestLap().toString());
		return sj.toString();
		
	}
}
