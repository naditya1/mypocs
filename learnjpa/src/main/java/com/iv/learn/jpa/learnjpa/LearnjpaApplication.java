package com.iv.learn.jpa.learnjpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.iv.learn.jpa.learnjpa.entity.Course;
import com.iv.learn.jpa.learnjpa.repository.CourseRepository;

@SpringBootApplication
public class LearnjpaApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository repository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(LearnjpaApplication.class, args);
	}
	
	@Override
	public void run(String... arg0) throws Exception {
		Course course = repository.findById(90003L);
		
		logger.info("Course 90003 -> {}", course);
		
		repository.deleteById(90003L);
		
		repository.save(new Course("JPA Hibernate"));
		
		//repository.playWithEntityManager();
		
		//repository.playWithEntityManager2();
		
		repository.addReviewsToExistingCourse();
	}
}
