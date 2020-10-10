package com.foxminded.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacerInfoParser implements Parser{
	
		private final Path path;
	
	public RacerInfoParser(Path path) {
		this.path = path;	
	}

	@Override
	public Map<Object, Object> parse() throws IOException {
		try (Stream<String>lines = Files.lines(path)){
			return lines.collect(Collectors.toMap(
					string -> string.substring(0,3),
					string -> Arrays.asList(string.substring(4).split("_"))));
		}
	}
}