package com.foxminded.formatter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.StringJoiner;

import com.foxminded.model.BestLapTableModel;
import com.foxminded.model.TableModel;

public class TableFormatter {
	private String type;
	
	public TableFormatter(String type) {
		this.type = type;
	}
	
	
	
	public String formatTable() throws URISyntaxException, IOException {
		RowFormatter formatter;
		TableModel model;
		if(this.type.equals("Best Lap")) {
			formatter = new BestLapRowFormatter();
			model = new BestLapTableModel();
			
			System.out.println("According to the Best Lap:\n\n");
		}else {
			model = new BestLapTableModel();
			formatter = new BestLapRowFormatter();
		}
		
		StringJoiner sj = new StringJoiner("\n");
		
		model.createTableModel().stream()
		.forEach(racer -> sj.add(formatter.format(racer)));
		
		return sj.toString();
	}
}
