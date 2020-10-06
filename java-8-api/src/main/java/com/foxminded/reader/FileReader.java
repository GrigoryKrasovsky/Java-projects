package com.foxminded.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileReader {
	public InputStream getInputStream(String pathToFile){
		return FileReader.class.getClassLoader().getResourceAsStream(pathToFile);
	}
	public String getBufferedString (InputStream is) throws IOException{
		StringBuilder sb = new StringBuilder();
		try {
			String line;
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			while((line = reader.readLine())!=null) {
				sb.append(line).append("\n");
			}
		}catch (IOException e) {
			e.printStackTrace();
			System.out.println("File is absent");
		}
		return sb.toString();
	}
}