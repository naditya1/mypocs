package com.iv.learn.jpa.learnjpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.iv.learn.jpa.learnjpa.entity.Course;
import com.iv.learn.jpa.learnjpa.entity.Review;

@Repository
@Transactional
public class CourseRepository {	
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	public Course findById(Long id){
		return em.find(Course.class, id);
	}


	//insert or update
	public Course save(Course course) {
		
		if (course.getId() == null) {
			em.persist(course);
		} else {
			em.merge(course);
		}
		
		return course;
	}
	
	
	public void deleteById(Long id) {
		Course course = findById(id);
		em.remove(course);
	}
	
	public List<Course> findAll() {
		TypedQuery<Course> namedQuery = em.createNamedQuery("find_all_courses", Course.class);
		return namedQuery.getResultList();
	}
	
	public void playWithEntityManager() {
		
		Course course1 = new Course("Learn Web Services");
		em.persist(course1);	
		
		
		Course course2 = new Course("Learn Angular");
		em.persist(course2);
		
		//logger.info("Before Flush All users -> {}", findAll());
		
		
		em.flush();
		//logger.info("After Flush All users -> {}", findAll());
		
		course1.setName("Learn Web Services Updated");
		course2.setName("Learn Angular Updated");
		
		//logger.info("After Setter All users -> {}", findAll());
		
		
		em.refresh(course1);
		//logger.info("After Refresh All users -> {}", findAll());
		
		em.flush();
		
		
		//logger.info("After Refresh Flush All users -> {}", findAll());
	}

	public void playWithEntityManager2() {
		Course course1 = new Course("Learn REST Services");
		em.persist(course1);
		
		course1.setName(null);
	}
	
	public void addReviewsToExistingCourse() {
		Course course1 = findById(90001L);

		logger.info(course1.toString());
		Review review1 = new Review("4", "Nice Course");	
		//Review review2 = new Review("5", "Great Start");
		
		course1.addReview(review1);
		review1.setCourse(course1);
		
		em.persist(review1);
		
		
	}
}
