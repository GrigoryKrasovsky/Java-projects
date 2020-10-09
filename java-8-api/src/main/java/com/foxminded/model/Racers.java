package com.foxminded.model;

import java.util.ArrayList;
import java.util.List;

public class Racers {
	List<Racer> racersList = new ArrayList<>();
	
	public void add(Racer racer) {
		racersList.add(racer);
	}
	
	public List<Racer> getRacersList(){
		return racersList;
	}
}
