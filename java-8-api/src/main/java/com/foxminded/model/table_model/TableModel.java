package com.foxminded.model.table_model;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface TableModel {
	public List<?> createTableModel() throws URISyntaxException, IOException;

}