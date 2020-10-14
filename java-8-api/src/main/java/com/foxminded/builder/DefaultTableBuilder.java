package com.foxminded.builder;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.foxminded.model.Racer;

public class DefaultTableBuilder implements TableBuilder {

	@Override
	public Map<Integer, List<String>> buildRow(Integer integer, Racer racer) throws URISyntaxException, IOException {
		
		List <String> list = new ArrayList<>();
		list.add(racer.getAbbreviation());
		list.add(racer.getName());
		list.add(racer.getStartTime());
		list.add(racer.getAbbreviation());
		list.add(racer.getAbbreviation());
		list.add(racer.getAbbreviation());
		
		Map<Integer, List<String>> map= new HashMap<>();
		map.put(integer, list);

		return map;
		
	}

}
