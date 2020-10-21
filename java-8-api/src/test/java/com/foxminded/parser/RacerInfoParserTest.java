package com.foxminded.parser;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.foxminded.model.name_team_date_time_info.NameAndTeamInfo;

class RacerInfoParserTest {

	@Test
	void shouldVerifyCorrectRacerInfo() throws IOException, URISyntaxException {
		
		Path path = Paths.get(getClass().getClassLoader()
			      .getResource("abbreviations.txt").toURI());
		Parser fp = new RacerInfoParser(path);
		assertTrue(fp.parse().containsKey("VBM"));
		NameAndTeamInfo nameAndTeamInfo = (NameAndTeamInfo)fp.parse().get("VBM");
		
		assertEquals(Arrays.asList("Valtteri Bottas", "MERCEDES"), Arrays.asList(nameAndTeamInfo.getName(),nameAndTeamInfo.getTeam()));
	}
}


