package com.foxminded.formatter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicInteger;

import com.foxminded.formatter.header_delimiter.AverageLapTimeTableHeaderAndDelimiterLine;
import com.foxminded.formatter.row_formatter.AverageLapTimeRowFormatter;
import com.foxminded.model.AverageLapTimeTableModel;
import com.foxminded.model.BestLapTableModel;
import com.foxminded.model.NamesInAlphabeticalOrderTableModel;
import com.foxminded.model.TableModel;

public class TableFormatter {
	private String type;
	
	public TableFormatter(String type) {
		this.type = type;
	}

	public String formatTable() throws URISyntaxException, IOException {
		RowFormatter formatter;
		TableModel model;
		TableHeaderAndDelimiterLine headerAndDelimiter;
		String title;
		AtomicInteger i = new AtomicInteger(0);
		if(this.type.equals("Lap count")) {
			formatter = new NumberOfLapsRowFormatter();
			model = new BestLapTableModel();
			headerAndDelimiter = new NumberOfLapsTableHeaderAndDelimiterLine();
			title = "According to the Best Lap:\n";
		}else if(this.type.equals("Average")){
			model = new AverageLapTimeTableModel();
			formatter = new AverageLapTimeRowFormatter();
			headerAndDelimiter = new AverageLapTimeTableHeaderAndDelimiterLine();
			title = "Racers in average lap time order:\n";
		}else if(this.type.equals("Alphabetical order")){
			model = new NamesInAlphabeticalOrderTableModel();
			formatter = new NamesInAlphabeticalOrderRowFormatter();
			headerAndDelimiter = new NamesInAlphabeticalOrderTableHeaderAndDelimiterLine();
			title = "Racers in alphabetical order:\n";
		}else {
			formatter = new BestLapRowFormatter();
			model = new BestLapTableModel();
			headerAndDelimiter = new BestLapTableHeaderAndDelimiterLine();
			title = "According to the Best Lap:\n";
		}
		
		StringJoiner sj = new StringJoiner("\n");
		
		sj.add(title).add(headerAndDelimiter.buildHeader());
		model.createTableModel().stream().limit(16)
		.forEach(racer -> sj.add(formatter.format(i.getAndIncrement(), racer)));
		sj.add(headerAndDelimiter.buildDelimiter());
		model.createTableModel().stream().skip(16)
		.forEach(racer -> sj.add(formatter.format(i.getAndIncrement(), racer)));
		
		return sj.toString();
	}
}
