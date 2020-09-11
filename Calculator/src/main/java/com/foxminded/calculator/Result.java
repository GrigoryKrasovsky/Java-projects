package com.foxminded.calculator;

import java.util.List;

public class Result {
	private int dividend;
	private int divisor;
	private int quotient;
	private int remainder;
	
	private List<Step> steps;
	
	public Result(int dividend, int divisor, int quotient, int remainder, List<Step> steps) {
		this.dividend=dividend;
		this.divisor=divisor;
		this.quotient=quotient;
		this.remainder=remainder;
		this.steps=steps;
		
	}
	public int getDividend() {
		return dividend;
	}
	public int getDivisor() {
		return divisor;
	}
	public int getQuotient() {
		return quotient;
	}
	public int getRemainder() {
		return remainder;
	}
	public List<Step> getSteps(){
		return steps;
	}
	public String getAllValues() {
		StringBuilder allValues = new StringBuilder();
		allValues.append(dividend+" ");
		allValues.append(divisor+" ");
		allValues.append(quotient+" ");
		allValues.append(remainder+" ");
		for (Step step:steps) {
			allValues.append(step.getLocalDividend()+" ");
			allValues.append(step.getIntermediate()+" ");
		}
		return allValues.toString();
	}

}
