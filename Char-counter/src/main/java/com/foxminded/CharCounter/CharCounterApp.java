package com.foxminded.CharCounter;

import java.util.Map;
import java.util.Scanner;

import com.foxminded.cash.Cache;

public class CharCounterApp {
	public static void main(String[] args) {
		
	String text = "hello";
	CharCounter basic = new BasicCharCounter();
	Cache cache = new Cache();
	Map<Character, Integer> result = basic.count(text);
	cache.putText(text, result);
		System.out.println(result.toString());
	}
}
