package com.foxminded.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.foxminded.model.DateAndTimeInfo;

public class TimeParser implements Parser {
	
		private final Path path;
	
	public TimeParser(Path path) {
		this.path = path;	
	}

	
	@Override
	public Map <String, ?> parse() throws IOException {
		
		try (Stream<String>lines = Files.lines(path)){
			

		return lines.collect(Collectors.toMap(
				string -> string.substring(0,3),
				string -> new DateAndTimeInfo(LocalTime.from(DateTimeFormatter.ofPattern("HH:mm:ss.SSS").parse((string.substring(3).split("_")[1]))),
						LocalDate.parse(string.substring(3).split("_")[0], DateTimeFormatter.ofPattern("yyyy-MM-dd")))));
		}
	}
}
		

