package com.foxminded.model;

import java.util.List;

public class Team {
	private final String teamName;
	private List<String> listOfRacers;
	
	public Team(String teamName,
			List<String> listOfRacers) {
		this.teamName = teamName;
		this.listOfRacers = listOfRacers;
	}
	
	public String getTeamName() {
		return this.teamName;
	}
	public List<String> getListOfRacers() {
		return this.listOfRacers;
	}
	public Integer getNumberOfRacers() {
		return this.listOfRacers.size();
	}
	
	
	
}
