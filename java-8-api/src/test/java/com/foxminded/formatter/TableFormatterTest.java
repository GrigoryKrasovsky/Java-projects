package com.foxminded.formatter;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;

import com.foxminded.model.table_model.BestLapTableModel;
import com.foxminded.model.table_model.TableModel;

class TableFormatterTest {

	@Test
	void test() throws URISyntaxException, IOException {

		
		
		TableFormatter tf = new TableFormatter("Default");
		assertEquals(1, tf.formatTable());
		
	}
}
