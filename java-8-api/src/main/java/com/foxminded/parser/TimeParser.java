package com.foxminded.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TimeParser implements Parser {
	
	private static final DateTimeFormatter DATETIME_FORMAT = 
			DateTimeFormatter.ofPattern("uuuu-MM-dd_HH:mm:ss.SSS", Locale.ENGLISH);
	
	private final Path path;
	
	public TimeParser(Path path) {
		this.path = path;	
	}

	@Override
	public Map<Object, Object> parse() throws IOException {
		try (Stream<String>lines = Files.lines(path)){
			return lines.collect(Collectors.toMap(
					string -> string.substring(0,3),
					string -> Arrays.asList(string.substring(3).split("_"))));
		}
	}
}
		

