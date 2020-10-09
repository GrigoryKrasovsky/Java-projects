package com.foxminded.parser;

import java.io.IOException;
import java.util.Map;

public interface Parser {
	public Map<Object, Object> parse() throws IOException;
}
