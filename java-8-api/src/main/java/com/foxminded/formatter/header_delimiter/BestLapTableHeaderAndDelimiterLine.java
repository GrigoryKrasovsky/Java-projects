package com.foxminded.formatter.header_delimiter;

import java.util.Collections;
import java.util.StringJoiner;

public class BestLapTableHeaderAndDelimiterLine implements TableHeaderAndDelimiterLine{

	@Override
	public String buildHeader() {
		StringJoiner sj = new StringJoiner("|");
		String no = "No.";
		String name = "NAME";
		String team = "TEAM";
		String bestLap = "BEST LAP";
		sj.add(String.format("%-3s", no))
		.add(String.format("%-25s", name))
		.add(String.format("%-30s", team))
		.add(bestLap);
		return sj.toString();

	}

	@Override
	public String buildDelimiter() {
		return String.join("", Collections.nCopies(70, "-"));
	}

}
