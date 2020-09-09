package com.foxminded.calculator;

class Step {
	private int localDividend;
	private int intermediate;
	public Step(int localDividend, int intermediate) {
		this.localDividend=localDividend;
		this.intermediate=intermediate;
	}
	public int getLocalDividend() {
		return localDividend;
	}
	public int getIntermediate() {
		return intermediate;
	}
}


