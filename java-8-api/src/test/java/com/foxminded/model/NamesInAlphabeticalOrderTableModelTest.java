package com.foxminded.model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.foxminded.model.table_model.NamesInAlphabeticalOrderTableModel;
import com.foxminded.model.table_model.TableModel;

class NamesInAlphabeticalOrderTableModelTest {

	@Test
	void shouldVerifyCorrectFirstElement() throws URISyntaxException, IOException {
		TableModel model = new NamesInAlphabeticalOrderTableModel();
		String expected = "Alexander Albon";

		@SuppressWarnings("unchecked")
		List<Racer> list = (List<Racer>) model.createTableModel();
		assertEquals(expected,list.stream()
				.map(racer -> racer.getName())
				.collect(Collectors.toList()).get(0));
	}

}
