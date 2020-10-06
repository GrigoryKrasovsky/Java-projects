package com.foxminded.tableApp;

import java.io.IOException;
import java.io.InputStream;

import com.foxminded.reader.FileReader;

public class testApp {
	public static void main (String[] args) throws IOException {
		FileReader fr = new FileReader();
		System.out.println(fr.getBufferedString(fr.getInputStream("start.log")));
	}
}
