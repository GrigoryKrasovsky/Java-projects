package com.foxminded.parser;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class TimeParserTest {

	@Test
	void shouldVerifyCorrectgetRacersOutput() throws IOException, URISyntaxException {
		
		Path path = Paths.get(getClass().getClassLoader()
			      .getResource("start.log").toURI());
		Parser fp = new TimeParser(path);
		assertTrue(fp.parse().containsKey("VBM"));
		assertEquals(Arrays.asList("2018-05-24","12:00:00.000"), fp.parse().get("VBM"));
	}
}
