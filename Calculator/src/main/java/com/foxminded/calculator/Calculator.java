package com.foxminded.calculator;

import java.util.Arrays;
import java.util.StringJoiner;

public class Calculator {
	public String process(String divident, String divisor) {
		for (int index = 0; index < divident.length(); index++) {
			if (!Character.isDigit(divident.charAt(index))) {
				throw new IllegalArgumentException("Only numbers can be processed");
			}
		}
		for (int index = 0; index < divisor.length(); index++) {
			if (!Character.isDigit(divisor.charAt(index))) {
				throw new IllegalArgumentException("Only numbers can be processed");
			}
		}
		
		char [] spacing = new char[divident.length()];
		for (int index = 0;index<spacing.length;index++) {
			spacing[index]=' ';
		}
		String strspc = String.valueOf(spacing);
		
		char [] divisorSpacing = new char[divisor.length()];
		for (int index = 0;index<divisorSpacing.length;index++) {
			divisorSpacing[index]='-';
		}
		String dvsrSpc = String.valueOf(divisorSpacing);
	
		StringJoiner joiner = new StringJoiner("");
		
		
		return joiner.toString();
	}
	public String divide (String divident, String divisor) {
		
		StringBuilder builder = new StringBuilder("");
		StringJoiner testJoiner = new StringJoiner("");
		testJoiner.add(String.valueOf(divident.length())+"\n");
		StringJoiner joiner = new StringJoiner("");
		joiner.add("_"+ divident+"|"+divisor+"\n");
		
		int index =0;
						
		while (index<divident.length()) {
			
			builder.append(String.valueOf(divident.charAt(index)));
			int localDivident = Integer.parseInt(builder.toString());
			index++;
			
			if (localDivident>=Integer.parseInt(divisor)) {
				
				if (index!=divident.length()-String.valueOf(localDivident).length()-1) {
					

					joiner.add(padding(index-String.valueOf(localDivident).length()-1, ' ') + " _"+String.valueOf(localDivident)+"\n");
					
					
					testJoiner.add("local " + String.valueOf(localDivident)+ "\n");
					testJoiner.add("local padding " + String.valueOf(divident.length()-index));
					testJoiner.add("\n");
				}
				
				
				
				int intermediate = localDivident / Integer.parseInt(divisor)*Integer.parseInt(divisor);
				localDivident=localDivident - localDivident / Integer.parseInt(divisor)*Integer.parseInt(divisor);
				if (index==divident.length()-String.valueOf(localDivident).length()-2) {
					joiner.add("index " + String.valueOf(index)+"\n");
					joiner.add("div loc " + String.valueOf(divident.length())+" "+ String.valueOf(localDivident).length()+"\n");
					joiner.add(padding(index-String.valueOf(intermediate).length(), ' ') + " "+ String.valueOf(intermediate));
					joiner.add(padding(String.valueOf(divident).length()-String.valueOf(intermediate).length(), ' ')+"|");
					joiner.add(padding(String.valueOf(Integer.parseInt(divident)/Integer.parseInt(divisor)).length(),'-')+"\n");
					joiner.add(padding(index-String.valueOf(intermediate).length()+1, ' ')+padding(String.valueOf(intermediate).length(), '-'));
					joiner.add(padding(String.valueOf(divident).length()-String.valueOf(intermediate).length(), ' ')+"|");
					joiner.add(String.valueOf(Integer.parseInt(divident)/Integer.parseInt(divisor))+"\n");

				}else {
				joiner.add(padding(index-String.valueOf(intermediate).length(), ' ') + " "+ String.valueOf(intermediate)+"\n");
				joiner.add(padding(index-String.valueOf(intermediate).length()+1, ' ')+padding(String.valueOf(intermediate).length(), '-')+"\n");
				}
				testJoiner.add("index "+String.valueOf(index)+"\n");
				testJoiner.add("intermediate " + String.valueOf(intermediate)+ "\n");
				testJoiner.add("intermediate padding " + String.valueOf(divident.length()-index)+ "\n");
				testJoiner.add("alt left padding "+String.valueOf(index-String.valueOf(intermediate).length())+"\n");
				testJoiner.add("left intermediate padding " + String.valueOf(divident.length()-(divident.length()-index+String.valueOf(intermediate).length()))+ "\n");
				
				
				
				
				

				testJoiner.add("\n");
				/*неполный localDivident*/
				if (index==divident.length()) {
					testJoiner.add(String.valueOf("bottom number "+localDivident));
					joiner.add(padding(index-String.valueOf(localDivident).length(), ' ')+" "+ String.valueOf(localDivident));
				}
				
				builder.delete(0, builder.length());
				builder.append(String.valueOf(localDivident));
				
				
			}
		}
		
		
		return joiner.toString();
	}
	public String padding (int number,char charToFill) {
		char [] array = new char [number];
		Arrays.fill(array, charToFill);
		return String.valueOf(array);
	}
}