package com.foxminded.parser;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class FileParserTest {
	
	@Test
	void shouldVerifyCorrectAbbreviationReturned() throws IOException {
		FileParser fp = new FileParser("start.log");
		String expected = "2018-05-24_12:02:58.917";
		assertEquals(expected, fp.getCertainPair("SVF"));
	}

}
