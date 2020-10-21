package com.foxminded.builder;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.foxminded.model.Racer;
import com.foxminded.model.name_team_date_time_info.DateAndTimeInfo;
import com.foxminded.model.name_team_date_time_info.NameAndTeamInfo;
import com.foxminded.parser.Parser;
import com.foxminded.parser.RacerInfoParser;
import com.foxminded.parser.TimeParser;

public class Builder {
	public List<Racer> buildListOfRacers () throws URISyntaxException, IOException {

		Parser racerInfoParser = new RacerInfoParser(Paths.get(getClass().getClassLoader()
			      .getResource("abbreviations1.txt").toURI()));
		Parser startTimeParser = new TimeParser(Paths.get(getClass().getClassLoader()
			      .getResource("start1.log").toURI()));
		Parser endTimeParser = new TimeParser(Paths.get(getClass().getClassLoader()
			      .getResource("end1.log").toURI()));
		
		Map<String, ?> racerInfoMap = racerInfoParser.parse();
		Map<String, ?> startTimeMap = startTimeParser.parse();
		Map<String, ?> endTimeMap = endTimeParser.parse();
		

		List<Racer> badRacers = racerInfoMap.keySet().stream()
				.filter(i -> !endTimeMap.containsKey(i))
				.map(i -> new Racer (i,
						((NameAndTeamInfo) racerInfoMap.get(i)).getName(),
						((NameAndTeamInfo) racerInfoMap.get(i)).getTeam(),
						((DateAndTimeInfo) startTimeMap.get(i)).getLocalTime(),
						null,
						((DateAndTimeInfo) startTimeMap.get(i)).getLocalDate()))
				.collect(Collectors.toList());
		
				
		List<Racer> allRacers = racerInfoMap.keySet().stream()
				.filter(i -> endTimeMap.containsKey(i))
				.map(i -> new Racer (i,
						((NameAndTeamInfo) racerInfoMap.get(i)).getName(),
						((NameAndTeamInfo) racerInfoMap.get(i)).getTeam(),
						((DateAndTimeInfo) startTimeMap.get(i)).getLocalTime(),
						((DateAndTimeInfo) endTimeMap.get(i)).getLocalTime(),
						((DateAndTimeInfo) startTimeMap.get(i)).getLocalDate()))
				.collect(Collectors.toList());
		
		badRacers.stream()
				.forEach(i -> allRacers.add(i));
		
		return allRacers;
	}
}
