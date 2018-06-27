package com.iv.java8.features.springbootjava8features.daos;

import com.iv.java8.features.springbootjava8features.infaces.Food;
import com.iv.java8.features.springbootjava8features.infaces.Vehicle;

public class PersonDAO implements Vehicle, Food{

	

	@Override
	public void wheels() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void defaultlog(String str) {
		Food.super.defaultlog(str);
	}

	

	@Override
	public void fooditems(String str) {
		// TODO Auto-generated method stub
		
	}

	

}
