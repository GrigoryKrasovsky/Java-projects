package com.foxminded.tableApp;

import java.io.IOException;
import com.foxminded.reader.FileReader;

public class testApp {
	public static void main (String[] args) throws IOException {
		FileReader fr = new FileReader();
		System.out.println(fr.getBufferedString(fr.getInputStream("start.log")));
	}
}
