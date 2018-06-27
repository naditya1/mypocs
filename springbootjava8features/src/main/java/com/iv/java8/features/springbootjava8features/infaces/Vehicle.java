package com.iv.java8.features.springbootjava8features.infaces;

@FunctionalInterface
public interface Vehicle {

	void wheels();
	
	default void defaultlog(String str){
		System.out.println("print default log from  vehicle::"+str);
	}
	
}
