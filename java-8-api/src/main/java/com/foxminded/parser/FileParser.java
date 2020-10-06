package com.foxminded.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.foxminded.reader.FileReader;

public class FileParser {
	private final String outputString;
	public FileParser(String fileName) throws IOException {
		FileReader fr = new FileReader();
		this.outputString = fr.getBufferedString(fr.getInputStream(fileName));
		
	}
	public List<StringBuilder> getAbbreviations () {
		String[] lines = outputString.split("\n");
		List <StringBuilder>listOfAbbreviations = new ArrayList<>();
		StringBuilder abbreviationListAsString = new StringBuilder(" ");
		for (String line:lines) {
			StringBuilder abbreviation = new StringBuilder();
				for (int i=0; i<3;i++) {
					abbreviation.append(line.charAt(i));
			}
				listOfAbbreviations.add(abbreviation);
				abbreviationListAsString.append(abbreviation).append(",");
		}
		return listOfAbbreviations;
	}
	
	public String getCertainAbbreviation(int number) {
		return getAbbreviations().get(number).toString();
	}
}
