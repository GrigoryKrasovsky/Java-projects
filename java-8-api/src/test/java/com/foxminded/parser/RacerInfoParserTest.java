package com.foxminded.parser;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class RacerInfoParserTest {

	@Test
	void shouldVerifyCorrectRacerInfo() throws IOException, URISyntaxException {
		
		Path path = Paths.get(getClass().getClassLoader()
			      .getResource("abbreviations.txt").toURI());
		Parser fp = new RacerInfoParser(path);
		assertTrue(fp.parse().containsKey("VBM"));
		assertEquals(Arrays.asList("Valtteri Bottas", "MERCEDES"), fp.parse().get("VBM"));
	}
}


