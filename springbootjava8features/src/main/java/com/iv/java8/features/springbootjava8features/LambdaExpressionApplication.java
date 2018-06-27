package com.iv.java8.features.springbootjava8features;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.iv.java8.features.springbootjava8features.daos.DeveloperDAO;
import com.iv.java8.features.springbootjava8features.pojos.Developer;

//@SpringBootApplication
public class LambdaExpressionApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	DeveloperDAO develperdao;
	
	public static void main(String[] args) {
		SpringApplication.run(LambdaExpressionApplication.class, args);
	}
	
	@Override
	public void run(String... arg0) throws Exception {
		List<Developer> listDevs = develperdao.getDevelopers();
		
		logger.info("Print before Sorting the list");
		for (Developer developer : listDevs) {
			logger.info(developer.toString());
		}
		
		//Sorting by age with out using Lambda 
		Collections.sort(listDevs, new Comparator<Developer>() {
			public int compare(Developer o1, Developer o2) {
				return o1.getAge() - o2.getAge();
			}
		});
		
		logger.info("Print after Sorting the list");
		for (Developer developer : listDevs) {
			System.out.println(developer);
		}
		
		//lambda here!
		logger.info("Lambda Starts");
		
		logger.info("Before Sort");
		List<Developer> listDevsOne = develperdao.getDevelopers();
		listDevsOne.forEach((developer) -> logger.info(developer.toString()));
		
		listDevsOne.sort((Developer o1, Developer o2) -> o1.getAge()-o2.getAge());
				
		logger.info("After Sort");
		listDevsOne.forEach((developer) -> logger.info(developer.toString()));
		
		
	}
}
