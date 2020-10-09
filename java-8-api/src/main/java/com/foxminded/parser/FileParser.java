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

public class FileParser {
	
	private static final DateTimeFormatter DATETIME_FORMAT = 
			DateTimeFormatter.ofPattern("uuuu-MM-dd_HH:mm:ss.SSS", Locale.ENGLISH);
	
	private final Path path;
	
	public FileParser(Path path) {
		this.path = path;	
	}
	
	public Map <Object, Object> parseRacersInfo() throws IOException {
		try (Stream<String>lines = Files.lines(path)){
			return lines.collect(Collectors.toMap(
					string -> string.substring(0,3),
					string -> Arrays.asList(string.substring(3).split("_"))));
		}
	}
}
		

