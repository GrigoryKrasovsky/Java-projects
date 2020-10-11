package com.foxminded.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface Parser {
	public Map<String, List<String>> parse() throws IOException;
}
