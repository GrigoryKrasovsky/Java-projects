package com.foxminded.parser;

import java.io.IOException;

import com.foxminded.reader.FileReader;

public class FileParser {
	private final String outputString;
	public FileParser(String fileName) throws IOException {
		FileReader fr = new FileReader();
		this.outputString = fr.getBufferedString(fr.getInputStream("start.log"));
		
	}
	public String getAbbreviation () {
		String[] lines = outputString.split("\n");
		StringBuilder abbreviationList = new StringBuilder();
		for (String line:lines) {
			StringBuilder abbreviation = new StringBuilder();
				for (int i=0; i<3;i++) {
					abbreviation.append(line.charAt(i));
			}
			abbreviationList.append(abbreviation);
		}
		return abbreviationList.toString();
	}
}
