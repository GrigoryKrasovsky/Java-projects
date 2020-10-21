package com.foxminded.model.table_model;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import com.foxminded.model.Racer;

public interface TableModel {
	public List<Racer> createTableModel() throws URISyntaxException, IOException;

}