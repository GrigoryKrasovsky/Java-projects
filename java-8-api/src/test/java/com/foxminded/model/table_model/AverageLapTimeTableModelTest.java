package com.foxminded.model.table_model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.foxminded.builder.Builder;
import com.foxminded.model.Racer;
import com.foxminded.model.table_model.BestLapTableModel;
import com.foxminded.model.table_model.TableModel;

class AverageLapTimeTableModelTest {
	
	@Test
	void shouldVerifyCorrectTimeAndDateOutput() throws IOException, URISyntaxException {
		TableModel model = new BestLapTableModel();
		String expected = "01:25.505";
		
		@SuppressWarnings("unchecked")
		List<Racer> list = (List<Racer>) model.createTableModel();

		assertEquals(expected, list.stream()
				.map(racer -> racer.getAverageLapTime())
				.collect(Collectors.toList()).get(0));
	}
}