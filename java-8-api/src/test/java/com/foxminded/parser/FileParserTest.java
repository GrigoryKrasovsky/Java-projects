package com.foxminded.parser;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class FileParserTest {
	
	@Test
	void shouldVerifyCorrectAbbreviationReturned() throws IOException {
		FileParser fp = new FileParser("start.log");
		String expected = "SVF";
		assertEquals(expected, fp.getCertainAbbreviation(0));
	}

}
