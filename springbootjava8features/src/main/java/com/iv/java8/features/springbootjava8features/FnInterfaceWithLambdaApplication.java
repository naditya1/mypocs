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
import com.iv.java8.features.springbootjava8features.daos.PersonDAO;
import com.iv.java8.features.springbootjava8features.infaces.Food;

@SpringBootApplication
public class FnInterfaceWithLambdaApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//@Autowired
	//PersonDAO persondao;
	
	public static void main(String[] args) {
		SpringApplication.run(FnInterfaceWithLambdaApplication.class, args);
	}
	
	@Override
	public void run(String... arg0) throws Exception {
		
		//without lambda and functional interface
		Food food = new PersonDAO();
		food.defaultlog("Apple");
		
		Food foode = (s) -> logger.info(s);
		
		foode.fooditems("burger");
		
		Food foodie = (s) -> {
			logger.info("in lambda multi stmts");
			logger.info(s);
		};
		
		foodie.fooditems("pizza");
	}
}
