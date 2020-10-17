package com.foxminded.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Racer {

	private final String abbreviation;
	private final String name;
	private final String team;
	private final List<LocalTime> startTime;
	private final List<LocalTime> endTime;
	private final List<LocalDate> date;
	private final long lapTime;

	
	public Racer(String abbreviation,
			String name,
			String team,
			List<LocalTime> startTime,
			List<LocalTime> endTime,
			List<LocalDate> date) {
		this.abbreviation = abbreviation;
		this.name = name;
		this.team = team;
		this.startTime = startTime;
		this.endTime = endTime;
		this.date = date;
		this.lapTime = ChronoUnit.MILLIS.between(startTime,endTime);

	}
	
	public String getAbbreviation() {
		return abbreviation;
	}
	
	public String getLap() {
		return Utilities.convertLongToTime(this.lapTime);
	}
	
	public long getLapInLong() {
		return lapTime;
	}
	
	public String getName() {
		return name;
	}
	
	public String getTeam() {
		return team;
	}
	
	public LocalTime getStartTime() {
		return startTime;
	}
	
	public LocalTime getEndTime() {
		return endTime;
	}
	
	public LocalDate getDate() {
		return date;
	}
}
