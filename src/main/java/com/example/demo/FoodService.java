package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {
	
	  @Autowired
	   FoodRepo foodDao;


	    public List<Food> getFoodListbyrestaurantid(int restaurantid,String restaurantname){
	        List<Food> food;
	        food = foodDao.findbyrestaurantidrestaurantname(restaurantid,restaurantname);
	        return food;
	    }

	    public Food validateFoodInfo(String productId){
	        Food food = null;
	        food = foodDao.findById(productId).get();
	        return food;
	    }

}
