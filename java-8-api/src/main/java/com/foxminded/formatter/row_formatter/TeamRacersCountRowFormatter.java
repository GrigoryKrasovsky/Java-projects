package com.foxminded.formatter.row_formatter;

import java.util.StringJoiner;

import com.foxminded.model.Racer;

public class  TeamRacersCountRowFormatter implements RowFormatter{

	@Override
	public String format(Integer i, Racer racer) {
		
		StringJoiner sj = new StringJoiner("|");
		sj.add(String.format("%-3s", String.valueOf(i)))
		.add(String.format("%-30s",racer.getTeam()));
		return sj.toString();	
	}
}
