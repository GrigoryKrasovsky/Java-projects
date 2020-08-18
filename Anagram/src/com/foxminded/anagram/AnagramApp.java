package com.foxminded.anagram;

import java.util.Scanner;

import com.foxminded.anagram.Anagram;

public class AnagramApp {
	public static void main(String [] args) {
		Scanner scanner = new Scanner (System.in);
		String string = scanner.nextLine();	
		Anagram anagram = new Anagram();
		System.out.print(anagram.process(string));
		
	}
}
