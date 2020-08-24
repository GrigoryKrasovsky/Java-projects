package com.foxminded.anagram;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Anagram {
	public String process(String string) {
		if (string == null) {
			throw new IllegalArgumentException("Text cannot be null");
		}
		StringJoiner joiner = new StringJoiner(" ");
		for(String word:string.split(" ")) {
			String reversedWord = new String(reverse(word));
			joiner.add(reversedWord);
		}
		return joiner.toString();
		
	}
	
	public char [] reverse(String word) {
		char [] chars = new char [word.length()];
		int leftIndex = 0;
		int rightIndex = word.length()-1;
		while (leftIndex <= rightIndex) {
			if(!Character.isLetter(word.charAt(leftIndex))&Character.isLetter(word.charAt(rightIndex))){
				chars[leftIndex]= word.charAt(leftIndex);
				leftIndex++;
			}else if(!Character.isLetter(word.charAt(rightIndex))&Character.isLetter(word.charAt(leftIndex))){
				chars[rightIndex]= word.charAt(rightIndex);
				rightIndex--;
			}else if (Character.isLetter(word.charAt(leftIndex))&Character.isLetter(word.charAt(rightIndex))) {
				chars[leftIndex] = word.charAt(rightIndex);
				chars[rightIndex] = word.charAt(leftIndex);
				leftIndex++;
				rightIndex--;
			}
		}	
		return chars;
	}
}
