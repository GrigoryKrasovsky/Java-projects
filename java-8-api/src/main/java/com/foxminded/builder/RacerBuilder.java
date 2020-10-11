package com.foxminded.builder;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
		
		Map<String, List<String>> racerInfoMap = racerInfoParser.parse();
		Map<String, List<String>> startTimeMap = startTimeParser.parse();
		Map<String, List<String>> endTimeMap = endTimeParser.parse();

		return racerInfoMap.keySet().stream()
				.map(i -> new Racer (i,
						racerInfoMap.get(i).get(0),
						racerInfoMap.get(i).get(1),
						startTimeMap.get(i).get(1),
						endTimeMap.get(i).get(1),
						endTimeMap.get(i).get(0)))
				.collect(Collectors.toList());
	}
}
