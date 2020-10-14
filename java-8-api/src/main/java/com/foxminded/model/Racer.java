package com.foxminded.model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Racer {

	private final String abbreviation;
	private final String name;
	private final String team;
	private final LocalTime startTime;
	private final LocalTime endTime;
	private final LocalDate date;
	private final Period lapTime;

	
	public Racer(String abbreviation,
			String name,
			String team,
			LocalTime startTime,
			LocalTime endTime,
			LocalDate date) {
		this.abbreviation = abbreviation;
		this.name = name;
		this.team = team;
		this.startTime = startTime;
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
	
	public LocalTime getStartTime() {
		return this.startTime;
	}
	
	public LocalTime getEndTime() {
		return this.endTime;
	}
	
	public LocalDate getDate() {
		return date;
	}
}
