package com.foxminded.model;

import java.util.List;

public class Team {
	private final String teamName;
	private Integer numberOfRacers =0;
	
	public Team(String teamName,
			List<String> namesOfRacers) {
		this.teamName = teamName;
	}
	
	public String getTeamName() {
		return this.teamName;
	}
	
	public Integer getNumberOfRacers() {
		return this.getNumberOfRacers();
	}
	
	public Team setNumberOfRacers() {
		this.numberOfRacers++;
		return this;
	}
}
