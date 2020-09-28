package com.foxminded.charcounter;

import java.util.Map;
import java.util.Scanner;

import com.foxminded.cache.CharMapCache;

public class CharCounterApp {
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	int i=0;
	CharCounter basic = new BasicCharCounter();
	CharMapCache cache = new CharMapCache();
	CachingCharCounterDecorator decorator = new CachingCharCounterDecorator(cache, basic);
	while (i<10) {
			i++;
			String text =scanner.nextLine();
			Map<Character, Integer> result = decorator.count(text);
			System.out.println(result.toString());
		}
	scanner.close();
	}
}
