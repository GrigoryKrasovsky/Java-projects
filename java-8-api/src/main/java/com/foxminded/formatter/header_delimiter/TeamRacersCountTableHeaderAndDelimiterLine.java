package com.foxminded.formatter.header_delimiter;

import java.util.Collections;
import java.util.StringJoiner;

public class TeamRacersCountTableHeaderAndDelimiterLine implements TableHeaderAndDelimiterLine{
	private static final String INDENTATION = "%-25s";
	private static final String SMALL_INDENTATION = "%-3s";

	@Override
	public String buildHeader() {

		StringJoiner sj = new StringJoiner("|");
		String no = "No.";
		String team = "TEAM";
		String racerCount = "RACERS NUMBER";
		sj.add(String.format(SMALL_INDENTATION, no))
		.add(String.format(INDENTATION, team))
		.add(String.format(INDENTATION, racerCount));
		return sj.toString();
	}

	@Override
	public String buildDelimiter() {
		return String.join("", Collections.nCopies(0, "-"));
	}
}
