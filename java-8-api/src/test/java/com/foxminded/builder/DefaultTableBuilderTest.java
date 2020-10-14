package com.foxminded.builder;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;

class DefaultTableBuilderTest {

	@Test
	void test() throws URISyntaxException, IOException {
		TableBuilder tableBuilder = new DefaultTableBuilder();
		assertEquals(1, tableBuilder.buildTable());
	}

}
