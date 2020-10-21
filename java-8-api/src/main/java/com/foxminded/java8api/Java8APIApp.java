package com.foxminded.java8api;

import java.io.IOException;
import java.net.URISyntaxException;

import com.foxminded.formatter.TableFormatter;

public class Java8APIApp {

	public static void main(String[] args) throws URISyntaxException, IOException {
		TableFormatter tf = new TableFormatter("Lap count");
		System.out.println(tf.formatTable());
	}
}
