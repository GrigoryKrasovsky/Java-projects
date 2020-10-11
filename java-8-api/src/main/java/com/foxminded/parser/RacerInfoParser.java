package com.foxminded.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class RacerInfoParser implements Parser{
	
		private final Path path;
	
	public RacerInfoParser(Path path) {
		this.path = path;	
	}

	@Override
	public Map <String, List<String>> parse() throws IOException {
		try (Stream<String>lines = Files.lines(path)){
			
			Map <Object, Object> map = lines.collect(Collectors.toMap(
					string -> string.substring(0,3),
					string -> Arrays.asList(string.substring(4).split("_"))));
			
			Map<String, List<String>> result = new HashMap<>((Map) map);
			return result;
		}
	}
}