package com.foxminded.parser;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.foxminded.model.Racer;
import com.foxminded.model.Racers;
import com.foxminded.reader.FileReader;

public class FileParser {
	private final String outputString;
	Stream<String> outputStream;
	public FileParser(String fileName) throws IOException, URISyntaxException {
		FileReader fr = new FileReader();
		this.outputStream = fr.getStreamFromFile(fileName);
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
						if(i==3 && line.charAt(i)=='_') {
						
						}else {
							otherData.append(line.charAt(i));
						}	
					}
				}
				mapOfAbbreviations.put(abbreviation.toString(), otherData.toString());
			}
		return mapOfAbbreviations;
	}
	
	public Map<String, Map<String, String>> getMapWithMaps(){
		Map<String, Map<String, String>> mapOfMaps = new HashMap<>();
		Map <String, String> abbreviationsAndDataMap = getMapOfAbbreviationsAndData();
		for(String element:abbreviationsAndDataMap.keySet()) {
			
			Map <String, String> insideMap = new HashMap<>();
			insideMap.put("key0",abbreviationsAndDataMap.get(element).split("_")[0]);
			insideMap.put("key1",abbreviationsAndDataMap.get(element).split("_")[1]);
			mapOfMaps.put(element, insideMap);
		}
		return mapOfMaps;
	}

	public String getCertainPair(String key) {
		return getMapOfAbbreviationsAndData().get(key);
	}
	
	public List<String> getRacersAbbreviations(){
		Racers racers = new Racers();
		return outputStream.map(line -> Arrays.asList(line.split("_")))
				.map(element -> element.get(0))
				.map(string -> string.substring(0,3)).collect(Collectors.toList());
	}
	//return outputStream.map(racers.add(new Racer("","","","","","")));
	
}
