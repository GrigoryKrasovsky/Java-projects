package com.foxminded.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Racer {
	private static final DateTimeFormatter DATETIME_FORMAT =
	        DateTimeFormatter.ofPattern("HH:mm:ss.SSS", Locale.ENGLISH);
	private final String abbreviation;
	private final String name;
	private final String team;
	private final LocalDateTime startTime;
	private final String endTime;
	private final String date;
	private final Period lapTime;

	
	public Racer(String abbreviation,
			String name,
			String team,
			String startTime,
			String endTime,
			String date) {
		this.abbreviation = abbreviation;
		this.name = name;
		this.team = team;
		this.startTime = LocalDateTime.parse(startTime, DATETIME_FORMAT);
		this.endTime = endTime;
		this.date = date;
		this.lapTime = null;

	}
	
	public String getAbbreviation() {
		return abbreviation;
	}
	
	public Period getLap() {
		return this.lapTime;
	}
	
	public String getName() {
		return name;
	}
	
	public String getTeam() {
		return team;
	}
	
	public LocalDateTime getStartTime() {
		return this.startTime;
	}
	
	public String getEndTime() {
		return this.endTime;
	}
	
	public String getDate() {
		return date;
	}
	public Map<String, String> toMap() {
		Map<String, String> result = new HashMap<>();
		result.put("abbreviation", abbreviation);
		result.put("name", name);
		result.put("team", team);
		result.put("startTime", startTime);
		result.put("endTime", endTime);
		result.put("date", date);
		return result;
	}
}
