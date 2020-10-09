package com.foxminded.result;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;

import com.foxminded.model.Result;
import com.foxminded.parser.FileParser;

class ResultTest {
	
		
	@Test
	void shouldVerifyCorrectNameFromResult() throws IOException, URISyntaxException {
		FileParser abbreviationsFP = new FileParser("abbreviations.txt");
		FileParser startFP = new FileParser("start.log");
		FileParser endFP = new FileParser("end.log");
		
		Result result = new Result(abbreviationsFP.getMapWithMaps(),startFP.getMapWithMaps(), endFP.getMapWithMaps());
		String expected = "Daniel Ricciardo";
		assertEquals(expected, result.getName("DRR"));
	}
	
	@Test
	void shouldVerifyCorrectStartTimeFromResult() throws IOException, URISyntaxException {
		FileParser abbreviationsFP = new FileParser("abbreviations.txt");
		FileParser startFP = new FileParser("start.log");
		FileParser endFP = new FileParser("end.log");
		
		Result result = new Result(abbreviationsFP.getMapWithMaps(),startFP.getMapWithMaps(), endFP.getMapWithMaps());
		String expected = "12:14:12.054";
		assertEquals(expected, result.getStartTime("DRR"));
	}
	
	@Test
	void shouldVerifyCorrectEndTimeFromResult() throws IOException, URISyntaxException {
		FileParser abbreviationsFP = new FileParser("abbreviations.txt");
		FileParser startFP = new FileParser("start.log");
		FileParser endFP = new FileParser("end.log");
		
		Result result = new Result(abbreviationsFP.getMapWithMaps(),startFP.getMapWithMaps(), endFP.getMapWithMaps());
		String expected = "12:15:24.067";
		assertEquals(expected, result.getEndTime("DRR"));
	}
	
	@Test
	void shouldVerifyCorrectDateFromResult() throws IOException, URISyntaxException {
		FileParser abbreviationsFP = new FileParser("abbreviations.txt");
		FileParser startFP = new FileParser("start.log");
		FileParser endFP = new FileParser("end.log");
		
		Result result = new Result(abbreviationsFP.getMapWithMaps(),startFP.getMapWithMaps(), endFP.getMapWithMaps());
		String expected = "2018-05-24";
		assertEquals(expected, result.getDate("DRR"));
	}
}
