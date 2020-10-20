package com.foxminded.model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.foxminded.builder.RacerBuilder;

class BestLapTableModelTest {

	@Test
	void shouldVerifyCorrectTimeAndDateOutput() throws IOException, URISyntaxException {
		TableModel drm = new BestLapTableModel();
		String expected = "01:25.093";

		System.out.println(drm.createTableModel().stream()
				.map(racer -> racer.getBestLap())
				.collect(Collectors.toList()));
		
		assertEquals(expected,drm.createTableModel().stream()
				.map(racer -> racer.getBestLap())
				.collect(Collectors.toList()).get(0));
	}
}