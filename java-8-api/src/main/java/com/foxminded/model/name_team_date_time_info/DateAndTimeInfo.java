package com.foxminded.model.name_team_date_time_info;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DateAndTimeInfo {
	private List<LocalTime> localTime = new ArrayList<>();
    private List<LocalDate> localDate = new ArrayList<>();
	
	public DateAndTimeInfo(LocalTime localTime, LocalDate localDate) {
		this.localTime.add(localTime);
        this.localDate.add(localDate);

	}
	public List<LocalTime> getLocalTime() {
		return this.localTime;
	}
	public List<LocalDate> getLocalDate() {
		return this.localDate;
	}
	public DateAndTimeInfo addAnotherLapTime(DateAndTimeInfo dateAndTimeInfo) {
		this.localTime.addAll(dateAndTimeInfo.getLocalTime());
		this.localDate.addAll(dateAndTimeInfo.getLocalDate());
		return this;
	}
}
