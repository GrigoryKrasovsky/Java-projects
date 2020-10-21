package com.foxminded.formatter;

import java.util.StringJoiner;
import com.foxminded.model.Racer;

public class NamesInAlphabeticalOrderRowFormatter implements RowFormatter{

	@Override
	public String format(Integer i, Racer racer) {
		
		StringJoiner sj = new StringJoiner("|");
		sj.add(String.format("%-3s", String.valueOf(i)))
		.add(String.format("%-25s", racer.getName()));
		return sj.toString();	
	}
}
