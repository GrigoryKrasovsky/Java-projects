package com.foxminded.anagram;

import java.util.Scanner;

import com.foxminded.anagram.Anagram;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class AnagramApp {
	public static void main(String [] args) {
		Scanner scanner = new Scanner (System.in);
		String string = scanner.nextLine();	
		string = null;
		Anagram anagram = new Anagram();
		System.out.print(anagram.process(string));
		
	}
}
