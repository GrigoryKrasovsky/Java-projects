package com.foxminded.formatter;

import java.util.concurrent.atomic.AtomicInteger;

import com.foxminded.model.Racer;

public interface RowFormatter {
	public String format(Integer i, Racer racer);
}
