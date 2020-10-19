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
	//private final List<Long> lapTime;

	
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
		//this.lapTime = Utilities.findLapTime(startTime,endTime);

	}
	
	public String getAbbreviation() {
		return abbreviation;
	}
	
	public List<String> getLapList() {
		return Utilities.convertLongToTime(Utilities.findLapTime(startTime,endTime));
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
		return endTime.size();
	}
	public <T> T getBestLap() {
		if(endTime == null) {
			return (T) String.format("%s has not completed any laps", this.getName());
		}
		return (T)Utilities.convertLongToTime(Arrays.asList(Utilities.findMinNumber(Utilities.findLapTime(startTime,endTime))));
	}
	public <T> T getBestLapInLong() {
		if(endTime == null) {
			return (T) String.format("%s has not completed any laps", this.getName());
		}
		return (T)Utilities.findMinNumber(Utilities.findLapTime(startTime,endTime));
	}
}
