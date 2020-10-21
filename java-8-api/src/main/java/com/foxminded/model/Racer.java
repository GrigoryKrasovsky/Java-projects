package com.foxminded.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

public class Racer {

	private final String abbreviation;
	private final String name;
	private final String team;
	private final List<LocalTime> startTime;
	private final List<LocalTime> endTime;
	private final List<LocalDate> date;

	
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

	}
	
	public String getAbbreviation() {
		return abbreviation;
	}
	
	public List<String> getLapTimeList() {
		return Utilities.convertLongToString(Utilities.findLapTime(startTime,endTime));
	}
	public String getAverageLapTime() {
		if(endTime == null) {
			return String.format("%s has not completed any laps", this.getName());
		}
		return Utilities.convertLongToString(Arrays.asList(Utilities.findAverage(Utilities.findLapTime(startTime,endTime)))).get(0);
	}
	public Long getAverageLapTimeInLong() {
		return Arrays.asList(Utilities.findAverage(Utilities.findLapTime(startTime,endTime))).get(0);
	}
	
	public List<Long> getLapInLong() {
		return Utilities.findLapTime(startTime,endTime);
	}
	
	public String getName() {
		return name;
	}
	
	public String getTeam() {
		return team;
	}
	
	public List<LocalTime> getStartTime() {
		return startTime;
	}
	
	public List<LocalTime> getEndTime() {
		return endTime;
	}
	
	public LocalDate getDate() {
		return date.get(0);
	}
	public Integer findNumberOfLaps() {
		if(endTime == null) {
			return 0;
		}
		return endTime.size();
	}
	public String getBestLap() {
		if(endTime == null) {
			return String.format("%s has not completed any laps", this.getName());
		}
		return Utilities.convertLongToString(Arrays.asList(Utilities.findMinNumber(Utilities.findLapTime(startTime,endTime)))).get(0);
	}
	public Long getBestLapInLong() {
		if(endTime == null) {
			return null;
		}
		return Utilities.findMinNumber(Utilities.findLapTime(startTime,endTime));
	}
}
