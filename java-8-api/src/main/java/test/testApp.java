package test;

import java.io.IOException;

public class testApp {
	public static void main (String[] args) {
		Test testString = new Test();
		try {
			System.out.println(testString.testMethod());
		} catch (IOException e) {
			System.out.println("Exception");
			e.printStackTrace();
		}
	}

}
