package com.foxminded.parser;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class FileParserTest {
	
	@Test
	void shouldVerifyCorrectDataReturned() throws IOException {
		FileParser fp = new FileParser("start.log");
		String expected = "2018-05-24_12:02:58.917";
		assertEquals(expected, fp.getCertainPair("SVF"));
	}
	
	@Test
	void shouldVerifyCorrectNameAndTeamReturned() throws IOException {
		FileParser fp = new FileParser("abbreviations.txt");
		String expected = "Sebastian Vettel_FERRARI";
		assertEquals(expected, fp.getCertainPair("SVF"));
	}
	@Test
	void shouldVerifyCorrectNameInFinalMapOfMaps() throws IOException {
		FileParser fp = new FileParser("abbreviations.txt");
		String expected = "Sebastian Vettel";
		assertEquals(expected, fp.getFinalMapWithMaps().get("SVF").get("key0"));
	}
	@Test
	void shouldVerifyCorrectTeamInFinalMapOfMaps() throws IOException {
		FileParser fp = new FileParser("abbreviations.txt");
		String expected = "RED BULL RACING TAG HEUER";
		assertEquals(expected, fp.getFinalMapWithMaps().get("DRR").get("key1"));
	}
	@Test
	void shouldVerifyCorrectTimeInFinalMapOfMaps() throws IOException {
		FileParser fp = new FileParser("start.log");
		String expected = "12:14:12.054";
		assertEquals(expected, fp.getFinalMapWithMaps().get("DRR").get("key1"));
	}

}
