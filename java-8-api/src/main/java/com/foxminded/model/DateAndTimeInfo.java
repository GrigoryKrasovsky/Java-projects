package com.foxminded.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class DateAndTimeInfo {
	private final LocalTime localTime;
	private final LocalDate localDate;
	
	public DateAndTimeInfo(LocalTime localTime, LocalDate localDate) {
		this.localTime = localTime;
		this.localDate = localDate;
	}
	public LocalTime getLocalTime() {
		return this.localTime;
	}
	public LocalDate getLocalDate() {
		return this.localDate;
	}
}
