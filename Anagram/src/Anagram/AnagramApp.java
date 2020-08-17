package Anagram;

import java.util.Scanner;
import Anagram.Anagram;

public class AnagramApp {
	public static void main(String [] args) {
		Scanner scanner = new Scanner (System.in);
		String string = scanner.nextLine();	
		Anagram anagram = new Anagram();
		System.out.print(anagram.process(string));
		
	}
}
