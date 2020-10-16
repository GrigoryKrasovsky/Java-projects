package com.foxminded.builder;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.URISyntaxException;
import org.junit.jupiter.api.Test;

import com.foxminded.model.Racer;

class DefaultTableBuilderTest {

	@Test
	void shouldVerifyCorrectMapReturned() throws URISyntaxException, IOException {
		RacerBuilder racerBuilder = new RacerBuilder();
		Racer testRacer = racerBuilder.buildRacers().get(0);
		
		TableBuilder tableBuilder = new DefaultTableBuilder();
		/*tableBuilder.buildTable().keySet().stream().collect(collector)
		for (Long key:tableBuilder.buildTable().keySet()) {
			System.out.println(tableBuilder.buildTable().get(key).get(0).getName()+" "+tableBuilder.buildTable().get(key).get(0).getLap());
		}*/
		String expected = testRacer.getName();
		assertTrue(tableBuilder.buildTable().containsKey(testRacer.getLapInLong()));
		System.out.println("here");
		assertEquals(expected, tableBuilder.buildTable().get(testRacer.getLapInLong()).get(0).getName());
	}

}
