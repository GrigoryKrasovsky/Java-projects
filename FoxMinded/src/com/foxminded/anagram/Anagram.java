package com.foxminded.anagram;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Anagram {
	public String process(String string) {
		if (string == null) {
			throw new IllegalArgumentException("Text cannot be null");
		}
		String finalString = reverse(string);
		return finalString;
	}
	
	public String reverse(String text) {
		String [] words = text.split(" ");
		for(int index=0; index < words.length; index++) {
			String word = words[index];
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
			word = new String(chars);
			words [index] = word;
		}
		String joinedString = String.join(" ", words);
		return joinedString;
	}
}
