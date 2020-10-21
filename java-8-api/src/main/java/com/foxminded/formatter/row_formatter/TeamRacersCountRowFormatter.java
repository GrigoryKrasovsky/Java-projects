package com.foxminded.formatter.row_formatter;

import java.util.StringJoiner;

import com.foxminded.model.Racer;
import com.foxminded.model.Team;

public class  TeamRacersCountRowFormatter implements RowFormatter{

	@Override
	public String format(Integer i, Object team) {
		
		StringJoiner sj = new StringJoiner("|");
		sj.add(String.format("%-3s", String.valueOf(i)))
		.add(String.format("%-25s",((Team) team).getTeamName()))
		.add(String.format("%-20s",((Team) team).getNumberOfRacers()));
		return sj.toString();	
	}
}
