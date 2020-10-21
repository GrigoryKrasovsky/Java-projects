package com.foxminded.formatter.header_delimiter;

import java.util.Collections;
import java.util.StringJoiner;

import com.foxminded.formatter.TableHeaderAndDelimiterLine;

public class NamesInAlphabeticalOrderTableHeaderAndDelimiterLine implements TableHeaderAndDelimiterLine{

	@Override
	public String buildHeader() {
		StringJoiner sj = new StringJoiner("|");
		String no = "No.";
		String name = "NAME";
		sj.add(String.format("%-3s", no))
		.add(String.format("%-25s", name));
		return sj.toString();

	}

	@Override
	public String buildDelimiter() {
		return String.join("", Collections.nCopies(21, "-"));
	}

}
