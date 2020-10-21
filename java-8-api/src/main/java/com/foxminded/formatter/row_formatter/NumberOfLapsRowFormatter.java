package com.foxminded.formatter.row_formatter;

import java.util.StringJoiner;

import com.foxminded.model.Racer;

public class NumberOfLapsRowFormatter implements RowFormatter{

	@Override
	public String format(Integer i, Object racer) {
		
		StringJoiner sj = new StringJoiner("|");
		sj.add(String.format("%-3s", String.valueOf(i)))
		.add(String.format("%-25s", ((Racer) racer).getName()))
		.add(String.format("%-25s", ((Racer) racer).getTeam()))
		.add(String.format("%-25s", ((Racer) racer).findNumberOfLaps()));
		return sj.toString();	
	}
}
