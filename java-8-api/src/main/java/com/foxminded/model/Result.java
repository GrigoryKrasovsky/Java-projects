package com.foxminded.model;

import java.util.HashMap;
import java.util.Map;

public class Result {

	private Map<String, Map<String, String>> resultMap = new HashMap<>();
	
	public Result(Map <String,Map<String,String>> abbreviationMap,
			Map <String,Map<String,String>> startMap,
			Map <String,Map<String,String>> endMap) {

		for(String abbreviation: abbreviationMap.keySet()) {
			Map <String, String> insideMap = new HashMap<>();
			String name = abbreviationMap.get(abbreviation).get("key0");
			String team = abbreviationMap.get(abbreviation).get("key1");
			String date = startMap.get(abbreviation).get("key0");
			String startTime = startMap.get(abbreviation).get("key1");
			String endTime = endMap.get(abbreviation).get("key1");
			
			insideMap.put("name", name);
			insideMap.put("team", team);
			insideMap.put("startTime", startTime);
			insideMap.put("endTime", endTime);
			insideMap.put("date", date);
			resultMap.put(abbreviation, insideMap);
		}
	}
	public String getName(String abbreviation) {
		return resultMap.get(abbreviation).get("name");
	}
	
	public String getStartTime(String abbreviation) {
		return resultMap.get(abbreviation).get("startTime");
	}
	
	public String getEndTime(String abbreviation) {
		return resultMap.get(abbreviation).get("endTime");
	}
	
	public String getDate(String abbreviation) {
		return resultMap.get(abbreviation).get("date");
	}
	
	public String getTeam(String abbreviation) {
		return resultMap.get(abbreviation).get("team");
	}
}
