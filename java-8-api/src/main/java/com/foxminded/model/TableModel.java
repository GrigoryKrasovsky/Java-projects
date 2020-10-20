package com.foxminded.model;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface TableModel {
	public List<Racer> createTableModel() throws URISyntaxException, IOException;

}