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

import com.foxminded.model.name_team_date_time_info.DateAndTimeInfo;

public class TimeParser implements Parser {
	
		private final Path path;
		private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
		private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public TimeParser(Path path) {
		this.path = path;	
	}

	
	@Override
	public Map <String, ?> parse() throws IOException {
		
		try (Stream<String>lines = Files.lines(path)){
			

		return lines.collect(Collectors.toMap(
				string -> string.substring(0,3),
				string -> new DateAndTimeInfo(LocalTime.from(TIME_FORMATTER.parse((string.substring(3).split("_")[1]))),
						LocalDate.parse(string.substring(3).split("_")[0], DATE_FORMATTER)),
				(string1, string2)->string1.addAnotherLapTime(string2)));
		}
	}
}
		

