package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Test {
	public StringBuilder testMethod () throws IOException {
		StringBuilder sb = new StringBuilder();
		InputStream is = Test.class.getClassLoader().getResourceAsStream("test.txt");
		try{
			String line;
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		while ((line=reader.readLine())!=null) {
			sb.append(line).append("\n");
		}
		reader.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		

		return sb;
	}

}
