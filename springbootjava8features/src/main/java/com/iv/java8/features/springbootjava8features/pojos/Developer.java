package com.iv.java8.features.springbootjava8features.pojos;

import java.math.BigDecimal;

public class Developer {

	private String givenName;
	private BigDecimal score;
	private int age;
	
	public Developer(String givenName, BigDecimal score, int age) {
		this.givenName = givenName;
		this.score = score;
		this.age = age;
	}

	public String getGivenName() {
		return givenName;
	}

	public BigDecimal getScore() {
		return score;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Developer [givenName=" + givenName + ", score=" + score
				+ ", age=" + age + "]";
	}
	
	
}
