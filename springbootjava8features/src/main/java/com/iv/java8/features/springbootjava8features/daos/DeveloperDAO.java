package com.iv.java8.features.springbootjava8features.daos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.iv.java8.features.springbootjava8features.pojos.Developer;

@Component
public class DeveloperDAO {
	
	public List<Developer> getDevelopers() {

		List<Developer> result = new ArrayList<Developer>();

		result.add(new Developer("eric", new BigDecimal("70000"), 33));
		result.add(new Developer("jsson", new BigDecimal("80000"), 20));
		result.add(new Developer("david", new BigDecimal("100000"), 10));
		result.add(new Developer("john", new BigDecimal("170000"), 55));

		return result;

	}
}
