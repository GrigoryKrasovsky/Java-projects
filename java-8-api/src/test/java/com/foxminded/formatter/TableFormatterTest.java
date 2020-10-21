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

		
		
		TableFormatter tf = new TableFormatter("Best lap");
		String expected = "According to the Best Lap:\n" + 
				"\n" + 
				"No.|NAME                     |TEAM                          |BEST LAP\n" + 
				"0  |Valtteri Bottas          |MERCEDES                      |01:25.093\n" + 
				"1  |Lewis Hamilton           |MERCEDES                      |01:25.099\n" + 
				"2  |Charles Leclerc          |FERRARI                       |01:25.172\n" + 
				"3  |Max Verstappen           |RED BULL RACING HONDA         |01:25.276\n" + 
				"4  |Sebastian Vettel         |FERRARI                       |01:25.787\n" + 
				"5  |Pierre Gasly             |RED BULL RACING HONDA         |01:26.038\n" + 
				"6  |Lando Norris             |MCLAREN RENAULT               |01:26.079\n" + 
				"7  |Daniel Ricciardo         |RENAULT                       |01:26.182\n" + 
				"8  |Carlos Sainz             |MCLAREN RENAULT               |01:26.203\n" + 
				"9  |Alexander Albon          |SCUDERIA TORO ROSSO HONDA     |01:26.345\n" + 
				"10 |Romain Grosjean          |HAAS FERRARI                  |01:26.347\n" + 
				"11 |Nico Hulkenberg          |RENAULT                       |01:26.386\n" + 
				"12 |Antonio Giovinazzi       |ALFA ROMEO RACING FERRARI     |01:26.449\n" + 
				"13 |Kimi Räikkönen           |ALFA ROMEO RACING FERRARI     |01:26.546\n" + 
				"14 |Sergio Perez             |RACING POINT BWT MERCEDES     |01:26.649\n" + 
				"15 |Kevin Magnussen          |HAAS FERRARI                  |01:26.662\n" + 
				"----------------------------------------------------------------------\n" + 
				"16 |Daniil Kvyat             |SCUDERIA TORO ROSSO HONDA     |01:26.721\n" + 
				"17 |Lance Stroll             |RACING POINT BWT MERCEDES     |01:26.762\n" + 
				"18 |George Russell           |WILLIAMS MERCEDES             |01:27.789\n" + 
				"19 |Robert Kubica            |WILLIAMS MERCEDES             |Robert Kubica has not completed any laps";
		assertEquals(expected, tf.formatTable());
		
	}
}
