package com.foxminded.parser;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;

class FileParserTest {
	
	@Test
	void shouldVerifyCorrectDataReturned() throws IOException, URISyntaxException {
		FileParser fp = new FileParser("start.log");
		String expected = "2018-05-24_12:02:58.917";
		assertEquals(expected, fp.getCertainPair("SVF"));
	}
	
	@Test
	void shouldVerifyCorrectNameAndTeamReturned() throws IOException, URISyntaxException {
		FileParser fp = new FileParser("abbreviations.txt");
		String expected = "Sebastian Vettel_FERRARI";
		assertEquals(expected, fp.getCertainPair("SVF"));
	}
	@Test
	void shouldVerifyCorrectNameInMapOfMaps() throws IOException, URISyntaxException {
		FileParser fp = new FileParser("abbreviations.txt");
		String expected = "Sebastian Vettel";
		assertEquals(expected, fp.getMapWithMaps().get("SVF").get("key0"));
	}
	@Test
	void shouldVerifyCorrectTeamInMapOfMaps() throws IOException, URISyntaxException {
		FileParser fp = new FileParser("abbreviations.txt");
		String expected = "RED BULL RACING TAG HEUER";
		assertEquals(expected, fp.getMapWithMaps().get("DRR").get("key1"));
	}
	@Test
	void shouldVerifyCorrectTimeInMapOfMaps() throws IOException, URISyntaxException {
		FileParser fp = new FileParser("start.log");
		String expected = "12:14:12.054";
		assertEquals(expected, fp.getMapWithMaps().get("DRR").get("key1"));
	}
	
	@Test
	void shouldVerifyCorrectStreamOutput() throws IOException, URISyntaxException {
		FileParser fp = new FileParser("start.log");
		String expected = "12:14:12.054";
		assertEquals(expected, fp.getMapWithMaps().get("DRR").get("key1"));
	}

}
