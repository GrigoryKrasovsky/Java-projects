package com.foxminded.formatter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicInteger;

import com.foxminded.formatter.header_delimiter.AverageLapTimeTableHeaderAndDelimiterLine;
import com.foxminded.formatter.header_delimiter.BestLapTableHeaderAndDelimiterLine;
import com.foxminded.formatter.header_delimiter.NamesInAlphabeticalOrderTableHeaderAndDelimiterLine;
import com.foxminded.formatter.header_delimiter.NumberOfLapsTableHeaderAndDelimiterLine;
import com.foxminded.formatter.header_delimiter.TableHeaderAndDelimiterLine;
import com.foxminded.formatter.header_delimiter.TeamRacersCountTableHeaderAndDelimiterLine;
import com.foxminded.formatter.row_formatter.AverageLapTimeRowFormatter;
import com.foxminded.formatter.row_formatter.BestLapRowFormatter;
import com.foxminded.formatter.row_formatter.NamesInAlphabeticalOrderRowFormatter;
import com.foxminded.formatter.row_formatter.NumberOfLapsRowFormatter;
import com.foxminded.formatter.row_formatter.RowFormatter;
import com.foxminded.formatter.row_formatter.TeamRacersCountRowFormatter;
import com.foxminded.model.table_model.AverageLapTimeTableModel;
import com.foxminded.model.table_model.BestLapTableModel;
import com.foxminded.model.table_model.NamesInAlphabeticalOrderTableModel;
import com.foxminded.model.table_model.NumberOfLapsTableModel;
import com.foxminded.model.table_model.TableModel;
import com.foxminded.model.table_model.TeamRacersCountTableModel;

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
		
		if(this.type.equals("Racers lap count")) {
			formatter = new NumberOfLapsRowFormatter();
			model = new NumberOfLapsTableModel();
			headerAndDelimiter = new NumberOfLapsTableHeaderAndDelimiterLine();
			title = "According to the lap count:\n";
			
		}else if(this.type.equals("Racers avg lap time")){
			model = new AverageLapTimeTableModel();
			formatter = new AverageLapTimeRowFormatter();
			headerAndDelimiter = new AverageLapTimeTableHeaderAndDelimiterLine();
			title = "Racers in average lap time order:\n";
			
		}else if(this.type.equals("Racers names")){
			model = new NamesInAlphabeticalOrderTableModel();
			formatter = new NamesInAlphabeticalOrderRowFormatter();
			headerAndDelimiter = new NamesInAlphabeticalOrderTableHeaderAndDelimiterLine();
			title = "Racers in alphabetical order:\n";
			
		}else if(this.type.equals("Team racers count")){
			model = new TeamRacersCountTableModel();
			formatter = new TeamRacersCountRowFormatter();
			headerAndDelimiter = new TeamRacersCountTableHeaderAndDelimiterLine();
			title = "Teams according to the number of racers in them:\n";
			
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
