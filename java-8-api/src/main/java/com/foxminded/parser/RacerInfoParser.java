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
import com.foxminded.model.name_team_date_time_info.NameAndTeamInfo;


public class RacerInfoParser implements Parser{
	
		private final Path path;
	
	public RacerInfoParser(Path path) {
		this.path = path;	
	}

	@Override
	public Map <String, ?> parse() throws IOException {
		try (Stream<String>lines = Files.lines(path)){
			
			return lines.collect(Collectors.toMap(
					string -> string.substring(0,3),
					string -> new NameAndTeamInfo(string.substring(3).split("_")[1],
							string.substring(3).split("_")[2])));
		}
	}
}