package com.foxminded.builder;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.foxminded.model.DateAndTimeInfo;
import com.foxminded.model.NameAndTeamInfo;
import com.foxminded.model.Racer;
import com.foxminded.parser.Parser;
import com.foxminded.parser.RacerInfoParser;
import com.foxminded.parser.TimeParser;

public class RacerBuilder {
	public List<Racer> buildRacers () throws URISyntaxException, IOException {

		Parser racerInfoParser = new RacerInfoParser(Paths.get(getClass().getClassLoader()
			      .getResource("abbreviations.txt").toURI()));
		Parser startTimeParser = new TimeParser(Paths.get(getClass().getClassLoader()
			      .getResource("start.log").toURI()));
		Parser endTimeParser = new TimeParser(Paths.get(getClass().getClassLoader()
			      .getResource("end.log").toURI()));
		
		Map<String, ?> racerInfoMap = racerInfoParser.parse();
		Map<String, ?> startTimeMap = startTimeParser.parse();
		Map<String, ?> endTimeMap = endTimeParser.parse();

		return racerInfoMap.keySet().stream()
				.map(i -> new Racer (i,
						((NameAndTeamInfo) racerInfoMap.get(i)).getName(),
						((NameAndTeamInfo) racerInfoMap.get(i)).getTeam(),
						((DateAndTimeInfo)startTimeMap.get(i)).getLocalTime(),
						((DateAndTimeInfo)endTimeMap.get(i)).getLocalTime(),
						((DateAndTimeInfo)endTimeMap.get(i)).getLocalDate()))
				.collect(Collectors.toList());
	}
}
