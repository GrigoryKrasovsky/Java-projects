package com.foxminded.formatter.header_delimiter;

import java.util.Collections;
import java.util.StringJoiner;

import com.foxminded.formatter.TableHeaderAndDelimiterLine;

public class NumberOfLapsTableHeaderAndDelimiterLine implements TableHeaderAndDelimiterLine{

	@Override
	public String buildHeader() {
		StringJoiner sj = new StringJoiner("|");
		String no = "No.";
		String name = "NAME";
		String team = "TEAM";
		String lapCount = "LAPS NUMBER";
		sj.add(String.format("%-3s", no))
		.add(String.format("%-25s", name))
		.add(String.format("%-25s", team))
		.add(String.format("%-25s", lapCount));
		return sj.toString();
	}

	@Override
	public String buildDelimiter() {
		return String.join("", Collections.nCopies(57, "-"));
	}
}
