package com.foxminded.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface Parser {
	public <T>Map<String, List<T>> parse() throws IOException;
}
