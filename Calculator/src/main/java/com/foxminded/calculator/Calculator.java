package com.foxminded.calculator;

import java.util.Arrays;
import java.util.StringJoiner;

public class Calculator {
	public String process(String divident, String divisor) {
		for (int index = 0; index < divident.length(); index++) {
			if (!Character.isDigit(divident.charAt(index))||!Character.isDigit(divisor.charAt(index))) {
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
		StringJoiner joiner = new StringJoiner("");
		joiner.add("_"+ divident+"|"+divisor+"\n");
		boolean firstLocalDivident = false;
		
		int index =0;
						
		while (index<divident.length()) {
			builder.append(String.valueOf(divident.charAt(index)));
			int localDivident = Integer.parseInt(builder.toString());
			index++;
			if (localDivident>=Integer.parseInt(divisor)) {
				if (firstLocalDivident) {
					joiner.add(fill(index-String.valueOf(localDivident).length(), ' ') + "_"+String.valueOf(localDivident)+"\n");
				}
				int intermediate = localDivident / Integer.parseInt(divisor)*Integer.parseInt(divisor);
				localDivident=localDivident - localDivident / Integer.parseInt(divisor)*Integer.parseInt(divisor);
				if (!firstLocalDivident) {
					joiner.add(fill(index-String.valueOf(intermediate).length(), ' ') + " "+ String.valueOf(intermediate));
					joiner.add(fill(String.valueOf(divident).length()-String.valueOf(intermediate).length(), ' ')+"|");
					if (String.valueOf(Integer.parseInt(divident)/Integer.parseInt(divisor)).length()>divisor.length()) {
						joiner.add(fill(String.valueOf(Integer.parseInt(divident)/Integer.parseInt(divisor)).length(),'-')+"\n");
					}else {
						joiner.add(fill((divisor).length(),'-')+"\n");
					}
					
					joiner.add(fill(index-String.valueOf(intermediate).length()+1, ' ')+fill(String.valueOf(intermediate).length(), '-'));
					joiner.add(fill(String.valueOf(divident).length()-String.valueOf(intermediate).length(), ' ')+"|");
					joiner.add(String.valueOf(Integer.parseInt(divident)/Integer.parseInt(divisor))+"\n");
					firstLocalDivident = true;
				}else {
				joiner.add(fill(index-String.valueOf(intermediate).length(), ' ') + " "+ String.valueOf(intermediate)+"\n");
				joiner.add(fill(index-String.valueOf(intermediate).length()+1, ' ')+fill(String.valueOf(intermediate).length(), '-')+"\n");
				}
				builder.delete(0, builder.length());
				builder.append(String.valueOf(localDivident));	
			}else if (localDivident<Integer.parseInt(divisor)&index==divident.length()){
				joiner.add(fill(index-String.valueOf(localDivident).length(), ' ')+" "+ String.valueOf(localDivident));
			}
		}
		return joiner.toString();
	}
	public String fill (int number,char charToFill) {
		char [] array = new char [number];
		Arrays.fill(array, charToFill);
		return String.valueOf(array);
	}
}