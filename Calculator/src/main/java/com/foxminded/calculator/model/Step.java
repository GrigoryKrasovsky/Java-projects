package com.foxminded.calculator.model;

public class Step {
	private final int localDividend;
	private final int intermediate;

	public Step(int localDividend, int intermediate) {
		this.localDividend = localDividend;
		this.intermediate = intermediate;
	}

	public int getLocalDividend() {
		return localDividend;
	}

	public int getIntermediate() {
		return intermediate;
	}
}


