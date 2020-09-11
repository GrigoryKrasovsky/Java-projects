package com.foxminded.calculator;

public class ClassicFormatter implements Formatter {

	@Override
	public String format(Result result) {
		StringBuilder output = new StringBuilder("");
		String indentIfNegative = "";
		if (result.getDividend()<0) {
			indentIfNegative = " ";
		}
		int lastDigitIndex=Calculator.findLength(result.getSteps().get(0).getIntermediate());
		
		output.append("_"+result.getDividend()+"|"+result.getDivisor()+"\n");
		output.append(" "+ result.getSteps().get(0).getIntermediate());
		for(int i=0;i<Calculator.findLength(result.getDividend())-Calculator.findLength(result.getSteps().get(0).getIntermediate());i++) {
			output.append(" ");
		}
		output.append("|");
		for(int i=0;i<=Calculator.findLength(result.getQuotient());i++) {
			output.append("-");
		}
		output.append("\n ");
		output.append(indentIfNegative);
		for(int i=0;i<=Calculator.findLength(result.getDividend());i++) {
			if (i<=Calculator.findLength(result.getSteps().get(0).getIntermediate())) {
				output.append("-");
				
			}else {
				output.append(" ");
			}
		}
		output.append("|"+result.getQuotient()+"\n");
		//"�������"
		for (int i = 1; i<result.getSteps().size();i++) {
			Step step=result.getSteps().get(i);
			if(result.getSteps().get(i).getIntermediate()==0) {
				continue;
			}
			for(int index=0;index<lastDigitIndex+i;index++) {
				if(index<lastDigitIndex+i-Calculator.findLength(step.getLocalDividend())) {
					output.append(" ");
				}
			}
			output.append("_"+ step.getLocalDividend()+"\n");
			for(int index=0;index<lastDigitIndex+i;index++) {
				if(index<lastDigitIndex+i-Calculator.findLength(step.getIntermediate())) {
					output.append(" ");
				}
			}
			output.append(" "+ step.getIntermediate()+"\n"+" ");
			output.append(indentIfNegative);
			for(int index=0;index<lastDigitIndex+i+1;index++) {
				if(index<lastDigitIndex+i-Calculator.findLength(step.getIntermediate())) {
					output.append(" ");
				}else {
					output.append("-");
				}
			}
			output.append("\n");
		}
		// �������
		for (int i=0;i<Calculator.findLength(result.getDividend())-Calculator.findLength(result.getRemainder())+1;i++) {
			
			output.append(" ");
		}
		output.append(result.getRemainder());
		return output.toString();
	}
}
