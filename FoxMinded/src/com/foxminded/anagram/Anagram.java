package com.foxminded.anagram;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;



public class Anagram {
	public String process(String string) {
		String finalString ="";
		char [] resultArray;
		HashMap <Integer, Character> mapOfNonLetters = new HashMap<>();
		String[] stringOfReversedWords = new String [splitString(string).length];
		
		for (int index = 0; index < splitString(string).length; index++) {
			mapOfNonLetters = getDictionaryOfNonLetterElements(splitString(string)[index]);
			resultArray = reverseString(splitString(string)[index]);
			for (Map.Entry<Integer,Character>entry:mapOfNonLetters.entrySet()) {
				resultArray = insertNonLetterElement(resultArray,entry);
			}
			
			String stringFromArray = new String(resultArray);
			
			if (index < splitString(string).length-1) {
			finalString+=stringFromArray;
			finalString+=" ";
			}else {
			finalString+=stringFromArray;
			}
		}
		return finalString;
	}
		
	public static char [] insertNonLetterElement(char [] oldArray, Map.Entry<Integer, Character>entry) {
		char [] newArray = new char[oldArray.length+1];			
		for (int index = 0; index<newArray.length; index++) {
			if (index < entry.getKey()) {
			newArray[index]=oldArray[index];
			}else if (index == entry.getKey()) {
			newArray[index] = entry.getValue();
			}else {
			newArray[index] = oldArray[index-1];
			}
		}
		return newArray;
	}

	public static char [] reverseString(String initialString) {
		String reversedString = "";
		for (int index = initialString.length()-1; index>-1;index--) {
			if (Character.isLetter(initialString.charAt(index))) {
				reversedString+=initialString.charAt(index);
			}
		}
		char [] reversedArray = new char [reversedString.length()];
		for (int index = 0; index < reversedString.length(); index++) {
			reversedArray[index] = reversedString.charAt(index);
		}
		return reversedArray;
	}

	public static HashMap getDictionaryOfNonLetterElements(String initialString) {
		HashMap<Integer, Character> mapOfNonLetters = new HashMap<>();
		for(int index=0;index < initialString.length();index++) {
			if (Character.isLetter(initialString.charAt(index))){
			}else {mapOfNonLetters.put(index, initialString.charAt(index));
			}
		}
		return mapOfNonLetters;
	}
	
	public static String [] splitString (String string) {
		String [] splitString;
		splitString = string.split(" ");
		return splitString;
	}
	
	public static String finalString (String [] inputString) {
		String finalString = "";
		for (int index = 0; index<inputString.length;index++) {
			if (index < inputString.length-1) {
				finalString += inputString[index];
				finalString +=" ";
			}else {
				finalString += inputString[index];
			}
		}
		return finalString;
	}
}

class AnagramTest {
	Anagram anagram = new Anagram();
	@Test
	void processTest() {
		
		String expected = "olleH";
		String actual = anagram.process("Hello");
		assertEquals(expected,actual);
		
	}
	@Test
	void insertNonLetterElementTest(){
		char [] oldArray = {'a','b','c'};
		Map.Entry<Integer, Character>entry = new AbstractMap.SimpleEntry<Integer, Character>(1, 'x');
		char [] expected = {'a','x','b','c'};
		char [] actual = anagram.insertNonLetterElement(oldArray, entry);
		System.out.println(anagram.insertNonLetterElement(oldArray, entry));
		assertEquals(expected,actual);
		
	}
}

