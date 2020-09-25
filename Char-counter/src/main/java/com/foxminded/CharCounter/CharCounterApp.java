package com.foxminded.CharCounter;

import java.util.Map;
import java.util.Scanner;

import com.foxminded.cache.Cache;
import com.foxminded.cache.CounterDecorator;

public class CharCounterApp {
	public static void main(String[] args) {
		
	String text = "hello";
	CharCounter basic = new BasicCharCounter();
	//System.out.println(basic.count(text));
	Cache cache = new Cache();
	CounterDecorator decorator = new CounterDecorator(cache, basic);
	Map<Character, Integer> result = decorator.count(text);
		System.out.println(result.toString());
		//System.out.println(cache.contains(text));
	}
}
