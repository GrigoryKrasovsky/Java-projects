package com.foxminded.model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.foxminded.builder.Builder;
import com.foxminded.model.table_model.BestLapTableModel;
import com.foxminded.model.table_model.TableModel;

class AverageLapTimeTableModelTest {
	
	@Test
	void shouldVerifyCorrectTimeAndDateOutput() throws IOException, URISyntaxException {
		TableModel drm = new BestLapTableModel();
		String expected = "01:25.505";

		assertEquals(expected,drm.createTableModel().stream()
				.map(racer -> racer.getAverageLapTime())
				.collect(Collectors.toList()).get(0));
	}
}