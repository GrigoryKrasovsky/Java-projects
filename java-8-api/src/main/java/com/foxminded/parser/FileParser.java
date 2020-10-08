package com.foxminded.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.foxminded.reader.FileReader;

public class FileParser {
	private final String outputString;
	public FileParser(String fileName) throws IOException {
		FileReader fr = new FileReader();
		this.outputString = fr.getBufferedString(fr.getInputStream(fileName));
		
	}
	public Map<String, String> getMapOfAbbreviationsAndData () {
		String[] lines = outputString.split("\n");
		Map<String, String>mapOfAbbreviations = new HashMap<>();
		for (String line:lines) {
			StringBuilder abbreviation = new StringBuilder();
			StringBuilder otherData = new StringBuilder();
				for (int i=0; i<line.length();i++) {
					if (i<3) {
						abbreviation.append(line.charAt(i));
					}else {
						otherData.append(line.charAt(i));
					}
					
			}
				mapOfAbbreviations.put(abbreviation.toString(), otherData.toString());
		}
		return mapOfAbbreviations;
	}
	
	public String getCertainPair(String key) {
		return getMapOfAbbreviationsAndData().get(key);
	}
}
