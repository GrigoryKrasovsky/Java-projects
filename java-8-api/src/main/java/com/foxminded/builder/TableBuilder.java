package com.foxminded.builder;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import com.foxminded.model.Racer;

public interface TableBuilder {
	public Map<Long, List<Racer>> buildTable() throws URISyntaxException, IOException;
}
