package com.foxminded.model.name_team_date_time_info;

public class NameAndTeamInfo {

	private final String name;
	private final String team;
		
	public NameAndTeamInfo(String name, String team) {
		this.name = name;
		this.team = team;
	}
	public String getName() {
		return this.name;
	}
	public String getTeam() {
		return this.team;
	}
}

