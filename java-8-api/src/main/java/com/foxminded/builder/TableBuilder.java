package com.foxminded.builder;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import com.foxminded.model.Racer;

public interface TableBuilder {
	public Map<Integer,List<String>> buildRow(Integer integer, Racer racer) throws URISyntaxException, IOException;
}
