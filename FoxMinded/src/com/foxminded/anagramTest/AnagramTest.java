package com.foxminded.anagramTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.AbstractMap;
import java.util.Map;


import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import com.foxminded.anagram.Anagram;

class AnagramTest {
	Anagram anagram = new Anagram();
	@Rule
    public ExpectedException thrown= ExpectedException.none();
	@Test
	void singleWordTest() {
		
		String expected = "olleH";
		String actual = anagram.process("Hello");
		assertEquals(expected,actual);
		
	}
	@Test
	void twoWordsTest() {
		
		String expected = "olleH dlrow";
		String actual = anagram.process("Hello world");
		assertEquals(expected,actual);
	}
	@Test
	void wordsAndNonLettersTest() {
		
		String expected = "olleH123 dlr@ow!";
		String actual = anagram.process("Hello123 wor@ld!");
		assertEquals(expected,actual);
	}
	
	@Test
	void testExpectedException() {
	 
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
	    anagram.process(null);
	  });
	 
	}

}
