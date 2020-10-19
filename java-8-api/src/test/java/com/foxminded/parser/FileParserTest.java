package com.foxminded.parser;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

class FileParserTest {
	
	@Test
	void shouldVerifyCorrectgetRacersOutput() throws IOException, URISyntaxException {
		
		Path path = Paths.get(getClass().getClassLoader()
			      .getResource("abbreviations.txt").toURI());
		Parser fp = new RacerInfoParser(path);
		String expected = "12:14:12.054";
		assertTrue(fp.parse().containsKey("VBM"));
	}

}
