package com.iv.java8.features.springbootjava8features.infaces;

public interface Food {
	
	public void fooditems(String str); 
	
	
	default void defaultlog(String str){
		System.out.println("try default method in Food logging::"+str);
	}
	
	static void defaultprint(String str){
		System.out.println("try static method in Food "+str);
	}
	
	default void defaultlog1(String str){
		System.out.println("try default method in Food logging1::"+str);
	}
	
}
