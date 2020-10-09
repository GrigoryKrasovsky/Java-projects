package com.foxminded.model;

public class Racer {
	private final String abbreviation;
	private final String name;
	private final String team;
	private final String startTime;
	private final String endTime;
	private final String date;

	
	public Racer(String abbreviation,
			String name,
			String team,
			String startTime,
			String endTime,
			String date) {
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
	
	public String getName() {
		return name;
	}
	
	public String getTeam() {
		return team;
	}
	
	public String getStartTime() {
		return startTime;
	}
	
	public String getEndTime() {
		return endTime;
	}
	
	public String getDate() {
		return date;
	}
}
