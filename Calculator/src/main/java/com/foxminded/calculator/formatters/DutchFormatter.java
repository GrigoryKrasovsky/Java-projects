package com.foxminded.calculator.formatters;

import static com.foxminded.calculator.model.MathUtils.*;
import com.foxminded.calculator.model.Result;

public class DutchFormatter implements Formatter {

	@Override
	public String format(Result result) {
		StringBuilder output = new StringBuilder();
		String indentIfDividendNegative = "";
		String indentIfDivisorNegative = "";

		if (result.getDividend()<0) {
			indentIfDividendNegative = " ";
		}
		if (result.getDivisor()<0) {
			indentIfDivisorNegative = " ";
		}
		int startingPoint = findLength(result.getSteps().get(0).getLocalDividend())+findLength(result.getDivisor())+3;
		output.append(result.getDivisor()+"/_"+result.getDividend()+ "\\" +result.getQuotient()+"\n");
		output.append(indentIfDivisorNegative);
		
		for (int i = 0; i<result.getSteps().size();i++) {
			if(result.getSteps().get(i).getIntermediate()==0) {
				continue;
			}
			if(i == 0) {
				
				for (int index=0;index<startingPoint;index++) {
					if(index>=startingPoint-findLength(result.getSteps().get(i).getIntermediate())-1+i) {
						break;
					}
					output.append(" "); 
				}
				
				output.append(" "+result.getSteps().get(i).getIntermediate()+"\n");
				output.append(indentIfDividendNegative);
				output.append(indentIfDivisorNegative);

				for (int index=0;index<=startingPoint+i;index++) {
					if (index < startingPoint+i-findLength(result.getSteps().get(i).getIntermediate())) {
						output.append(" "); 
					}else {
						output.append("-"); 
					}
				}
				output.append("\n");
			}else {
				for (int index=0;index<startingPoint+i;index++) {
					if(index>=startingPoint-findLength(result.getSteps().get(i).getIntermediate())-1+i) {
						break;
					}
					output.append(" "); 
				}
				output.append(indentIfDivisorNegative);
				output.append("_"+result.getSteps().get(i).getLocalDividend()+"\n");
				for (int index=0;index<startingPoint+i;index++) {
					if(index>=startingPoint-findLength(result.getSteps().get(i).getIntermediate())-1+i) {
						break;
					}
					output.append(" "); 
				}
				output.append(indentIfDivisorNegative);
				output.append(" "+result.getSteps().get(i).getIntermediate()+"\n");
				output.append(indentIfDivisorNegative);

				for (int index=0;index<=startingPoint+i;index++) {
					if (index < startingPoint+i-findLength(result.getSteps().get(i).getIntermediate())) {
						output.append(" "); 
					}else {
						output.append("-"); 
					}
				}
				output.append("\n");
			}
		}
		for(int i=0;i<findLength(result.getDividend())+findLength(result.getDivisor())+3-findLength(result.getRemainder());i++) {
			output.append(" ");
		}
		output.append(indentIfDivisorNegative);
		output.append(result.getRemainder());
		return output.toString();
	}
}
